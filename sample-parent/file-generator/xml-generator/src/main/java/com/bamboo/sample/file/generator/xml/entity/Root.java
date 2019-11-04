package com.bamboo.sample.file.generator.xml.entity;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * @author Li Bin
 * @date 2019/8/14 上午11:27
 **/
@XmlRootElement(name = "SQLStatementList")
@XmlAccessorType(value = XmlAccessType.FIELD)
public class Root {

    @XmlElement(name = "SQLStatement")
    private List<SQLStatement> sqlStatements;

    public List<SQLStatement> getSqlStatements() {
        return sqlStatements;
    }

    public void setSqlStatements(List<SQLStatement> sqlStatements) {
        this.sqlStatements = sqlStatements;
    }
}
