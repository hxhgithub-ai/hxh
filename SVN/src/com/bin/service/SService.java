package com.bin.service;

import java.util.List;
import java.util.Map;

public interface SService{

	//����Ա��½
	public Object glogin(Map map);
	//��׮
	public Object dianzhuang(Map map);

	//������Ѽ�¼��ѯ
	public 	Object xiaofei(Map map);
	//����Ա����
	public Object liuyan(Map map); 
	//��׮ɾ��
	public void delete(Map map);
	//��ѯ���ݿ�����session
	public String SessionSelect(String sessionid);

	public int sxiaofei(Map hashmap);

	public int userInsert(Map usermap);

	public String GetDianzhuang(String phone);

	public String PhoneSelect(String phone);

	public int UpuserByphone(Map usermap);

	public String MoneySelect(String phone);

	public int UpMoney(Map mnmap);
		//���
	public void sess(Map map);
		//��ֵ�˻�
	public void cmony(Map map);
		//��ֵ֮��ѯ�˻����
	public Integer smony(Map map);
		//��ֵ֮�޸��˻����
	public void umony(Map map);
	
	//�������
	public void jialiuyan(Map map);

		/*//����
		public Object liuyan2(Map map); */
		//�û�����
	public List<Map> yh(Map map);
	public List<Map> xiaofei2(Map map);
	public void ldelete(Map map);
	//��ѯ��ͷ״̬
	public List<Map> ChaSelect();
	//���Ĳ�ͷ״̬
	public void qiang(Map map);
	//��ѯ���е�׮����Ϣ
		 public List<Map> query(Map map);
		//ɾ����Ϣ
			public int deletedz(Map map);
			//�޸���Ϣ
			public int update(Map map);
			//�û�ע��
			public int insert(Map map) ;
			//��ѯ״̬Ϊ1�ĵ�׮����Ϣ
			 public List<Map> query1(Map map);
			//��ѯ״̬Ϊ(����)0�ĵ�׮����Ϣ
			 public List<Map> query0(Map map);
			//��ѯ״̬Ϊ(����)2�ĵ�׮����Ϣ
			 public List<Map> query2(Map map);

}
