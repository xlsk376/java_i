package I1_클래스배열매소드1_알고리즘;
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
		//문제1) 아래순서대로 전체 학생 출력  
		//     [학생번호] [이름] [지역] [국어] [수학] [영어] [총합] [평균] [랭크]						
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
public class I1_클래스배열1_평가문제_리턴3 {
	public static void main(String[] args) {
		
		String [][] student = {
				{"이만수","신촌","1001"}, 
				{"김철민","강남","1002"},
				{"심장호","대치","1003"} , 
				{"유재석","강동","1004"}};
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