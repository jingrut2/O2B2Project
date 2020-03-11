package dbtest;

import java.sql.*;
import java.util.Scanner;


public class DBTest_Delete {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String delphonenum = null;
		String delpassword = null;
		Scanner sc = new Scanner(System.in);
		System.out.println("삭제할 전화번호 입력: ");
		delphonenum = sc.next();
		System.out.println("삭제할 비밀번호 입력: ");
		delpassword = sc.next();
		
		
		
		delete(delphonenum, delpassword);
	}
		
		public static void delete(String delphonenum ,String delpassword ) {
			
			Connection conn = null;
			PreparedStatement pstmt = null;
			
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/o2b2", "root", "1234");
			
			String sql = "Delete from profile where phonenum = ? and password1= ?";
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, delphonenum);
			pstmt.setString(2, delpassword);
			
			int count = pstmt.executeUpdate();
			System.out.println("변경된 row: "+ count);
			
			

		} catch (Exception e) {

			e.printStackTrace();

		} finally {
			try {
				if (pstmt != null && !pstmt.isClosed()) {
					pstmt.close();
				}
				if (conn != null && !conn.isClosed()) {
					conn.close();
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}
}
