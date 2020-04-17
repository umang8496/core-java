
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertOperation {

	public static void main(String[] args) {
		System.out.println("Inside PSVM");
		System.out.println("-----------");
		System.out.println();
		
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		boolean bool = false;
		int row = 0;
		
		try{
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/db1", "root", "root");
			stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
			bool = stmt.execute("DESC TAB");
			
			if(bool==true){
				row = stmt.executeUpdate("INSERT INTO TAB VALUES('UMANG', 89360, 20, 'VAISHALI')");
				if(row!=0){
						System.out.println("Record Inserted");
					}
			}
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
		}catch (SQLException e) {
			e.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}
