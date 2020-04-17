
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UpdateUsingPreparedStatement {
	static int i = -1;
	static Connection con = null;
	static PreparedStatement pst = null;
	static PreparedStatement pstmt = null;
	static ResultSet rs = null;

	static InputStreamReader isr = new InputStreamReader(System.in);
	static BufferedReader br = new BufferedReader(isr);

	static void establishConnection() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "scott", "tiger");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	static void clearResources() {
		try {
			if (rs != null)
				rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			if (pst != null)
				pst.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			if (pstmt != null)
				pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			if (con != null)
				con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			if (br != null)
				br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			if (isr != null)
				isr.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	static void retrieveFromTAB() {
		try {
			String sql = "SELECT NAME, CITY, CODE, ROWID FROM TAB";
			pstmt = con.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				System.out.printf("%10s%15s%10s%20s%n", rs.getString(1), rs.getString(2), rs.getString(3),
						rs.getString(4));
			}
			System.out.println("------------------------------------------");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		System.out.println(".......UpdateUsingPreparedStatement.......");
		System.out.println("------------------------------------------");
		System.out.println();

		establishConnection();
		
		String Name = "";
		String rowid = "";
		String choice = "";

		try {
			System.out.println("Do you want to Update Records : yes/no");
			choice = br.readLine();

			if (choice.startsWith("n") || choice.startsWith("N")) {
				retrieveFromTAB();
			} else {
				retrieveFromTAB();
				pst = con.prepareStatement("UPDATE TAB SET NAME=? WHERE ROWID=?");
				do {
					System.out.println();
					System.out.println("updated NAME:");
					Name = br.readLine();

					System.out.println("enter ROWID:");
					rowid = br.readLine();
					
					pst.setString(1, Name);
					pst.setString(2, rowid);
					
					i = pst.executeUpdate();
					System.out.println(i + " records affected");

					System.out.println("Do you want to Update More Records : yes/no");
					choice = br.readLine();

					if (choice.startsWith("n") || choice.startsWith("N")) {
						retrieveFromTAB();
						break;
					}
				} while (true);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			clearResources();
		}
	}
}
