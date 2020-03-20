package o2b2;


public class MainFrame {
		
		public static void main(String [] args) {
			
			new MainSetting();
			new MenuBar();
			
			And_Server mAnd_Server = new And_Server();
			mAnd_Server.start();
			
			Rasp_Main mRasp_Main = new Rasp_Main();
			mRasp_Main.start();
	
		}
}
