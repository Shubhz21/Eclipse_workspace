package projectnew;

import javax.sql.DataSource;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
@ComponentScan("projectnew")
public class Config {
	
	
	@Bean
    public JdbcTemplate template() {
		
		
		
        return new JdbcTemplate(d());
    }
	
	
//	@Bean
//    public DriverManagerDataSource dmd() {
//		
//        return new DriverManagerDataSource();
//    }
	
	@Bean
    public DataSource d() {
		
		DriverManagerDataSource d = new DriverManagerDataSource();
		
		d.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		d.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
		d.setUsername("system");
		d.setPassword("admin");
		
        return d;
    }
	
	
    
	
	
	
	
	
	

}
