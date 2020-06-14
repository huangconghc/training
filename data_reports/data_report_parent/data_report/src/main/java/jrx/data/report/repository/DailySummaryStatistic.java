package jrx.data.report.repository;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * <p>
 * 交易统计汇总
 * </p>
 *
 * @author 小聪聪
 * @since 2020-06-06
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="DailySummaryStatistic对象", description="")
public class DailySummaryStatistic implements Serializable {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "索引项，uuid_yyyyMMdd")
    private String sIndex;

    @ApiModelProperty(value = "客户号")
    private Integer custId;

    private Date updateTime;

    private Date transDate;

    @ApiModelProperty(value = "客户姓名")
    private String surname;

    @ApiModelProperty(value = "最大单笔交易金额")
    private BigDecimal tranMaxAmt;

    @ApiModelProperty(value = "当天还款总金额")
    private BigDecimal payAmt;

    @ApiModelProperty(value = "当天消费笔数")
    private Integer tranCnt;

    @ApiModelProperty(value = "当天还款笔数")
    private Integer payCnt;

    @ApiModelProperty(value = "当天交易总金额")
    private BigDecimal tranAmt;

    @ApiModelProperty(value = "当天交易总金额")
    private BigDecimal tranAll;

    @ApiModelProperty(value = "当天交易总金额")
    private BigDecimal payAll;


}
