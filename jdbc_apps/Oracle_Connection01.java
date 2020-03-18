
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Oracle_Connection01 {

	public static void main(String[] args) {
		Connection con = null;
		
		try{
			//register driver class object
			Class.forName("oracle.jdbc.driver.OracleDriver");
		}catch (Exception e){
			e.printStackTrace();
		}
		
		try{
			//establishing the connection
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","scott","tiger");
		}catch(SQLException e){
			e.printStackTrace();
		}
		
		if(con==null){
			System.out.println("Connection to oracle 11g is failed");
		}
		else{
			System.out.println("Connection to oracle 11g is successful");
		}
		
		try{
			if(con!=null)
				con.close();
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
