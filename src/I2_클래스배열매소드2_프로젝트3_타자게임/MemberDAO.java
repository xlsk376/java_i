package I2_Ŭ�����迭�żҵ�2_������Ʈ3_Ÿ�ڰ���;

import java.util.Scanner;

public class MemberDAO {
	int max;
	Member[] memberList;
	int memberCount;
	Scanner scan = new Scanner(System.in);
	void init(int size) {
		max = size;
		memberList = new Member[max];
		memberCount = 0;
	}
	
	void insertMember(Member member) {
		
		memberList[memberCount] = member;
		memberCount += 1;
	}
	
	boolean checkMemberId(String id) {
		for(int i = 0; i < memberCount; i++) {
			if(memberList[i].id.equals(id)) {
				return true;
			}
		}		
		return false;
	}
	boolean checkMemberIdAndPw(String id , String pw) {
		for(int i = 0; i < memberCount; i++) {
			if(memberList[i].id.equals(id) &&
					memberList[i].pw.equals(pw)) {
				return true;
			}
		}		
		return false;
	}
	void updateMember(int index , Member member) {
		memberList[index] = member;		
	}
	int getMemberIndex(String id) {
		int index = 0;
		for(int i = 0; i < memberCount; i++) {
			if(memberList[i].id.equals(id)) {
				index = i;
				break;
			}
		}
		return index;
	}
	void removeMember(int index) {
		for(int i = index; i < memberCount - 1 ; i++) {
			memberList[i] = memberList[i + 1];
		}
		memberCount -= 1;
	}
	
	Member getMember(String id) {
		Member member = null;
		for(int i = 0; i < memberCount; i++) {
			if(memberList[i].id.equals(id)) {
				member = memberList[i];
				break;
			}
		}
		return member;
	}
	void printMemberList() {
		for(int i = 0; i < memberCount; i++) {
			memberList[i].printMember();
		}
	}
	
	void join() {
		System.out.println("[ȸ������] ���̵��Է� : ");
		String id = scan.next();
		boolean result = checkMemberId(id);
		if (result == true) {
			System.out.println("[�ߺ����̵�]");
		} else {
			System.out.println("[ȸ������] ��й�ȣ�Է� : ");
			String pw = scan.next();
			System.out.println("[ȸ������] �̸��Է� : ");
			String name = scan.next();
			Member member = new Member();
			member.id = id;
			member.pw = pw;
			member.name = name;
			insertMember(member);
			System.out.println("[ȸ������ ����]");
		}
	}
	Member login() {
		System.out.println("[�α���] ���̵��Է� : ");
		String id = scan.next();
		boolean result = checkMemberId(id);
		if (result == false) {
			System.out.println("[���¾��̵�]");
			return null;
		} else {
			return getMember(id);
		}
		
	}
	
}
