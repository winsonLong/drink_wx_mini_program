package com.example.utils;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.domain.AlipayTradeAppPayModel;
import com.alipay.api.request.AlipayTradeAppPayRequest;
import com.alipay.api.response.AlipayTradeAppPayResponse;

/**
 * 2017-07-21 by 我是个导演
 * 欢迎访问支付宝论坛：https://openclub.alipay.com/index.php
 */

public class Alipaytradeapppay {

	public String pay() {


	String APP_ID = "2019041563865908";
	String APP_PRIVATE_KEY = "MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQCGYJVNgfcM+Ng8pkxq/dBgN6EYIDZ/5yMszdzEN/vBBXzVDzShr58H0bL7q08U3LYm2jFJbYeLUBKs+k/mfDvndDmoYsISKfNkhzBDWM2ZMHy/w5kw8HGO2oObPnPMcZpol0AjuySdcPa47ZCKZy768FH0/Av+U57hEr2Hxxv2qK9ekYDK4ObmZb2eVDgLxCNPRl+EV2hktubtC6i2KGzIGDPHGoHVRkS122OwImLFGMLS2ADhPryQM9RBflwUAlyEqwmU6shoLiRuXO8qgeagh71hw7mR3Os+lpRybAmHLjq+B7Rsyj2L0aSqA9Iz7snweB0ZQkOOWNvHerJCriLdAgMBAAECggEAEP7sQ1ZZyeE7cEhUR//8N/8xN9zzJ7AzSbpr3sF57QrlpAj9TinpQlLqgVxEb04PF9DnBPN+fkdNZWVvb6Zs6TRRCpQbGbMGnsNeflYgAu0YCiUSHhd7NWc72AnJGaWQswPWT+6eje84tWEOtAKi9YgpxYOPfMZUxQDaye6MAeFbBjUYjwhq4vZrm9cdB4XctVBRcHCExCwsbNXWU4yRdkYoznwCBwX2CGBZEvPRk8NusHPjNZJUbBjEoGNv2zAv7n014xsdTnM0lyYTonAj0D+EFMMVzwpduASILqI75XEY/kyywBaxS9HIgXM5UUFPpExdZFLUIq3ZYXrd/kYhwQKBgQC+NgXkzDZ7ICnQi6a2FmMQ5HYbihfTR5bezL88KN37yTb1EFIZLl0egpHgKAp1WWVg+yb755Lo1BbWEuJrJjOFIFOaZjIRWvHDLRqRM2Z78v4Myj6FV+JuyxeYDCwbrPnYiSYF871bub0T4zqgQaXjuAWbDbY/GDVXChFmRoc3TQKBgQC02tYzwZuxESZhzr2qBtUJDcoI13FsYwyOYUVgnl+BD3IPGfVElAKIzbJp8zwDyzm+7m92Zi6XZ5O4gJL6JN+TtBx+1MFpZCDkQVTPyfYR3588pMO6Iw6RgJ03Ksjaj0eMoRwVC9Rp6XURpkXpwUhoiI+cTm9/PeYeYQ9BI+Vx0QKBgQCVIBuszqIkFApUcziH57NRihxC6RhWz/irwtBnZQ7smUuaBGqpTV06T1n46MuSRz0hNKbStjLKkYU53uJe6TtZMwf4tAiq7KdAwvriPe8qXE7rTiCIQGfJPzbHQTvPkuTq7FPANOEPqeZgUjUjcXSSvTK/5pcsjlk7XSxZCBB4vQKBgQCSc3ttoeQ/uJGKNm4j1zCACmiGTGAO0w6B5YbWvKi9zBIi5HRWujxrJ5bIcS0yLUlvsYkVKZ2lATz/9S4P3fgmlX1Vv1d3zptL+xOAyBy5UIqUAyB0BJtxe+LTn5PSWKAp4vTonhG+SkyApFKM/fVyoNMaUfG76hYEl7hQmY7dYQKBgBRXKmTgK/zrxovWkwsihvJsOia55AwLv8p9Xwz1EavZUzowQnV29j7sMBdYy8LQMXvIi5NH9phSnLzH5bo2+ZdYn8m/eYNZbFJaWAxOPE8JFp5ueD3coEc7L7Nq2J5lSGfqS5NK7u46cMixOaoza18osqlMTNI6oQC+zCvsagH9";
	String ALIPAY_PUBLIC_KEY = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAgOi8nhTO29XZfz/5vKRcQjZqV6R5qKFOZa2UZeBOkHLXphSKL3ZLAkc+PkZr6U0woDa5mM2lZpZw4UuNpSCgDqskhx6QG3PFUi+msHPuzM0x+oTo1urTZJzUyaESFCcqaRyu1gQ6rcABHSqaVm30ql2Gf9yBzkpH4yGvZwVXL4+blxzuYbOa4KP8rm4PdgFPfjbV0H35bps1CVFAa0AfZU6msmWGbGCnyEsrEn8Uv8ZSW9TodhBMBYNs11uyTXvbgVsSWnf2o3dmjv2K1Mjslb+BES196y5G9kFy6K72J//Dq7ba+VfH0k+2Br/dTT2xcLYrZvC+qS5V5R+TfAZcuQIDAQAB";
	//签名方式
	String sign_type = "RSA2";
	//编码格式
	String CHARSET = "utf-8";
	//正式环境支付宝网关，如果是沙箱环境需更改成https://openapi.alipaydev.com/gateway.do
	String url = "https://openapi.alipaydev.com/gateway.do";
	//实例化客户端
	AlipayClient alipayClient = new DefaultAlipayClient(url, APP_ID, APP_PRIVATE_KEY, "json", CHARSET, ALIPAY_PUBLIC_KEY, sign_type);
	//实例化具体API对应的request类,类名称和接口名称对应,当前调用接口名称：alipay.trade.app.pay
	AlipayTradeAppPayRequest request = new AlipayTradeAppPayRequest();
	//SDK已经封装掉了公共参数，这里只需要传入业务参数。以下方法为sdk的model入参方式(model和biz_content同时存在的情况下取biz_content)。
	AlipayTradeAppPayModel model = new AlipayTradeAppPayModel();
		model.setBody("我是测试数据");
		model.setSubject("App支付测试Java");
	//请保证OutTradeNo值每次保证唯一
		model.setOutTradeNo("2017090080001939235");
		model.setTimeoutExpress("30m");
		model.setTotalAmount("0.01");
		model.setProductCode("QUICK_MSECURITY_PAY");
		request.setBizModel(model);
		request.setNotifyUrl("商户外网可以访问的异步地址");
	AlipayTradeAppPayResponse response=null;
		try {
		//这里和普通的接口调用不同，使用的是sdkExecute
		response = alipayClient.sdkExecute(request);
		System.out.println(response.getBody());//就是orderString 可以直接给客户端请求，无需再做处理。

	} catch (AlipayApiException e) {
		e.printStackTrace();
	}
		return response.getBody();
}

}
