package I1_Ŭ�����迭�żҵ�1_�⺻�̷�;
class User{
	String name;
	int score;
	void init(String n , int s) {  //���ڸ� �����ϴ� ���� "�Ű�����"
		this.name = n ; this.score = s;
	}
	void printData() {
		System.out.println(this.name  + " : " + this.score);
	}
}

public class I1_Ŭ�����迭1_�⺻�̷�2 {
	public static void main(String[] args) {
		User [] st = new User[3];
		for(int i = 0; i < st.length; i++) {
			st[i] = new User();
		}
		st[0].init("��ö��",100); // ���� ���� "����"
		st[1].init("�̸���",20);
		st[2].init("�ڿ���",70);
		
		for(int i = 0 ; i < st.length; i++) {
			st[i].printData();
		}
	
	}
}