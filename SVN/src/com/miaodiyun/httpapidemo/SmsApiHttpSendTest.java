package com.miaodiyun.httpapidemo;

import com.miaodiyun.httpapidemo.common.Config;
import com.miaodiyun.httpapidemo.common.HttpUtil;
import com.miaodiyun.httpapidemo.common.asd;

import java.net.URLEncoder;

/**
 * 短信API发送
 * @author JiangPengFei
 * @version $Id: javaHttpNewApiDemo, v 0.1 2019/1/23 11:42 JiangPengFei Exp $$
 */
public class SmsApiHttpSendTest {
	/**
	 * 短信发送(验证码通知，会员营销)
	 * 接口文档地址：http://www.miaodiyun.com/doc/https_sms.html
	 */
	public String execute(String phone) throws Exception{
		StringBuilder sb = new StringBuilder();
		sb.append("accountSid").append("=").append(Config.ACCOUNT_SID);
		sb.append("&to").append("=").append(phone);
		String yanzheng = asd.as();
		sb.append("&param").append("=").append(URLEncoder.encode(yanzheng,"UTF-8"));
		sb.append("&templateid").append("=").append("241254");
//		sb.append("&smsContent").append("=").append( URLEncoder.encode("【凯煌科技】您的验证码为{1}，请于2分钟内正确输入，如非本人操作，请忽略此短信。","UTF-8"));
		String body = sb.toString() + HttpUtil.createCommonParam(Config.ACCOUNT_SID, Config.AUTH_TOKEN);
		String result = HttpUtil.post(Config.BASE_URL, body);
		System.out.println(result);
		return yanzheng+"/"+result;
	}

	
}
