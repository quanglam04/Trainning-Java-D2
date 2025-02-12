package BT_12;

public class Student implements Comparable<Student> {
	private String name;
	private int score;
	public Student(String name,int score) {
		this.name = name;
		this.score = score;
	}
	
	@Override
	public int compareTo(Student others) {
		return this.name.compareTo(others.name);
	}
	
	@Override
	public String toString() {
		return name;
	}
	
	public int getScore() {
		return score;
	}
	public String getName() {
		return name;
	}
}


