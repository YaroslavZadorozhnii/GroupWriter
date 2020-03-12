package com.gmail.docfordja;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

import com.gmail.docfordja.exception.MyException;

public class Main {

	public static void main(String[] args) {
		Student a = new Student("Atrov", "Vas'ka", 21, true, 110, 1111, 99);
		Student b = new Student("Betrov", "Vas'ka", 22, true, 111, 1112, 98);
		Student c = new Student("Cetrov", "Vas'ka", 23, false, 112, 1113, 97);
		Student d = new Student("Detrov", "Vas'ka", 24, true, 113, 1114, 96);
		Student e = new Student("Etrov", "Vas'ka", 25, false, 114, 1115, 95);
		Student h = new Student("Hetrov", "Vas'ka", 26, true, 115, 1116, 94);
		Student z = new Student("Zetrov", "Vas'ka", 27, true, 116, 1117, 93);
		Student j = new Student("Jetrov", "Vas'ka", 28, false, 117, 1118, 92);
		Student k = new Student("Ketrov", "Vas'ka", 29, true, 118, 1119, 91);
		Student s = new Student("Setrov", "Vas'ka", 20, true, 119, 1110, 90);
		Student x = new Student("Xetrov", "Vas'ka", 21, true, 101, 1101, 89);

		Group studentGroup = new Group("best");
		Group stud1 = new Group("the best");
		Group stud2 = new Group("best of the best");

		try {
			// studentGroup.addStudent(x);
			studentGroup.addStudent(s);
			studentGroup.addStudent(j);
			studentGroup.addStudent(z);
			studentGroup.addStudent(h);
			studentGroup.addStudent(e);
			studentGroup.addStudent(d);
			studentGroup.addStudent(c);
			studentGroup.addStudent(k);
			studentGroup.addStudent(b);
			studentGroup.addStudent(a);
			
			stud1.addStudent(d);
			stud1.addStudent(c);
			stud1.addStudent(k);
			stud1.addStudent(b);
			stud1.addStudent(a);
			
			stud2.addStudent(s);
			stud2.addStudent(j);
			stud2.addStudent(z);
			stud2.addStudent(h);
			stud2.addStudent(e);
		} catch (MyException e1) {
			e1.printStackTrace();
		}
		try {
			studentGroup.saveGroup(studentGroup);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			Group group = new Group();
			group = group.downloadGroup(studentGroup.getNameOfGroup());
			System.out.println(group.toString());
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (MyException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		Database data = new Database("Owner of Student");
		try {
			data.add(studentGroup, 1);
			data.add(stud1, 2);
			data.add(stud2, 3);
			Group test = data.download(1);
			Group test1 = data.download(3);
			Group test2 = data.download(2);
			
			System.out.println(test.toString());
			System.out.println(test1.toString());
			System.out.println(test2.toString());
			
		} catch (FileNotFoundException e1) {
			System.out.println("FileNotFoundException Error");
			e1.printStackTrace();
		} catch (IllegalAccessException e2) {
			System.out.println("IllegalAccessException Error");
		}
		data.baseRead();


	}

}
