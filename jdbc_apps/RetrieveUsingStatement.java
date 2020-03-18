
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class RetrieveUsingStatement {

	public static void main(String[] args) {
		System.out.println(".......StaticInsertion.......");
		System.out.println();
		
		Connection con = null;
		Statement stmt = null;
		//boolean bool = false;
		ResultSet rs = null;
		int row = 0;
		String sql = "INSERT INTO TAB VALUES('JIGAR', 1234, 'GIRIDIH')";
		String query = "SELECT * FROM TAB";
		
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "scott", "tiger");
			stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			row = stmt.executeUpdate(sql);
			rs = stmt.executeQuery(query);
			
			System.out.println("-------------------------------------------------------");
			if(row!=0){
				System.out.println(row+" Record Inserted");
				System.out.println("-------------------------------------------------------");
			}
			while(rs.next()){
				System.out.printf("%10s%10s%10s",rs.getString(1),rs.getString(2),rs.getString(3));
				System.out.println();
			}
			System.out.println("-------------------------------------------------------");
			
		}catch (ClassNotFoundException e){
			e.printStackTrace();
		}catch (SQLException e) {
			e.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
			try{
				if(rs!=null)
					rs.close();
				if(stmt!=null)
					stmt.close();
				if(con!=null)
					con.close();
			}catch (SQLException e){
				e.printStackTrace();
			}
		}
	}
}
