package BT_12;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
	public static void main(String[] args) {
		List<Student> students = new ArrayList<Student>();
		students.add(new Student("Trinh Quang Lam",9));
		students.add(new Student("Nguyen Hoang Hiep",10));
		Collections.sort(students,new NameComparator());
		System.out.println("Sắp xếp theo tên");
		for(Student student : students)
			System.out.println(student.toString());
		Collections.sort(students,new ScoreComparator());
		System.out.println("\n\nSắp xếp theo điểm");
		for(Student student : students)
			System.out.println(student.toString());
		
	}
}


