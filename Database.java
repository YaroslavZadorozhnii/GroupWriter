package com.gmail.docfordja;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Database {
	private File file;
	private String name;


	public Database(String name) {
		this.name = name;
		this.file = new File(getName());
		this.file.mkdir();
	}

	public String getName() {
		return name;
	}

	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}

	public void setName(String name) {
		this.name = name;
	}
    
	// Пишет группу в файл
	public void add(Group group, int num) throws IllegalAccessException {


		for (File i : file.listFiles()) {
			String nam = "";
			char[] time = i.getName().toCharArray();
			for (char ch : time) {
				if (ch == '.') {
					break;
				}
				nam += ch;
			}

			if (Integer.parseInt(nam) == num) {
				System.out.println(Integer.parseInt(nam) + num);
				System.out.println("Make up some other number. This number is here");
				throw new IllegalAccessException();
			}
		}

		File file = new File(this.file, num  + ".txt");
		try {
			file.createNewFile();
		} catch (IOException e) {
			System.out.println("Bad luck");
			e.printStackTrace();
		}
		try (ObjectOutputStream objectOS = new ObjectOutputStream(new FileOutputStream(file))) {
			objectOS.writeObject(group);
			objectOS.close();
		} catch (Exception e) {
			System.out.println("Error save. Try again");
		}

	}
    
	
	// Записывает группы из файла 
	public Group download(int num) throws NullPointerException, FileNotFoundException {

		for (File j : file.listFiles()) {
			String nam = "";
			char[] time = j.getName().toCharArray();
			for (char ch : time) {
				if (ch == '.') {
					break;
				}
				nam += ch;

			}
			if (Integer.parseInt(nam) == num) {

				Group group = new Group();
				File file = new File(this.file, num + ".txt");
				try (ObjectInputStream objectIS = new ObjectInputStream(new FileInputStream(file))) {
					group = (Group) objectIS.readObject();
				} catch (Exception e) {
					System.out.println("There not is this group" + file.getAbsolutePath());
				}
				nam = "";

				return group;

			}

		}
		System.out.println("This number of group is not in this database");
		throw new NullPointerException();

	}
	// Выводит в консоль содержимое мини-базы
	public void baseRead () {
		System.out.println("A content of this database");
		int max = 0;
		for(File fil : file.listFiles() ) {
			if(fil.getName().length() > max) {
				max = fil.getName().length();
			}
		}
		for(int i = 0 ; i < max + 6 ; i++) {
			System.out.print("*");
		}
		System.out.println();
		
		for(File fil : file.listFiles() ) {
			System.out.print("* >");
			System.out.print(fil.getName());
			System.out.println("  *");
		}
		for(int i = 0 ; i < max + 6 ; i++) {
			System.out.print("*");
	}

}
}
