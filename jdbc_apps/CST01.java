
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Scanner;

/*Create or replace procedure Procedure_First(num1 in number, num2 out number) as
begin
num2:=num1*num1;
end;
/
*/

public class CST01 {
	public static void main(String[] args) {
		Scanner sc = null;
		int num=0;
		Connection con = null;
		String query = null;
		CallableStatement cst = null;
		int result = 0;
		
		try{
			sc = new Scanner(System.in);
			if(sc!=null){
				System.out.println("Enter number");
				num = sc.nextInt();
			}
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","scott","tiger");
			query = "{call Procedure_First(?,?)}";
			if(con!=null){
				cst = con.prepareCall(query);
			}
			if(cst!=null){
				cst.registerOutParameter(2, Types.INTEGER);
				cst.setInt(1, num);
				cst.execute();
				result = cst.getInt(2);
				System.out.println("SQUARE value:"+result);
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
