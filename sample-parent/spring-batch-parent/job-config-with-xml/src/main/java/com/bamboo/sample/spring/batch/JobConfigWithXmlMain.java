package com.bamboo.sample.spring.batch;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

/**
 * @author Li Bin
 * @date 2019/8/7 下午2:41
 **/
@SpringBootApplication
@ImportResource(locations = {"classpath:META-INF/spring/spring-batch-*.xml"})
public class JobConfigWithXmlMain {

    public static void main(String[] args) {
        SpringApplication.run(JobConfigWithXmlMain.class,args);
    }

}
