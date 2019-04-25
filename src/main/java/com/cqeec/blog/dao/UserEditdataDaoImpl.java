package com.cqeec.blog.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cqeec.blog.entity.SystemUser;

@Repository
public class UserEditdataDaoImpl implements UserEditdataDao {
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void editData(String id, String nickname, String netname,
			String address, String occupation, String password) {
		sessionFactory
				.getCurrentSession()
				.createQuery(
						"UPDATE SystemUser su SET su.nickname=:nickname,su.netname=:netname,su.address=:address,su.occupation=:occupation,su.password=:password WHERE su.id=:id")
				.setParameter("nickname", nickname)
				.setParameter("netname", netname)
				.setParameter("address", address)
				.setParameter("occupation", occupation)
				.setParameter("password", password).setParameter("id", id)
				.executeUpdate();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<SystemUser> checkPwdIdUpdate() {
		
		return sessionFactory.getCurrentSession().createQuery("FROM SystemUser").list();
	}
}
