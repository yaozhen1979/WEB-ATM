package com.uxb2b.test.httpclient;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.message.BasicNameValuePair;

public class FormPostDemo {

    /**
     * @param args
     * @throws UnsupportedEncodingException 
     */
    public static void main(String[] args) throws UnsupportedEncodingException {
        
        /*
         *  1.1.7.1. HTML forms
         *  Many applications need to simulate the process of 
         *  submitting an HTML form, for instance, 
         *  in order to log in to a web application or submit input data. 
         *  HttpClient provides the entity class UrlEncodedFormEntity 
         *  to facilitate the process.
         *  
         *  The UrlEncodedFormEntity instance will use the so called 
         *  URL encoding to encode parameters and 
         *  produce the following content:
         *  
         *  param1=value1&param2=value2
         *  
         */
        
        List<NameValuePair> formparams = new ArrayList<NameValuePair>();
        formparams.add(new BasicNameValuePair("param1", "value1"));
        formparams.add(new BasicNameValuePair("param2", "value2"));
        UrlEncodedFormEntity entity = new UrlEncodedFormEntity(formparams, "UTF-8");
        HttpPost httppost = new HttpPost("http://localhost/handler.do");
        httppost.setEntity(entity);
        
    }

}
