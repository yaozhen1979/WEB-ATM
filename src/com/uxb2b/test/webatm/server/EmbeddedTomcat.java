package com.uxb2b.test.webatm.server;

import java.io.File;

import org.apache.catalina.Context;
import org.apache.catalina.startup.Tomcat;
import org.apache.naming.resources.VirtualDirContext;

public class EmbeddedTomcat {

    /**
     * @param args
     */
    public static void main(String[] args) throws Exception {
        
        String webappDirLocation = "WebContent/";
        Tomcat tomcat = new Tomcat();

        // The port that we should run on can be set into an environment
        // variable
        // Look for that variable and default to 8080 if it isn't there.
        String webPort = System.getenv("PORT");
        if (webPort == null || webPort.isEmpty()) {
            webPort = "8080";
        }

        tomcat.setPort(Integer.valueOf(webPort));

        Context ctx = tomcat.addWebapp("/",
                new File(webappDirLocation).getAbsolutePath());
        System.out.println("configuring app with basedir: "
                + new File("./" + webappDirLocation).getAbsolutePath());

        /*
         * addServlet, addServletMapping 是可以手動加入Servlet 但這樣設定的話,
         * 在servlet的annotation就沒意義了...
         */
        // Context ctx = tomcat.addWebapp("/examples", "examples");
        // Tomcat.addServlet(ctx, "HelloServlet",
        // "com.uxb2b.test.webatm.servlet.HelloServlet");
        // ctx.addServletMapping("/hello", "HelloServlet");
        
        /*
         * 可加入額外所build classes
         */
        // declare an alternate location for your "WEB-INF/classes" dir:
        // File additionWebInfClasses = new File("build/classes");
        // VirtualDirContext resources = new VirtualDirContext();
        // resources.setExtraResourcePaths("/WEB-INF/classes="
        // + additionWebInfClasses);
        // ctx.setResources(resources);

        tomcat.start();
        tomcat.getServer().await();
    }

}
