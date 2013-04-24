package com.uxb2b.main.vo;

public class AtmVo {
    
    // 步驟一：傳送參數
    private String bankId;      // BANKID:3:String:轉入銀行代號
    private String accNo;       // ACCNO:16:String:轉入銀行帳號(快易收帳號)
    private String amt;         // AMT:String:7轉帳金額
    private String portal;      // PORTAL:String:10:廠商代號
    private String orderNo;     // ORDERNO:String:14:廠商帳單編號 (唯一)
    private String idKey;       // IDKEY:String:3:廠商專用認證碼ID(銀行一次提20組,對應資料請儲存在資料庫中, IDKEY由廠商從20組動態產生)
    private String vaerifyCode; // VERIFYCODE:String:64:檢核碼一(使用SHA256加密後的編碼,長度固定為64,皆為小寫)結帳
    
    //
    /*
     * 回應訊息：
     * 成功代碼：S：驗證成功
     * 驗證成功代碼： 8058937090621345152：Length 20以內
     * 範例： S, 8058937090621345152 (內容會用”,”隔開)
     * 失敗代碼：
     * D：帳單重覆
     * A：快易收帳號錯誤
     * F：檢核碼驗證失敗
     * B：傳遞參數錯誤 ;E：資料更新失敗
     */
    private String responseMsg;    // 回應訊息
    
    // 步驟二：傳送參數
    private String verifyNo;       // VERIFYNO:String:20:驗證成功代碼 (每筆代碼只能交易一次,交易過即失效)
    private String verifyCode2;    // VERIFYCODE2:String:64:檢核碼二(使用SHA256加密後的編碼,長度固定為64,皆為小寫)
    
    public String getBankId() {
        return bankId;
    }
    public void setBankId(String bankId) {
        this.bankId = bankId;
    }
    public String getAccNo() {
        return accNo;
    }
    public void setAccNo(String accNo) {
        this.accNo = accNo;
    }
    public String getAmt() {
        return amt;
    }
    public void setAmt(String amt) {
        this.amt = amt;
    }
    public String getPortal() {
        return portal;
    }
    public void setPortal(String portal) {
        this.portal = portal;
    }
    public String getOrderNo() {
        return orderNo;
    }
    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }
    public String getIdKey() {
        return idKey;
    }
    public void setIdKey(String idKey) {
        this.idKey = idKey;
    }
    public String getVaerifyCode() {
        return vaerifyCode;
    }
    public void setVaerifyCode(String vaerifyCode) {
        this.vaerifyCode = vaerifyCode;
    }
    public String getResponseMsg() {
        return responseMsg;
    }
    public void setResponseMsg(String responseMsg) {
        this.responseMsg = responseMsg;
    }
    public String getVerifyNo() {
        return verifyNo;
    }
    public void setVerifyNo(String verifyNo) {
        this.verifyNo = verifyNo;
    }
    public String getVerifyCode2() {
        return verifyCode2;
    }
    public void setVerifyCode2(String verifyCode2) {
        this.verifyCode2 = verifyCode2;
    }
    
}
