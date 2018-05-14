package com.mssc.bo;

public class CustomerBO {
 private int sno;
 private String fname;
 private String lname;
 private String emailadress;
 private long mbno;
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
public String getEmailadress() {
	return emailadress;
}
public void setEmailadress(String emailadress) {
	this.emailadress = emailadress;
}
public long getMbno() {
	return mbno;
}
public void setMbno(long mbno) {
	this.mbno = mbno;
}
 //create to string
@Override
public String toString() {
	return "CustomerBO [sno=" + sno + ", fname=" + fname + ", lname=" + lname + ", emailadress=" + emailadress
			+ ", mbno=" + mbno + "]";
}

}
