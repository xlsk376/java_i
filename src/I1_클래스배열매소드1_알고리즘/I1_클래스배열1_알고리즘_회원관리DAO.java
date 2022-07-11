package I1_Ŭ�����迭�żҵ�1_�˰���;
import java.util.Scanner;
class Member{
	String id;
	String name;
}

class ClientDAO{
	Scanner scan = new Scanner(System.in);
	Member[] clientList = new Member[100];
	int clientCount = 0;
	
	void insertClient(Member client) {
		clientList[clientCount] = client;
		clientCount += 1;
	}
	void removeClient(String id) {
		int index = -1;
		for(int i = 0; i < clientCount; i++) {
			if(clientList[i].id.equals(id)) {
				index = i;
				break;
			}
		}
		if(index == -1) {
			System.out.println("��������");
		}else {
			for(int i = index; i < clientCount -1; i++) {
				clientList[i] = clientList[i + 1];
			}
			clientCount -= 1;
		}
	}
	void printClintList() {
		for(int i = 0; i < clientCount; i++) {
			System.out.println(clientList[i].id + " " +clientList[i].name);
		}
	}
	void join() {
		System.out.println("���̵� �Է� : ");
		String id = scan.next();
		System.out.println("�̸� �Է� : ");
		String name = scan.next();
		
		Member client = new Member();
		client.id = id;
		client.name = name;
		insertClient(client);
	}
	void remove() {
		System.out.println("���̵��Է� : ");
		String id = scan.next();
		removeClient(id);
	}
}

public class I1_Ŭ�����迭1_�˰���_ȸ������DAO {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		ClientDAO clientDAO = new ClientDAO();	
		while(true) {
			System.out.println("[1]�߰� [2]���� [3]��� [0]����");
			int sel = scan.nextInt();		
			if(sel == 1) {
				clientDAO.join();			
			}else if(sel == 2){
				clientDAO.remove();
			}else if(sel == 3) {
				clientDAO.printClintList();
			}
		}		
	}
}