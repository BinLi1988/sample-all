package com.bamboo.sample.file.generator.xml.generator;

import com.bamboo.sample.file.generator.xml.entity.Root;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Li Bin
 * @date 2019/8/14 下午4:48
 **/
public class GeneratorTask {

    private List<AbstractGenerator> allGenerators;

    private static GeneratorTask generatorTask;

    private GeneratorTask(){
        this.allGenerators = new ArrayList<>();
    }

    public static GeneratorTask currentInstance(){
        if(generatorTask == null){
            synchronized (GeneratorTask.class){
                if(generatorTask == null){
                    generatorTask = new GeneratorTask();
                    generatorTask.addGenerator(new StandardTransGenerator());
                    generatorTask.addGenerator(new MultiUpdateTransGenerator());
                    generatorTask.addGenerator(new SimpleInsertGenerator());
                }
            }
        }
        return generatorTask;
    }

    public void addGenerator(AbstractGenerator generator){
        this.allGenerators.add(generator);
    }


    public void doGenerate() throws JAXBException, IOException {
        for(AbstractGenerator generator : allGenerators){
            JAXBContext jaxbContext = JAXBContext.newInstance(Root.class);
            Marshaller marshaller = jaxbContext.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");
            marshaller.setProperty(Marshaller.JAXB_FRAGMENT, true);
            StringWriter writer = new StringWriter();
            writer.write("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>");
            writer.write("\n");
            marshaller.marshal(generator.build(),writer);
            BufferedWriter bufferedWriter=new BufferedWriter(new FileWriter(new File(generator.xmlPath())));
            bufferedWriter.write(writer.toString());
            bufferedWriter.close();
        }
    }
}
