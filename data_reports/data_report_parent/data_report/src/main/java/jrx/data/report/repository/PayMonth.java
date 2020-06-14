package jrx.data.report.repository;


/**
 * <p>
 *近三个月消费
 * </p>
 *
 * @author 小聪聪
 * @since 2020-06-10
 */
public class PayMonth {

    private String cusName;

    private Integer tranNum;

    public String getCusName() {
        return cusName;
    }

    public void setCusName(String cusName) {
        this.cusName = cusName;
    }

    public Integer getTranNum() {
        return tranNum;
    }

    public void setTranNum(Integer tranNum) {
        this.tranNum = tranNum;
    }
}
