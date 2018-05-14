package com.ca.bo;

public class CustomerBO {
	private int sno;
	private String fname;
	private String lname;
	private String emailAdress;
	private String mbno;
	//setter and getter
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
	public String getMbno() {
		return mbno;
	}
	public void setMbno(String mbno) {
		this.mbno = mbno;
	}
/*	public CustomerBO(int sno, String fname, String lname, String emailAdress, String mbno) {
		this.sno = sno;
		this.fname = fname;
		this.lname = lname;
		this.emailAdress = emailAdress;
		this.mbno = mbno;
	}*/
	@Override
	public String toString() {
		return "CustomerBO [sno=" + sno + ", fname=" + fname + ", lname=" + lname + ", emailAdress=" + emailAdress
				+ ", mbno=" + mbno + "]";
	}
	
	

}
