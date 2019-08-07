package com.bamboo.sample.spring.batch.domain;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Li Bin
 * @date 2019/8/7 上午10:34
 **/
public class Record {

    private static Logger logger = LoggerFactory.getLogger(Record.class);

    public Record(String hello){
        logger.info(">>>> " + hello);
    }
}
