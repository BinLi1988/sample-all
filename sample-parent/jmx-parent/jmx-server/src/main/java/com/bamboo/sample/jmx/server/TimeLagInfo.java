package com.bamboo.sample.jmx.server;

import java.beans.ConstructorProperties;

public class TimeLagInfo {

    private long maxTimeLag;
    private long currentTimeLag;

    @ConstructorProperties({"maxTimeLag","currentTimeLag"})
    public TimeLagInfo(long maxTimeLag,long currentTimeLag){
        this.maxTimeLag = maxTimeLag;
        this.currentTimeLag = currentTimeLag;
    }

    /**
     * No consistency requirement.
     * @param maxTimeLag
     * @param currentTimeLag
     */
    public void refresh(long maxTimeLag,long currentTimeLag){
        this.maxTimeLag = maxTimeLag;
        this.currentTimeLag = currentTimeLag;
    }

    public long getMaxTimeLag() {
        return maxTimeLag;
    }

    public long getCurrentTimeLag() {
        return currentTimeLag;
    }

    @Override
    public String toString(){
        return "maxTimeLag:"+this.maxTimeLag+",currentTimeLag:"+this.currentTimeLag;
    }
}
