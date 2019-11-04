package com.bamboo.sample.file.generator.xml.entity;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

/**
 * @author Li Bin
 * @date 2019/8/14 上午11:29
 *
 *     /**
 *      *
 *      * @param sequence
 *      * @param root
 *      *
 *      * <SQLStatement>
 *      *         <id>1</id>
 *      *         <name>insert_01</name>
 *      *         <shortname>s1</shortname>
 *      *         <sql>insert into atmtxnjnl(logdat)values(:P1)</sql>
 *      *         <implmentasliteral>true</implmentasliteral>
 *      *         <enabled>true</enabled>
 *      *         <querytimeout>0</querytimeout>
 *      *         <parameter_list>
 *      *             <parameter>
 *      *                 <id>:P1</id>
 *      *                 <datatype>string</datatype>
 *      *                 <quotestring>true</quotestring>
 *      *                 <enumerationvalues>
 *      *                     <possiblevalues>20190813</possiblevalues>
 *      *                 </enumerationvalues>
 *      *             </parameter>
 *      *         </parameter_list>
 *      *     </SQLStatement>
 *      */
@XmlAccessorType(value = XmlAccessType.FIELD)
public class SQLStatement {

    @XmlElement(name ="id")
    private int id;

    @XmlElement(name ="name")
    private String name;

    @XmlElement(name = "shortname")
    private String shortname;

    @XmlElement(name = "sql")
    private String sql;

    @XmlElement(name = "implmentasliteral")
    private boolean implmentasliteral = true;

    @XmlElement(name = "enabled")
    private boolean enabled = true;

    @XmlElement(name = "querytimeout")
    private int querytimeout;

    @XmlElement(name = "parameter_list")
    private Parameters parameters;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
        this.setName(String.valueOf(id));
        this.setShortname(String.valueOf(id));
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = "Script-"+name;
    }

    public String getShortname() {
        return shortname;
    }

    public void setShortname(String shortname) {
        this.shortname = "Short-"+shortname;
    }

    public String getSql() {
        return sql;
    }

    public void setSql(String sql) {
        this.sql = sql;
    }

    public boolean getImplmentasliteral() {
        return implmentasliteral;
    }

    public void setImplmentasliteral(boolean implmentasliteral) {
        this.implmentasliteral = implmentasliteral;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public int getQuerytimeout() {
        return querytimeout;
    }

    public void setQuerytimeout(int querytimeout) {
        this.querytimeout = querytimeout;
    }

    public Parameters getParameters() {
        return parameters;
    }

    public void setParameters(Parameters parameters) {
        this.parameters = parameters;
    }
}
