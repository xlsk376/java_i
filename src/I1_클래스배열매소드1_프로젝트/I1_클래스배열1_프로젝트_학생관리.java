package I1_클래스배열매소드1_프로젝트;

import java.util.Arrays;

class Student{
	int number;
	String name;
	String address;
	int score[] = new int[3];
	int total;
	double avg;
	int rank;
	void print() {
		System.out.print(number + " " + name + " " + address + " ");
		System.out.print(score[0] + " " + score[1]+ " " + score[2]+ " ");
		System.out.println(total + " " + avg + " " + rank);
	}
	
}
class StudentDAO{
	Student[] getList(String[][] student, String[][] score) {
		//문제1) 전체 회원리스트를 만들어서 리턴
		Student[] result = null;
		result = new Student[student.length-1];
		for(int i = 0; i < student.length-1; i++) {
			result[i] = new Student();
			result[i].number = Integer.parseInt(student[i+1][2]);
			result[i].name = student[i+1][0];
			result[i].address = student[i+1][1];
			int index = 0;
			for(int j = 0; j < score.length-1; j++) {
				int temp = Integer.parseInt(score[j+1][0]);
				if(result[i].number == temp) {
					result[i].total += Integer.parseInt(score[j+1][2]);
					result[i].score[index] = Integer.parseInt(score[j+1][2]);
					index += 1;
				}
			}
			result[i].avg = result[i].total/3;
		}
		for(int i = 0; i < result.length; i++) {
			for(int j = 0; j < result.length; j++) {
				if(i != j && result[i].avg < result[j].avg) {
					result[i].rank += 1;
				}
			}
			result[i].rank += 1;
		}
		return result;
	}
	Student[] getRank1List(String[][] student, String[][] score) {
		//문제2) 각과목별 1등의 데이터만 클래스 배열로 만들어서 리턴
		Student temp[] = null;
		temp = new Student[student.length-1];
		for(int i = 0; i < student.length-1; i++) {
			temp[i] = new Student();
			temp[i].number = Integer.parseInt(student[i+1][2]);
			temp[i].name = student[i+1][0];
			temp[i].address = student[i+1][1];
			int index = 0;
			for(int j = 0; j < score.length-1; j++) {
				int temp1 = Integer.parseInt(score[j+1][0]);
				if(temp[i].number == temp1) {
					temp[i].total += Integer.parseInt(score[j+1][2]);
					temp[i].score[index] = Integer.parseInt(score[j+1][2]);
					index += 1;
				}
			}
			temp[i].avg = temp[i].total/3;
		}
		for(int i = 0; i < temp.length; i++) {
			for(int j = 0; j < temp.length; j++) {
				if(i != j && temp[i].avg < temp[j].avg) {
					temp[i].rank += 1;
				}
			}
			temp[i].rank += 1;
		}
		int max[] = new int[3];
		int index[] = new int[3];
		for(int i = 0; i < temp.length; i++) {
			if(max[0] < temp[i].score[0]) {
				max[0] = temp[i].score[0];
				index[0] = i;
			}
			if(max[1] < temp[i].score[1]) {
				max[1] = temp[i].score[1];
				index[1] = i;
			}
			if(max[1] < temp[i].score[2]) {
				max[2] = temp[i].score[2];
				index[2] = i;
			}
		}
		Student[] result = null;
		result = new Student[3];
		for(int i = 0; i < result.length; i++) {
			result[i] = new Student();
			result[i].number = temp[index[i]].number;
			result[i].name = temp[index[i]].name;
			result[i].address = temp[index[i]].address;
			int index1 = 0;
			for(int j = 0; j < score.length-1; j++) {
				int temp1 = Integer.parseInt(score[j+1][0]);
				if(result[i].number == temp1) {
					result[i].total += Integer.parseInt(score[j+1][2]);
					result[i].score[index1] = Integer.parseInt(score[j+1][2]);
					index1 += 1;
				}
			}
			result[i].avg = result[i].total/3;
			result[i].rank = temp[index[i]].rank;
		}
		
		return result;
	}
	
}
public class I1_클래스배열1_프로젝트_학생관리 {
	public static void main(String[] args) {
		StudentDAO re = new StudentDAO();
		String [][] student = {
				{"이름","지역","번호"}, 
				{"김철만","신촌","1001"}, 
				{"오상덕","강남","1002"},
				{"민철이","대치","1003"} ,
				{"유재석","강동","1004"}};
		String[][] score = {
				{"번호","과목","점수"},
				{"1001" ,"국어","20"},
				{"1002" ,"국어","50"},
				{"1003" ,"국어","60"},
				{"1004" ,"국어","17"},
				{"1001" ,"수학","65"},
				{"1002" ,"수학","15"},
				{"1003" ,"수학","80"},
				{"1004" ,"수학","70"},
				{"1001" ,"영어","43"},
				{"1002" ,"영어","90"},
				{"1003" ,"영어","30"},
				{"1004" ,"영어","70"}
		};
		Student[] nodeList = re.getList(student, score);	
		for(int i = 0; i < student.length-1; i++) {
			nodeList[i].print();
		}
		System.out.println();
		Student[] scoreList = re.getRank1List(student, score);
		for(int i = 0; i < 3; i++) {
			scoreList[i].print();
		}
	}
}