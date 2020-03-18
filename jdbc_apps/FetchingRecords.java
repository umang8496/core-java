
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class FetchingRecords {
	
	public static void main(String[] args) {
		System.out.println(".......inside PSVM.......");
		System.out.println();
		System.out.println();
		
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		String query = "SELECT EMPNO, ENAME, JOB, ROWID FROM EMP";
		
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		try{
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","scott","tiger");
			stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
		try{
			rs = stmt.executeQuery(query);
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
		System.out.println("fetching records from the beginning");
		System.out.println("-----------------------------------------");
		try{
			while(rs.next()!=false){
				System.out.printf("%-10s   %-10s   %-10s",rs.getString(1),rs.getString(2),rs.getString(3));
				System.out.println();
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("-----------------------------------------");
		
		System.out.println();
		System.out.println("fetching records from the end");
		System.out.println("-----------------------------------------");
		
		try{
			rs.afterLast();
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
		try{
			while(rs.previous()!=false){
				System.out.printf("%-10s   %-10s   %-10s",rs.getString(1),rs.getString(2),rs.getString(3));
				System.out.println();
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("-----------------------------------------");

		System.out.println("con==> "+con);
		System.out.println("stmt==> "+stmt);
		System.out.println("rs==> "+rs);
		
		System.out.println("-----------------------------------------");
		
		
		/*
		-----------------------------------------
		con==> oracle.jdbc.driver.T4CConnection@7907ec20
		stmt==> oracle.jdbc.driver.T4CStatement@546a03af
		rs==> oracle.jdbc.driver.UpdatableResultSet@721e0f4f
		-----------------------------------------
		 */
		
		
		try{
			if(rs!=null)
				rs.close();
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
		try{
			if(stmt!=null)
				stmt.close();
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
		try{
			if(con!=null)
				con.close();
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
