package jrx.data.report.Controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import jrx.data.report.model.Customer;
import jrx.data.report.model.DailySummaryStatistic;
import jrx.data.report.service.CustomerService;
import jrx.data.report.util.Result;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author xiaocongcong
 * @date 2020/6/7
 */

@Api(tags = "Customer控制类")
@RestController
@CrossOrigin
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    /**
     * @param
     * @Description 查询所有客户
     * @MethodName listAllCustomers
     * @Return jrx.data.report.util.Result
     * @Author xiaocongcong
     * @Date 2020/6/7
     */

    @ApiOperation(value = "查询所有客户信息")
    @GetMapping("/requestAll")
    public Result selectAllCustomer() {
        List<Customer> customers = customerService.selectAllCustomer();
        return Result.success("查询成功", customers);
    }


    /**
     * @param page
     * @param size
     * @Description 分页查询
     * @MethodName listPage
     * @Return jrx.data.report.util.Result<com.github.pagehelper.PageInfo>
     * @Author xiaocongcong
     * @Date 2020/6/7
     */


    @ApiOperation(value = "分页查询")
    @RequestMapping(value = "/search/{page}/{size}")
    public Result<PageInfo> listPage(@PathVariable int page, @PathVariable int size) {
        PageInfo<Customer> pageInfo = customerService.listPage(page, size);
        return Result.success("查询成功", pageInfo);
    }

}
