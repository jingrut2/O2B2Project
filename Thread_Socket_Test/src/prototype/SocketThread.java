package prototype;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Queue;

class SocketThread {
	static SocketThread m = null;
	ServerSocket server = null;
	Socket sock = null;
	boolean isInterrupt = false;
	ArrayList<String> mRead_Queue = new ArrayList<String>();
	
	private SocketThread() {

	}

	static SocketThread get() {
		if (m == null)
			m = new SocketThread();
		return m;
	}

	void join() { // 접속 //
		try {
			System.out.println("join 함수 들어옴");
			server = new ServerSocket(5678);
			System.out.println("And App Wating Connect ..");

			sock = server.accept();
			SocketThread_Read mSocketThread_Read = new SocketThread_Read();
			mSocketThread_Read.start();
			InetAddress inetaddr = sock.getInetAddress();
			isInterrupt = false;

			System.out.println(inetaddr.getHostAddress() + " 로부터 접속했습니다.");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	String readData() {
		String msg = null;
		if (mRead_Queue.size() > 0) {
			msg = mRead_Queue.get(0);
			mRead_Queue.remove(0);
		}
		return msg;
	}

	void readThreadStart() {
		SocketThread_Read mRead = new SocketThread_Read();
		mRead.start();
	}

	void write(String msg) {
		try {
			OutputStream out = sock.getOutputStream();
			PrintWriter pw = new PrintWriter(new OutputStreamWriter(out));
			pw.println(msg);
			pw.flush();
		} catch (Exception e) {

		}
	}

}

class SocketThread_Read extends Thread {
	String msg_AndThred=null;
	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		try {
			Frame mFrame = Frame.getInstance();
			SocketThread mSocketThread = SocketThread.get();
			InputStream in = mSocketThread.sock.getInputStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			//&& !mSocketThread.sock.isClosed() 조건을 넣어준다.
			while (!mSocketThread.isInterrupt && !mSocketThread.sock.isClosed()) {
				String readMsg = br.readLine();
				mSocketThread.mRead_Queue.add(readMsg);
				mFrame.txta1.append(readMsg + "\n");
				System.out.println("queue add : " + readMsg);
				Thread.sleep(100);
			}

		} catch (Exception e) {

		}
	}
}
