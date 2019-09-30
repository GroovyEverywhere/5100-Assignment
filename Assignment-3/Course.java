package Assignment3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Course {
	private int courseId;
	private String courseName;
	private int maxCapacity;
	private int professorId;
	private int credits;
	private int [] studentIds = new int [99];
	private int count = 0;
	
	public static void main(String []args) {
		Course c = new Course(123);
		c.registerStudent(1);
		c.registerStudent(2);
		c.registerStudent(3);
		c.registerStudent(4);
		c.registerStudent(5);
		c.registerStudent(6);
		c.registerStudent(6);
		//System.out.println(Arrays.toString(c.studentIds));
		c.removeDuplicates(c.studentIds);
		System.out.println(Arrays.toString(c.studentIds));
		c.groupsOfStudents(c.studentIds);
		System.out.println(c.groupsOfStudents(c.studentIds));
		int n =7;
		System.out.println(countAndSay(n));
		String sentence = "the sky is blue";
		System.out.println(reverseWords(sentence));
		int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
		System.out.println(spiralOrder(matrix));
		String s = "PAYPALISHIRING";
		int numsOfRows = 3;
		System.out.println(zigZagCoversion(s,numsOfRows));
		
    } 
	
	
	public void registerStudent(int studentId) {		
			studentIds [count] = studentId;
			count++;
	}
	public  void removeDuplicates(int [] studentIds) {		
		ArrayList<Integer> list = new ArrayList<Integer>();
		for(int i = 0; i < studentIds.length; i++) {
			if(studentIds[i] != 0 && !list.contains(studentIds[i]))
			list.add(studentIds[i]);
		}
		//System.out.println(list);
		this.studentIds = list.stream().mapToInt(Integer::intValue).toArray();
		//System.out.println(Arrays.toString(studentIds));
    	}
    	
	public int groupsOfStudents(int[] studentIds) { 	
		int count = 0;
		for(int i = 0; i < studentIds.length; i++) {
			for(int j = i +1; j < studentIds.length; j++) {
				if( (studentIds [i] + studentIds[j]) % 2 == 0 && studentIds[j] != 0 && studentIds [i] != 0) {
					count++;
				}
			}
		}
		return count;
	}
    	
	
	Course(int courseId){
		this.courseId = courseId;
		if(courseId <= 0 ) {
			throw new IllegalArgumentException();		
			}
	}
	Course(int courseId, int professorId){
		
	}
	Course(int courseId, int professorId, int credits){
		
	}
	
	public int getCourseId(){
		return courseId;
	}
	
	public void setCourseId(int courseId){
		this.courseId = courseId;
	}
	
	public String getCourseName(){
		return courseName;
	}
	
	public void setCourseName(String courseName){
		if(courseName.length() < 10 ||courseName.length() > 60 ) {
			throw new IllegalArgumentException();
		}
		this.courseName = courseName;
	}
	
	public int getMaxCapacity(){
		return maxCapacity;
	}
	
	public void setMaxCapacity(int maxCapacity){
		if(maxCapacity < 10 || maxCapacity > 100) {
			throw new IllegalArgumentException();
		}
		this.maxCapacity = maxCapacity;
	}
	
	public int getProfessorId(){
		return professorId;
	}
	
	public void setProfessorId(int professorId){
		if(professorId == 000000 || professorId > 999999 && professorId < 100000) {
			throw new IllegalArgumentException();
		}
		this.professorId = professorId;
	}
	
	public int getCredits(){
		return credits;
	}
	
	public void setCredits(int credits){
		if(credits < 0 || credits > 10) {
			throw new IllegalArgumentException();
		}
		this.credits = credits;
	}
	
	public int [] getStudentIds() {
		return studentIds;
	}
	
	public void setStudentIds(int [] studentIds) {
		this.studentIds = studentIds;
	}
	
	
	
	public static String countAndSay(int n) {
		 if(n == 1){
	            return "1";
	        }
	        String str = countAndSay(n-1) + "*";
	        char[] c = str.toCharArray();
	        int count = 1;
	        String s = "";
	        for(int i = 0; i < c.length - 1;i++){
	        	if(c[i] == c[i+1]){
	        		count++;
	        	}else{
	        		s = s + count + c[i];
	        		count = 1;
	        	}
	        }
	        return s;
	}
	
	public static String reverseWords(String sentence) {
		String [] str = sentence.split(" ");
		String [] s = new String[str.length];
		int count = 0;
		for(int i = str.length - 1; i >=0;) {
			s [count] = str[i];
			--i;
			count++;
		}
		String string = String.join(" ", s);
		return string;
	}
	
	
	public static ArrayList<Integer> spiralOrder(int[][] matrix) {
		int row = matrix.length;
		int column = matrix[0].length;
		int T = 0;
		int B = row -1;
		int L = 0;
		int R = column -1;
		int dir = 0;
		ArrayList <Integer> result = new ArrayList<Integer>(); 
		while(T <=B && L <= R) {
			if(dir == 0) {
				for(int i = L; i <= R; i++){
					result.add(matrix[T][i]);
				}
				T++;
				dir = 1;
			}
			else if(dir == 1) {
				for(int i = T; i <= B; i++) {
					result.add(matrix[i][R]);
				}
				R--;
				dir = 2;
			}
			else if(dir == 2) {
				for(int i = R; i >= L; i--) {
					result.add(matrix[B][i]);
				}
				B--;
				dir = 3;
			}
			else if(dir == 3) {
				for(int i = B; i >= T; i--) {
					result.add(matrix[i][L]);
				}
				L++;
				dir = 0;
			}
		}
		return result;
	}
	
	public static String zigZagCoversion(String s, int numsOfRows) {
		int length = s.length();
		if(numsOfRows > length || numsOfRows <= 1) {
			return s;
		}
		char [] result = new char [length];
		int count = 0;
		int interval = 2 * numsOfRows - 2;
		for(int i = 0; i < numsOfRows; i++) {
			int step = interval - 2 * i;
			for(int j = i; j < length; j = j + interval) {
				result[count] = s.charAt(j);
				count++;
				if(step > 0 && step < interval && j + step < length) {
					result[count] = s.charAt(j + step);
					count++;
				}
			}
		}
		return new String(result);
	}
	
	
//	Explain Encapsulation with an example. (Write at least 30-40 words).
	
//	Aws: From my point of view, encapsulation is an approach to store data into a unit or private class and prevent it to be called from other classes.
//		 It is like a protective shield that prevent the data you put in form of encapsulation to be accessed outside the shield.
//		 An example I can think of is that the access card or access code of enter a system or building in security area. As a user, you only have the right
//		 to make yourself reach the server or system but you cannot change other users' rights or classifications.
	
		 
//	What is the difference between Encapsulation and Abstraction.
	
//	Aws: Encapsulation hides variables or implementations in a class to prevent outsiders to access it, so users have to access it by other getter/setter 
//	  	 methods. While abstraction also hide stuff but in a higher level e.g. class, interface, etc. Users use it by just need to know what it can 
//	  	 do, thus, what inside in does not really matters to users.
}
