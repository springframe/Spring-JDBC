package com.npjt.bo;

/**
 * @author Spring
 *
 */
public class CustomerBO {
	private int sno;
	private String fname;
	private String lname;
	private String emailAdress;
	private long mbno;
	
	public int getSno() {
		return sno;
	}
	public void setSno(int sno) {
		this.sno = sno;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public String getEmailAdress() {
		return emailAdress;
	}
	public void setEmailAdress(String emailAdress) {
		this.emailAdress = emailAdress;
	}
	public long getMbno() {
		return mbno;
	}
	public void setMbno(long mbno) {
		this.mbno = mbno;
	}
	@Override
	public String toString() {
		return "CustomerBO [sno=" + sno + ", fname=" + fname + ", lname=" + lname + ", emailAdress=" + emailAdress
				+ ", mbno=" + mbno + "]";
	}
	
	

}
