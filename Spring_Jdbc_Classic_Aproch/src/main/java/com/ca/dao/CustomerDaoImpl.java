package com.ca.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.StatementCallback;

import com.ca.bo.CustomerBO;

public class CustomerDaoImpl implements CustomerDao {
	private final String SQL_GET_CUST_DETAIL = "SELECT * FROM CUST_JDBC";
	private final String SQL_GET_CUST_DETAIL_By_No = "SELECT * FROM CUST_JDBC WHERE SNO=?";
	private final String SQL_GET_CUST_DETAIL_By_FNAME = "SELECT * FROM CUST_JDBC WHERE FNAME=?";
	private final String SQL_INSERT = "INSERT INTO CUST_JDBC VALUES(?,?,?,?,?)";
	private final String SQL_QRY_UPDATE_BY_NO = "UPDATE CUST_JDBC SET FNAME=? WHERE SNO=?";
	private final String SQL_QRY_DELETE_BY_NO = "DELETE * FROM CUST_JDBC WHERE SNO=?";
	private JdbcTemplate jt;

	public void setJt(JdbcTemplate jt) {
		this.jt = jt;
	}


	@Override
	public List<CustomerBO> getAllCustdetailsInList() {
		// TODO Auto-generated method stub

		return jt.execute(new getAllDetails());
	}

	private final class getAllDetails implements StatementCallback<List<CustomerBO>> {

		@Override
		public List<CustomerBO> doInStatement(Statement stmt) throws SQLException, DataAccessException {
			ResultSet rs = null;
			CustomerBO cbo = null;
			List<CustomerBO> lcbo = null;
			cbo = new CustomerBO();
			lcbo = new ArrayList<>();
			rs = stmt.executeQuery(SQL_GET_CUST_DETAIL);
			while (rs.next()) {
				cbo.setSno(rs.getInt(1));
				cbo.setFname(rs.getString(2));
				cbo.setLname(rs.getString(3));
				cbo.setEmailAdress(rs.getString(4));
				cbo.setMbno(rs.getString(5));
				lcbo.add(cbo);
			}
			return lcbo;
		}}
	@Override
	public List<CustomerBO> getAllCustdetailsByNo(int sno) {
		getAllCustdetailsByPstmCreator gacdbp = new getAllCustdetailsByPstmCreator(sno);
		getAllCustdetailsByPstmtCall gacdbpc = new getAllCustdetailsByPstmtCall();

		return jt.execute(gacdbp, gacdbpc);
	}

	private final class getAllCustdetailsByPstmCreator implements PreparedStatementCreator {
		private int sno;

		public getAllCustdetailsByPstmCreator(int sno) {
			this.sno = sno;
		}

		@Override
		public PreparedStatement createPreparedStatement(Connection con) throws SQLException {

			PreparedStatement pstm = con.prepareStatement(SQL_GET_CUST_DETAIL_By_No);
			pstm.setInt(1, sno);
			return pstm;
		}
	}

	private final class getAllCustdetailsByPstmtCall implements PreparedStatementCallback<List<CustomerBO>> {

		@Override
		public List<CustomerBO> doInPreparedStatement(PreparedStatement pstmt)
				throws SQLException, DataAccessException {
			ResultSet rs = null;
			CustomerBO cbo = null;
			List<CustomerBO> lcbo = null;
			cbo = new CustomerBO();
			lcbo = new ArrayList<>();
			rs = pstmt.executeQuery();
			while (rs.next()) {
				cbo.setFname(rs.getString(2));
				cbo.setLname(rs.getString(3));
				cbo.setEmailAdress(rs.getString(4));
				cbo.setMbno(rs.getString(5));
				lcbo.add(cbo);

			}
			return lcbo;
		}

	}

	@Override
	public List<CustomerBO> getAllCustdetailsByName(String fname) {
		CustdetailsByPstmCreator cdpc=new CustdetailsByPstmCreator(fname);
		CustdetailsByPstmtCall cdbp=new CustdetailsByPstmtCall();
		
		return jt.execute(cdpc, cdbp);
	}
	private final class CustdetailsByPstmCreator implements PreparedStatementCreator {
		private String fname;
		public CustdetailsByPstmCreator(String fname) {
			this.fname = fname;
		}

		@Override
		public PreparedStatement createPreparedStatement(Connection con) throws SQLException {

			PreparedStatement pstm = con.prepareStatement(SQL_GET_CUST_DETAIL_By_FNAME);
			pstm.setString(1,fname);
			return pstm;
		}
	}

	private final class CustdetailsByPstmtCall implements PreparedStatementCallback<List<CustomerBO>> {

		@Override
		public List<CustomerBO> doInPreparedStatement(PreparedStatement pstmt)
				throws SQLException, DataAccessException {
			ResultSet rs = null;
			CustomerBO cbo = null;
			List<CustomerBO> lcbo = null;
			cbo = new CustomerBO();
			lcbo = new ArrayList<>();
			rs = pstmt.executeQuery();
			while (rs.next()) {
				cbo.setSno(rs.getInt(1));
				cbo.setLname(rs.getString(3));
				cbo.setEmailAdress(rs.getString(4));
				cbo.setMbno(rs.getString(5));
				lcbo.add(cbo);

			}
			return lcbo;
		}
	}

	@Override
	public Map<String, Object> getAllCustdetailsInMap() {
		return jt.execute(new CustDetailsInMap());
	}
	private final class CustDetailsInMap implements StatementCallback<Map<String,Object>>
	{
		@Override
		public Map<String, Object> doInStatement(Statement stmt) throws SQLException, DataAccessException {
			ResultSet rs = null;
			CustomerBO cbo = null;
			Map<String,Object> lcbo = null;
			cbo = new CustomerBO();
			lcbo = new HashMap<>();
			rs = stmt.executeQuery(SQL_GET_CUST_DETAIL);
			while (rs.next()) {
				cbo.setSno(rs.getInt(1));
				cbo.setFname(rs.getString(2));
				cbo.setLname(rs.getString(3));
				cbo.setEmailAdress(rs.getString(4));
				cbo.setMbno(rs.getString(5));
				lcbo.put("1",cbo);
			}
			return lcbo;
		}
		
	}
                 
	@Override
	public int insertCustdetails(int sno, String fname, String lname, String emailAdr, String mbno) {
		InsetQuerycreator iqc=new InsetQuerycreator(sno, fname, lname, emailAdr, mbno);
                   InsertQryCall isqc=new InsertQryCall();
		
		return (int) jt.execute(iqc, isqc);
	  }
	
	private final class InsetQuerycreator implements PreparedStatementCreator
	{
		int sno;
		String fname,lname,emailAdr,mbno;
		
		public InsetQuerycreator(int sno, String fname, String lname, String emailAdr, String mbno) {
			this.sno = sno;
			this.fname = fname;
			this.lname = lname;
			this.emailAdr = emailAdr;
			this.mbno = mbno;
		}

		@Override
		public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
                   PreparedStatement pstmt=con.prepareStatement(SQL_INSERT);
                   pstmt.setInt(1,sno);
                   pstmt.setString(2,fname);
                   pstmt.setString(3,lname);
                   pstmt.setString(4,emailAdr);
                   pstmt.setString(5,mbno);
                   
			
			return pstmt;
		}
		
	}
	private final class InsertQryCall implements PreparedStatementCallback
	{

		@Override
		public Object doInPreparedStatement(PreparedStatement pstmt) throws SQLException, DataAccessException {
            int rs=pstmt.executeUpdate();
			return rs;
		}
		
	}
                         /* **************update qry*******************/
	@Override
	public int updateCustdetails(String fname,int sno) {
		UpdateQryCreator uqc=new UpdateQryCreator(fname, sno);
		UpdateQryCall uq=new UpdateQryCall();
		return  (int) jt.execute(uqc,uq);
	}
    private final class UpdateQryCreator implements PreparedStatementCreator
    {
     private String fname;
     private int sno;
     
		public UpdateQryCreator(String fname, int sno) {
		this.fname = fname;
		this.sno = sno;
	}

		@Override
		public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
			PreparedStatement pstmt=con.prepareStatement(SQL_QRY_UPDATE_BY_NO);
			pstmt.setString(1,fname);
			pstmt.setInt(2,sno);
			return pstmt;
		}
    	
    }
    private final class UpdateQryCall implements PreparedStatementCallback
    {

		@Override
		public Object doInPreparedStatement(PreparedStatement pst) throws SQLException, DataAccessException {
          int rs=pst.executeUpdate();
			return rs;
		}}

	@Override
	public int deleteCustdetailsByNo(int sno) {
		deleteCustRowByNoCreator dcrbc=new deleteCustRowByNoCreator(sno);
		deleteCustRowByNoCall dcrbnc=new deleteCustRowByNoCall();
		return (int) jt.execute(dcrbc, dcrbnc);
	}
private final class deleteCustRowByNoCreator implements PreparedStatementCreator
{
	private int sno;
	public deleteCustRowByNoCreator(int sno) 
	{
		this.sno = sno;
	}
	@Override
	public PreparedStatement createPreparedStatement(Connection con) throws SQLException 
	{
        PreparedStatement ps=con.prepareStatement(SQL_QRY_DELETE_BY_NO);
         ps.setInt(1,sno);
		return ps;
	}
	
}
private final class deleteCustRowByNoCall implements PreparedStatementCallback
{

	@Override
	public Object doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {
		// TODO Auto-generated method stub
		return ps.executeUpdate();
	}



}
}

