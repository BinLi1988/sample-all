package com.bamboo.sample.file.generator.xml.generator;

import com.bamboo.sample.file.generator.xml.entity.*;

import java.util.Arrays;

/**
 * @author Li Bin
 * @date 2019/8/14 下午4:28
 **/
public class StandardTransGenerator extends AbstractGenerator {

    private static int DEFAULT_START = 1;
    private static int DEFAULT_END = 1000000;

    private int start;
    private int end;

    /**
     * 1 insert + 1 update
     */
    public StandardTransGenerator(){
        this(DEFAULT_START,DEFAULT_END);
    }

    public StandardTransGenerator(int start,int end){
        super();
        this.start = start;
        this.end = end;
    }

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
        //update
        SQLStatement update = new SQLStatement();
        update.setId(statementIndex());
        update.setSql(SQL.UPDATE_SKNF_BY_PK);
        Parameters parametersOfUpdate = new Parameters();
        parametersOfUpdate.setParameters(Arrays.asList(parameterOfIntegerType(Constants.P2,start,end)));
        update.setParameters(parametersOfUpdate);
        //add create、update、commit
        root.setSqlStatements(Arrays.asList(create,update,commit(statementIndex())));
        return root;
    }

    @Override
    protected String xmlPath() {
        return "/Users/libin/Tools/swingbench/swingbench/configs/INSERT_UPDATE.xml";
    }
}
