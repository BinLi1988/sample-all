package com.bamboo.sample.file.generator.xml.generator;

import com.bamboo.sample.file.generator.xml.entity.*;

import java.util.Arrays;

/**
 * @author Li Bin
 * @date 2019/8/14 下午4:28
 **/
public class SimpleInsertGenerator extends AbstractGenerator {


    @Override
    protected Root build() {
        Root root = new Root();
        //create
        SQLStatement create = new SQLStatement();
        create.setId(statementIndex());
        create.setSql(String.format(SQL.INSERT_SKNF,String.valueOf(System.currentTimeMillis())));
        Parameters parametersOfCreate = new Parameters();
        parametersOfCreate.setParameters(Arrays.asList(parameterOfStringType(Constants.P1)));
        create.setParameters(parametersOfCreate);

        //add create、commit
        root.setSqlStatements(Arrays.asList(create,commit(statementIndex())));
        return root;
    }

    @Override
    protected String xmlPath() {
        return "/Users/libin/Tools/swingbench/swingbench/configs/INSERT.xml";
    }
}
