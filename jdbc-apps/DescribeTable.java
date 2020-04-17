
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DescribeTable {

	public static void main(String[] args) {
		System.out.println("Inside DescribeTable");
		System.out.println("--------------------");
		System.out.println();
		
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		boolean bool = false;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/db1", "root", "root");
			stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
			bool = stmt.execute("DESC TAB");
			//bool = stmt.execute("DESC first");
			rs = stmt.getResultSet();
			
			while(rs.next()!=false){
				System.out.format("%-10s %-10s %-10s %-10s%n", rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(5));	
			}
			System.out.println("------------------------------------------------------------");
			System.out.println();
			System.out.println();
			
			rs = stmt.executeQuery("SELECT * FROM TAB");
			while(rs.next()){
				System.out.printf("%-10s %-10s %-10s %-10s%n", rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4));
			}
			System.out.println("------------------------------------------------------------");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
