package com.bamboo.sample.file.generator.sql;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.UUID;

/**
 * @author Li Bin
 * @date 2019/8/19 下午3:21
 **/
public class OralceInsertAll {

    /**
     * insert all
     * into t_inst_test(tid,prod_name)values(101,'张三')
     * into t_inst_test(tid,prod_name)values(102,'lucky')
     * into t_inst_test(tid,prod_name)values(103,'王五')
     * select * from dual
     * ;
     * commit;
     * @param args
     */


    private static final String insert_all = "insert all\n";
    private static final String insert_into = "into SKNF(K1,C1) values('%s','%s')\n";
    private static final String tail = "select * from dual;\ncommit;";
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(new File("/Users/libin/Tools/insert.sql")));
        bw.write(insert_all);
        int i = 0;
        while(i++<2000000){
            bw.write(String.format(insert_into,String.valueOf(System.currentTimeMillis()), UUID.randomUUID().toString().replace("-","")));
        }
        bw.write(tail);
        bw.flush();
    }

}
