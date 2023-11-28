package egovframework.kjhpayment.service;

/**
 * @Class Name : KjhpaymentVO.java
 * @Description : Kjhpayment VO class
 * @Modification Information
 *
 * @author kjh
 * @since 2023-05-08
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public class KjhpaymentVO extends KjhpaymentDefaultVO{
    private static final long serialVersionUID = 1L;
    
    /** pno */
    private int pno;
    
    /** username */
    private java.lang.String username;
    
    /** phone */
    private java.lang.String phone;
    
    /** money */
    private int money;
    
    /** content */
    private java.lang.String content;
    
    /** pdate */
    private java.util.Date pdate;
    
    public int getPno() {
        return this.pno;
    }
    
    public void setPno(int pno) {
        this.pno = pno;
    }
    
    public java.lang.String getUsername() {
        return this.username;
    }
    
    public void setUsername(java.lang.String username) {
        this.username = username;
    }
    
    public java.lang.String getPhone() {
        return this.phone;
    }
    
    public void setPhone(java.lang.String phone) {
        this.phone = phone;
    }
    
    public int getMoney() {
        return this.money;
    }
    
    public void setMoney(int money) {
        this.money = money;
    }
    
    public java.lang.String getContent() {
        return this.content;
    }
    
    public void setContent(java.lang.String content) {
        this.content = content;
    }
    
    public java.util.Date getPdate() {
        return this.pdate;
    }
    
    public void setPdate(java.util.Date pdate) {
        this.pdate = pdate;
    }
    
}
