package com.sprint;
import javax.servlet.MultipartConfigElement;  
import org.springframework.context.annotation.Bean;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@SpringBootApplication
public class Application {

	@Bean  
    public MultipartConfigElement multipartConfigElement() {  
        MultipartConfigFactory factory = new MultipartConfigFactory();  
        factory.setMaxFileSize("100MB");  
        factory.setMaxRequestSize("100MB");  
        return factory.createMultipartConfig();  
    }  
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
