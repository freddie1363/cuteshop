package egovframework.notice.service;

/**
 * @Class Name : NoticeVO.java
 * @Description : Notice VO class
 * @Modification Information
 *
 * @author kjh
 * @since 2023-04-03
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public class NoticeVO extends NoticeDefaultVO{
    private static final long serialVersionUID = 1L;
    
    /** id */
    private int id=-1;
    
    /** subject */
    private java.lang.String subject;
    
    /** content */
    private java.lang.String content;
    
    /** writer */
    private java.lang.String writer;
    
    /** regdate */
    private java.lang.String regdate;
    
    public int getId() {
        return this.id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public java.lang.String getSubject() {
        return this.subject;
    }
    
    public void setSubject(java.lang.String subject) {
        this.subject = subject;
    }
    
    public java.lang.String getContent() {
        return this.content;
    }
    
    public void setContent(java.lang.String content) {
        this.content = content;
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
    
}
