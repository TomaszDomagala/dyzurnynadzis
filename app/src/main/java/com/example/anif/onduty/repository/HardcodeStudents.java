package com.example.anif.onduty.repository;

import android.widget.ArrayAdapter;

import com.example.anif.onduty.models.Student;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tomek on 12.10.2017.
 */

public class HardcodeStudents {
    public static List<Student> getStudents(){
        ArrayList<Student> students = new ArrayList<>();
        students.add(new Student("Jakub", "Bębacz", 1,2));
        students.add(new Student("Karol", "Brożyna", 2,3));
        students.add(new Student("Przemysław", "Cedro", 3,1));
        students.add(new Student("Mateusz", "Chodurski", 4,2));
        students.add(new Student("Roksana", "Cieśla", 5,3));
        students.add(new Student("Tomasz", "Domagała", 6,1));
        students.add(new Student("Izabela", "Działak", 7,1));
        students.add(new Student("Weronika", "Dziwirek", 8,1));
        students.add(new Student("Marcin", "Grzegorzewski", 9,1));
        students.add(new Student("Radosław", "Grzesik", 10,2));
        students.add(new Student("Karolina", "Homa", 11,3));
        students.add(new Student("Adam", "Kaleta", 12,3));
        students.add(new Student("Bartłomiej", "Kopyść", 13,3));
        students.add(new Student("Jakub", "Kozieł", 14,1));
        students.add(new Student("Mateusz", "Krzysiek", 15,3));
        students.add(new Student("Jan", "Kuc", 16,2));
        students.add(new Student("Jessica", "Łukawska", 17,2));
        students.add(new Student("Sylwia", "Malarczyk", 18,3));
        students.add(new Student("Aleksandra", "Mazur", 19,3));
        students.add(new Student("Izabela", "Mojecka", 20,3));
        students.add(new Student("Kinga", "Nowakowska", 21,1));
        students.add(new Student("Agnieszka", "Pajdała", 22,1));
        students.add(new Student("Kamil", "Petrus", 23,2));
        students.add(new Student("Karol", "Polit", 24,2));
        students.add(new Student("Bartłomiej", "Rasztabiga", 25,1));
        students.add(new Student("Jędrzej", "Sarna", 26,2));
        students.add(new Student("Miłosz", "Słoń", 27,1));
        students.add(new Student("Mateusz", "Sobierajski", 28,-418));
        students.add(new Student("Mikołaj", "Stefański", 29,2));
        students.add(new Student("Dawid", "Wąsala", 30,1));
        students.add(new Student("Wiktor", "Wdowin", 31,2));
        students.add(new Student("Barbara", "Winkler", 32,1));
        students.add(new Student("Karol", "Wyrębkiewicz", 33,2));
        return students;
    }
}
