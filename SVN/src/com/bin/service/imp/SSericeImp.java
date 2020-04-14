package com.bin.service.imp;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bin.dao.SDao;
import com.bin.service.SService;

import net.sf.json.JSONArray;

@Service
public class SSericeImp implements SService {

	@Autowired
	SDao dao;






   //电桩
	@Override
	public Object dianzhuang(Map map) {
		
		return dao.dianzhuang(map);
	}

   //充电消费记录
	@Override
	public Object xiaofei(Map map) {
		System.out.println("啦啦啦啦消费");
		return dao.xiaofei(map);
	}


//留言
	@Override
	public Object liuyan(Map map) {
		
		return dao.liuyan(map);
	}
//电桩删除
	@Override
	public void delete(Map map) {
		dao.delete(map);
	}




//管理员登录
	@Override
	public Object glogin(Map map) {
		List<Map> list = dao.glogin(map);
		System.out.println("g管理员登陆service");
		System.out.println(list);
		//判断list是否为空
		return list.size()!=0?"success":"kong";
	}

	@Override
	public String SessionSelect(String sessionid) {
		// TODO Auto-generated method stub
		//查询数据库并获取返回值
				List<Map> list = dao.SessionSelect(sessionid);
				System.out.println("查询结果："+list);
				//判断
				return list.size()!=0?"yes":"no";
	}

	@Override
	public int sxiaofei(Map hashmap) {
		// TODO Auto-generated method stub
		return dao.sxiaofei(hashmap);
	}

	@Override
	public int userInsert(Map usermap) {
		// TODO Auto-generated method stub
		return dao.userInsert(usermap);
	}

	@Override
	public String GetDianzhuang(String phone) {
		// TODO Auto-generated method stub
				return dao.GetDianzhuang(phone);
	}
	//查询有无此手机号
	@Override
	public String PhoneSelect(String phone) {
		// TODO Auto-generated method stub
		String phoneSelect = dao.PhoneSelect(phone);
		System.out.println("phoneSelect:"+phoneSelect);
		System.out.println("phone:"+phone);
		if(phone.equals(phoneSelect)) {
			return "you";
		}else {
			return "wu";
		}
	}
	//更新uer表用户信息
	@Override
	public int UpuserByphone(Map usermap) {
		// TODO Auto-generated method stub
		return dao.UpuserByphone(usermap);
	}

	@Override
	public String MoneySelect(String phone) {
		// TODO Auto-generated method stub
		return dao.MoneySelect(phone);
	}
	//更新user表money
	@Override
	public int UpMoney(Map mnmap) {
		// TODO Auto-generated method stub
		return dao.UpMoney(mnmap);
	}

	@Override
	public void sess(Map map) {
		dao.sess(map);
		
	}

	@Override
	public void cmony(Map map) {
		dao.cmony(map);
		
	}

	@Override
	public Integer smony(Map map) {
		// TODO Auto-generated method stub
				return dao.smony(map);
	}

	@Override
	public void umony(Map map) {
		// TODO Auto-generated method stub
		dao.umony(map);
		
	}


	/*@Override
	public Object yliuyan(Map map) {
		List<Map> list = dao.yliuyan(map);
		System.out.println("登陆service");
		System.out.println(list);
		//判断list是否为空
		return list.size()!=0?"success":"kong";
	}
*/
	
	 //充电消费记录
		@Override
		public List<Map> xiaofei2(Map map) {
			
			return dao.xiaofei2(map);
		}
	//添加留言
		@Override
		public void jialiuyan(Map map) {
			// TODO Auto-generated method stub
			System.out.println("添加留言到数据库");
			 dao.jialiuyan(map);
		}
		//用户中心

		@Override
		public List<Map> yh(Map map) {
			// TODO Auto-generated method stub
			return dao.yh(map);
		}
       //留言删除
		@Override
		public void ldelete(Map map) {
			dao.ldelete(map);
			
		}

		//查询插头和状态
				@Override
				public List<Map> ChaSelect() {
					List<Map> chaSelect = dao.ChaSelect();
					return chaSelect;
				}
				
				//更改插头状态
				@Override
				public void qiang(Map map) {
					// TODO Auto-generated method stub
					 dao.qiang(map);
				}

				@Override
				public List<Map> query(Map map) {
					// TODO Auto-generated method stub
					List<Map> query = dao.query(map);
					return query;
				}

				@Override
				public int deletedz(Map map) {
					// TODO Auto-generated method stub
					int deletedz = dao.deletedz(map);
					return deletedz;
				}

				@Override
				public int update(Map map) {
					// TODO Auto-generated method stub
					return dao.update(map);
				}

				@Override
				public int insert(Map map) {
					// TODO Auto-generated method stub
					return dao.insert(map);
				}

				@Override
				public List<Map> query1(Map map) {
					List<Map> query1 = dao.query1(map);
					return query1;
				}

				@Override
				public List<Map> query0(Map map) {
					List<Map> query0 = dao.query0(map);
					return query0;
				}

				@Override
				public List<Map> query2(Map map) {
					List<Map> query2 = dao.query2(map);
					return query2;
				}
	
	
	
}
