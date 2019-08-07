package com.bamboo.sample.spring.batch.step.processor;

import com.bamboo.sample.spring.batch.domain.Record;
import org.springframework.batch.item.ItemProcessor;

/**
 * @author Li Bin
 * @date 2019/8/7 上午10:51
 **/
public class RecordProcessor implements ItemProcessor<Record,Record> {

    @Override
    public Record process(Record item) throws Exception {
        return null;
    }
}
