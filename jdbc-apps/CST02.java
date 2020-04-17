
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Scanner;

/*
Create or replace procedure getEmployeeDetails(num in number, Employee_Name out varchar2, Employee_Salary out number, Employee_Job out varchar2) as
begin
SELECT ename,sal,job INTO Employee_Name,Employee_Salary,Employee_Job FROM EMP WHERE empno=num;
end;
/

*/
public class CST02 {
	private static String query = "{call getEmployeeDetails(?,?,?,?)}";
	public static void main(String[] args) {
		Scanner sc = null;
		int num=0;
		Connection con = null;
		CallableStatement cst = null;
		
		try{
			sc = new Scanner(System.in);
			if(sc!=null){
				System.out.println("Enter the Employee_Number:");
				num = sc.nextInt();
			}
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","scott","tiger");
			if(con!=null){
				cst = con.prepareCall(query);
			}
			if(cst!=null){
				cst.registerOutParameter(2, Types.VARCHAR);
				cst.registerOutParameter(3, Types.INTEGER);
				cst.registerOutParameter(4, Types.VARCHAR);
				
				cst.setInt(1, num);
				cst.execute();
				
				System.out.println("Employee_Name : "+cst.getString(2));
				System.out.println("Employee_Salary : "+cst.getInt(3));
				System.out.println("Employee_Job : "+cst.getString(4));
			}
		}catch(SQLException exp){
			exp.printStackTrace();
		}catch(ClassNotFoundException exp){
			exp.printStackTrace();
		}catch(Exception exp){
			exp.printStackTrace();
		}finally{
			try{
				if(cst!=null)
					cst.close();
			}catch(SQLException exp){
				exp.printStackTrace();
			}
			try{
				if(con!=null)
					con.close();
			}catch(SQLException exp){
				exp.printStackTrace();
			}
			try{
				if(sc!=null)
					sc.close();
			}catch(Exception exp){
				exp.printStackTrace();
			}
		}
	}
}
