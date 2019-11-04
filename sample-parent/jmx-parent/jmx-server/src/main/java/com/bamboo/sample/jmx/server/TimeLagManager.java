package com.bamboo.sample.jmx.server;

public class TimeLagManager implements TimeLagManagerEndpoint {

    private TimeLagInfo timeLagInfo;

    public TimeLagManager(TimeLagInfo timeLagInfo){
        this.timeLagInfo = timeLagInfo;
    }

    @Override
    public TimeLagInfo getTimeLagInfo() {
        return timeLagInfo;
    }

    public static TimeLagManager startTimeLag(){
        return new TimeLagManager(new TimeLagInfo(0L,0L));
    }
}
