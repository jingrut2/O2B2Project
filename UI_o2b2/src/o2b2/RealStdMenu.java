package o2b2;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import o2b2.JPanel01.JPanelTest;

class JPanel04 extends JPanel {

	private JButton jButton1;
	private JButton jButton2;
	private JButton jButton3;
	private JButton jButton4;

	private JLabel jlabel1;

	private JTextField jtextfield1;

	private JScrollPane jScrollPane1;
	private JTextArea jTextArea1;

	void makeCombo() { // select 박스
		JComboBox<String> c = new JComboBox();
		c.setSize(500, 40);
		c.setLocation(200, 385);
//		c.addItem("data1"); // 데이터값 넣기
		
		SingleTon s =SingleTon.getInstanse();
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
	
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3309/o2b2", "root", "1234");
		
			stmt = conn.createStatement();
		
			String sql = "SELECT * FROM realstudytime ORDER BY serialnum asc;";
		
			rs = stmt.executeQuery(sql);
		
			while (rs.next()) {
				// 레코드의 칼럼은 배열과 달리 0부터 시작하지 않고 1부터 시작한다.
				// 데이터베이스에서 가져오는 데이터의 타입에 맞게 getString 또는 getInt 등을 호출한다.
				String serialnum = rs.getString(1);
				s.SelectRealserialnum_singleTon.add(rs.getString(1));
				String studytime = rs.getString(2);
				s.SelectRealstudytime_singleTon.add(rs.getString(2));
				String date = rs.getString(3);
				s.SelectRealdate_singleTon.add(rs.getString(3));
				String subject = rs.getString(4);
				s.SelectRealsubject_singleTon.add(rs.getString(4));
		
				s.realstudytimeval = serialnum + "/" + studytime + "/" + date + "/"+ subject + "\n";
				c.addItem(s.realstudytimeval);
				add(c);
			}
	
		} catch (Exception e1) {
			e1.printStackTrace();
		} finally {
			try {
				if (conn != null && !conn.isClosed()) {
					conn.close();
				}
				if (stmt != null && !stmt.isClosed()) {
					stmt.close();
				}
				if (rs != null && !rs.isClosed()) {
					rs.close();
				}
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
//		add(c);
		////   선택값 가져오기
		c.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				s.Delete_rst = c.getSelectedItem().toString();
			}
		});



	}

	public JPanel04(JPanelTest win) {

		SingleTon s = SingleTon.getInstanse();

		jlabel1 = new JLabel("실제 학습시간");
		jlabel1.setSize(200, 40);
		jlabel1.setLocation(365, 10);
		jlabel1.setForeground(Color.white); // 글 색상
		jlabel1.setFont(jlabel1.getFont().deriveFont(20.0f));
		add(jlabel1);

		ImageIcon img = new ImageIcon("image/oba-study2.jpg"); // 이미지 경로
		JLabel imagelJLabel = new JLabel(img);
		imagelJLabel.setSize(200, 60);
		imagelJLabel.setLocation(8, 45);

		add(imagelJLabel);
		setVisible(true); // 화면에 보이기

		makeCombo();

		setLayout(null);

		jButton1 = new JButton("UP LOADING");
		jButton1.setSize(130, 40);
		jButton1.setLocation(40, 240);
		add(jButton1);
		//
		jButton1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				makeCombo();
				jTextArea1.setText("");
				Select_RealStudyTime mR = new Select_RealStudyTime();
				mR.loadRealStudyTime(jTextArea1);
			}
		});
		//

		jButton2 = new JButton("INSERT");
		jButton2.setSize(130, 40);
		jButton2.setLocation(40, 450);
		add(jButton2);
		//
		jButton2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//
				try {
					s.get_textfield_realstudy_ = jtextfield1.getText();
					System.out.println(s.get_textfield_realstudy_);
					jTextArea1.append(s.get_textfield_realstudy_+"\n");
					jtextfield1.setText(null);
					//
					jTextArea1.setText("");
//	        	 s.Insert_sst = "2,3,2020-02-11,3";
					String[] array = s.get_textfield_realstudy_.split("/");
					String serialNum = array[0];
					String studytime = array[1];
					String date = array[2];
					String subject = array[3];

					Insert_RealStudyTime.insert(serialNum, studytime, date, subject, jTextArea1);

				} catch (Exception e2) {
					// TODO: handle exception
					jTextArea1.append("실패했습니다. 값을 다시 한번 확인해 주세요.");
				}
				//
				}
		});
		//

		jButton3 = new JButton("DELETE");
		jButton3.setSize(130, 40);
		jButton3.setLocation(40, 385);
		add(jButton3);

		jButton3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jTextArea1.setText("");
//				s.Delete_rst = "2,3,2020-02-11,3";
				String[] array = s.Delete_rst.split("/");
				String serialNum = array[0];
				String studytime = array[1];
				String date = array[2];
				String subject = array[3];

				Delete_RealStudyTime.delete(serialNum, studytime, date, subject, jTextArea1);
			}
		});
		//

		jButton4 = new JButton("CLEAR");
		jButton4.setSize(130, 40);
		jButton4.setLocation(40, 310);
		add(jButton4);
		jButton4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jTextArea1.setText("");
			}
		});
		//

		jTextArea1 = new JTextArea();
		jScrollPane1 = new JScrollPane(jTextArea1);
		jScrollPane1.setSize(500, 300);
		jScrollPane1.setLocation(200, 50);
		add(jScrollPane1);

		jtextfield1 = new JTextField();
		jtextfield1.setSize(500, 40);
		jtextfield1.setLocation(200, 450);
		add(jtextfield1);

	}

}

public class RealStdMenu {

}
