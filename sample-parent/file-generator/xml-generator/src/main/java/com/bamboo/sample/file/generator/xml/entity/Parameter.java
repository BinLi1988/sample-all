package com.bamboo.sample.file.generator.xml.entity;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(value = XmlAccessType.FIELD)
public class Parameter {

    @XmlElement(name = "id")
    private String id;

    @XmlElement(name = "datatype")
    private String datatype;

    @XmlElement(name = "quotestring")
    private boolean quotestring = true;

    @XmlElement(name = "enumerationvalues")
    private EnumerationValues enumerationvalues;

    @XmlElement(name = "randomvalues")
    private RandomValues randomValues;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDatatype() {
        return datatype;
    }

    public void setDatatype(String datatype) {
        this.datatype = datatype;
    }

    public boolean getQuotestring() {
        return quotestring;
    }

    public void setQuotestring(boolean quotestring) {
        this.quotestring = quotestring;
    }

    public EnumerationValues getEnumerationvalues() {
        return enumerationvalues;
    }

    public void setEnumerationvalues(EnumerationValues enumerationvalues) {
        this.enumerationvalues = enumerationvalues;
    }

    public RandomValues getRandomValues() {
        return randomValues;
    }

    public void setRandomValues(RandomValues randomValues) {
        this.randomValues = randomValues;
    }
}
