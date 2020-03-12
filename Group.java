package com.gmail.docfordja;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Scanner;
import com.gmail.docfordja.exception.IllegalNameException;
import com.gmail.docfordja.exception.MyException;

public class Group implements Serializable  {
	private Student[] group = new Student[10];
	private String nameOfGroup;

	public Group() {
	}

	public Group(String nameOfGroup) {
		this.nameOfGroup = nameOfGroup;
	}

	public Student[] getGroup() {
		return group;
	}

	public void setGroup(Student[] group) {
		this.group = group;
	}

	public String getNameOfGroup() {
		return nameOfGroup;
	}

	public void setNameOfGroup(String nameOfGroup) {
		this.nameOfGroup = nameOfGroup;
	}

	// Добавление студента
	public void addStudent(Student student) throws MyException {
		for (int i = 0; i < group.length + 1; i++) {
			if (group[i] == student && student != null) {
				System.out.println("This student is in group list");
				return;
			}
			if (group[i] == null && student != null) {
				group[i] = student;
				return;
			}
			if (student == null) {
				return;
			}

		}
		throw new MyException();
	}

	// Удаление студента с группы
	public void deleteStudent(Student student) {
		for (int i = 0; i < group.length; i++) {
			if (group[i] == student) {
				group[i] = null;
				return;
			}
		}
		System.out.println("This student is not in the group");
	}

	// переопределение ToString согласно условию задачи
	@Override
	public String toString() {
		String[] temp = bubbleSort();

		return Arrays.toString(temp);

	}

	public Student[] getSt(Group group) {
		Student[] st = group.getGroup();
		return st;
	}

	// меняет фамилии местами
	public void exchange(String[] string, int i, int j) {
		String now = "";
		now = string[j];
		string[j] = string[i];
		string[i] = now;

	}

	// создание массива с фамилиями студентов и его сортировка

	public String[] bubbleSort() {
		String[] sort = new String[group.length];
		for (int i = 0; i < sort.length; i++) {
			if (group[i] != null) {
				sort[i] = group[i].getLastName() + " " + group[i].getName();
			}
		}
		try {
			for (int i = 0; i < sort.length; i++) {
				for (int j = 1 + i; j < sort.length; j++) {
					if (sort[i] == null && sort[j] != null) {
						exchange(sort, i, j);
						continue;
					}
					if (sort[i] != null && sort[j] == null) {
						continue;
					}
					if (sort[i] == null && sort[j] == null) {
						continue;
					}
					if (sort[i].toUpperCase().compareTo(sort[j].toUpperCase()) > 0) {
						exchange(sort, i, j);
					}
				}

			}
		} catch (NullPointerException e) {
			System.out.println("!");
		}
		return sort;

	}

	// Поиск студента
	public Student someStudent(String name) throws NullPointerException {
		Student student = new Student();
		for (int i = 0; i < group.length; i++) {
			if (group[i] != null) {
				if (name.equalsIgnoreCase(group[i].getLastName())) {
					student = group[i];
					return student;
				}
			}
		}
		return null;
	}

	// Чек на корректность ввода
	public boolean check(String string) throws IllegalNameException {
		boolean check = false;
		for (int i = 0; i < string.length(); i++) {
			if ((int) string.toLowerCase().charAt(i) < (int) 97 && (int) string.toLowerCase().charAt(i) < 122) {
				System.out.println("Incorrected name");
				throw new IllegalNameException();
			}
		}
		check = true;
		return check;

	}

	// Чек на корректность ввода
	public boolean check(int in) throws IllegalArgumentException {
		boolean check = false;

		if (in > 99 || in < 14) {
			System.out.println("Incorrected age");
			throw new IllegalArgumentException();
		}
		check = true;

		return check;
	}

	// Интерактивное добавление студентов
	public void interAdd(Group group) throws IllegalArgumentException {
		String test = "";
		int ageTest = 0;
		Student student = new Student();
		Scanner scanner = new Scanner(System.in);
		System.out.println("Input student name");
		test = scanner.nextLine();
		try {
			if (check(test))
				student.setName(test);
		} catch (IllegalNameException e) {
			e.printStackTrace();
		}
		System.out.println("Input student last name");
		test = scanner.nextLine();
		try {
			if (check(test)) {
				student.setLastName(test);
			}
		} catch (IllegalNameException e) {
			e.printStackTrace();
		}
		System.out.println("Input student age");
		ageTest = scanner.nextInt();
		if (check(ageTest)) {
			student.setAge(ageTest);
		} else {
			System.out.println("Incorrect age");
			throw new IllegalArgumentException();
		}
		for (boolean i; i = true;) {
			test = scanner.nextLine();
			if (test.toLowerCase().equals("man")) {
				student.setSex(true);
				break;
			} else if (test.toLowerCase().equals("woman")) {
				student.setSex(false);
				break;
			} else {
				System.out.println("Input student sex ( man or woman )");
			}
		}
		System.out.println("Input student grade book number");
		student.setGradeBook(scanner.nextInt());
		for (;;) {
			System.out.println("Input student year of study ");
			ageTest = scanner.nextInt();
			if (ageTest > 0 && ageTest < 7) {
				student.setYearOfStudy(ageTest);
				break;
			} else {
				System.out.println("Incorrect value");
			}
		}
		for (;;) {
			System.out.println("Input value student level (0 - 100)");
			ageTest = scanner.nextInt();
			if (ageTest > 0 && ageTest < 101) {
				student.setLevel(ageTest);
				break;
			} else {
				System.out.println("Incorrect value");
			}
		}
		try {
			group.addStudent(student);
		} catch (MyException e) {
			e.printStackTrace();
		}
	}

	/*Создает папку, сохраняет в файлах содержимое Group*/
	public void saveGroup(Group group) throws IOException {
		File saver = new File("C:\\Users\\anton\\Desktop\\pacage\\" + nameOfGroup);
		saver.mkdirs();
		Student[] studentList = group.getGroup();
		for (int i = 0; i < studentList.length; i++) {
			if (studentList[i] != null) {
				File save = new File("C:\\Users\\anton\\Desktop\\pacage\\" + nameOfGroup + "\\" + i + ".bin");
				save.createNewFile();

				FileWriter fw = new FileWriter(save);
				PrintWriter pw = new PrintWriter(fw);
				if (group.getSt(group)[i] != null) {
					pw.print(group.getSt(group)[i].toString());
					pw.close();
				}
			} else {
				File save = new File("C:\\Users\\anton\\Desktop\\pacage\\" + nameOfGroup + "\\" + i + ".bin");
				FileWriter fw = new FileWriter(save);
				PrintWriter pw = new PrintWriter(fw);
				pw.print(1);
				pw.close();
			}

		}

	}
    // Создает новый обьект Group, заполняет его считываемыми с файлов значениями
	public Group downloadGroup(String nameOfGroup) throws IOException, ClassNotFoundException, MyException {
		Group group = new Group();

		for (int i = 0; i < 10; i++) {
			File save = new File("C:\\Users\\anton\\Desktop\\pacage\\" + nameOfGroup + "\\" + i + ".bin");
			Scanner scanner = new Scanner(save);
			String result = scanner.nextLine();
			if (result.equals("1")) {
				continue;
			}
			Student student = new Student();
			student.setLastName(readValue(result, "lastName"));
			student.setName(readValue(result, "name"));
			student.setAge(value(readValue(result, "age")));
			student.setGradeBook(value(readValue(result, "gradeBook")));
			student.setYearOfStudy(value(readValue(result, "yearOfStudy")));
			student.setLevel(value(readValue(result, "level")));
			student.setSex(ifValue(readValue(result, "sex")));
			group.addStudent(student);
			scanner.close();
		}

		return group;
	}

	// Отделяет значения
	public String readValue(String result, String value) {
		int index = result.indexOf(value) + value.length() + 1;
		int endIndex = result.indexOf(",", index);
		String rededValue = result.substring(index, endIndex);
		//System.out.println(rededValue);
		return rededValue;
	}

	// Преобразует строковые значения в int
	public int value(String readValue) {
		int value = Integer.parseInt(readValue);
		return value;
	}
    // преобразует строковое значение в логическое
	public boolean ifValue(String readValue) {
		if (readValue.equals("true"))
			return true;
		return false;
	}
	
	public void save () {
		File file = new File(nameOfGroup +".txt");
		try {
			file.createNewFile();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		
		try(ObjectOutputStream objectOS = new ObjectOutputStream(new FileOutputStream("w.txt"))){
			objectOS.writeObject(group);
			objectOS.close();
			System.out.println("Done! You can download this group if you will input <<" + nameOfGroup + ">>");
		}catch (Exception e) {
			System.out.println("Error save. Try again");
		}
	}
	public Group download () {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Input some name of group");
		String name = scanner.nextLine();
		File file = new File(name +".txt");
		try (ObjectInputStream objectIS = new ObjectInputStream(new FileInputStream("w.txt"))){
			return (Group) objectIS.readObject();
		}catch (Exception e) {
			System.out.println("There not is this group" + file.getAbsolutePath());
		}
		
		return null;
		
	} 

}
