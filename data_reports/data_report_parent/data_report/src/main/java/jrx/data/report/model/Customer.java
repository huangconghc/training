package jrx.data.report.model;

import com.baomidou.mybatisplus.annotation.IdType;
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
@ApiModel(value="Customer对象", description="")
public class Customer implements Serializable {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "客户号")
    @TableId(value = "cust_id", type = IdType.AUTO)
    private Integer custId;

    @ApiModelProperty(value = "客户姓名")
    private String surname;

    @ApiModelProperty(value = "性别")
    private String gender;

    @ApiModelProperty(value = "教育状况")
    private String educaDes;

    @ApiModelProperty(value = "婚姻状况")
    private String marDes;

    @ApiModelProperty(value = "生日")
    private Integer birthday;

    @ApiModelProperty(value = "家庭地址")
    private String address;


}
