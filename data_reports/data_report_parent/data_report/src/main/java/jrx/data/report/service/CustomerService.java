package jrx.data.report.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.github.pagehelper.PageInfo;
import jrx.data.report.model.Customer;
import org.springframework.ui.Model;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 小聪聪
 * @since 2020-06-06
 */
public interface CustomerService  {



    List<Customer> selectAllCustomer();

    PageInfo<Customer> listPage(int page, int size);




}
