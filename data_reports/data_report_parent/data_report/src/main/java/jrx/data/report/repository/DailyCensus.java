package jrx.data.report.repository;

import java.math.BigDecimal;



/**
 * <p>
 *每天消费
 * </p>
 *
 * @author 小聪聪
 * @since 2020-06-10
 */
public class DailyCensus {

    private Integer day;

    private BigDecimal amount;

    public Integer getDay() {
        return day;
    }

    public void setDay(Integer day) {
        this.day = day;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
}
