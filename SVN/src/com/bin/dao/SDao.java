package com.bin.dao;

import java.util.List;
import java.util.Map;


public interface SDao {
	//����Ա��½
	public List<Map> glogin(Map map);
	//��׮
	public List<Map>dianzhuang(Map map);

	//��ѯ������Ѽ�¼
	public List<Map>xiaofei(Map map);
	//��������
	public List<Map>liuyan(Map map);
	//��׮��Ϣɾ��
	public  void delete(Map map);
	//������Ϣɾ��
	public  void ldelete(Map map);
	
	public List<Map> SessionSelect(String sessionid);
    //������Ѽ�¼
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
	//������Ѽ�¼
	public List<Map> xiaofei2(Map map);
	//�û�����
	public List<Map> yh(Map map);
	//��ѯ��ͷ��״̬
	public List<Map> ChaSelect();
		//���Ĳ�ͷ״̬
	public void qiang(Map map);
	//��ѯ���е�׮����Ϣ
	 public List<Map> query(Map map);
	//ɾ����Ϣ
		public int deletedz(Map map);
		//�޸���Ϣ
		public int update(Map map);
		//�����Ϣ
		public int insert(Map map) ;
		//��ѯ״̬Ϊ1�ĵ�׮����Ϣ
		 public List<Map> query1(Map map);
		//��ѯ״̬Ϊ(����)0�ĵ�׮����Ϣ
		 public List<Map> query0(Map map);
		//��ѯ״̬Ϊ(����)2�ĵ�׮����Ϣ
		 public List<Map> query2(Map map);
}
