package com.bamboo.sample.spring.batch.step.writer;

import com.bamboo.sample.spring.batch.domain.Record;
import org.springframework.batch.item.ItemWriter;

import java.util.List;

/**
 * @author Li Bin
 * @date 2019/8/7 上午10:50
 **/
public class RecordWriter implements ItemWriter<Record> {

    @Override
    public void write(List<? extends Record> items) throws Exception {

    }
}
