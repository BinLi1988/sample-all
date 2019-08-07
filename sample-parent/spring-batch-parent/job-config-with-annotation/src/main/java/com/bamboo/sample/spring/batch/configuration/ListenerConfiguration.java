package com.bamboo.sample.spring.batch.configuration;

import com.bamboo.sample.spring.batch.listener.RecordListener;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Li Bin
 * @date 2019/8/7 上午10:53
 **/
@Configuration
public class ListenerConfiguration {

    @Bean
    public JobExecutionListener recordListener(){
        return new RecordListener();
    }

}
