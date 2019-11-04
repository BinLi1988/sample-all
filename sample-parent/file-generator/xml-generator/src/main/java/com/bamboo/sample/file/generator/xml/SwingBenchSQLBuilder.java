package com.bamboo.sample.file.generator.xml;

import com.bamboo.sample.file.generator.xml.generator.GeneratorTask;
import com.bamboo.sample.file.generator.xml.entity.UUIDCache;

import javax.xml.bind.JAXBException;
import java.io.*;

/**
 * @author Li Bin
 * @date 2019/8/14 上午11:24
 **/
public class SwingBenchSQLBuilder {

    public static void main(String[] args) throws IOException, JAXBException {
        UUIDCache.newInstance(10).prepare();
        GeneratorTask.currentInstance().doGenerate();
    }
}
