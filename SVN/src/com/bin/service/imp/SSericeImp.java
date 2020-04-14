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






   //��׮
	@Override
	public Object dianzhuang(Map map) {
		
		return dao.dianzhuang(map);
	}

   //������Ѽ�¼
	@Override
	public Object xiaofei(Map map) {
		System.out.println("������������");
		return dao.xiaofei(map);
	}


//����
	@Override
	public Object liuyan(Map map) {
		
		return dao.liuyan(map);
	}
//��׮ɾ��
	@Override
	public void delete(Map map) {
		dao.delete(map);
	}




//����Ա��¼
	@Override
	public Object glogin(Map map) {
		List<Map> list = dao.glogin(map);
		System.out.println("g����Ա��½service");
		System.out.println(list);
		//�ж�list�Ƿ�Ϊ��
		return list.size()!=0?"success":"kong";
	}

	@Override
	public String SessionSelect(String sessionid) {
		// TODO Auto-generated method stub
		//��ѯ���ݿⲢ��ȡ����ֵ
				List<Map> list = dao.SessionSelect(sessionid);
				System.out.println("��ѯ�����"+list);
				//�ж�
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
	//��ѯ���޴��ֻ���
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
	//����uer���û���Ϣ
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
	//����user��money
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
		System.out.println("��½service");
		System.out.println(list);
		//�ж�list�Ƿ�Ϊ��
		return list.size()!=0?"success":"kong";
	}
*/
	
	 //������Ѽ�¼
		@Override
		public List<Map> xiaofei2(Map map) {
			
			return dao.xiaofei2(map);
		}
	//�������
		@Override
		public void jialiuyan(Map map) {
			// TODO Auto-generated method stub
			System.out.println("������Ե����ݿ�");
			 dao.jialiuyan(map);
		}
		//�û�����

		@Override
		public List<Map> yh(Map map) {
			// TODO Auto-generated method stub
			return dao.yh(map);
		}
       //����ɾ��
		@Override
		public void ldelete(Map map) {
			dao.ldelete(map);
			
		}

		//��ѯ��ͷ��״̬
				@Override
				public List<Map> ChaSelect() {
					List<Map> chaSelect = dao.ChaSelect();
					return chaSelect;
				}
				
				//���Ĳ�ͷ״̬
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
