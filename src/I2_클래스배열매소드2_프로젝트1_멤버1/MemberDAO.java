package I2_Ŭ�����迭�żҵ�2_������Ʈ1_���1;
import java.util.Scanner;
public class MemberDAO {
	Scanner scan;
	int max;
	Member[] memberList;
	int memberCount;
	
	void init(int size) {
		scan = new Scanner(System.in);
		max = size;
		memberList = new Member[max];
		memberCount = 0;
	}
	
	void printMemberList() {
		for(int i = 0; i < memberCount; i++) {
			memberList[i].printMember();
		}
	}
	void join() {
		System.out.println("[�߰�] ���̵��Է� : ");
		String id = scan.next();
		
		boolean result = false;		
		for(int i = 0; i < memberCount; i++) {
			if(memberList[i].id.equals(id)) {
				result =  true;
			}
		}	
		
		if(result == true) {
			System.out.println("[�ߺ����̵�]");
		}else {
			System.out.println("[�߰�] ��й�ȣ�Է� : ");
			String pw = scan.next();
			System.out.println("[�߰�] �̸��Է� : ");
			String name = scan.next();
			Member member = new Member();
			member.id = id;
			member.pw = pw;
			member.name = name;
			memberList[memberCount] = member;
			memberCount += 1;
			System.out.println("[�߰�����]");
		}
	}
	void delete() {
		System.out.println("[����] ���̵��Է� : ");
		String id = scan.next();
		
		boolean result = false;		
		for(int i = 0; i < memberCount; i++) {
			if(memberList[i].id.equals(id)) {
				result =  true;
			}
		}	
		
		if(result == false) {
			System.out.println("[���̵� ã���� �����ϴ�]");
		}else {
			int index = 0;
			for(int i = 0; i < memberCount; i++) {
				if(memberList[i].id.equals(id)) {
					index = i;
				}
			}
			for(int i = index; i < memberCount - 1 ; i++) {
				memberList[i] = memberList[i + 1];
			}
			memberCount -= 1;
			
			System.out.println("[��������]");
		}
	}
	void update() {
		System.out.println("[����] ���̵��Է� : ");
		String id = scan.next();
		System.out.println("[����] ��й�ȣ�Է� : ");
		String pw = scan.next();
		
		boolean result = false;
		
		for(int i = 0; i < memberCount; i++) {
			if(memberList[i].id.equals(id) &&
					memberList[i].pw.equals(pw)) {
				result =  true;
			}
		}		
		
		if(result == false) {
			System.out.println("[���̵� ã���� �����ϴ�]");
		}else {
			System.out.println("[����] �̸��Է� : ");
			String name = scan.next();
			Member member = null;
			for(int i = 0; i < memberCount; i++) {
				if(memberList[i].id.equals(id)) {
					member = memberList[i];
					break;
				}
			}
			if(member != null) {
				member.name = name;
				System.out.println("[�����Ϸ�]");
			}
			else {
				System.out.println("����");
			}
		}
	}
	void printAll() {
		printMemberList();
	}
	
}
