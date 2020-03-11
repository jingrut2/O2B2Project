package dbtest;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;


public class Layout_test extends JFrame{
	public Layout_test() {
		// TODO Auto-generated constructor stub
		JTextField tf = new JTextField(20);
		JTextArea ta = new JTextArea(7, 20); 
		setTitle("텍스트영역 만들기 예제");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JScrollPane scroll = new JScrollPane(ta);
		scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		
		Container c = getContentPane();
			c.setLayout(new FlowLayout());
			c.add(new JLabel("입력 후 <Enter> 키를 입력하세요"));
			c.add(tf);
			c.add(scroll);
			setSize(300,300);
			setVisible(true);
	}
public static void main(String[] args) {
	new Layout_test();

//		
//
//	// 프레임 및 패널 만들기
//			JFrame f = new JFrame();
//			JPanel p1 = new JPanel();
//			JPanel p2 = new JPanel();
//			JPanel p3 = new JPanel();
//			JTextArea txtArea1 = new JTextArea();
//			// 스크롤
//
//			
//			JTextArea txtArea2 = new JTextArea();
//			JTextArea txtArea3 = new JTextArea();
//			
//			Color color=new Color(220,220,220); 
//			
//			// 프레임 셋팅
//			f.setTitle("TEST");
//			f.setBounds(0, 0, 800, 600);
//			f.setVisible(true);			
//			
//			// 프레임의 레이아웃 설정
//			f.setLayout(null);				
//			
//			// 패널 셋팅
//			p1.setBounds(10, 0, 800, 190);
//
//			
//			
//			p2.setBounds(10, 200, 800, 190);
//			//p2.add(scroll);
//			p3.setBounds(10, 400, 800, 190);
//			//p3.add(scroll);
//			// 패널의 레이아웃 설정
//			p1.setLayout(null);
//			p2.setLayout(null);
//			p3.setLayout(null);
//			
//			// 컴포넌트 만들기
//			Button btn1 = new Button("패널1 버튼");
//			Button btn2 = new Button("패널2 버튼");
//			Button btn3 = new Button("패널2 버튼2");
//			
//			
//			// 컴포넌트 위치, 크기 설정
//			btn1.setBounds(0, 50, 100, 100);
//			btn2.setBounds(0, 50, 100, 100);
//			btn3.setBounds(0, 50, 100, 100);
//			txtArea1.setBounds(200,50, 400,150);
//			txtArea2.setBounds(200,50, 400,150);
//			txtArea3.setBounds(200,50, 400,150);
//			
//			// 패널에 컴포넌트 붙이기
//			p1.add(btn1);
//			p2.add(btn2);
//			p3.add(btn3);
//			
//			p1.setBounds(10, 0, 800, 190);
//			JScrollPane scroll = new JScrollPane(txtArea1);
//			scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
//			p1.add(scroll, BorderLayout.CENTER);
//			//p1.add(txtArea1);
//			p2.add(txtArea2);
//			p3.add(txtArea3);
//			
//			p1.setBackground(color);
//			p2.setBackground(color);
//			p3.setBackground(color);
//			
//			// 프레임에 패널 붙이기
//			f.add(p1);
//			f.add(p2);
//			f.add(p3);
//			
//			f.setBackground(color);
	}
}
