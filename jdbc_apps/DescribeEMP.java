
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DescribeEMP {
	static boolean bool;
	public static void main(String[] args) {
		System.out.println(".......DescribeEMP.......");
		System.out.println("-------------------------");
		System.out.println();
	
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		String sql = "DESC EMP";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "scott", "tiger");
			stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			bool = stmt.execute(sql);
			
			if (bool == true) {
				System.out.println("query executed properly");
				rs = stmt.getResultSet();
				while(rs.next()) {
					//System.out.printf("%10s %10s %n", rs.getString(1),rs.getString(3));
					System.out.println(rs.getString(1)+rs.getString(3));
				}
			} else {
				System.out.println("query does not executed");
			}
		} catch (ClassNotFoundException|SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			try {
				if (stmt != null)
					stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			try {
				if (con != null)
					con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
