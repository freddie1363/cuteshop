package egovframework.bulletin.service;

/**
 * @Class Name : BulletinVO.java
 * @Description : Bulletin VO class
 * @Modification Information
 *
 * @author kjh
 * @since 2023-03-23
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public class BulletinVO extends BulletinDefaultVO{
    private static final long serialVersionUID = 1L;
    
    /** id */
    private int id;
    
    /** title */
    private java.lang.String title;
    
    /** content */
    private java.lang.String content;
    
    /** appendix */
    private java.lang.String appendix;
    
    /** writer */
    private java.lang.String writer;
    
    /** regdate */
    private java.lang.String regdate;
    
    /** moddate */
    private java.lang.String moddate;
    
    /** status */
    private java.lang.String status;
    
    public int getId() {
        return this.id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public java.lang.String getTitle() {
        return this.title;
    }
    
    public void setTitle(java.lang.String title) {
        this.title = title;
    }
    
    public java.lang.String getContent() {
        return this.content;
    }
    
    public void setContent(java.lang.String content) {
        this.content = content;
    }
    
    public java.lang.String getAppendix() {
        return this.appendix;
    }
    
    public void setAppendix(java.lang.String appendix) {
        this.appendix = appendix;
    }
    
    public java.lang.String getWriter() {
        return this.writer;
    }
    
    public void setWriter(java.lang.String writer) {
        this.writer = writer;
    }
    
    public java.lang.String getRegdate() {
        return this.regdate;
    }
    
    public void setRegdate(java.lang.String regdate) {
        this.regdate = regdate;
    }
    
    public java.lang.String getModdate() {
        return this.moddate;
    }
    
    public void setModdate(java.lang.String moddate) {
        this.moddate = moddate;
    }
    
    public java.lang.String getStatus() {
        return this.status;
    }
    
    public void setStatus(java.lang.String status) {
        this.status = status;
    }
    
}
