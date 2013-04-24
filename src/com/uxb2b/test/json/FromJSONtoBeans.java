package com.uxb2b.test.json;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import org.apache.commons.beanutils.PropertyUtils;
import org.junit.Test;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import static org.junit.Assert.*;

public class FromJSONtoBeans {

    /**
     * @param args
     * @throws NoSuchMethodException
     * @throws InvocationTargetException
     * @throws IllegalAccessException
     */
    public static void main(String[] args) {

    }

    @Test
    public void testJson1() throws IllegalAccessException,
            InvocationTargetException, NoSuchMethodException {
        String json = "{name=\"json\",bool:true,int:1,double:2.2,func:function(a){ return a; },array:[1,2]}";
        JSONObject jsonObject = JSONObject.fromObject(json);
        Object bean = JSONObject.toBean(jsonObject);
        
        assertEquals(jsonObject.get("name"),
                PropertyUtils.getProperty(bean, "name"));
        assertEquals(jsonObject.get("bool"),
                PropertyUtils.getProperty(bean, "bool"));
        assertEquals(jsonObject.get("int"),
                PropertyUtils.getProperty(bean, "int"));
        assertEquals(jsonObject.get("double"),
                PropertyUtils.getProperty(bean, "double"));
        assertEquals(jsonObject.get("func"),
                PropertyUtils.getProperty(bean, "func"));
        /*
         * net.sf.json.JSONArray.toList(JSONArray) 
         * replaced by toCollection 
         */
        // List expected = JSONArray.toList(jsonObject.getJSONArray("array"));
        List expected = (List) JSONArray.toCollection(jsonObject.getJSONArray("array"));
        assertEquals(expected, (List) PropertyUtils.getProperty(bean, "array"));
    }

    @Test
    public void testJson2() throws IllegalAccessException,
            InvocationTargetException, NoSuchMethodException {
        String json = "{name=\"json\",bool:true,int:1,double:2.2,func:function(a){ return a; },array:[1,2]}";
        JSONObject jsonObject = JSONObject.fromObject(json);
        Object bean = JSONObject.toBean(jsonObject);

        List expected = JSONArray.toList(jsonObject.getJSONArray("array"));
        
        assertEquals(expected, (List) PropertyUtils.getProperty(bean, "array"));
    }

    @Test
    public void testJson3() {
        
        String json = "{bool:true,integer:1,string:\"json\"}";
        JSONObject jsonObject = JSONObject.fromObject(json);
        BeanA bean = (BeanA) JSONObject.toBean(jsonObject, BeanA.class);
        
        assertEquals(jsonObject.get("bool"), Boolean.valueOf(bean.isBool()));
        assertEquals(jsonObject.get("integer"), new Integer(bean.getInteger()));
        assertEquals(jsonObject.get("string"), bean.getString());
    }

}
