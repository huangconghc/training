package jrx.data.report.repository;

import java.math.BigDecimal;


/**
 * <p>
 *消费总金额，还款总金额
 * </p>
 *
 * @author 小聪聪
 * @since 2020-06-10
 */
public class PayTran {

    private BigDecimal pay;

    private BigDecimal tran;

    public BigDecimal getPay() {
        return pay;
    }

    public void setPay(BigDecimal pay) {
        this.pay = pay;
    }

    public BigDecimal getTran() {
        return tran;
    }

    public void setTran(BigDecimal tran) {
        this.tran = tran;
    }
}
