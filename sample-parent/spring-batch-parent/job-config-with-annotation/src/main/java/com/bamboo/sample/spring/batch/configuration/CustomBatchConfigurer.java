package com.bamboo.sample.spring.batch.configuration;

import org.springframework.boot.autoconfigure.batch.BasicBatchConfigurer;
import org.springframework.boot.autoconfigure.batch.BatchProperties;
import org.springframework.boot.autoconfigure.transaction.TransactionManagerCustomizers;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * @author Li Bin
 * @date 2019/8/7 下午3:42
 **/
@Configuration
public class CustomBatchConfigurer extends BasicBatchConfigurer {

    protected CustomBatchConfigurer(BatchProperties properties, DataSource dataSource, TransactionManagerCustomizers transactionManagerCustomizers) {
        super(properties, dataSource, transactionManagerCustomizers);
    }

    protected String determineIsolationLevel() {
        return "ISOLATION_READ_COMMITTED";
    }


}
