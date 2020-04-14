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
		
		
		//����Ա��½
				@RequestMapping("/login")
				@ResponseBody
				public String login(@RequestParam Map map ,HttpServletRequest req) {
					System.out.println("��½controller");
					System.out.println(map.toString());
					HttpSession session =req.getSession();
					Object username =req.getParameter("username");
					session.setAttribute("username", username);
					if(map.containsKey(username)) {
						System.out.println("���û��Ѵ���");
						System.out.println("map:"+map);
						
					}else {
						System.out.println("�ǵ�¼");
					}
					return service.glogin(map).toString();
				}
		
		
		
		
		//��׮��Ϣ
				@RequestMapping(value="/dian",produces="text/html;charset=UTF-8")
				@ResponseBody
				public String dianzhuang(@RequestParam Map map) {
					System.out.println("�����׮��Ϣ��ѯ");
					Object list = service.dianzhuang(map);
					System.out.println(list.toString());
					String json = JSON.toJSONString(list);
					System.out.println(json);
					return json;
				}

		//���������Ϣ
		@RequestMapping(value="/xiao",produces="text/html;charset=UTF-8")
		@ResponseBody
		public String xiaofei(@RequestParam Map map) {
			System.out.println("�������Ѽ�¼��ѯ");
			Object list = service.xiaofei(map);
			System.out.println(list.toString());
			String json = JSON.toJSONString(list);
			System.out.println(json);
			return json;
				}

		//����Ա��������
				@RequestMapping(value="/liu",produces="text/html;charset=UTF-8")
				@ResponseBody
				public String liuyan(@RequestParam Map map){
					System.out.println("�����������Ĳ鿴����");
					Object list = service.liuyan(map);
					System.out.println(list.toString());
					String json = JSON.toJSONString(list);
					System.out.println(json);
					return json;
					
				}
				//��׮ɾ��
				@RequestMapping(value="/delete")
				public String delete(@RequestParam Map map) {
					System.out.println("�����׮ɾ���ķ���");
					System.out.println("ɾ����id��"+map.get("dID"));
					service.delete(map);
					
						return "/html/dianzhuang.html";
		

				}
				//����ɾ��
				@RequestMapping(value="/ldelete")
				public String ldelete(@RequestParam Map map) {
					System.out.println("��������ɾ���ķ���");
					System.out.println("ɾ����id��"+map.get("id"));
					service.ldelete(map);
					
						return "/html/liuyan.html";
		

				}
				//��ҳ
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
				//��ͷҳ��ȷ��
				@RequestMapping("/qiang")
				@ResponseBody
				public String qiang(@RequestParam Map map){
					System.out.println("....."+map);
					service.qiang(map);
					return "success";
				}
					
				//֧��ҳ������ʾ
				@RequestMapping("/jine")
				@ResponseBody
				public String jine(@RequestParam Map map){
					hashmap.get("time");
					Object money = hashmap.get("money");
					String m = String.valueOf(money);
					return m;
				}
				
				//֧��ҳ������ʾ
				@RequestMapping("/zhi")
				@ResponseBody
				public String zhi(@RequestParam Map map,HttpServletRequest request){
					//��ȡ��ǰʱ�䲢��ӵ�hashmap
					String start = sim.format(new Date());
					System.out.println("��ǰʱ��:"+start);
					hashmap.put("start",start);
					//��ȡ������֮��
					Object time = hashmap.get("time");
					String endtime = qwe.t(time);
					hashmap.put("endtime", endtime);
					//��ȡsession
					String sessionid = request.getSession().getId();
					//��ѯ���ݿ����޴�session
					String select = service.SessionSelect(sessionid);
					//��ȡ��½��ʽ
					fang = String.valueOf(map.get("fang"));
					if(select.equals("yes")) {	//���û�
						System.out.println("�д�sessionid��Ϊ���û�");
						//΢��֧��
						if(fang.equals("wei")) {
							System.out.println("hashmap:"+hashmap);
							service.xiaofei(hashmap);
							//�ɹ�ʱ���Ĳ�ͷ״̬
							chamap.put("chazt", "1");
							 service.qiang(chamap);
							//System.out.println("���Ĳ�ͷ״̬��"+qiang);
							return "lao";
						}else {
							//�˻����֧��
							//ͨ���ֻ��Ų�ѯ���
							String moneySelect = service.MoneySelect(phone);
							int mny = 0;
						/*	for (Map map2 : moneySelect) {
								mny = Integer.parseInt((String) map2.get("money"));
							}*/
							mny = Integer.parseInt(moneySelect);
							if(mny>=money) {
								System.out.println("�˻�����㹻");
								//���˻���������֧��
								int i = mny-money;
								//����user��money
								mnmap.put("money",i);
								mnmap.put("phone",phone);
								int upMoney = service.UpMoney(mnmap);
								System.out.println("�˻����䶯��"+upMoney);
								//�ɹ�ʱ���Ĳ�ͷ״̬
								chamap.put("chazt", "1");
								service.qiang(chamap);
								//System.out.println("���Ĳ�ͷ״̬��"+qiang);
								return "yue";
							}else {
								System.out.println("�˻�����");
								return "buzu";
							}
						}
					}else {	//���û�
						System.out.println("�޴�sessionid��Ϊ���û�");
						return "xin";
					}
					
				}
				
				//������֤����ֻ���
				@RequestMapping("/phone")
				@ResponseBody
				public String phone(@RequestParam Map map,HttpServletRequest request) throws Exception {
					System.out.println("��֤");
					//��ȡ�ֻ���
					phone = (String) map.get("phone");
					//�ж��ֻ������Ƿ���ȷ
					if(phone.length()!=11) {
						if(phone.equals("")) {
							System.out.println("����Ϊ��");
							return "kong";
						}else {
							System.out.println("�ֻ���λ������");
							return "shibai";
						}
					}else {
						System.out.println("�ֻ���λ����ȷ");
						System.out.println("�ֻ���"+phone);
						//������֤�벢�õ�����ֵ
						SmsApiHttpSendTest am = new SmsApiHttpSendTest();
						yanzheng = am.execute(phone);
						String[] split = yanzheng.split("/");
						Map result = JSON.parseObject(split[1]);
						//�鿴����״̬
						Object qingqiu = result.get("respDesc");
						System.out.println("��ȡ��"+qingqiu);
						//��ȡ�������ɵ���֤��
						yanzheng = split[0];
						if(qingqiu.equals("����ɹ���")) {
							System.out.println("����ɹ�");
							return "success";
						}else {
							System.out.println("����ʧ��");
							return "shibai";
						}
					}
					
					
				}		
				//��֤���ж�
				@RequestMapping("/yan")
				@ResponseBody
				public String yanzheng(@RequestParam Map map,HttpServletRequest request) {
					System.out.println("��֤");
					//��ȡҳ�洫��������֤��
					String yz = (String) map.get("yz");
					System.out.println(yz);
					if(yz.equals("")) {
						System.out.println("��֤��Ϊ��");
						return "kong";
					}else {
						if(yz.equals(yanzheng)) {
							System.out.println("��֤�ɹ�");
							//��֤�ɹ�ʱ���û���sessionid��ӽ����ݿ�
							String sessionid = request.getSession().getId();
							//��usermap�������
							usermap.put("phone", phone);
							usermap.put("sessionid", sessionid);
							//hashmap����ֻ���
							hashmap.put("phone",phone);
							//��֤�ɹ���������ӵ����ݿ�
							System.out.println("ȫ�ֱ���hashmap:"+hashmap);
							System.out.println("ȫ�ֱ���usermap:"+usermap);
							//��ѯ���ݿ����޴��ֻ���
							String phoneSelect = service.PhoneSelect(phone);
							System.out.println("�ֻ������ޣ�"+phoneSelect);
							//���������ֻ��Ž����ж�
							if(phoneSelect.equals("wu")) {
								int userInsert = service.userInsert(usermap);
								System.out.println("user������û��ɹ���"+userInsert);
								int xiaofei = service.sxiaofei(hashmap);
								System.out.println("xiaofei����Ӽ�¼�ɹ���"+xiaofei);
								return "success";
							}else {	
								//���ֻ��ž͸���sessionid
								int up = service.UpuserByphone(usermap);
								System.out.println("����:"+up);
								//֧����ʽ
								if(fang.equals("wei")) {	//΢��֧��
									System.out.println("hashmap:"+hashmap);
									service.sxiaofei(hashmap);
									//�ɹ�ʱ���Ĳ�ͷ״̬
									chamap.put("chazt", "1");
									service.qiang(chamap);
									//System.out.println("���Ĳ�ͷ״̬��"+qiang);
									return "lao";
								}else {	//�˻����֧��
									//ͨ���ֻ��Ų�ѯ���˺��������
									String moneySelect = service.MoneySelect(phone);
									int mny = 0;
									/*for (Map map2 : moneySelect) {
										 mny = Integer.parseInt((String) map2.get("money"));
									}*/
									mny = Integer.parseInt(moneySelect);
									if(mny>=money) {
										System.out.println("�˻�����㹻");
										//���˻���������֧��
										int i = mny-money;
										//����user��money
										mnmap.put("money",i);
										mnmap.put("phone",phone);
										int upMoney = service.UpMoney(mnmap);
										System.out.println("�˻����䶯��"+upMoney);
										//�ɹ�ʱ���Ĳ�ͷ״̬
										chamap.put("chazt", "1");
										service.qiang(chamap);
										//System.out.println("���Ĳ�ͷ״̬��"+qiang);
										return "yue";
									}else {//�����
										System.out.println("�˻�����");
										return "buzu";
									}
								}
							}
						}else {
							System.out.println("��֤ʧ��");
							return "shibai";
						}
					}
					
				}

				//֧��ҳ������ʾ
				@RequestMapping("/zhuang")
				@ResponseBody
				public String zhuang(@RequestParam Map map){
					//�����ݿ���ҵ�׮���
					return service.GetDianzhuang(phone);
				}
					//���
			/*@RequestMapping("/sess")
			public String sess(@RequestParam Map map ,HttpServletRequest req) {
							System.out.println("sessioncontroller");
							//sId  = req.getRequestedSessionId();
							SimpleDateFormat sdf = new SimpleDateFormat();// ��ʽ��ʱ�� 
						    sdf.applyPattern("yyyy-MM-dd HH:mm:ss");// aΪam/pm�ı��  
						    Date date = new Date();// ��ȡ��ǰʱ�� 
							map.put("starttime", date);
							//System.out.println("sessionid:"+sId);
							System.out.println(map);
							service.sess(map);
							return null;
							
						}*/
			
			//��ֵ
			@RequestMapping("/cmony")
			@ResponseBody
			public String cmony(@RequestParam Map map ,HttpServletRequest req) {
				System.out.println("�����˳�ֵҳ��");
				String sessionid = req.getSession().getId();
				map.put("phone", phone);
				map.put("sessionid", sessionid);
				System.out.println("map"+map.toString());
				//��ѯ�û������
				Integer smony = service.smony(map);
				System.out.println("smony"+smony);
				if(smony==null) {
					index=0;
				}else {
					index =smony;
				}
				
				//�����õ��û����
				System.out.println("���Ϊ��"+index);
				System.out.println(smony);
				//�ж�
				if(index>0) {
					 String money = (String) map.get("money");
					int parseInt = Integer.parseInt(money);
					int moneys=parseInt+index;
					map.put("money", moneys);
					System.out.println("�޸����");
					service.umony(map);
				}else {
					System.out.println("������");
					service.umony(map);
				}
				
				//service.cmony(map);
				System.out.println(map);
				return "success";
				
			}
			//�û�������Ϣ��ѯ
			@RequestMapping(value="/xiao2",produces="text/html;charset=UTF-8")
			@ResponseBody
			public String xiaofei2(@RequestParam Map map) {
				System.out.println("�������Ѽ�¼��ѯ");
				map.put("phone", phone);
				List list = service.xiaofei2(map);
				System.out.println(list);
				String json = JSON.toJSONString(list);
				System.out.println(json);
				return json.toString();
					}
			//�û�����
			@RequestMapping(value="/yh",produces="text/html;charset=UTF-8")
			@ResponseBody
			public String yh(@RequestParam Map map) {
				map.put("phone", phone);
				System.out.println(map);
				System.out.println("�����û�����");
				List list = service.yh(map);
				System.out.println(list);
				String json = JSON.toJSONString(list);
				System.out.println(json);
				return json.toString();	
			}

			//�������
			@RequestMapping(value="/jialiu")
			@ResponseBody
		public String jialiuyan(@RequestParam Map map, HttpServletRequest req){
				SimpleDateFormat sdf = new SimpleDateFormat("yyy-MM-dd HH:mm:ss");
				System.out.println("��ǰʱ�䣺" + sdf.format(new Date()));
				       Object time=sdf.format(new Date());
				       Object  title= req.getParameter("title");
				        map.put("time", time);
				        map.put("phone", phone);
				        map.put("title", title);
						System.out.println("�������");
						 service.jialiuyan(map);
						System.out.println("��ҳ��ת");
//						System.out.println(list.toString());
//						String json = JSON.toJSONString(list);
//						System.out.println(json);
						return "success";
						
					}
			//��ʾ��׮��Ϣ
			@RequestMapping(value="/query",method= {RequestMethod.POST,RequestMethod.GET})
			@ResponseBody
			public String query(@RequestParam Map map) {
				List<Map> query = service.query(map);
				JSONArray json = JSONArray.fromObject(query);
				String data = json.toString();
				return data;
				
			}
			//���
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
			//ɾ��
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
			//�޸�
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
			//��ʾ��׮��Ϣ
			@RequestMapping(value="/query1",method= {RequestMethod.POST,RequestMethod.GET})
			@ResponseBody
			public String query1(@RequestParam Map map) {
				List<Map> query1 = service.query1(map);
				JSONArray json = JSONArray.fromObject(query1);
				String data = json.toString();
				return data;
				
			}
			//��ʾ��׮��Ϣ
			@RequestMapping(value="/query0",method= {RequestMethod.POST,RequestMethod.GET})
			@ResponseBody
			public String query0(@RequestParam Map map) {
				List<Map> query0 = service.query0(map);
				JSONArray json = JSONArray.fromObject(query0);
				String data = json.toString();
				return data;
				
			}
			//��ʾ��׮��Ϣ
			@RequestMapping(value="/query2",method= {RequestMethod.POST,RequestMethod.GET})
			@ResponseBody
			public String query2(@RequestParam Map map) {
				List<Map> query2 = service.query2(map);
				JSONArray json = JSONArray.fromObject(query2);
				String data = json.toString();
				return data;
				
			}
} 
