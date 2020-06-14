package jrx.data.report.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import jrx.data.report.mapper.DailySummaryStatisticMapper;
import jrx.data.report.model.Customer;
import jrx.data.report.model.DailySummaryStatistic;
import jrx.data.report.repository.DailyCensus;
import jrx.data.report.repository.PayMonth;
import jrx.data.report.repository.PayTran;
import jrx.data.report.service.DailySummaryStatisticService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author 小聪聪
 * @since 2020-06-06
 */
@Service
public class DailySummaryStatisticServiceImpl implements DailySummaryStatisticService {

    @Autowired
    private DailySummaryStatisticMapper dailySummaryStatisticMapper;


    /**
     * @param
     * @Description 一个月每天的交易总金额
     * @MethodName getDailyCensus
     * @Return java.util.List<jrx.data.report.repository.DailyCensus>
     * @Author xiaocongcong
     * @Date 2020/6/10
     */

    @Override
    public List<DailyCensus> getDailyCensus() {
        return dailySummaryStatisticMapper.getDailyCensus();
    }


    /**
     * @param
     * @Description 三个月交易笔数
     * @MethodName getCntMonth
     * @Return java.util.List<jrx.data.report.repository.PayMonth>
     * @Author xiaocongcong
     * @Date 2020/6/10
     */
    @Override
    public List<PayMonth> getCntMonth() {
        return dailySummaryStatisticMapper.getCntMonth();
    }


    /**
     * @param
     * @Description 一个月的消费总金额和还款总金额
     * @MethodName getPayTran
     * @Return jrx.data.report.repository.PayTran
     * @Author xiaocongcong
     * @Date 2020/6/10
     */
    @Override
    public PayTran getPayTran() {
        return dailySummaryStatisticMapper.getPayTran();
    }


    /**
     * @param page
     * @param size
     * @Description 分页查询
     * @MethodName listPage
     * @Return com.github.pagehelper.PageInfo<jrx.data.report.model.DailySummaryStatistic>
     * @Author xiaocongcong
     * @Date 2020/6/6
     */
    @Override
    public PageInfo<DailySummaryStatistic> listPage(int page, int size) {
        PageHelper.startPage(page, size);
        return new PageInfo<DailySummaryStatistic>(dailySummaryStatisticMapper.selectAllDailySummaryStatistic());
    }


    /**
     * @param
     * @Description 查询所有
     * @MethodName list
     * @Return java.util.List<jrx.data.report.model.DailySummaryStatistic>
     * @Author xiaocongcong
     * @Date 2020/6/6
     */
    @Override
    public List<DailySummaryStatistic> list() {
        return dailySummaryStatisticMapper.selectAllDailySummaryStatistic();
    }


}
