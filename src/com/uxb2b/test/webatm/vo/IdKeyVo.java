package com.uxb2b.test.webatm.vo;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import com.sun.org.apache.bcel.internal.generic.NEW;

public class IdKeyVo {
    
    private int id;
    // private String keyData;
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public static String getKeyData(int id) {
        
        Map<Integer, String> keyDataList = new HashMap<Integer, String>();
        
        keyDataList.put(1, "a58ab520c14acfa80c144707491df43d");
        keyDataList.put(2, "ab62781cca754621dc37e6976921778b");
        keyDataList.put(3, "20e784acece50026db141ffed24a040f");
        keyDataList.put(4, "baa525e354b4f5a0f767c49a927f5bcf");
        keyDataList.put(5, "6c63b32c57829c686bbacd27d1d9c458");
        keyDataList.put(6, "fdc30528e5de79cf2b0b3ca47d6f73a6");
        keyDataList.put(7, "313ab11dcccc496747ff6496d12c303d");
        keyDataList.put(8, "1e4760a07e0c69624624f47533f4809c");
        keyDataList.put(9, "0a835648d54bdf5ca5224523234bb9bc");
        keyDataList.put(10, "0640dd61d4f15c8c917bf4acb3faaeb4");
        keyDataList.put(11, "e7b25b42108b1ef0cb5fca35465c9aa1");
        keyDataList.put(12, "c33c467684ad2810a054a914bd6d2367");
        keyDataList.put(13, "8db88a584fcb728310e921a8046c3aca");
        keyDataList.put(14, "6cd41cb561cc53123c7191fdf68a3798");
        keyDataList.put(15, "4cb390b8cba6e28e326a219272660f38");
        keyDataList.put(16, "07836c53c298153d861bc4ba78ddc7ec");
        keyDataList.put(17, "0cfffe5cf2ce41c4006652697d0baa23");
        keyDataList.put(18, "a8b54547bfc6776660faab70a2ff5f12");
        keyDataList.put(19, "590a6bb01fb5efea755066659c0b81b0");
        keyDataList.put(20, "c90547837ac9aee44fdebb19faec5842");
        
        return keyDataList.get(id);
    }
    
    public static String getTestKeyData() {
        return "0cfda10dbae2e1f770ca2388af951837";
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        System.out
                .println(IdKeyVo.getKeyData(new Random().nextInt(20) + 1));
    }

}
