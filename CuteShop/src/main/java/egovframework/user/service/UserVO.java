package egovframework.user.service;

/**
 * @Class Name : UserVO.java
 * @Description : User VO class
 * @Modification Information
 *
 * @author bonok
 * @since 2023-03-20
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public class UserVO extends UserDefaultVO{
    private static final long serialVersionUID = 1L;
    
    /** id */
    private int id=-1;
    
    /** userId */
    private java.lang.String userid="";
    
    /** userPass */
    private java.lang.String userpass="";
    
    /** userClass */
    private java.lang.String userclass="";
    private java.lang.String address="";
    
    public UserVO() {
    	this(-1, "", "", "");
    }
    
    public UserVO(int id, String userid, String userpass, String userclass) {
		super();
		this.id = id;
		this.userid = userid;
		this.userpass = userpass;
		this.userclass = userclass;
	}

	public int getId() {
        return this.id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public java.lang.String getUserid() {
        return this.userid;
    }
    
    public void setUserid(java.lang.String userid) {
        this.userid = userid;
    }
    
    public java.lang.String getUserpass() {
        return this.userpass;
    }
    
    public void setUserpass(java.lang.String userpass) {
        this.userpass = userpass;
    }
    
    public java.lang.String getUserclass() {
        return this.userclass;
    }
    
    public void setUserclass(java.lang.String userclass) {
        this.userclass = userclass;
    }
    
    public java.lang.String getAddress() {
        return this.address;
    }
    
    public void setAddress(java.lang.String address) {
        this.address = address;
    }
    
}
