package com.bamboo.sample.spring.batch.step.reader;

import com.bamboo.sample.spring.batch.domain.Record;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.item.ItemReader;
import org.springframework.core.io.Resource;

/**
 * @author Li Bin
 * @date 2019/8/7 上午10:48
 **/
@Slf4j
public class RecordReader implements ItemReader<Record> {

    private Resource fileResource;

    public RecordReader(Resource fileResource){
        this.fileResource = fileResource;
    }

    @Override
    public Record read() {
        return null;
    }


}
