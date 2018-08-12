package com.zm.springtoy;

import com.zm.context.ApplicationContext;
import com.zm.context.support.ClassPathXmlApplicationContext;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import service.PetStoreService;

@SpringBootApplication
public class SpringToyApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringToyApplication.class, args);
        ApplicationContext ctx = new ClassPathXmlApplicationContext("petstore-v4.xml");
        PetStoreService petStore = (PetStoreService) ctx.getBean("petStore");
        System.out.println(petStore.getAccountDao());
        System.out.println(petStore.getItemDao());
    }
}
