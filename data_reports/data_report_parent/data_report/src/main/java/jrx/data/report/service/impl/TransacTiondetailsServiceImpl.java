package jrx.data.report.service.impl;

;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import jrx.data.report.mapper.TransacTiondetailsMapper;
import jrx.data.report.model.DailySummaryStatistic;
import jrx.data.report.model.TransacTiondetails;
import jrx.data.report.service.TransacTiondetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 小聪聪
 * @since 2020-06-06
 */
@Service
public class TransacTiondetailsServiceImpl implements TransacTiondetailsService {

    @Autowired
    private TransacTiondetailsMapper transacTiondetailsMapper;


   /**
     *@Description 查询所有交易明细
     *@MethodName selectAllTransacTiondetails
       * @param
     *@Return java.util.List<jrx.data.report.model.TransacTiondetails>
     *@Author xiaocongcong
     *@Date 2020/6/6
     */

    @Override
    public List<TransacTiondetails> selectAllTransacTiondetails() {
        return transacTiondetailsMapper.selectAllTransacTiondetails();
    }

    /**
      *@Description 分页查询
      *@MethodName listPage
        * @param page
     * @param size
      *@Return com.github.pagehelper.PageInfo<jrx.data.report.model.TransacTiondetails>
      *@Author xiaocongcong
      *@Date 2020/6/6
      */

    @Override
    public PageInfo<TransacTiondetails> listPage(int page, int size){
        PageHelper.startPage(page, size);
        return new PageInfo<TransacTiondetails>(transacTiondetailsMapper.selectAllTransacTiondetails());
    }

}
