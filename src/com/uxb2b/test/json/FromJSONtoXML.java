package com.uxb2b.test.json;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.xml.XMLSerializer;

public class FromJSONtoXML {
    
    /**
     * @param args
     */
    public static void main(String[] args) {
        // 
        JSONObject json = new JSONObject(true);
        String xml = new XMLSerializer().write(json);
        System.out.println(xml);

        //
        JSONObject json2 = JSONObject
                .fromObject("{\"name\":\"json\",\"bool\":true,\"int\":1}");
        String xml2 = new XMLSerializer().write(json2);
        System.out.println(xml2);
        

        JSONArray json3 = JSONArray.fromObject("[1,2,3]");
        String xml3 = new XMLSerializer().write(json3);
        System.out.println(xml3);

    }

}
