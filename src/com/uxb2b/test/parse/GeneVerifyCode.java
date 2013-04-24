package com.uxb2b.test.parse;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.net.URI;
import java.net.URISyntaxException;

import net.sf.json.JSONObject;

import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.io.IOUtils;

import com.uxb2b.test.json.ReadJSONFileToBean;
import com.uxb2b.test.webatm.vo.IdKeyVo;

public class GeneVerifyCode {

    /**
     * @param args
     * @throws URISyntaxException 
     * @throws IOException 
     * @throws NoSuchMethodException 
     * @throws InvocationTargetException 
     * @throws IllegalAccessException 
     * @throws NumberFormatException 
     */
    public static void main(String[] args) throws URISyntaxException, IOException, NumberFormatException, IllegalAccessException, InvocationTargetException, NoSuchMethodException {
        // TODO Auto-generated method stub
        URI filePathString = GeneVerifyCode.class.getResource(
                "../json/data_sample.json").toURI();
        System.out.println(filePathString);

        File file = new File(filePathString);
        System.out.println(file.exists());
        
        FileInputStream fis = new FileInputStream(file);

        String StringFromInputStream = IOUtils.toString(fis, "UTF-8");
        System.out.println(StringFromInputStream);

        JSONObject jsonObject = JSONObject.fromObject(StringFromInputStream);
        Object bean = JSONObject.toBean(jsonObject);
        
        // idKey:目前的產生規則, 為由傳入的數值(長度為1~3)除以20的餘數來決定.
        // String idKey = IdKeyVo.getKeyData(Integer.valueOf((String) PropertyUtils.getProperty(bean, "IDKEY"))%20 + 1);
        String idKey = IdKeyVo.getTestKeyData();
        System.out.println(idKey);
        
        // 步驟一之最長參數長度為 3 + 6 + 7 + 10 + 14 + 3 + 64 = 107
        StringBuilder sb = new StringBuilder(107);
        sb.append(PropertyUtils.getProperty(bean, "BANKID"));
        sb.append(PropertyUtils.getProperty(bean, "ACCNO"));
        sb.append(PropertyUtils.getProperty(bean, "AMT"));
        sb.append(PropertyUtils.getProperty(bean, "PORTAL"));
        sb.append(idKey);
        
        String verifyCode = sb.toString();
        System.out.println(verifyCode);
        
        /*
         * VERIFYCODE： Length 64：檢核碼一(使用SHA256加密後的編碼,長度固定為64,皆為小寫)
         * 範例:
         * c2f10530d66d49b5521c5878cd75fdbdad1713070b52eb28b17c09add2f3d954
         */
        String sha256Code = DigestUtils.sha256Hex(verifyCode);
        System.out.println("SHA256:\n" + sha256Code);
        
    }

}
