package com.uxb2b.test.webatm.server;

import java.io.File;

import javax.servlet.ServletException;

import org.apache.catalina.LifecycleException;
import org.apache.catalina.connector.Connector;
import org.apache.catalina.core.AprLifecycleListener;
import org.apache.catalina.core.StandardServer;
import org.apache.catalina.startup.Tomcat;

public class EmbeddedHttpsTomcat {

    /**
     * @param args
     * @throws LifecycleException 
     * @throws ServletException 
     */
    public static void main(String[] args) throws LifecycleException, ServletException {

        Connector httpsConnector = new Connector();
        httpsConnector.setPort(8443);
        httpsConnector.setSecure(true);
        httpsConnector.setScheme("https");
        httpsConnector.setAttribute("keystoreFile", "c:/.keystore");
        httpsConnector.setAttribute("clientAuth", "false");
        httpsConnector.setAttribute("sslProtocol", "TLS");
        httpsConnector.setAttribute("SSLEnabled", true);
        // maxThreads="200"
        httpsConnector.setAttribute("maxThreads", 200);

        Tomcat tomcat = new Tomcat();
        tomcat.getService().addConnector(httpsConnector);
        tomcat.setPort(8080);
//        Connector defaultConnector = tomcat.getConnector();
//        defaultConnector.setRedirectPort(8443);

//        tomcat.setBaseDir(".");
//        tomcat.getHost().setAppBase("WebContent/");
        
        tomcat.addWebapp("/",
                new File("WebContent/").getAbsolutePath());
        
        StandardServer server = (StandardServer) tomcat.getServer();
        AprLifecycleListener listener = new AprLifecycleListener();
        server.addLifecycleListener(listener);
        
        tomcat.start();
        tomcat.getServer().await();

    }

}
