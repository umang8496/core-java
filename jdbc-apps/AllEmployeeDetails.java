
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AllEmployeeDetails {

	public static void main(String[] args) {
		System.out.println(".......PSVM starting.......");
		System.out.println();
		
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		String str = "SELECT * FROM EMP";
		
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		try{
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "scott", "tiger");
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
		try{
			stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
		try{
			rs = stmt.executeQuery(str);
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
		System.out.println("RIGHT ALIGNED OUTPUT");
		System.out.println("-------------------------------------------------------------------------------------");
		
		try{
			while(rs.next()){
				System.out.printf("%10s %10s %10s %10s %10s %10s %10s %10s%n",
									rs.getString(1),rs.getString(2),rs.getString(3),
									rs.getString(4),rs.getDate(5),rs.getString(6),
									rs.getString(7),rs.getString(8));
				//System.out.println();
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
		System.out.println("-------------------------------------------------------------------------------------");
		
		try{
			rs.beforeFirst();
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
		System.out.println("LEFT ALIGNED OUTPUT");
		System.out.println("-------------------------------------------------------------------------------------");
		
		try{
			while(rs.next()){
				System.out.printf("%-10s %-10s %-10s %-10s %-10s %-10s %-10s %-10s%n",
									rs.getString(1),rs.getString(2),rs.getString(3),
									rs.getString(4),rs.getDate(5),rs.getString(6),
									rs.getString(7),rs.getString(8));
				//System.out.println();
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
		System.out.println("-------------------------------------------------------------------------------------");
		
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
