package jrx.data.report.config;

import jrx.data.report.model.DailySummaryStatistic;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.batch.item.ItemProcessor;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.UUID;

/**
 * @author xiaocongcong
 * @date 2020/6/8
 */
@Configuration
@Component
public class DailiSummaryStatisticProcessor implements ItemProcessor<DailySummaryStatistic, DailySummaryStatistic> {

    private SimpleDateFormat f =
            new SimpleDateFormat("yyyyMMdd");

    /**
     * @param dailySummaryStatistic
     * @Description 进行数据的逻辑处理
     * @MethodName process
     * @Return jrx.data.report.model.DailySummaryStatistic
     * @Author xiaocongcong
     * @Date 2020/6/14
     */

    @Override
    public DailySummaryStatistic process(DailySummaryStatistic dailySummaryStatistic) throws Exception {
        String sIndex = UUID.randomUUID().toString().replaceAll("-", "").substring(0, 5) + "_" + f.format(new Date());
        dailySummaryStatistic.setSIndex(sIndex);
        dailySummaryStatistic.setUpdateTime(new Date());
        return dailySummaryStatistic;
    }
}
