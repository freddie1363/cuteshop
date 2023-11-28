package egovframework.kjhcomment.service;

/**
 * @Class Name : KjhcommentVO.java
 * @Description : Kjhcomment VO class
 * @Modification Information
 *
 * @author kjh
 * @since 2023-05-10
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public class KjhcommentVO extends KjhcommentDefaultVO{
    private static final long serialVersionUID = 1L;
    
    /** cno */
    private int cno;
    
    /** content */
    private java.lang.String content;
    
    /** writer */
    private java.lang.String writer;
    
    /** regdate */
    private java.sql.Timestamp regdate;
    
    /** id */
    private int id;
    
    public int getCno() {
        return this.cno;
    }
    
    public void setCno(int cno) {
        this.cno = cno;
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
    
    public java.sql.Timestamp getRegdate() {
        return this.regdate;
    }
    
    public void setRegdate(java.sql.Timestamp regdate) {
        this.regdate = regdate;
    }
    
    public int getId() {
        return this.id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
}
