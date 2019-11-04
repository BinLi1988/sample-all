package com.bamboo.sample.jmx.server;

import com.bamboo.sample.jmx.share.ObjectNameUtils;

import javax.management.*;
import javax.management.remote.JMXConnectorServer;
import javax.management.remote.JMXConnectorServerFactory;
import javax.management.remote.JMXServiceURL;
import java.io.IOException;
import java.lang.management.ManagementFactory;
import java.rmi.registry.LocateRegistry;
import java.util.Random;

public class TimeLagServer {

    public static void main(String[] args) throws MalformedObjectNameException, NotCompliantMBeanException, InstanceAlreadyExistsException, MBeanRegistrationException, InterruptedException, IOException {
        MBeanServer mbs = ManagementFactory.getPlatformMBeanServer();
        ObjectName timeLagManagerObjName = ObjectNameUtils.fromClass(TimeLagManager.class);

        Random random = new Random();
        TimeLagInfo timeLagInfo = new TimeLagInfo(random.nextLong(),random.nextLong());

        TimeLagManager timeLagManager = new TimeLagManager(timeLagInfo);
        mbs.registerMBean(timeLagManager, timeLagManagerObjName);

        int RMI_PORT = 9999;
        LocateRegistry.createRegistry(RMI_PORT);
        JMXServiceURL url = new JMXServiceURL("service:jmx:rmi:///jndi/rmi://192.168.1.21:" + RMI_PORT + "/jmxrmi");
        JMXConnectorServer jmxConnectorServer = JMXConnectorServerFactory.newJMXConnectorServer(url, null, mbs);
        jmxConnectorServer.start();

        while(true){
            timeLagInfo.refresh(random.nextLong(),random.nextLong());
            Thread.sleep(1000L);
        }

    }


}
