
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateNewEmployee {

	public static void main(String[] args) {
		System.out.println("This program creates a table using an existing table");
		System.out.println("----------------------------------------------------");
		System.out.println();
		System.out.println();
		
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		String str = "CREATE TABLE Employee AS SELECT * FROM EMP";
		//SQL> CREATE TABLE Employee AS SELECT * FROM EMP;
		boolean bool = false;
		boolean status = false;
		
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");

			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "scott", "tiger");
			
			stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
			
			bool = stmt.execute(str);
			
		/**
		 * It returns "true" if the first result is a ResultSet object;
		 * It returns "false" if it is an update count or there are no results;
		 */
			if(bool==false){
				System.out.println("Employee TABLE IS CREATED");
				status = true;
			}else{
				System.out.println("Employee TABLE IS NOT CREATED");
			}
			
			if(status==true){
				rs = stmt.executeQuery("SELECT * FROM Employee");
				while(rs.next()){
					System.out.printf("%10s %10s %10s %10s %10s %10s %10s %10s%n",
							rs.getString(1),rs.getString(2),rs.getString(3),
							rs.getString(4),rs.getDate(5),rs.getString(6),
							rs.getString(7),rs.getString(8));
				}
			}
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
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
}
