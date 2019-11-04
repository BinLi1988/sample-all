package com.bamboo.sample.file.generator.xml.generator;

import com.bamboo.sample.file.generator.xml.entity.*;

import java.util.Arrays;

/**
 * @author Li Bin
 * @date 2019/8/14 下午5:00
 **/
public class MultiUpdateTransGenerator extends AbstractGenerator {

    private static int DEFAULT_START = 1;
    private static int DEFAULT_END = 1000000;

    private int start;
    private int end;

    /**
     * 1 insert + 1 update
     */
    public MultiUpdateTransGenerator(){
        this(DEFAULT_START,DEFAULT_END);
    }

    public MultiUpdateTransGenerator(int start,int end){
        super();
        this.start = start;
        this.end = end;
    }

    @Override
    protected Root build() {
        Root root = new Root();
        //update
        SQLStatement update = new SQLStatement();
        update.setId(statementIndex());
        update.setSql(SQL.UPDATE_SKNF_BY_RANGE);
        Parameters parametersOfUpdate = new Parameters();
        parametersOfUpdate.setParameters(Arrays.asList(parameterOfIntegerType(Constants.P2,start,end)));
        update.setParameters(parametersOfUpdate);
        //add update、commit
        root.setSqlStatements(Arrays.asList(update,commit(statementIndex())));
        return root;
    }

    @Override
    protected String xmlPath() {
        return "/Users/libin/Tools/swingbench/swingbench/configs/UPDATE_N.xml";
    }
}
