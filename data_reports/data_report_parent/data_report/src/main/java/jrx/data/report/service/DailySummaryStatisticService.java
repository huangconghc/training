package jrx.data.report.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.github.pagehelper.PageInfo;
import jrx.data.report.model.Customer;
import jrx.data.report.model.DailySummaryStatistic;
import jrx.data.report.repository.DailyCensus;
import jrx.data.report.repository.PayMonth;
import jrx.data.report.repository.PayTran;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author 小聪聪
 * @since 2020-06-06
 */
public interface DailySummaryStatisticService {


    /**
     * @param
     * @Description 一个月每天的交易总金额
     * @MethodName getDailyCensus
     * @Return java.util.List<jrx.data.report.repository.DailyCensus>
     * @Author xiaocongcong
     * @Date 2020/6/10
     */

    List<DailyCensus> getDailyCensus();


    /**
     * @param
     * @Description 三个月交易笔数
     * @MethodName getCntMonth
     * @Return java.util.List<jrx.data.report.repository.PayMonth>
     * @Author xiaocongcong
     * @Date 2020/6/10
     */

    List<PayMonth> getCntMonth();


    /**
     * @param
     * @Description 一个月的消费总金额和还款总金额
     * @MethodName getPayTran
     * @Return jrx.data.report.repository.PayTran
     * @Author xiaocongcong
     * @Date 2020/6/10
     */

    PayTran getPayTran();


    /**
     * @param
     * @Description 查询所有
     * @MethodName list
     * @Return java.util.List<jrx.data.report.model.DailySummaryStatistic>
     * @Author xiaocongcong
     * @Date 2020/6/6
     */

    List<DailySummaryStatistic> list();


    /**
     * @param page
     * @param size
     * @Description 分页查询
     * @MethodName listPage
     * @Return com.github.pagehelper.PageInfo<jrx.data.report.model.DailySummaryStatistic>
     * @Author xiaocongcong
     * @Date 2020/6/6
     */

    PageInfo<DailySummaryStatistic> listPage(int page, int size);


}
