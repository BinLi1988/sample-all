package com.bamboo.sample.spring.batch.configuration;

import com.bamboo.sample.spring.batch.domain.Record;
import com.bamboo.sample.spring.batch.step.processor.RecordProcessor;
import com.bamboo.sample.spring.batch.step.reader.RecordReader;
import com.bamboo.sample.spring.batch.step.tasklet.RecordTasklet;
import com.bamboo.sample.spring.batch.step.writer.RecordWriter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.item.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;


/**
 * @author Li Bin
 * @date 2019/8/7 上午10:23
 **/
@Configuration
@Slf4j
public class ShareConfiguration {

    @StepScope
    @Bean
    public ItemReader<Record> recordReader(@Value("#{jobParameters['input.file.name']}") String name){
        return new RecordReader(new FileSystemResource(name));
    }

    @Bean
    public ItemProcessor<Record,Record> recordProcessor(){
        return new RecordProcessor();
    }

    @Bean
    public ItemWriter<Record> recordWriter(){
        return new RecordWriter();
    }

    @Bean
    public Tasklet recordTasklet(){
        return new RecordTasklet();
    }

}
