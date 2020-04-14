package com.bin.service;

import java.util.List;
import java.util.Map;

public interface SService{

	//管理员登陆
	public Object glogin(Map map);
	//电桩
	public Object dianzhuang(Map map);

	//充电消费记录查询
	public 	Object xiaofei(Map map);
	//管理员留言
	public Object liuyan(Map map); 
	//电桩删除
	public void delete(Map map);
	//查询数据库有无session
	public String SessionSelect(String sessionid);

	public int sxiaofei(Map hashmap);

	public int userInsert(Map usermap);

	public String GetDianzhuang(String phone);

	public String PhoneSelect(String phone);

	public int UpuserByphone(Map usermap);

	public String MoneySelect(String phone);

	public int UpMoney(Map mnmap);
		//充电
	public void sess(Map map);
		//充值账户
	public void cmony(Map map);
		//充值之查询账户余额
	public Integer smony(Map map);
		//充值之修改账户余额
	public void umony(Map map);
	
	//添加留言
	public void jialiuyan(Map map);

		/*//留言
		public Object liuyan2(Map map); */
		//用户中心
	public List<Map> yh(Map map);
	public List<Map> xiaofei2(Map map);
	public void ldelete(Map map);
	//查询插头状态
	public List<Map> ChaSelect();
	//更改插头状态
	public void qiang(Map map);
	//查询所有电桩的信息
		 public List<Map> query(Map map);
		//删除信息
			public int deletedz(Map map);
			//修改信息
			public int update(Map map);
			//用户注册
			public int insert(Map map) ;
			//查询状态为1的电桩的信息
			 public List<Map> query1(Map map);
			//查询状态为(空闲)0的电桩的信息
			 public List<Map> query0(Map map);
			//查询状态为(离线)2的电桩的信息
			 public List<Map> query2(Map map);

}
