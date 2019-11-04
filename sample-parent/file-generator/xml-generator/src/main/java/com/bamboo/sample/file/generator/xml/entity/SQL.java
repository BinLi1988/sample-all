package com.bamboo.sample.file.generator.xml.entity;

/**
 * @author Li Bin
 * @date 2019/8/14 下午4:07
 **/
public interface SQL {

    String COMMIT = "commit";

    String INSERT_SKNF = "insert into sknf(k1,c1) values((select to_char(sysdate,'YYYYMMDDHH24MISS') from dual),:P1)";

    String UPDATE_SKNF_BY_PK= "update sknf set c1 = 'modified-pk' where id=:P1";

    String UPDATE_SKNF_BY_RANGE = "update sknf set c1 = 'modified-range' where id < :P1+6000 and id > :P1";

}
