package BT_12;

import java.util.Comparator;

public class ScoreComparator implements Comparator<Student> {

	@Override
	public int compare(Student o1, Student o2) {
		return Integer.compare(o1.getScore(), o2.getScore());
	}
	
}

