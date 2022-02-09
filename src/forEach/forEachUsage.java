package forEach;

import streamApi.Product;

import java.util.ArrayList;
import java.util.List;

public class forEachUsage {
    public static void main(String[] args) {
        //forEach() method can use with collection that implements Iterable interface
        List<Student> students  = new ArrayList<Student>();
        students.add(new Student(1,"Enes"));
        students.add(new Student(2,"Emir"));
        students.add(new Student(3,"İrem"));
        students.add(new Student(4,"Ecem"));

        students.forEach(student -> {
            System.out.println("Student name: "+student.getName() + "\nId: "+ student.getId()+"\n\n");
        });
    }
}
