package com.q.dao;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.metamodel.source.hbm.SetAttributeSourceImpl;
import org.springframework.stereotype.Repository;

import com.q.model.TbUser;

@Repository("userDao")
public class UserDao {

private SessionFactory sessionFactory;
	
	@Resource(name="mySessionFactory")
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public Session getSession(){
		return sessionFactory.getCurrentSession();
	}
	
	//�û�ע��
	public void regiest(TbUser user) {
		Session session = getSession(); 
		session.save(user);
	}
	
	/**
	 * ��ѯȫ���û�
	 * �˴�Ϊ��ѯȫ���������������ʮ���û�
	 * һ��ҳ�������ʾʮ���û�
	 * @author Qloud
	 * @return List<TbUser>
	 * */
	public List<TbUser> getAll(int page) {
		Session session = getSession(); 
		String hql = "FROM TbUser WHERE statues = 1 OR statues = 2";
		Query query = session.createQuery(hql);
		query.setFirstResult(page*10-10);
		query.setMaxResults(page*9);
		List<TbUser> userList = query.list();
		return userList;
	}
	
	/**
	 * ��ȡ��ҳ��
	 * @author Qloud
	 * @return List<TbUser>
	 * */
	public List<TbUser> getTotal() {
		Session session = getSession(); 
		String hql = "FROM TbUser WHERE statues = 1 OR statues = 2";
		List<TbUser> users = session.createQuery(hql).list();
		return users;
	}
	
	/**
	 * �����û�����ѯ�û�
	 * @author Qloud
	 * @return List<TbUser>
	 * */
	public List<TbUser> queryUserByName(String name) {
		Session session = getSession(); 
		String hql = "FROM TbUser WHERE (statues = 1 OR statues = 2) AND name = ?";
		List<TbUser> users = session.createQuery(hql)
													.setParameter(0, name)
													.list();
		return users;
	}

	//ɾ���û�
	public void deleteUser(TbUser user) {
		Session session = getSession(); 
		String hql = "UPDATE TbUser user SET user.statues = 0 WHERE id = ?";
		session.createQuery(hql).setParameter(0, user.getId());
	}

	//�޸��û�
	public void alertUser(TbUser user) {
		Session session = getSession(); 
		/*String hql = "UPDATE TbUser u SET u.password = ? AND u.email = ? AND u.sex = ? WHERE u.id = ?";
		Query query = session.createQuery(hql);
		query.setParameter(0, user.getPassword());
		query.setParameter(1, user.getEmail());
		query.setParameter(2, user.getSex());
		query.setParameter(3, user.getId());*/
		session.update(user);
	}

}