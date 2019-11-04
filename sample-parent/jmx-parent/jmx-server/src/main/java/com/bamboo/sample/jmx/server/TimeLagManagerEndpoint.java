package com.bamboo.sample.jmx.server;


import javax.management.MXBean;

@MXBean
public interface TimeLagManagerEndpoint {

    TimeLagInfo getTimeLagInfo();

}
