
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Oracle_MySQL_Comm {

	public static void main(String[] args) {
		System.out.println();
		System.out.println(".......Oracle-MySQL Communication.......");
		System.out.println("----------------------------------------");
		System.out.println();
		System.out.println();
		
		
		Connection Ocon = null;
		Connection Mcon = null;
		Statement Ost = null;
		Statement Mst = null;
		ResultSet Ors = null;
		ResultSet Mrs = null;
		int row = -1;
		
		
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Class.forName("com.mysql.jdbc.Driver");
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		try{
			Ocon = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "scott", "tiger");
			Mcon = DriverManager.getConnection("jdbc:mysql://localhost:3306/db1", "root", "root");
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
		if(Ocon!=null && Mcon!=null){
			System.out.println("Both the connections are Valid");
		}else{
			System.out.println("Both the connections are Invalid");
		}
		
		try{
			Ost = Ocon.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
			Mst = Mcon.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
		System.out.println("----------------------------------------");
		
		try{
			Ors = Ost.executeQuery("SELECT * FROM Employee");
			while(Ors.next()){
				System.out.printf("%10s %10s %10s %10s %10s %10s %10s%n",
									Ors.getString(1),Ors.getString(2),Ors.getString(3),
									Ors.getString(4),Ors.getString(6),
									Ors.getString(7),Ors.getString(8));
				
			}
			Ors.beforeFirst();
//INSERT INTO Employee VALUES
//(7369  ,   'SMITH'  ,    'CLERK'  ,     7902     ,    800   ,    null   ,      20);			
			
			while(Ors.next()){
				row = Mst.executeUpdate("INSERT INTO Employee VALUES ("+Ors.getString(1)
										+",'"+Ors.getString(2)+"','"+Ors.getString(3)
										+"',"+Ors.getString(4)+","+Ors.getString(6)
										+","+Ors.getString(7)+","+Ors.getString(8)
										+")");
				//row = Mst.executeUpdate("INSERT INTO Employee VALUES ("+"7369"+",'"+"SMITH"+"','"+"CLERK"+"',"+"7902"+","+"800"+","+"null"+","+"20"+")");
				//row = Mst.executeUpdate("INSERT INTO Employee VALUES (7369, 'SMITH', 'CLERK', 7902, 800, null, 20)");
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
		System.out.println("----------------------------------------");
		
		if(row!=-1){
			System.out.println("Record Inserted Successfully");
		}else{
			System.out.println("Record NOT Inserted");
		}
		
		System.out.println("----------------------------------------");
		
		try{
			Mrs = Mst.executeQuery("SELECT * FROM Employee");
			while(Mrs.next()){
				System.out.printf("%10s %10s %10s %10s %10s %10s %10s %n",
									Mrs.getString(1),Mrs.getString(2),Mrs.getString(3),
									Mrs.getString(4),Mrs.getString(5),
									Mrs.getString(6),Mrs.getString(7));				
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try{
				if(Ors!=null)
					Ors.close();
				if(Mrs!=null)
					Mrs.close();
			}catch (SQLException e) {
				e.printStackTrace();
			}
			
			try{
				if(Ost!=null)
					Ost.close();
				if(Mst!=null)
					Mst.close();
			}catch (SQLException e) {
				e.printStackTrace();
			}
			
			try{
				if(Ocon!=null)
					Ocon.close();
				if(Mcon!=null)
					Mcon.close();
			}catch (SQLException e) {
				e.printStackTrace();
			}
		}
		System.out.println("----------------------------------------");
	}
}
