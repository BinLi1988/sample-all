package com.bamboo.sample.file.generator.xml.entity;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import java.util.List;

/**
 * @author Li Bin
 * @date 2019/8/14 下午2:28
 **/
@XmlAccessorType(value = XmlAccessType.FIELD)
public class Parameters {

    @XmlElement(name="parameter")
    private List<Parameter> parameters;

    public List<Parameter> getParameters() {
        return parameters;
    }

    public void setParameters(List<Parameter> parameters) {
        this.parameters = parameters;
    }
}
