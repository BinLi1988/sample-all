package com.bamboo.sample.file.generator.xml.entity;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

/**
 * @author Li Bin
 * @date 2019/8/14 下午4:19
 **/
@XmlAccessorType(value = XmlAccessType.FIELD)
public class RandomValues {

    @XmlElement(name = "startvalue")
    private int startValue = 1;

    @XmlElement(name = "endvalue")
    private int endValue;

    public int getStartValue() {
        return startValue;
    }

    public void setStartValue(int startValue) {
        this.startValue = startValue;
    }

    public int getEndValue() {
        return endValue;
    }

    public void setEndValue(int endValue) {
        this.endValue = endValue;
    }
}
