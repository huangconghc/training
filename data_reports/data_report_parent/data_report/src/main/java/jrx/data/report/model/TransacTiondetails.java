package jrx.data.report.model;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author 小聪聪
 * @since 2020-06-06
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="TransacTiondetails对象", description="")
public class TransacTiondetails implements Serializable {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "交易id")
    @TableId(value = "trans_id", type = IdType.AUTO)
    private Integer transId;

    @ApiModelProperty(value = "客户号")
    private Integer custId;

    @ApiModelProperty(value = "账户号")
    private String account;

    @ApiModelProperty(value = "卡号")
    private String cardNbr;

    @ApiModelProperty(value = "交易流水号")
    private Integer tranno;

    @ApiModelProperty(value = "账单月")
    private Integer monthNbr;

    @ApiModelProperty(value = "交易金额")
    private BigDecimal bill;

    @ApiModelProperty(value = "交易类型，消费还款")
    private String transType;

    private Date txnDatetime;


}
