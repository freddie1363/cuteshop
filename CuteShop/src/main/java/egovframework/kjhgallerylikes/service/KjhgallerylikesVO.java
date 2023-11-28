package egovframework.kjhgallerylikes.service;

/**
 * @Class Name : KjhgallerylikesVO.java
 * @Description : Kjhgallerylikes VO class
 * @Modification Information
 *
 * @author kjh
 * @since 2023-05-07
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public class KjhgallerylikesVO extends KjhgallerylikesDefaultVO{
    private static final long serialVersionUID = 1L;
    
    /** lno */
    private int lno;
    
    /** userid */
    private java.lang.String userid;
    
    /** gno */
    private int gno;
    
    public int getLno() {
        return this.lno;
    }
    
    public void setLno(int lno) {
        this.lno = lno;
    }
    
    public java.lang.String getUserid() {
        return this.userid;
    }
    
    public void setUserid(java.lang.String userid) {
        this.userid = userid;
    }
    
    public int getGno() {
        return this.gno;
    }
    
    public void setGno(int gno) {
        this.gno = gno;
    }
    
}
