package AS;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ASserver {
	public static final int PORT=15421;
	public ASserver(){	
	}
	public void run()
	{
		ASui a =new ASui();
		a.ini();
		ServerSocket serverSocket;
		Socket client;
		try {
			//����ServerSocket���󣬼���������PORT�˿�
			serverSocket=new ServerSocket(PORT);
			while(true){
				//����socket�׽��֣������ͻ�����������
				client=serverSocket.accept();
				ASrunnable my = new ASrunnable(client,a.ta);
				Thread thread = new Thread(my);				//�������߳�
				thread.start();	
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args)
	{

		ASserver server=new ASserver();
		server.run();
	}
	
}