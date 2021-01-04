package co.company.test.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
@ComponentScan(basePackages = "co.company.test")
public class IOCConfiguration {

	/*
	 * @Bean(initMethod = "init", destroyMethod = "destroy") // <bean id="tv"
	 * class="
	 * 
	 * @Scope("prototype") //singletone, request, session public TV tv() { return
	 * new TV(); }
	 */


}
