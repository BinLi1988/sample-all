package com.bamboo.sample.file.generator.xml.entity;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import java.util.List;

/**
 * @author Li Bin
 * @date 2019/8/14 上午11:50
 **/
@XmlAccessorType(value = XmlAccessType.FIELD)
public class EnumerationValues {

    @XmlElement(name = "possiblevalues")
    private List<String> values;

    public List<String> getValues() {
        return values;
    }

    public void setValues(List<String> values) {
        this.values = values;
    }
}
