package jrx.data.report.Controller;

import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import jrx.data.report.model.DailySummaryStatistic;
import jrx.data.report.repository.DailyCensus;
import jrx.data.report.repository.PayMonth;
import jrx.data.report.repository.PayTran;
import jrx.data.report.service.DailySummaryStatisticService;
import jrx.data.report.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author xiaocongcong
 * @date 2020/6/9
 */
@Api(tags = "DailySummaryStatistic控制类")
@RestController
@CrossOrigin
public class DailySummaryStatisticController {

    @Autowired
    private DailySummaryStatisticService dailySummaryStatisticService;


    /**
     * @param
     * @Description 一个月每天的交易总金额
     * @MethodName getDailyCensus
     * @Return jrx.data.report.util.Result
     * @Author xiaocongcong
     * @Date 2020/6/10
     */

    @GetMapping("/daily-census")
    @ApiOperation(value = "一个月每天的交易总金额")
    public Result getDailyCensus() {
        List<DailyCensus> census = dailySummaryStatisticService.getDailyCensus();
        return Result.success("查询成功", census);
    }

    /**
     * @param
     * @Description 三个月用户交易笔数
     * @MethodName getCntMonth
     * @Return jrx.data.report.util.Result
     * @Author xiaocongcong
     * @Date 2020/6/10
     */

    @GetMapping("/tran-num")
    @ApiOperation(value = "三个月用户交易笔数")
    public Result getCntMonth() {
        List<PayMonth> payMonth = dailySummaryStatisticService.getCntMonth();
        return Result.success("查询成功", payMonth);
    }

    /**
     * @param
     * @Description 一个月的消费总金额和还款总金额
     * @MethodName getPayTran
     * @Return jrx.data.report.util.Result
     * @Author xiaocongcong
     * @Date 2020/6/10
     */

    @GetMapping("/pay-tran")
    @ApiOperation(value = "一个月的消费总金额和还款总金额")
    public Result getPayTran() {
        PayTran tran = dailySummaryStatisticService.getPayTran();
        return Result.success("查询成功", tran);
    }


    /**
     * @param
     * @Description查询所有汇总信息
     * @MethodName getAlldailySummaryStatistic
     * @Return jrx.data.report.util.Result
     * @Author xiaocongcong
     * @Date 2020/6/9
     */

    @ApiOperation(value = "查询所有汇总信息")
    @RequestMapping("/all")
    public Result getAlldailySummaryStatistic() {
        List<DailySummaryStatistic> dailySummaries = dailySummaryStatisticService.list();
        return Result.success("查询成功", dailySummaries);
    }

    /**
     * @param page
     * @param size
     * @Description 分页查询
     * @MethodName listPage
     * @Return jrx.data.report.util.Result<com.github.pagehelper.PageInfo>
     * @Author xiaocongcong
     * @Date 2020/6/9
     */

    @GetMapping(value = "/search/{page}/{size}")
    @ApiOperation(value = "分页查询")
    public Result<PageInfo> listPage(@PathVariable int page, @PathVariable int size) {
        PageInfo<DailySummaryStatistic> pageInfo = dailySummaryStatisticService.listPage(page, size);
        return Result.success("查询成功", pageInfo);
    }


}
