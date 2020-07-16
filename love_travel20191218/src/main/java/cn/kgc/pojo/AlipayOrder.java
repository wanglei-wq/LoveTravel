package cn.kgc.pojo;

import java.math.BigDecimal;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AlipayOrder {
	/**
	 * 订单id(主键)
	 */
	private int id;
	//订单号
	private String outTradeNo;
	//支付宝交易号
	private String tradeNo;
	//付款金额
	private BigDecimal totalAmount;
	//绑定用户的信息
	private int userId;

	public AlipayOrder(String outTradeNo, String tradeNo, BigDecimal totalAmount, int userId) {
		this.outTradeNo = outTradeNo;
		this.tradeNo = tradeNo;
		this.totalAmount = totalAmount;
		this.userId = userId;
	}
}
