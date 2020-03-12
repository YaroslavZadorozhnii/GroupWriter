package com.gmail.docfordja;

import java.util.Arrays;
// ќ“бирает пригодных к службе студентов, сортирует
public class Comissariat implements WarComissariat {

	@Override
	public Student[] comone(Group group) {
		Student[] students = group.getGroup();
		int num = students.length;
		for (int i = 0; i < students.length; i++) {
			if (students[i] != null) {
				students[i].setLastName(students[i].getLastName().toLowerCase());
			    students[i].setName(students[i].getName().toLowerCase());
				if (students[i].isSex() != true || students[i].getAge() < 17 || students[i].getAge() > 28)
					num -= 1;
			}
		}
		Student[] goToArmy = new Student[num];
		for (int i = 0; i < students.length; i++) {
			if (students[i] != null) {
				if (students[i].isSex() == true && students[i].getAge() > 17 && students[i].getAge() < 28)
					goToArmy[num-1] = students[i];
				num -= 1;
			}
		}
		Arrays.sort(goToArmy, new NameComparator());

		return goToArmy;
	}

}
