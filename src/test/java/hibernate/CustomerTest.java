package hibernate;

import java.util.UUID;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.cqeec.blog.entity.Customer;
import com.cqeec.blog.entity.SystemUser;
import com.cqeec.blog.service.UserRegisterService;

public class CustomerTest {
	@Autowired
	private UserRegisterService userService;

	@Autowired
	private SessionFactory sessionFactory;

	@Test
	public void inserTest() {
		// 加载hibernate.cfg.xml
		Configuration config = new Configuration().configure();
		// 获取SessionFactory
		SessionFactory sessionFactory = config.buildSessionFactory();
		// 得到一个Session
		Session session = sessionFactory.openSession();
		// 开启事务
		Transaction t = session.beginTransaction();
		// 操作
		Customer c = new Customer();
		c.setId(UUID.randomUUID().toString().toUpperCase());
		c.setName("展示");
		c.setAge(23);
		c.setCity("上海");
		c.setSex("女");
		session.save(c);
		t.commit();

	}

	@Test
	public void testInsertUser() {
		SystemUser su=new SystemUser();
		su.setNickname("2222");
		su.setUsername("ZS222");
		su.setPassword("12222");
		su.setPassword2("1");
		su.setId("444444");
		sessionFactory.getCurrentSession().save(su);
	}
}
