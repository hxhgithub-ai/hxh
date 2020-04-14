package com.bin.controller;

import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.bin.service.SService;
import com.miaodiyun.httpapidemo.SmsApiHttpSendTest;

import net.sf.json.JSONArray;


@Controller
@Scope("prototype")
@RequestMapping("test")
public class SController {
	private static String yanzheng = null;
	private static Map hashmap = new HashMap();
	private static SimpleDateFormat sim = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	private static Map usermap = new HashMap();
	private static Map chamap = new HashMap();
	private static String phone = null;
	private static int money;
	private static Map mnmap = new HashMap();
	private static String fang = null;
	private int index;
	private static String cha = null;
		@Autowired
		SService service;
		
		
		//管理员登陆
				@RequestMapping("/login")
				@ResponseBody
				public String login(@RequestParam Map map ,HttpServletRequest req) {
					System.out.println("登陆controller");
					System.out.println(map.toString());
					HttpSession session =req.getSession();
					Object username =req.getParameter("username");
					session.setAttribute("username", username);
					if(map.containsKey(username)) {
						System.out.println("该用户已存在");
						System.out.println("map:"+map);
						
					}else {
						System.out.println("非登录");
					}
					return service.glogin(map).toString();
				}
		
		
		
		
		//电桩信息
				@RequestMapping(value="/dian",produces="text/html;charset=UTF-8")
				@ResponseBody
				public String dianzhuang(@RequestParam Map map) {
					System.out.println("进入电桩信息查询");
					Object list = service.dianzhuang(map);
					System.out.println(list.toString());
					String json = JSON.toJSONString(list);
					System.out.println(json);
					return json;
				}

		//充电消费信息
		@RequestMapping(value="/xiao",produces="text/html;charset=UTF-8")
		@ResponseBody
		public String xiaofei(@RequestParam Map map) {
			System.out.println("进入消费记录查询");
			Object list = service.xiaofei(map);
			System.out.println(list.toString());
			String json = JSON.toJSONString(list);
			System.out.println(json);
			return json;
				}

		//管理员留言中心
				@RequestMapping(value="/liu",produces="text/html;charset=UTF-8")
				@ResponseBody
				public String liuyan(@RequestParam Map map){
					System.out.println("进入留言中心查看留言");
					Object list = service.liuyan(map);
					System.out.println(list.toString());
					String json = JSON.toJSONString(list);
					System.out.println(json);
					return json;
					
				}
				//电桩删除
				@RequestMapping(value="/delete")
				public String delete(@RequestParam Map map) {
					System.out.println("进入电桩删除的方法");
					System.out.println("删除的id："+map.get("dID"));
					service.delete(map);
					
						return "/html/dianzhuang.html";
		

				}
				//留言删除
				@RequestMapping(value="/ldelete")
				public String ldelete(@RequestParam Map map) {
					System.out.println("进入留言删除的方法");
					System.out.println("删除的id："+map.get("id"));
					service.ldelete(map);
					
						return "/html/liuyan.html";
		

				}
				//首页
				@RequestMapping("/shou")
				@ResponseBody
				public String shou(@RequestParam Map map){
					String dianzhuang = (String) map.get("dianzhuang");
					money = Integer.parseInt((String)map.get("xiaomoney"));
					if(money==2) {
						hashmap.put("time","30");
					}else if(money==4) {
						hashmap.put("time","60");
					}if(money==8) {
						hashmap.put("time","120");
					}
					hashmap.put("dianzhuang",dianzhuang);
					hashmap.put("money",money);
					System.out.println("hashmap:"+hashmap);
					return "success";
				}
				//
				@RequestMapping(value="/cha",method= {RequestMethod.POST,RequestMethod.GET})
				@ResponseBody
				public String cha(@RequestParam Map map){
					 List<Map> chaSelect = service.ChaSelect();
					JSONArray json = JSONArray.fromObject(chaSelect);
					String data = json.toString();
					return data;
				}
				//插头页面确认
				@RequestMapping("/qiang")
				@ResponseBody
				public String qiang(@RequestParam Map map){
					System.out.println("....."+map);
					service.qiang(map);
					return "success";
				}
					
				//支付页面金额显示
				@RequestMapping("/jine")
				@ResponseBody
				public String jine(@RequestParam Map map){
					hashmap.get("time");
					Object money = hashmap.get("money");
					String m = String.valueOf(money);
					return m;
				}
				
				//支付页面金额显示
				@RequestMapping("/zhi")
				@ResponseBody
				public String zhi(@RequestParam Map map,HttpServletRequest request){
					//获取当前时间并添加到hashmap
					String start = sim.format(new Date());
					System.out.println("当前时间:"+start);
					hashmap.put("start",start);
					//获取充电结束之间
					Object time = hashmap.get("time");
					String endtime = qwe.t(time);
					hashmap.put("endtime", endtime);
					//获取session
					String sessionid = request.getSession().getId();
					//查询数据库有无此session
					String select = service.SessionSelect(sessionid);
					//获取登陆方式
					fang = String.valueOf(map.get("fang"));
					if(select.equals("yes")) {	//老用户
						System.out.println("有此sessionid，为老用户");
						//微信支付
						if(fang.equals("wei")) {
							System.out.println("hashmap:"+hashmap);
							service.xiaofei(hashmap);
							//成功时更改插头状态
							chamap.put("chazt", "1");
							 service.qiang(chamap);
							//System.out.println("更改插头状态："+qiang);
							return "lao";
						}else {
							//账户余额支付
							//通过手机号查询余额
							String moneySelect = service.MoneySelect(phone);
							int mny = 0;
						/*	for (Map map2 : moneySelect) {
								mny = Integer.parseInt((String) map2.get("money"));
							}*/
							mny = Integer.parseInt(moneySelect);
							if(mny>=money) {
								System.out.println("账户余额足够");
								//减账户余额而不用支付
								int i = mny-money;
								//更新user表money
								mnmap.put("money",i);
								mnmap.put("phone",phone);
								int upMoney = service.UpMoney(mnmap);
								System.out.println("账户余额变动："+upMoney);
								//成功时更改插头状态
								chamap.put("chazt", "1");
								service.qiang(chamap);
								//System.out.println("更改插头状态："+qiang);
								return "yue";
							}else {
								System.out.println("账户余额不足");
								return "buzu";
							}
						}
					}else {	//新用户
						System.out.println("无此sessionid，为新用户");
						return "xin";
					}
					
				}
				
				//发送验证码给手机号
				@RequestMapping("/phone")
				@ResponseBody
				public String phone(@RequestParam Map map,HttpServletRequest request) throws Exception {
					System.out.println("验证");
					//获取手机号
					phone = (String) map.get("phone");
					//判断手机号码是否正确
					if(phone.length()!=11) {
						if(phone.equals("")) {
							System.out.println("号码为空");
							return "kong";
						}else {
							System.out.println("手机号位数错误");
							return "shibai";
						}
					}else {
						System.out.println("手机号位数正确");
						System.out.println("手机号"+phone);
						//发送验证码并拿到返回值
						SmsApiHttpSendTest am = new SmsApiHttpSendTest();
						yanzheng = am.execute(phone);
						String[] split = yanzheng.split("/");
						Map result = JSON.parseObject(split[1]);
						//查看请求状态
						Object qingqiu = result.get("respDesc");
						System.out.println("获取到"+qingqiu);
						//获取本地生成的验证码
						yanzheng = split[0];
						if(qingqiu.equals("请求成功。")) {
							System.out.println("请求成功");
							return "success";
						}else {
							System.out.println("请求失败");
							return "shibai";
						}
					}
					
					
				}		
				//验证码判断
				@RequestMapping("/yan")
				@ResponseBody
				public String yanzheng(@RequestParam Map map,HttpServletRequest request) {
					System.out.println("验证");
					//获取页面传过来的验证码
					String yz = (String) map.get("yz");
					System.out.println(yz);
					if(yz.equals("")) {
						System.out.println("验证码为空");
						return "kong";
					}else {
						if(yz.equals(yanzheng)) {
							System.out.println("验证成功");
							//验证成功时将用户的sessionid添加进数据库
							String sessionid = request.getSession().getId();
							//给usermap添加数据
							usermap.put("phone", phone);
							usermap.put("sessionid", sessionid);
							//hashmap添加手机号
							hashmap.put("phone",phone);
							//验证成功后将数据添加到数据库
							System.out.println("全局变量hashmap:"+hashmap);
							System.out.println("全局变量usermap:"+usermap);
							//查询数据库有无此手机号
							String phoneSelect = service.PhoneSelect(phone);
							System.out.println("手机号有无："+phoneSelect);
							//根据有无手机号进行判断
							if(phoneSelect.equals("wu")) {
								int userInsert = service.userInsert(usermap);
								System.out.println("user表添加用户成功："+userInsert);
								int xiaofei = service.sxiaofei(hashmap);
								System.out.println("xiaofei表添加记录成功："+xiaofei);
								return "success";
							}else {	
								//有手机号就更新sessionid
								int up = service.UpuserByphone(usermap);
								System.out.println("更新:"+up);
								//支付方式
								if(fang.equals("wei")) {	//微信支付
									System.out.println("hashmap:"+hashmap);
									service.sxiaofei(hashmap);
									//成功时更改插头状态
									chamap.put("chazt", "1");
									service.qiang(chamap);
									//System.out.println("更改插头状态："+qiang);
									return "lao";
								}else {	//账户余额支付
									//通过手机号查询该账号有无余额
									String moneySelect = service.MoneySelect(phone);
									int mny = 0;
									/*for (Map map2 : moneySelect) {
										 mny = Integer.parseInt((String) map2.get("money"));
									}*/
									mny = Integer.parseInt(moneySelect);
									if(mny>=money) {
										System.out.println("账户余额足够");
										//减账户余额而不用支付
										int i = mny-money;
										//更新user表money
										mnmap.put("money",i);
										mnmap.put("phone",phone);
										int upMoney = service.UpMoney(mnmap);
										System.out.println("账户余额变动："+upMoney);
										//成功时更改插头状态
										chamap.put("chazt", "1");
										service.qiang(chamap);
										//System.out.println("更改插头状态："+qiang);
										return "yue";
									}else {//无余额
										System.out.println("账户余额不足");
										return "buzu";
									}
								}
							}
						}else {
							System.out.println("验证失败");
							return "shibai";
						}
					}
					
				}

				//支付页面金额显示
				@RequestMapping("/zhuang")
				@ResponseBody
				public String zhuang(@RequestParam Map map){
					//从数据库查找电桩编号
					return service.GetDianzhuang(phone);
				}
					//充电
			/*@RequestMapping("/sess")
			public String sess(@RequestParam Map map ,HttpServletRequest req) {
							System.out.println("sessioncontroller");
							//sId  = req.getRequestedSessionId();
							SimpleDateFormat sdf = new SimpleDateFormat();// 格式化时间 
						    sdf.applyPattern("yyyy-MM-dd HH:mm:ss");// a为am/pm的标记  
						    Date date = new Date();// 获取当前时间 
							map.put("starttime", date);
							//System.out.println("sessionid:"+sId);
							System.out.println(map);
							service.sess(map);
							return null;
							
						}*/
			
			//充值
			@RequestMapping("/cmony")
			@ResponseBody
			public String cmony(@RequestParam Map map ,HttpServletRequest req) {
				System.out.println("进入了充值页面");
				String sessionid = req.getSession().getId();
				map.put("phone", phone);
				map.put("sessionid", sessionid);
				System.out.println("map"+map.toString());
				//查询用户的余额
				Integer smony = service.smony(map);
				System.out.println("smony"+smony);
				if(smony==null) {
					index=0;
				}else {
					index =smony;
				}
				
				//遍历得到用户余额
				System.out.println("余额为："+index);
				System.out.println(smony);
				//判断
				if(index>0) {
					 String money = (String) map.get("money");
					int parseInt = Integer.parseInt(money);
					int moneys=parseInt+index;
					map.put("money", moneys);
					System.out.println("修改余额");
					service.umony(map);
				}else {
					System.out.println("添加余额");
					service.umony(map);
				}
				
				//service.cmony(map);
				System.out.println(map);
				return "success";
				
			}
			//用户消费信息查询
			@RequestMapping(value="/xiao2",produces="text/html;charset=UTF-8")
			@ResponseBody
			public String xiaofei2(@RequestParam Map map) {
				System.out.println("进入消费记录查询");
				map.put("phone", phone);
				List list = service.xiaofei2(map);
				System.out.println(list);
				String json = JSON.toJSONString(list);
				System.out.println(json);
				return json.toString();
					}
			//用户中心
			@RequestMapping(value="/yh",produces="text/html;charset=UTF-8")
			@ResponseBody
			public String yh(@RequestParam Map map) {
				map.put("phone", phone);
				System.out.println(map);
				System.out.println("进入用户中心");
				List list = service.yh(map);
				System.out.println(list);
				String json = JSON.toJSONString(list);
				System.out.println(json);
				return json.toString();	
			}

			//添加留言
			@RequestMapping(value="/jialiu")
			@ResponseBody
		public String jialiuyan(@RequestParam Map map, HttpServletRequest req){
				SimpleDateFormat sdf = new SimpleDateFormat("yyy-MM-dd HH:mm:ss");
				System.out.println("当前时间：" + sdf.format(new Date()));
				       Object time=sdf.format(new Date());
				       Object  title= req.getParameter("title");
				        map.put("time", time);
				        map.put("phone", phone);
				        map.put("title", title);
						System.out.println("添加留言");
						 service.jialiuyan(map);
						System.out.println("往页面转");
//						System.out.println(list.toString());
//						String json = JSON.toJSONString(list);
//						System.out.println(json);
						return "success";
						
					}
			//显示电桩信息
			@RequestMapping(value="/query",method= {RequestMethod.POST,RequestMethod.GET})
			@ResponseBody
			public String query(@RequestParam Map map) {
				List<Map> query = service.query(map);
				JSONArray json = JSONArray.fromObject(query);
				String data = json.toString();
				return data;
				
			}
			//添加
			@RequestMapping(value="/insert",method= {RequestMethod.POST,RequestMethod.GET})
			@ResponseBody
			public String insert(@RequestParam Map map) {
				Object Dname = map.get("Dname");
				Object Gname = map.get("Gname");
				Object Atime = map.get("Atime");
				Object Dtype = map.get("Dtype");
				Object Dguns = map.get("Dguns");
				Object Dversion = map.get("Dversion");
				Object Dstatus = map.get("chazt");
				System.out.println(Dname+" "+Gname);
				int reg = service.insert(map);
				if(Dname!=""&&Gname!=""&&Atime!=""&&Dtype!=""&&Dguns!=""&&Dversion!=""&&Dstatus!="") {
					return "success";
				}else {
					return "false";
				}
			}
			//删除
			@RequestMapping(value="/deletedz",method= {RequestMethod.POST,RequestMethod.GET})
			@ResponseBody
			public String deletedz(@RequestParam Map map) {
				int delete = service.deletedz(map);
				if(delete!=0) {
					return "success";
				}else {
					return "false";
				}
			}
			//修改
			@RequestMapping(value="/update",method= {RequestMethod.POST,RequestMethod.GET})
			@ResponseBody
			public String update(@RequestParam Map map) {
				int update = service.update(map);
				if(update!=0) {
					return "success";
				}else {
					return "false";
				}
			}
			//显示电桩信息
			@RequestMapping(value="/query1",method= {RequestMethod.POST,RequestMethod.GET})
			@ResponseBody
			public String query1(@RequestParam Map map) {
				List<Map> query1 = service.query1(map);
				JSONArray json = JSONArray.fromObject(query1);
				String data = json.toString();
				return data;
				
			}
			//显示电桩信息
			@RequestMapping(value="/query0",method= {RequestMethod.POST,RequestMethod.GET})
			@ResponseBody
			public String query0(@RequestParam Map map) {
				List<Map> query0 = service.query0(map);
				JSONArray json = JSONArray.fromObject(query0);
				String data = json.toString();
				return data;
				
			}
			//显示电桩信息
			@RequestMapping(value="/query2",method= {RequestMethod.POST,RequestMethod.GET})
			@ResponseBody
			public String query2(@RequestParam Map map) {
				List<Map> query2 = service.query2(map);
				JSONArray json = JSONArray.fromObject(query2);
				String data = json.toString();
				return data;
				
			}
} 
