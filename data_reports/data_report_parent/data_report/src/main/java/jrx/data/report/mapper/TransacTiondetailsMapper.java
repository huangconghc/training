package jrx.data.report.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import jrx.data.report.model.DailySummaryStatistic;
import jrx.data.report.model.TransacTiondetails;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Select;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author 小聪聪
 * @since 2020-06-06
 */
@Mapper //声明是一个Mapper,与springbootApplication中的@MapperScan二选一写上即可
@Repository
public interface TransacTiondetailsMapper {


    /**
      *@Description 查询所有
      *@MethodName  selectAllTransacTiondetails
        * @param
      *@Return java.util.List<jrx.data.report.model.TransacTiondetails>
      *@Author xiaocongcong
      *@Date 2020/6/6
      */

    @Select("SELECT * FROM transac_tiondetails")
    @ResultType(TransacTiondetails.class)
    List<TransacTiondetails> selectAllTransacTiondetails();
}
