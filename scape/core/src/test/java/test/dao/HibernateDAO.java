package test.dao;

import me.scape.ti.dao.UserDAO;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 
 * @author 刘飞 E-mail:liufei_it@126.com
 * @version 1.0.0
 * @since 2014年12月21日 下午4:23:26
 */
public class HibernateDAO {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[]{
				"classpath:conf/core-configurer.xml"
		});
		UserDAO userDAO = context.getBean(UserDAO.class);
		
		System.out.println(userDAO);
		
		context.close();
	}
}