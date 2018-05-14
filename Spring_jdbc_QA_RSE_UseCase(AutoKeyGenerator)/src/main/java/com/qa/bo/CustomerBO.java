package com.qa.bo;

public class CustomerBO {
	private int SNO;                 
	 private String FNAME;                                              
	private String LNAME  ;                                   
	 private String EMAILADRESS;
	private long  MBNO;
	public int getSNO() {
		return SNO;
	}
	public void setSNO(int sNO) {
		SNO = sNO;
	}
	public String getFNAME() {
		return FNAME;
	}
	public void setFNAME(String fNAME) {
		FNAME = fNAME;
	}
	public String getLNAME() {
		return LNAME;
	}
	public void setLNAME(String lNAME) {
		LNAME = lNAME;
	}
	public String getEMAILADRESS() {
		return EMAILADRESS;
	}
	public void setEMAILADRESS(String eMAILADRESS) {
		EMAILADRESS = eMAILADRESS;
	}
	public long getMBNO() {
		return MBNO;
	}
	public void setMBNO(long mBNO) {
		MBNO = mBNO;
	}
	@Override
	public String toString() {
		return "CustomerBO [SNO=" + SNO + ", FNAME=" + FNAME + ", LNAME=" + LNAME + ", EMAILADRESS=" + EMAILADRESS
				+ ", MBNO=" + MBNO + "]";
	}
	
}
