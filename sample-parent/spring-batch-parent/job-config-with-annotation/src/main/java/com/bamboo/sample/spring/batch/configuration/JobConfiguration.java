package com.bamboo.sample.spring.batch.configuration;

import com.bamboo.sample.spring.batch.domain.Record;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @author Li Bin
 * @date 2019/8/7 上午10:23
 **/
@Configuration
@EnableBatchProcessing
@Import({ShareConfiguration.class,ListenerConfiguration.class})
public class JobConfiguration {

    @Autowired
    private JobBuilderFactory jobBuilderFactory;

    @Autowired
    private StepBuilderFactory stepBuilderFactory;

    @Bean
    public Job recordJob(@Qualifier("firstStep") Step firstStep, @Qualifier("secondStep") Step secondStep, @Qualifier("recordListener") JobExecutionListener recordListener){
        return this.jobBuilderFactory
                .get("recordJob")
                .listener(recordListener)
                .start(firstStep)
                .next(secondStep)
                .build();
    }

    @Bean
    public Step firstStep(@Qualifier("recordReader") ItemReader<Record> reader, @Qualifier("recordProcessor") ItemProcessor<Record,Record> processor, @Qualifier("recordWriter") ItemWriter<Record> writer){
        return stepBuilderFactory
                .get("firstStep")
                .<Record,Record>chunk(1)
                .reader(reader)
                .processor(processor)
                .writer(writer)
                .build();
    }

    @Bean
    public Step secondStep(@Qualifier("recordTasklet") Tasklet recordTasklet){
        return stepBuilderFactory
                .get("secondStep")
                .tasklet(recordTasklet)
                .build();
    }

}
