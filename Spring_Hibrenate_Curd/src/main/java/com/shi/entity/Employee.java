package com.shi.entity;

public class Employee {
private int sid;
private String fname;
private String lname;
private String emailAdress;
private long mbno;

//setter and getter 
public int getSid() {
	return sid;
}
public void setSid(int sid) {
	this.sid = sid;
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
	return "Employee [sid=" + sid + ", fname=" + fname + ", lname=" + lname + ", emailAdress=" + emailAdress + ", mbno="
			+ mbno + "]";
}


}
