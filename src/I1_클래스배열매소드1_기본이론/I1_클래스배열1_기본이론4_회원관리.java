package I1_Ŭ�����迭�żҵ�1_�⺻�̷�;
import java.util.Scanner;
class Member{
	String id;
	String name;
}
public class I1_Ŭ�����迭1_�⺻�̷�4_ȸ������ {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Member[] memberList = new Member[100];
		int memberCount = 0;
		while(true) {
			System.out.println("[1]�߰� [2]���� [3]��� [0]����");
			int sel = scan.nextInt();
			
			if(sel == 1) {
				System.out.println("���̵� �Է� : ");
				String id = scan.next();
				System.out.println("�̸� �Է� : ");
				String name = scan.next();
				
				Member member = new Member();
				member.id = id;
				member.name = name;
				memberList[memberCount] = member;
				memberCount += 1;
			}else if(sel == 2){
				System.out.println("���̵��Է� : ");
				String id = scan.next();
				int index = -1;
				for(int i = 0; i < memberCount; i++) {
					if(memberList[i].id.equals(id)) {
						index = i;
						break;
					}
				}
				if(index == -1) {
					System.out.println("��������");
				}else {
					for(int i = index; i < memberCount -1; i++) {
						memberList[i] = memberList[i + 1];
					}
					memberCount -= 1;
				}
			}else if(sel == 3) {
				for(int i = 0; i < memberCount; i++) {
					System.out.println(memberList[i].id + " " +memberList[i].name);
				}
			}else if(sel == 0) {
				break;
			}
		}
	}
}