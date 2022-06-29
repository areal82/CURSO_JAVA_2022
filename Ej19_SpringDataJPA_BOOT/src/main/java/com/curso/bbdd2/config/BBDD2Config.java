package com.curso.bbdd2.config;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

import com.zaxxer.hikari.HikariDataSource;

//Producto
@Configuration
@EnableJpaRepositories(
		entityManagerFactoryRef = "bbdd2EntityManagerFactory", 
		transactionManagerRef = "bbdd2JpaTransactionManager", 
		basePackages = {"com.curso.bbdd2.repo" }
	)
public class BBDD2Config {
	
	@Bean
	@ConfigurationProperties("spring.datasource.bbdd2")
	public DataSourceProperties bbdd2DataSourceProperties() {
		return new DataSourceProperties();
	}

	@Bean
	@ConfigurationProperties("spring.datasource.bbdd2.configuration")
	public DataSource bbdd2DataSource() {
		return bbdd2DataSourceProperties().initializeDataSourceBuilder().type(HikariDataSource.class).build();
	}	
	
	@Bean
	public LocalContainerEntityManagerFactoryBean bbdd2EntityManagerFactory(DataSource bbdd2DataSource) {
        LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
        entityManagerFactoryBean.setDataSource(bbdd2DataSource);
        entityManagerFactoryBean.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
        entityManagerFactoryBean.setPackagesToScan("com.curso.bbdd2.modelo");
 
        Properties jpaProperties = new Properties();
        jpaProperties.put("hibernate.dialect", "org.hibernate.dialect.MySQL8Dialect");
        jpaProperties.put("hibernate.hbm2ddl.auto","update");
        jpaProperties.put("hibernate.show_sql", "true");
        jpaProperties.put("hibernate.format_sql", "false");
        entityManagerFactoryBean.setJpaProperties(jpaProperties);
 
        return entityManagerFactoryBean;
	}

	@Bean
	public PlatformTransactionManager bbdd2JpaTransactionManager(EntityManagerFactory bbdd2EntityManagerFactory) {
		return new JpaTransactionManager(bbdd2EntityManagerFactory);
	}
}