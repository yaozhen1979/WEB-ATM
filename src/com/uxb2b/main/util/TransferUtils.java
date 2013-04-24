package com.uxb2b.main.util;

import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class TransferUtils {

    private static Log log = LogFactory.getLog(TransferUtils.class);

    public static int sendDataToUrl(String targetUrl, byte[] sendData)
            throws Exception {
        if (sendData == null) {
            log.info("send to [" + targetUrl + "] with no data.");
        } else {
            log.info("send to [" + targetUrl + "] ==> "
                    + new String(sendData, "utf-8"));
        }

        URL httpServletUrl = new URL(targetUrl);
        HttpURLConnection httpURLConnection = (HttpURLConnection) httpServletUrl
                .openConnection();
        httpURLConnection.setRequestMethod("POST");
        httpURLConnection.setDoOutput(true);
        httpURLConnection.connect();

        OutputStream httpOutputStream = httpURLConnection.getOutputStream();
        if (null != sendData) {
            httpOutputStream.write(sendData);
        }

        httpOutputStream.flush();
        httpOutputStream.close();

        return httpURLConnection.getResponseCode();
    }
    
}
