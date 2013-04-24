package com.uxb2b.test.json;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.net.URI;
import java.net.URISyntaxException;

import net.sf.json.JSONObject;

import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.io.IOUtils;
import org.junit.Test;

public class ReadJSONFileToBean {

    @Test
    public void testJSONData() throws URISyntaxException, IOException,
            IllegalAccessException, InvocationTargetException,
            NoSuchMethodException {

        URI filePathString = ReadJSONFileToBean.class.getResource(
                "./data_1.json").toURI();
        File file = new File(filePathString);

        FileInputStream fis = new FileInputStream(file);
        String json = IOUtils.toString(fis, "UTF-8");
        JSONObject jsonObject = JSONObject.fromObject(json);
        Object bean = JSONObject.toBean(jsonObject);

        assertEquals(jsonObject.get("BANKID"),
                PropertyUtils.getProperty(bean, "BANKID"));
    }

    /**
     * @param args
     * @throws NoSuchMethodException
     * @throws InvocationTargetException
     * @throws IllegalAccessException
     * @throws IOException
     * @throws URISyntaxException
     */
    public static void main(String[] args) throws IllegalAccessException,
            InvocationTargetException, NoSuchMethodException, IOException,
            URISyntaxException {

        // String json =
        // "{name=\"json\",bool:true,int:1,double:2.2,func:function(a){ return a; },array:[1,2]}";

        URI filePathString = ReadJSONFileToBean.class.getResource(
                "./data_1.json").toURI();
        System.out.println(filePathString);

        File file = new File(filePathString);
        System.out.println(file.exists());

        FileInputStream fis = new FileInputStream(file);

        String StringFromInputStream = IOUtils.toString(fis, "UTF-8");
        System.out.println(StringFromInputStream);

        JSONObject jsonObject = JSONObject.fromObject(StringFromInputStream);
        Object bean = JSONObject.toBean(jsonObject);

        System.out.println("BANKID:" + jsonObject.get("BANKID"));
        System.out.println("BANKID:"
                + PropertyUtils.getProperty(bean, "BANKID"));

        PropertyUtils.setProperty(bean, "IDKEY", "3");
        System.out.println(PropertyUtils.getProperty(bean, "IDKEY"));

        PropertyUtils.setProperty(bean, "VERIFYCODE", "dfadsfadsfwef");
        System.out.println(PropertyUtils.getProperty(bean, "VERIFYCODE"));

        // bean to json
        JSONObject jsonObject2 = JSONObject.fromObject(bean);
        System.out.println(jsonObject2);

    }

}
