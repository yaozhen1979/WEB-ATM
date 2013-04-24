package com.uxb2b.test.httpclient;

import java.io.IOException;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;

public class PostDemo {

    /**
     * @param args
     * @throws IOException
     * @throws HttpException
     */
    public static void main(String[] args) throws HttpException, IOException {
        HttpClient httpclient = new HttpClient();
        // GetMethod httpget = new GetMethod("https://www.verisign.com/");
        PostMethod httppost = new PostMethod("https://www.verisign.com/");
        try {
            System.out.println(httppost.getRequestHeaders());
            httpclient.executeMethod(httppost);
            System.out.println(httppost.getStatusLine());
        } finally {
            httppost.releaseConnection();
        }
    }

}
