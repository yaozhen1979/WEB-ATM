package com.uxb2b.test.httpclient;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;
import java.util.Scanner;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

public class PostCustumDemo {

    public final static void main(String[] args) throws Exception {

        File file = new File("ssl/.keystore");
        System.out.println(".keystore file exists:" + file.exists());

        postHttps(file);
    }

    /**
     * @throws KeyStoreException
     * @throws FileNotFoundException
     * @throws IOException
     * @throws NoSuchAlgorithmException
     * @throws CertificateException
     * @throws KeyManagementException
     * @throws UnrecoverableKeyException
     * @throws ClientProtocolException
     */
    public static void postHttps(File file) throws KeyStoreException,
            FileNotFoundException, IOException, NoSuchAlgorithmException,
            CertificateException, KeyManagementException,
            UnrecoverableKeyException, ClientProtocolException {
        DefaultHttpClient httpclient = new DefaultHttpClient();
        try {
            KeyStore trustStore = KeyStore.getInstance(KeyStore
                    .getDefaultType());
            FileInputStream instream = new FileInputStream(file);
            try {
                // .keystore password:changeit
                trustStore.load(instream, "changeit".toCharArray());
            } finally {
                try {
                    instream.close();
                } catch (Exception ignore) {
                }
            }

            SSLSocketFactory socketFactory = new SSLSocketFactory(trustStore);
            Scheme sch = new Scheme("https", 8443, socketFactory);
            httpclient.getConnectionManager().getSchemeRegistry().register(sch);

            HttpPost httppost = new HttpPost("https://localhost/hello.do");
            // HttpPost httppost = new
            // HttpPost("https://localhost/HelloTwiceServlet");

            System.out.println("executing request" + httppost.getRequestLine());

            HttpResponse response = httpclient.execute(httppost);
            HttpEntity entity = response.getEntity();

            System.out.println("----------------------------------------");
            System.out.println(response.getStatusLine());
            if (entity != null) {
                
                System.out.println("Response content length:: "
                        + entity.getContentLength());
                
                /**
                 * Java program to demonstrate How to read InputStream as String
                 * using BufferedReader and StringBuilder in Java.
                 * This is old and standard way of converting an InputStream into String in Java
                 */
                // read inputstream example:
                // FileInputStream fis = new FileInputStream("c:/sample.txt");
//                StringBuilder inputStringBuilder = new StringBuilder();
//                // BufferedReader bufferedReader = new BufferedReader(new
//                // InputStreamReader(fis, "UTF-8"));
//                BufferedReader bufferedReader = new BufferedReader(
//                        new InputStreamReader(entity.getContent(), "UTF-8"));
//                String line = bufferedReader.readLine();
//                while (line != null) {
//                    inputStringBuilder.append(line);
//                    inputStringBuilder.append('\n');
//                    line = bufferedReader.readLine();
//                }
//                System.out.println("response content::" + inputStringBuilder.toString());
                
                // use Apache IOUtils library example:
                // FileInputStream fis = new FileInputStream("c:/sample.txt");
                // String StringFromInputStream = IOUtils.toString(fis,
                // "UTF-8");
                // System.out.println(StringFromInputStream);
                
                /**
                 * Java program example to demonstrate How to convert InputStream into String by using JDK 
                 * Scanner utility. This program will work Java 5 onwards as Scanner was added in Java 5.
                 */
                // FileInputStream fis = new FileInputStream("c:/sample.txt");
                String inputStreamString = new Scanner(entity.getContent(), "UTF-8")
                        .useDelimiter("\\A").next();
                System.out.println("Response content:" + inputStreamString);

            }
            EntityUtils.consume(entity);

        } finally {
            // When HttpClient instance is no longer needed,
            // shut down the connection manager to ensure
            // immediate deallocation of all system resources
            httpclient.getConnectionManager().shutdown();
        }
    }
}
