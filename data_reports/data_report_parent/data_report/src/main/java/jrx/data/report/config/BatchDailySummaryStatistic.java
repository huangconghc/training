package jrx.data.report.config;

import jrx.data.report.model.Customer;
import jrx.data.report.model.DailySummaryStatistic;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.database.JdbcCursorItemReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.RowMapper;

import javax.annotation.processing.Processor;
import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author xiaocongcong
 * @date 2020/6/8
 */
@Configuration
@EnableBatchProcessing
public class BatchDailySummaryStatistic {

    @Autowired
    private JobBuilderFactory jobBuilderFactory;
    @Autowired
    private StepBuilderFactory stepBuilderFactory;

    @Autowired
    private DataSource dataSource;

    @Autowired
    private DailiSummaryStatisticProcessor dailiSummaryStatisticProcessor;


    @Bean
    public Job dailiSummaryStatisticToJobs() {
        return jobBuilderFactory.get("dailiSummaryStatisticToJobs")
                .start(dailiSummaryStatisticToSteps())
                .listener(new ListenDailiSummaryStatistic())//监听job的执行
                .build();
    }

    @Bean
    public Step dailiSummaryStatisticToSteps() {
        return stepBuilderFactory.get("dailiSummaryStatisticToSteps")
                .<DailySummaryStatistic, DailySummaryStatistic>chunk(2)
                // .listener(new ListenDailiSummaryStatistic())
                .reader(dailySummaryStatisticToReader())
                .processor(dailiSummaryStatisticProcessor)//进行逻辑处理
                .writer(dailySummaryStatisticToWriter())
                .build()
                ;
    }


    /**
     * @param
     * @Description 从数据库中把数据查询出来
     * @MethodName dailySummaryStatisticToReader
     * @Return org.springframework.batch.item.database.JdbcCursorItemReader<jrx.data.report.model.DailySummaryStatistic>
     * @Author xiaocongcong
     * @Date 2020/6/14
     */


    @Bean
    @StepScope
    public JdbcCursorItemReader<DailySummaryStatistic> dailySummaryStatisticToReader() {
        JdbcCursorItemReader<DailySummaryStatistic> reader = new JdbcCursorItemReader<>();
        reader.setDataSource(dataSource);
        // reader.setFetchSize(10);
        reader.setSql("select w.*,s.tran_cnt from \n" +
                "(select b.*,a.pay_amt,a.pay_cnt from \n" +
                "(select c.cust_id as cust_id,c.surname,t.txn_datetime as trans_date,max(bill) as tran_max_amt,sum(bill) as tran_amt from customer c join  transac_tiondetails t on c.cust_id=t.cust_id GROUP BY cust_id) b\n" +
                "LEFT OUTER JOIN\n" +
                "(select c.cust_id as a_id,t.txn_datetime as trans_date,sum(bill) as pay_amt,count(t.bill) pay_cnt from transac_tiondetails t join customer c on  c.cust_id=t.cust_id where t.trans_type='还款' GROUP BY a_id,t.txn_datetime) a on b.cust_id=a.a_id) w\n" +
                "LEFT OUTER JOIN\n" +
                "(select c.cust_id as s_id,txn_datetime,count(bill) as tran_cnt  from transac_tiondetails t join customer c on c.cust_id=t.cust_id where t.trans_type='消费' GROUP BY s_id,txn_datetime) s ON  w.cust_id=s.s_id");
        reader.setRowMapper(new RowMapper<DailySummaryStatistic>() {
            @Override
            public DailySummaryStatistic mapRow(ResultSet resultSet, int i) throws SQLException {
                DailySummaryStatistic dailySummaryStatistic = new DailySummaryStatistic();
                dailySummaryStatistic.setCustId(resultSet.getInt("cust_id"));
                dailySummaryStatistic.setTransDate(resultSet.getDate("trans_date"));
                dailySummaryStatistic.setSurname(resultSet.getString("surname"));
                dailySummaryStatistic.setTranMaxAmt(resultSet.getBigDecimal("tran_max_amt"));
                dailySummaryStatistic.setTranAmt(resultSet.getBigDecimal("tran_amt"));
                dailySummaryStatistic.setPayAmt(resultSet.getBigDecimal("pay_amt"));
                dailySummaryStatistic.setPayCnt(resultSet.getInt("pay_cnt"));
                dailySummaryStatistic.setTranCnt(resultSet.getInt("tran_cnt"));
                return dailySummaryStatistic;

            }
        });
        return reader;
    }

    /**
     * @param
     * @Description 把处理好逻辑的数据插入数据库
     * @MethodName dailySummaryStatisticToWriter
     * @Return org.springframework.batch.item.ItemWriter<? super jrx.data.report.model.DailySummaryStatistic>
     * @Author xiaocongcong
     * @Date 2020/6/14
     */


    @Bean
    @StepScope
    public ItemWriter<? super DailySummaryStatistic> dailySummaryStatisticToWriter() {
        JdbcBatchItemWriter<DailySummaryStatistic> writer = new JdbcBatchItemWriter<>();
        writer.setDataSource(dataSource);
        writer.setSql("insert into daily_summary_statistic(s_index,cust_id,update_time,trans_date,surname,tran_max_amt, " +
                " pay_amt,tran_cnt,pay_cnt,tran_amt) VALUES (:sIndex,:custId,:updateTime,:transDate,:surname, " +
                " :tranMaxAmt,:payAmt,:tranCnt,:payCnt,:tranAmt)");
        writer.setItemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<>());
        return writer;
    }

}
