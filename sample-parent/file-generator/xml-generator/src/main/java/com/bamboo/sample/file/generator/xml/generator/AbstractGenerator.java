package com.bamboo.sample.file.generator.xml.generator;

import com.bamboo.sample.file.generator.xml.entity.*;

/**
 * @author Li Bin
 * @date 2019/8/14 下午3:51
 **/
public abstract class AbstractGenerator {


    private int statementIndex;

    public AbstractGenerator(){
        this.statementIndex = 1;
    }

    protected int statementIndex(){
        return this.statementIndex ++;
    }

    public SQLStatement commit(int sequence){
        SQLStatement sqlStatement = new SQLStatement();
        sqlStatement.setId(sequence);
        sqlStatement.setSql(SQL.COMMIT);
        return sqlStatement;
    }

    public Parameter parameterOfStringType(String p){
        Parameter parameter = new Parameter();
        parameter.setId(p);
        parameter.setDatatype(Constants.DATATYPE_STRING);
        EnumerationValues enumerationValues = new EnumerationValues();
        enumerationValues.setValues(UUIDCache.currentInstance().values());
        parameter.setEnumerationvalues(enumerationValues);
        return parameter;
    }

    public Parameter parameterOfIntegerType(String p,int start,int end){
        Parameter parameter = new Parameter();
        parameter.setId(p);
        parameter.setDatatype(Constants.DATATYPE_INTEGER);
        parameter.setQuotestring(false);
        RandomValues randomValues = new RandomValues();
        randomValues.setStartValue(start);
        randomValues.setEndValue(end);
        parameter.setRandomValues(randomValues);
        return parameter;
    }

    protected abstract Root build();

    protected abstract String xmlPath();
}
