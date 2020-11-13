package com.example.utils;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.domain.AlipayTradeAppPayModel;
import com.alipay.api.request.AlipayTradeAppPayRequest;
import com.alipay.api.response.AlipayTradeAppPayResponse;

/**
 * 2017-07-21 by ���Ǹ�����
 * ��ӭ����֧������̳��https://openclub.alipay.com/index.php
 */

public class Alipaytradeapppay {

	public String pay() {


	String APP_ID = "2019041563865908";
	String APP_PRIVATE_KEY = "MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQCGYJVNgfcM+Ng8pkxq/dBgN6EYIDZ/5yMszdzEN/vBBXzVDzShr58H0bL7q08U3LYm2jFJbYeLUBKs+k/mfDvndDmoYsISKfNkhzBDWM2ZMHy/w5kw8HGO2oObPnPMcZpol0AjuySdcPa47ZCKZy768FH0/Av+U57hEr2Hxxv2qK9ekYDK4ObmZb2eVDgLxCNPRl+EV2hktubtC6i2KGzIGDPHGoHVRkS122OwImLFGMLS2ADhPryQM9RBflwUAlyEqwmU6shoLiRuXO8qgeagh71hw7mR3Os+lpRybAmHLjq+B7Rsyj2L0aSqA9Iz7snweB0ZQkOOWNvHerJCriLdAgMBAAECggEAEP7sQ1ZZyeE7cEhUR//8N/8xN9zzJ7AzSbpr3sF57QrlpAj9TinpQlLqgVxEb04PF9DnBPN+fkdNZWVvb6Zs6TRRCpQbGbMGnsNeflYgAu0YCiUSHhd7NWc72AnJGaWQswPWT+6eje84tWEOtAKi9YgpxYOPfMZUxQDaye6MAeFbBjUYjwhq4vZrm9cdB4XctVBRcHCExCwsbNXWU4yRdkYoznwCBwX2CGBZEvPRk8NusHPjNZJUbBjEoGNv2zAv7n014xsdTnM0lyYTonAj0D+EFMMVzwpduASILqI75XEY/kyywBaxS9HIgXM5UUFPpExdZFLUIq3ZYXrd/kYhwQKBgQC+NgXkzDZ7ICnQi6a2FmMQ5HYbihfTR5bezL88KN37yTb1EFIZLl0egpHgKAp1WWVg+yb755Lo1BbWEuJrJjOFIFOaZjIRWvHDLRqRM2Z78v4Myj6FV+JuyxeYDCwbrPnYiSYF871bub0T4zqgQaXjuAWbDbY/GDVXChFmRoc3TQKBgQC02tYzwZuxESZhzr2qBtUJDcoI13FsYwyOYUVgnl+BD3IPGfVElAKIzbJp8zwDyzm+7m92Zi6XZ5O4gJL6JN+TtBx+1MFpZCDkQVTPyfYR3588pMO6Iw6RgJ03Ksjaj0eMoRwVC9Rp6XURpkXpwUhoiI+cTm9/PeYeYQ9BI+Vx0QKBgQCVIBuszqIkFApUcziH57NRihxC6RhWz/irwtBnZQ7smUuaBGqpTV06T1n46MuSRz0hNKbStjLKkYU53uJe6TtZMwf4tAiq7KdAwvriPe8qXE7rTiCIQGfJPzbHQTvPkuTq7FPANOEPqeZgUjUjcXSSvTK/5pcsjlk7XSxZCBB4vQKBgQCSc3ttoeQ/uJGKNm4j1zCACmiGTGAO0w6B5YbWvKi9zBIi5HRWujxrJ5bIcS0yLUlvsYkVKZ2lATz/9S4P3fgmlX1Vv1d3zptL+xOAyBy5UIqUAyB0BJtxe+LTn5PSWKAp4vTonhG+SkyApFKM/fVyoNMaUfG76hYEl7hQmY7dYQKBgBRXKmTgK/zrxovWkwsihvJsOia55AwLv8p9Xwz1EavZUzowQnV29j7sMBdYy8LQMXvIi5NH9phSnLzH5bo2+ZdYn8m/eYNZbFJaWAxOPE8JFp5ueD3coEc7L7Nq2J5lSGfqS5NK7u46cMixOaoza18osqlMTNI6oQC+zCvsagH9";
	String ALIPAY_PUBLIC_KEY = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAgOi8nhTO29XZfz/5vKRcQjZqV6R5qKFOZa2UZeBOkHLXphSKL3ZLAkc+PkZr6U0woDa5mM2lZpZw4UuNpSCgDqskhx6QG3PFUi+msHPuzM0x+oTo1urTZJzUyaESFCcqaRyu1gQ6rcABHSqaVm30ql2Gf9yBzkpH4yGvZwVXL4+blxzuYbOa4KP8rm4PdgFPfjbV0H35bps1CVFAa0AfZU6msmWGbGCnyEsrEn8Uv8ZSW9TodhBMBYNs11uyTXvbgVsSWnf2o3dmjv2K1Mjslb+BES196y5G9kFy6K72J//Dq7ba+VfH0k+2Br/dTT2xcLYrZvC+qS5V5R+TfAZcuQIDAQAB";
	//ǩ����ʽ
	String sign_type = "RSA2";
	//�����ʽ
	String CHARSET = "utf-8";
	//��ʽ����֧�������أ������ɳ�价������ĳ�https://openapi.alipaydev.com/gateway.do
	String url = "https://openapi.alipaydev.com/gateway.do";
	//ʵ�����ͻ���
	AlipayClient alipayClient = new DefaultAlipayClient(url, APP_ID, APP_PRIVATE_KEY, "json", CHARSET, ALIPAY_PUBLIC_KEY, sign_type);
	//ʵ��������API��Ӧ��request��,�����ƺͽӿ����ƶ�Ӧ,��ǰ���ýӿ����ƣ�alipay.trade.app.pay
	AlipayTradeAppPayRequest request = new AlipayTradeAppPayRequest();
	//SDK�Ѿ���װ���˹�������������ֻ��Ҫ����ҵ����������·���Ϊsdk��model��η�ʽ(model��biz_contentͬʱ���ڵ������ȡbiz_content)��
	AlipayTradeAppPayModel model = new AlipayTradeAppPayModel();
		model.setBody("���ǲ�������");
		model.setSubject("App֧������Java");
	//�뱣֤OutTradeNoֵÿ�α�֤Ψһ
		model.setOutTradeNo("2017090080001939235");
		model.setTimeoutExpress("30m");
		model.setTotalAmount("0.01");
		model.setProductCode("QUICK_MSECURITY_PAY");
		request.setBizModel(model);
		request.setNotifyUrl("�̻��������Է��ʵ��첽��ַ");
	AlipayTradeAppPayResponse response=null;
		try {
		//�������ͨ�Ľӿڵ��ò�ͬ��ʹ�õ���sdkExecute
		response = alipayClient.sdkExecute(request);
		System.out.println(response.getBody());//����orderString ����ֱ�Ӹ��ͻ�������������������

	} catch (AlipayApiException e) {
		e.printStackTrace();
	}
		return response.getBody();
}

}
