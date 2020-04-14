package com.bin.dao;

import java.util.List;
import java.util.Map;


public interface SDao {
	//管理员登陆
	public List<Map> glogin(Map map);
	//电桩
	public List<Map>dianzhuang(Map map);

	//查询充电消费记录
	public List<Map>xiaofei(Map map);
	//留言中心
	public List<Map>liuyan(Map map);
	//电桩信息删除
	public  void delete(Map map);
	//留言信息删除
	public  void ldelete(Map map);
	
	public List<Map> SessionSelect(String sessionid);
    //添加消费记录
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
	//充电消费记录
	public List<Map> xiaofei2(Map map);
	//用户中心
	public List<Map> yh(Map map);
	//查询插头和状态
	public List<Map> ChaSelect();
		//更改插头状态
	public void qiang(Map map);
	//查询所有电桩的信息
	 public List<Map> query(Map map);
	//删除信息
		public int deletedz(Map map);
		//修改信息
		public int update(Map map);
		//添加信息
		public int insert(Map map) ;
		//查询状态为1的电桩的信息
		 public List<Map> query1(Map map);
		//查询状态为(空闲)0的电桩的信息
		 public List<Map> query0(Map map);
		//查询状态为(离线)2的电桩的信息
		 public List<Map> query2(Map map);
}
