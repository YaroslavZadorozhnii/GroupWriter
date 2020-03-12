package com.gmail.docfordja;

import java.io.*;

public class SaveGroup  {
    public void saveGroup(Group group){
        try (ObjectOutputStream OOS = new ObjectOutputStream(new FileOutputStream("groupFIle.txt"))) {
            OOS.writeObject(group);
            OOS.close();
            System.out.println("File has been written");
        } catch (IOException e) {
            System. out .println("File has not been written");
        }
    }

    public Group readGroup(){
        try (ObjectInputStream OIS=new ObjectInputStream(new FileInputStream("groupFIle.txt"))){
            return (Group)OIS.readObject();
        } catch(IOException |ClassNotFoundException e){
            System. out .println("ERROR load group !!!");
            return null;
        }
    }


}