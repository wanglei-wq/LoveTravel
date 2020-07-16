package cn.kgc.controller;

import cn.kgc.pojo.AlipayOrder;
import cn.kgc.pojo.Order;
import cn.kgc.pojo.Room;
import cn.kgc.service.AlipayService;
import cn.kgc.util.AlipayConfig;
import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipayTradePagePayRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;

@Controller
@RequestMapping("/alipay")
public class AliPayController {
    @Autowired
    private AlipayService alipayService;

    @RequestMapping(value = "alipay", produces = "text/html; charset=UTF-8")
    @ResponseBody
    public String  alipay(Room room,Integer[] cId, Order order, HttpServletRequest request, HttpServletResponse response) throws IOException {
        //获得初始化的AlipayClient
        AlipayClient alipayClient = new DefaultAlipayClient(AlipayConfig.gatewayUrl, AlipayConfig.app_id, AlipayConfig.merchant_private_key, "json", AlipayConfig.charset, AlipayConfig.alipay_public_key, AlipayConfig.sign_type);

        //设置请求参数
        AlipayTradePagePayRequest alipayRequest = new AlipayTradePagePayRequest();
        alipayRequest.setReturnUrl(AlipayConfig.return_url);
        alipayRequest.setNotifyUrl(AlipayConfig.notify_url);
        //添加订单的入住时间，离宿时间，房间数量，房间类型
        int i  = alipayService.updateOrderIntimeAndOutimeAndroomCountByNo(order);
        Integer i2 = alipayService.addOrderListByOrder(order.getOId(), cId, room.getRId());
        Integer i3 = alipayService.deleteNumFromRoom(room);
        if(i>0 && i2>0 && i3>0) {
            System.out.println("酒店入住时间---金额，房型，房间数量！");
        }
        //商户订单号，商户网站订单系统中唯一订单号，必填
        //商品描述，项目生成的订单号16位随机数
        String out_trade_no =order.getNo();
        //付款金额，必填
        String money = request.getParameter("money");
        //订单名称，必填
        String subject = "支付宝第三方测试";

        String body = "";
        alipayRequest.setBizContent("{\"out_trade_no\":\""+ out_trade_no +"\","
                + "\"total_amount\":\""+ money +"\","
                + "\"subject\":\""+ subject +"\","
                + "\"body\":\""+ body +"\","
                + "\"product_code\":\"FAST_INSTANT_TRADE_PAY\"}");
        //请求
        String result=null;
        try {
            result = alipayClient.pageExecute(alipayRequest).getBody();
        } catch (AlipayApiException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println(result);
        //response.getWriter().println(result);
        return result;
    }

    @RequestMapping(value = "callBack")
    public String callBack(HttpServletRequest request, HttpServletResponse response) throws IOException, AlipayApiException {
        /**
         * 支付宝的回调 告诉你 1.支付宝订单号 2.自己商城生成的订单号 3.付款金额
         */
        // 商户订单号
        String out_trade_no = new String(request.getParameter("out_trade_no").getBytes("ISO-8859-1"), "UTF-8");
        // 支付宝交易号
        String trade_no = new String(request.getParameter("trade_no").getBytes("ISO-8859-1"), "UTF-8");
        // 付款金额
        String total_amount = new String(request.getParameter("total_amount").getBytes("ISO-8859-1"), "UTF-8");
        //设置相应的编码格式是 html
        response.setContentType("text/html;charset=utf-8");
        System.out.println("订单号:"+out_trade_no);
        System.out.println("支付宝交易号"+trade_no);
        System.out.println("付款金额"+total_amount);
        Integer i= alipayService.addAlipayOrder(new AlipayOrder(out_trade_no, trade_no, new BigDecimal(total_amount), 1));
            switch (i) {
                case 1:
                    // 修改订单的状态
                    Integer i2  = alipayService.updateOrderStateByOrderId(out_trade_no);
                    if(i2>0) {
                        System.out.println("订单状态--已支付修改成功");
                        return "redirect:/order/queryAllOrder";
                        //response.sendRedirect("http://localhost:8080/FashionGirl/my-account.html");
                    }else {
                        return "404";
                    }
                default:
                    return "404";
            }
    }
}

