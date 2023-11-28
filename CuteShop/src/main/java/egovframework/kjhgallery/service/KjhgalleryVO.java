package egovframework.kjhgallery.service;

/**
 * @Class Name : KjhgalleryVO.java
 * @Description : Kjhgallery VO class
 * @Modification Information
 *
 * @author kjh
 * @since 2023-04-08
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public class KjhgalleryVO extends KjhgalleryDefaultVO{
    private static final long serialVersionUID = 1L;
    
    /** id */
    private int id;
    private int likes;
    private int views;
    
    /** subject */
    private java.lang.String subject;
    
    /** content */
    private java.lang.String content;
    
    /** writer */
    private java.lang.String writer;
    
    /** regdate */
    private java.lang.String regdate;
    
    /** appendix */
    private java.lang.String appendix;
    
    public int getViews() {
        return this.views;
    }
    
    public void setViews(int views) {
        this.views = views;
    }
    
    public int getId() {
        return this.id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public int getLikes() {
        return this.likes;
    }
    
    public void setLikes(int likes) {
        this.likes = likes;
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
    
    public java.lang.String getAppendix() {
        return this.appendix;
    }
    
    public void setAppendix(java.lang.String appendix) {
        this.appendix = appendix;
    }
    
}
