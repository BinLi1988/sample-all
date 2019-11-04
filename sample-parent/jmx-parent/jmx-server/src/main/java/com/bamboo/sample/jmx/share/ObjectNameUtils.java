package com.bamboo.sample.jmx.share;

import javax.management.MalformedObjectNameException;
import javax.management.ObjectName;

public class ObjectNameUtils {
    public static ObjectName fromClass(Class<?> MXBeanClass) throws MalformedObjectNameException {
        String domain = MXBeanClass.getPackage().getName();
        String typeValue = MXBeanClass.getSimpleName();
        return new ObjectName(domain + ":type=" + typeValue);
    }
}
