package jrx.data.report.Controller;

import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import jrx.data.report.model.DailySummaryStatistic;
import jrx.data.report.model.TransacTiondetails;
import jrx.data.report.service.TransacTiondetailsService;
import jrx.data.report.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author xiaocongcong
 * @date 2020/6/9
 */

@Api(tags = "TransacTiondetails控制类")
@RestController
@CrossOrigin
@RequestMapping("/TransacTiondetails")
public class TransacTiondetailscontroller {

    @Autowired
    private TransacTiondetailsService transacTiondetailsService;


    /**
     * @param
     * @Description 查询所有交易明细
     * @MethodName selectAllTransacTiondetails
     * @Return jrx.data.report.util.Result
     * @Author xiaocongcong
     * @Date 2020/6/9
     */

    @ApiOperation("查询所有信息")
    @RequestMapping("/getAll")
    public Result selectAllTransacTiondetails() {
        List<TransacTiondetails> transactionDetails = transacTiondetailsService.selectAllTransacTiondetails();
        return Result.success("查询成功", transactionDetails);
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

    @ApiOperation("分页查询")
    @GetMapping(value = "/search/{page}/{size}")
    public Result<PageInfo> listPage(@PathVariable int page, @PathVariable int size) {
        PageInfo<TransacTiondetails> pageInfo = transacTiondetailsService.listPage(page, size);
        return Result.success("查询成功", pageInfo);
    }

}
