package me.scape.ti.commons;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

/**
 * 
 * @author john.liu E-mail:fei.liu@yeepay.com
 * @version 1.0.0
 * @since 2014年12月26日 下午7:31:02
 */
public class EntityManagerSupport implements InitializingBean {
	
	protected EntityManagerFactory entityManagerFactory;
	
	protected EntityManagerFactory getEntityManagerFactory() {
		return entityManagerFactory;
	}
	
	@Bean
	public DataSource dataSource() {
		com.jolbox.bonecp.BoneCPDataSource dataSource = new com.jolbox.bonecp.BoneCPDataSource();
		dataSource.setDriverClass("com.mysql.jdbc.Driver");
		dataSource.setJdbcUrl("jdbc:mysql://scape_mysql_master:3306/scape?useUnicode=yes&amp;characterEncoding=UTF-8&amp;autoReconnect=true&amp;useServerPrepStmts=true&amp;useCursorFetch=true");
		dataSource.setUsername("root");
		dataSource.setPassword("lF0130lf");
		return dataSource;
	}

	@Bean
	public EntityManagerFactory entityManagerFactory() {
		HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
		vendorAdapter.setGenerateDdl(true);
		LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
		factory.setJpaVendorAdapter(vendorAdapter);
		factory.setPackagesToScan("me.scape.ti.dataobject");
		factory.setDataSource(dataSource());
		factory.afterPropertiesSet();
		return factory.getObject();
	}

	@Bean
	public PlatformTransactionManager transactionManager() {
		JpaTransactionManager txManager = new JpaTransactionManager();
		txManager.setEntityManagerFactory(entityManagerFactory());
		return txManager;
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		
	}
}