package com.niit.configuration;

import java.util.Properties;



import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.hibernate.SessionFactory;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.niit.model.Product;
import com.niit.model.Category;
@ComponentScan(basePackages="com.niit")
@Configuration
@EnableTransactionManagement
public class DBConfiguration {
		@Bean(name="dataSource")
	public DataSource getDataSource() {
		System.out.println("Entering DataSource Bean creation method");
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setDriverClassName("org.h2.Driver");
		dataSource.setUrl("jdbc:h2:tcp://localhost/~/testdb");
		dataSource.setUsername("sa");
		dataSource.setPassword("password");
		System.out.println("DataSource bean " +dataSource);
		return dataSource;
		
		
		
	}

	
	@Bean //SessionFactory - factory of session objects
	public SessionFactory sessionFactory() {
		System.out.println("Entering sessionFactory creation method");
		LocalSessionFactoryBuilder lsf=
				new LocalSessionFactoryBuilder(getDataSource());
		Properties hibernateProperties=new Properties();
		hibernateProperties.setProperty(
				"hibernate.dialect", "org.hibernate.dialect.H2Dialect");
		hibernateProperties.setProperty("hibernate.hbm2ddl.auto", "update");
		hibernateProperties.setProperty("hibernate.show_sql", "true");
		lsf.addProperties(hibernateProperties);
		//An array of Class objects of all the entities
		//Map all entities to relational table
		Class classes[]=new Class[]{Product.class,Category.class};
		//localsesionfactorybuilder -> sessionfactory -> map all entities with relation table
		System.out.println("SessionFactory bean " + lsf);
	    return lsf.addAnnotatedClasses(classes).buildSessionFactory();
	}
	
	
	@Bean
	public HibernateTransactionManager hibTransManagement(){
		return new HibernateTransactionManager(sessionFactory());
}

}
 