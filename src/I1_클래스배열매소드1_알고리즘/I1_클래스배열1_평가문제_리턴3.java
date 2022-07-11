package I1_Ŭ�����迭�żҵ�1_�˰���;
class Node3{
	int number;
	String name;
	String address;
	int scoreList[] = new int[3];
	int total;
	int avg;
	int rank;
	void print() {
		System.out.print(number + " " + name + " " + address + " ");
		System.out.print(scoreList[0] + " "+ scoreList[1] + " " + scoreList[2] + " ");
		System.out.println(total + " " + avg + " " + rank);
	}
}
class Return3{
	Node3[] getList(String[][] student, String[][] score) {
		//����1) �Ʒ�������� ��ü �л� ���  
		//     [�л���ȣ] [�̸�] [����] [����] [����] [����] [����] [���] [��ũ]						
		Node3[] result = null;
		result = new Node3[student.length];
		int index = 0;
		for(int i = 0; i < student.length; i++) {
			result[i] = new Node3();
			result[i].number = Integer.parseInt(student[i][2]);
			result[i].name = student[i][0];
			result[i].address = student[i][1];
		}
		int max = 0;
		for(int i = 0; i < score.length; i++) {
			for(int j = 0; j < 3; j++) {
				result[i].scoreList[j] = Integer.parseInt(score[i][j+1]);
				result[i].total += Integer.parseInt(score[i][j+1]);
			}
			result[i].avg = result[i].total/3;
		}
		for(int i = 0; i < score.length; i++) {
			for(int j = 0; j < score.length; j++) {
				if(i != j && result[i].avg < result[j].avg) {
					result[i].rank += 1;
				}
			}
			result[i].rank += 1;
		}
		return result;
	}
}
public class I1_Ŭ�����迭1_�򰡹���_����3 {
	public static void main(String[] args) {
		
		String [][] student = {
				{"�̸���","����","1001"}, 
				{"��ö��","����","1002"},
				{"����ȣ","��ġ","1003"} , 
				{"���缮","����","1004"}};
		String[][] score = {
				{"1001","100","20","30"},
				{"1002","10" ,"60","60"},
				{"1003","23" ,"63","31"},
				{"1004","45" ,"30","35"},
		};
		
		Return3 re = new Return3();
		Node3[] list = re.getList(student, score);
		for(int i = 0; i < student.length; i++) {
			list[i].print();
		}
		
	}
}