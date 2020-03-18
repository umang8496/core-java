
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Inserting_BLOB {
	static Connection con;
	static PreparedStatement pst;
	static ResultSet rs;

	static InputStreamReader isr;
	static BufferedReader br;

	static String sql = "INSERT INTO GALLERY VALUES(?,?)";
	static String img_name;
	static String img_path;

	static File file;
	static InputStream is;
	static FileInputStream fin;

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

	static void framingQuery() {
		try {
			// pst = con.prepareStatement(sql,
			// ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
			// java.sql.SQLException: Cannot bind stream to a
			// ScrollableResultSet or UpdatableResultSet

			pst = con.prepareStatement(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	static void setValuesUsingFileAndInputStream() {
		try {
			System.out.println("Enter the Image Name");
			img_name = br.readLine();
			// img_name = "g2";

			System.out.println("Enter the Image Path");
			img_path = br.readLine();
			// img_path = "E:\\Images\\Gallery02.png";
			// img_path = "E:\\Images\\Gallery02.jpg";

			file = new File(img_path);
			is = new FileInputStream(file);

			pst.setString(1, img_name);
			pst.setBinaryStream(2, is, (int) file.length());
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	static void setValuesUsingFileInputStream() {
		try {
			System.out.println("Enter the Image Name");
			img_name = br.readLine();
			// img_name = "g1";

			System.out.println("Enter the Image Path");
			img_path = br.readLine();
			// img_path = "E:\\Images\\Gallery02.png";
			// img_path = "E:\\Images\\Gallery01.jpg";

			// file = new File(img_path);
			fin = new FileInputStream(img_path);

			pst.setString(1, img_name);
			pst.setBinaryStream(2, fin, fin.available());
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	static void insertBLOB() {
		try {
			result = pst.executeUpdate();

			if (result != -1) {
				System.out.println("BLOB Inserted");
			} else {
				System.out.println("BLOB Not Inserted");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		System.out.println(".......Inserting_BLOB.......");
		System.out.println("----------------------------");
		System.out.println();
		System.out.println();

		int Select_DataBase = 0;
		try {
			System.out.println("Select the DataBase you want to work with.");
			System.out.println("1..ORACLE 11g [Recommended]");
			System.out.println("2..MySQL 5.5 [Not Recommended]");

			isr = new InputStreamReader(System.in);
			br = new BufferedReader(isr);

			Select_DataBase = Integer.parseInt(br.readLine());

			if (Select_DataBase == 1) {
				getOracleConnection();
			} else {
				getMySQLConnection();
			}
			if (con != null) {
				framingQuery();
			}
			if (pst != null) {
				setValuesUsingFileInputStream();
				// setValuesUsingFileAndInputStream();
			}
			if (pst != null) {
				insertBLOB();
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
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
			if (is != null)
				is.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			if (br != null)
				br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			if (fin != null)
				fin.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
