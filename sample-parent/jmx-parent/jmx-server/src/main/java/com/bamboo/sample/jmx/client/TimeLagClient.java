package com.bamboo.sample.jmx.client;

import com.bamboo.sample.jmx.server.TimeLagManager;
import com.bamboo.sample.jmx.server.TimeLagManagerEndpoint;
import com.bamboo.sample.jmx.share.ObjectNameUtils;

import javax.management.*;
import javax.management.remote.JMXConnector;
import javax.management.remote.JMXConnectorFactory;
import javax.management.remote.JMXServiceURL;
import java.io.IOException;

public class TimeLagClient {

    public static void main(String[] args) throws IOException, MalformedObjectNameException, IntrospectionException, InstanceNotFoundException, ReflectionException, InterruptedException {
        JMXServiceURL url =
                new JMXServiceURL("service:jmx:rmi:///jndi/rmi://192.168.1.21:9999/jmxrmi");
        JMXConnector jmxc = JMXConnectorFactory.connect(url, null);
        MBeanServerConnection connection = jmxc.getMBeanServerConnection();
        TimeLagManagerEndpoint timeLagManagerEndpoint = JMX.newMXBeanProxy(connection, ObjectNameUtils.fromClass(TimeLagManager.class),
                TimeLagManagerEndpoint.class, false);
        while(true){
            System.out.println(timeLagManagerEndpoint.getTimeLagInfo());
            Thread.sleep(1000L);
        }
    }
}
