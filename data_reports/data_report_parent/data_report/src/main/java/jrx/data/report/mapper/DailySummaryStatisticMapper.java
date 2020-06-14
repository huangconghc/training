package jrx.data.report.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import jrx.data.report.model.Customer;
import jrx.data.report.model.DailySummaryStatistic;
import jrx.data.report.repository.DailyCensus;
import jrx.data.report.repository.PayMonth;
import jrx.data.report.repository.PayTran;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Select;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author 小聪聪
 * @since 2020-06-06
 */
@Mapper //声明是一个Mapper,与springbootApplication中的@MapperScan二选一写上即可
@Repository
public interface DailySummaryStatisticMapper {


    /**
     * @param
     * @Description 查询所有汇总信息
     * @MethodName selectAllDailySummaryStatistic
     * @Return java.util.List<jrx.data.report.model.DailySummaryStatistic>
     * @Author xiaocongcong
     * @Date 2020/6/6
     */

    @Select("SELECT * FROM daily_summary_statistic")
    @ResultType(DailySummaryStatistic.class)
    List<DailySummaryStatistic> selectAllDailySummaryStatistic();


    /**
     * @param
     * @Description一个月每天交易金额
     * @MethodName getDailyCensus
     * @Return java.util.List<jrx.data.report.repository.DailyCensus>
     * @Author xiaocongcong
     * @Date 2020/6/10
     */

    @Select("select DAYOFMONTH(trans_date) as day, sum(tran_amt) as amount from daily_summary_statistic where trans_date > DATE_ADD(now(), INTERVAL -1 MONTH)   group by DAYOFMONTH(trans_date) order by trans_date;")
    public List<DailyCensus> getDailyCensus();


    /**
     * @param
     * @Description 消费金额与还款金额
     * @MethodName getPayTran
     * @Return jrx.data.report.repository.PayTran
     * @Author xiaocongcong
     * @Date 2020/6/10
     */

    @Select("select sum(pay_amt) as pay, sum(tran_amt) as tran from daily_summary_statistic where trans_date > DATE_ADD(now(), INTERVAL -1 MONTH)")
    public PayTran getPayTran();


    /**
     * @param
     * @Description 三个月用户消费笔数
     * @MethodName getCntMonth
     * @Return java.util.List<jrx.data.report.repository.PayMonth>
     * @Author xiaocongcong
     * @Date 2020/6/10
     */

    @Select("select surname as cusName, sum(tran_cnt) as tranNum from daily_summary_statistic where trans_date > DATE_ADD(now(), INTERVAL -3 MONTH) group by surname  ")
    List<PayMonth> getCntMonth();


}
