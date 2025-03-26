package task3_with_Bean_annotation;



import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "task2_with_Bean_annotation")
public class Config {

    
    @Bean
    public IempDAO empDAO() {
        return new EmpDAOImpl();
    }

    
    @Bean
    public EmpS empService() {
        return new EmpS(empDAO()); 
    }
}

