package com.gmail.docfordja;

import java.util.Comparator;

public class NameComparator implements Comparator {

	@Override
	public int compare(Object st1, Object st2) {

		if (st1 != null && st2 == null) {
			return 1;
		}
		if (st1 == null && st2 != null) {
			return -1;
		}
		if (st1 == null && st2 == null) {
			return 0;
		}
		Student stud1 = (Student) st1;
		Student stud2 = (Student) st2;
		if (stud1.getLastName().compareTo(stud2.getLastName()) > 0) {
			return 1;
		}
		if (stud1.getLastName().compareTo(stud2.getLastName()) < 0) {
			return -1;
		}
		return 0;

	}
}

