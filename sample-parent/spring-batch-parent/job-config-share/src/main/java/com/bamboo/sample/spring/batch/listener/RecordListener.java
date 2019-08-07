package com.bamboo.sample.spring.batch.listener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionListener;

/**
 * @author Li Bin
 * @date 2019/8/7 上午10:51
 **/
@Slf4j
public class RecordListener implements JobExecutionListener {

    @Override
    public void beforeJob(JobExecution jobExecution) {
        log.info(">>>> method beforeJob invoked.");
    }

    @Override
    public void afterJob(JobExecution jobExecution) {
        log.info("<<<< method afterJob invoked.");
    }
}
