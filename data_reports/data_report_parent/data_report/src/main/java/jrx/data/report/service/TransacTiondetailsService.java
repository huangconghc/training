package jrx.data.report.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.github.pagehelper.PageInfo;
import jrx.data.report.model.DailySummaryStatistic;
import jrx.data.report.model.TransacTiondetails;
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
public interface TransacTiondetailsService {

   /**
     *@Description 查询所有客户接口
     *@MethodName getList
     * @param
     *@Return java.util.List<jrx.data.report.model.TransacTiondetails>
     *@Author xiaocongcong
     *@Date 2020/6/6
     */

    List<TransacTiondetails> selectAllTransacTiondetails();


 /**
   *@Description 分页查询接口
   *@MethodName listPage
     * @param page
  * @param size
   *@Return com.github.pagehelper.PageInfo<jrx.data.report.model.TransacTiondetails>
   *@Author xiaocongcong
   *@Date 2020/6/6
   */

    PageInfo<TransacTiondetails> listPage(int page, int size);

}
