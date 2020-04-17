
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;

import java.sql.Clob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.Scanner;

public class Retrieving_CLOB {

	static Connection con;
	static PreparedStatement pst;
	static ResultSet rs;

	static Scanner sc = null;
	static String id = "";
	static String sql = "SELECT * FROM FILES WHERE ID = ?";
	static Reader reader = null;
	static Writer writer = null;
	static int chars_read = 0;
	static char[] buffer = null;
	static Clob clob = null;

	static void getMySQLConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/db1", "root", "root");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	static void getOracleConnection() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "scott", "tiger");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	static void queryProcessing() {
		try {
			pst = con.prepareStatement(sql);
			if (pst != null) {
				pst.setString(1, id);
				rs = pst.executeQuery();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	static void retrieveCLOB01() {
		try {
			if (rs.next()) {
				reader = rs.getCharacterStream(2);
				writer = new FileWriter("D:\\JdbcApplications\\Files\\" + id + ".txt");
				buffer = new char[2048];
				while ((chars_read = reader.read(buffer)) != -1) {
					writer.write(buffer, 0, chars_read);
				}
				System.out.println("CLOB Retrieved Successfully");
			} else {
				System.out.println("CLOB Not Retrieved");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	static void retrieveCLOB02() {
		try {
			if (rs.next()) {
				clob = rs.getClob(2);
				reader = clob.getCharacterStream();

				writer = new FileWriter("D:\\JdbcApplications\\Files\\" + id + ".txt");

				while ((chars_read = reader.read()) != -1) {
					writer.write((int)chars_read);
				}
				System.out.println("CLOB Retrieved Successfully");
			} else {
				System.out.println("CLOB Not Retrieved");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		System.out.println(".......Retrieving_CLOB.......");
		System.out.println("-----------------------------");
		System.out.println();
		System.out.println();

		int Select_DataBase = 0;
		try {
			System.out.println("Select the DataBase you want to work with.");
			System.out.println("1..ORACLE 11g [Recommended]");
			System.out.println("2..MySQL 5.5 [Not Recommended]");

			sc = new Scanner(System.in);
			Select_DataBase = Integer.parseInt(sc.next());

			if (sc != null) {
				if (Select_DataBase == 1) {
					getOracleConnection();
				} else {
					getMySQLConnection();
				}

				System.out.print("Enter the File ID ");
				id = sc.next();
				// id = f3
			} else {
				return;
			}

			if (con != null) {
				queryProcessing();
			}

			if (rs != null) {
				//retrieveCLOB01();
				retrieveCLOB02();
			}
		} finally {
			cleanResources();
		}
	}

	static void cleanResources() {
		System.out.println("All the Resources are hereby Cleaned");
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
			if (con != null)
				con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			if (sc != null)
				sc.close();
		} catch (IllegalStateException e) {
			e.printStackTrace();
		}
		try {
			if (reader != null)
				reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			if (writer != null)
				writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
