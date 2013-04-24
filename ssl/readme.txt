>>> Tomcat ssl 設定
參考url:http://tomcat.apache.org/tomcat-7.0-doc/ssl-howto.html
password:changeit

=================================================================

>>> Java keytool 基本指令介紹

1. 匯入憑證到keystore
      keytool –import –alias xxx –file xxx.cer –keystore .keystore

2. 查詢keystore的內容
      keytool –list –v –keystore .keystore

3. 刪除keystore內的其中一個憑證
      keytool –delete –alias xxx –keystore .keystore

4. 產生金錀對(RSA為非對稱加密的演算法)
      keytool -genkey -alias xxx -keyalg RSA -keystore .keystore

5. 產生憑證申請檔
      keytool -certreq -alias xxx -file certreq.txt -keystore .keystore

6. 查詢PKCS12類型keystore的內容
      keytool –list –v –keystore .keystore -storetype pkcs12

7. 建立一個含有私鑰的keystore
      keytool -genkey -alias keyAlias -keyalg RSA -keystore keystore.jks

8. 修改keystore的密碼
      keytool -storepasswd -new newPassword -keystore keystore.jks
