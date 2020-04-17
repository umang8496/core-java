
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;

import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Retrieving_BLOB {
	static Connection con;
	static PreparedStatement pst;
	static ResultSet rs;

	static InputStreamReader isr;
	static BufferedReader br;

	static String img_name = "";
	static String sql = "SELECT * FROM GALLERY WHERE img_name=?";

	static File file;
	static InputStream is;
	static OutputStream os;
	static FileInputStream fin;
	static FileOutputStream fout;

	static int bytesRead;
	static byte[] buffer;

	static Blob blob;

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

	static void queryProcessing() {
		try {
			System.out.println("Enter the Image Name");
			img_name = br.readLine();

			pst.setString(1, img_name);

			rs = pst.executeQuery();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	static void retrieveImageUsingBinaryStream() {
		try {
			if (rs.next()) {
				is = rs.getBinaryStream(2);

				// os = new
				// FileOutputStream("D:\\JdbcApplications\\Images\\"+img_name+".png");
				os = new FileOutputStream("D:\\JdbcApplications\\Images\\" + img_name + ".jpg");

				buffer = new byte[4096];
				while ((bytesRead = is.read(buffer)) != -1) {
					os.write(buffer, 0, bytesRead);
				}
				System.out.println("Image Retrieved Successfully.");
				System.out.println("-----------------------------");
			} else {
				System.out.println("Image Not Retrieved.");
				System.out.println("--------------------");
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	static void retrieveImageUsingBlob() {
		try {
			if (rs.next()) {
				blob = rs.getBlob(2);
				buffer = blob.getBytes(1, (int) blob.length());

				fout = new FileOutputStream("D:\\JdbcApplications\\Images\\" + img_name + ".jpg");
				fout.write(buffer);

				System.out.println("Image Retrieved Successfully.");
				System.out.println("-----------------------------");
			} else {
				System.out.println("Image Not Retrieved.");
				System.out.println("--------------------");
			}
		} catch (IOException e) {
			e.printStackTrace();
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
				queryProcessing();
			}
			if (rs != null) {
				retrieveImageUsingBlob();
				// retrieveImageUsingBinaryStream();
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
			if (fout != null)
				fout.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
