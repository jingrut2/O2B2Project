package o2b2;

import java.util.ArrayList;

public class Main_DB {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Frame_DB mFrame_DB = Frame_DB.getInstance();
		
		And_Server mAnd_Server = new And_Server();
		mAnd_Server.start();
		
		Rasp_Main mRasp_Main = new Rasp_Main();
		mRasp_Main.start();
		
		new Graph_Test();
		//그래프 그리기 부분
		SingleTon mS =SingleTon.getInstanse();
		ArrayList<Integer> m = new ArrayList<Integer>();
		m.add(1);
		m.add(30);
		m.add(70);
		m.add(50);
		m.add(50);
		m.add(70);
		m.add(30);
		m.add(80);
		m.add(40);
		m.add(50);
		
		mS.setGraph(m);
		
//		StartSelect mLogin = new StartSelect();
//		mLogin.Login();
//		new App_Socket();
//		new Raspberry_Socket();
	}
}
