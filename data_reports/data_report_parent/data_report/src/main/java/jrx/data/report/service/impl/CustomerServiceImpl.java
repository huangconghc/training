package jrx.data.report.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.ApiOperation;
import jrx.data.report.mapper.CustomerMapper;
import jrx.data.report.model.Customer;
import jrx.data.report.service.CustomerService;
import jrx.data.report.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
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
public class CustomerServiceImpl implements CustomerService {


    @Autowired
    CustomerMapper customerMapper;


    /**
     * @param
     * @Description 客户信息
     * @MethodName selectAllCustomer
     * @Return java.util.List<jrx.data.report.model.Customer>
     * @Author xiaocongcong
     * @Date 2020/6/6
     */

    @Override
    public List<Customer> selectAllCustomer() {
        return customerMapper.selectAllCustomer();
    }


    /**
     * @param page
     * @param size
     * @Description 分页查询
     * @MethodName listPage
     * @Return com.github.pagehelper.PageInfo<jrx.data.report.model.Customer>
     * @Author xiaocongcong
     * @Date 2020/6/6
     */

    @Override
    public PageInfo<Customer> listPage(int page, int size) {
        PageHelper.startPage(page, size);
        return new PageInfo<Customer>(customerMapper.selectAllCustomer());
    }


}
