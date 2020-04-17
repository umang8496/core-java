
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.Scanner;

public class Inserting_CLOB {
	static Connection con;
	static PreparedStatement pst;
	static ResultSet rs;

	static Scanner sc = null;
	static String id = "";
	static String file_path = "";
	static String sql = "INSERT INTO FILES VALUES(?,?)";
	static File file = null;
	static Reader reader = null;
	static int result = -1;

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
			file = new File(file_path);
			reader = new FileReader(file);

			if (pst != null) {
				pst.setString(1, id);
				pst.setCharacterStream(2, reader, (int) file.length());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	static void insertCLOB() {
		try {
			if (pst != null) {
				result = pst.executeUpdate();
				if (result == -1) {
					System.out.println("CLOB Not Inserted");
				} else {
					System.out.println("CLOB Inserted");
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		System.out.println(".......Inserting_CLOB.......");
		System.out.println("----------------------------");
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
			} else {
				return;
			}

			if (con != null) {
				if (sc != null) {
					System.out.print("Enter the File ID ");
					id = sc.next();
					// id = f3

					System.out.print("Enter the File Path ");
					file_path = sc.next();
					// file_path = D:\documents\CLOB03.txt
				}
				queryProcessing();
			}

			if (pst != null) {
				insertCLOB();
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
	}
}
