package jrx.data.report.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import jrx.data.report.model.Customer;
import org.apache.ibatis.annotations.Param;
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
public interface CustomerMapper {


    /**
     * @param
     * @Description 查询所有客户信息
     * @MethodName selectAllCustomer
     * @Return java.util.List<jrx.data.report.model.Customer>
     * @Author xiaocongcong
     * @Date 2020/6/6
     */

    @Select("SELECT * FROM customer")
    @ResultType(Customer.class)
    List<Customer> selectAllCustomer();


}
