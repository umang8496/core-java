
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

class MySQL_Connection {

	public static void main(String args[]) {
		System.out.println(".......PSVM starting.......");
		System.out.println();
		
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		//String str = "SELECT * FROM FIRST";
		String str = "SHOW TABLES";
		
		try{
			Class.forName("com.mysql.jdbc.Driver");
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		try{
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql", "root", "root");
			if (con!=null){
				System.out.println("CONNECTION ESTABLISHED");
			}
			stmt = con.createStatement();
			rs = stmt.executeQuery(str);
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
		System.out.println("------------------------------------------------------------------");
		
		try{
			while (rs.next()){
				//System.out.println(rs.getString(1)+"  "+rs.getString(2)+"  "+rs.getString(3));
				System.out.println(rs.getString(1));
			}
		}catch (SQLException e){
			e.printStackTrace();
		}
		
		System.out.println("------------------------------------------------------------------");
		
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
