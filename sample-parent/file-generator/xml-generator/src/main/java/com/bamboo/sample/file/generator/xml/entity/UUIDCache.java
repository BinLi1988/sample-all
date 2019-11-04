package com.bamboo.sample.file.generator.xml.entity;

import java.util.*;

/**
 * @author Li Bin
 * @date 2019/8/14 下午3:56
 **/
public class UUIDCache {

    private List<String> values;
    private int valueCount;

    private static UUIDCache uuidCache;

    private UUIDCache(int valueCount){
        this.valueCount = valueCount;
        values = new ArrayList<>();
    }

    public void prepare(){
        if(!values.isEmpty()){
            return;
        }
        int current = valueCount;
        List<String> valuesPrepared = new ArrayList<>();
        while(current -- > 0){
            valuesPrepared.add(UUID.randomUUID().toString().replace("-",""));
        }
        values = Collections.unmodifiableList(valuesPrepared);
    }

    public static UUIDCache newInstance(int cachedSize){
        if(uuidCache == null){
            uuidCache = new UUIDCache(cachedSize);
        }
        return uuidCache;
    }

    public static UUIDCache currentInstance(){
        if(uuidCache == null){
            throw new RuntimeException("you should initialize UUIDCache firstly.");
        }
        return uuidCache;
    }

    public String ramdom(){
        return this.values.get(new Random().nextInt(1000));
    }

    public List<String> values(){
        return this.values;
    }

}
