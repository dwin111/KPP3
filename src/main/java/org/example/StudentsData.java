package org.example;
import java.util.ArrayList;
import java.util.List;
public class StudentsData {
    public List<Student> studentList = null;
    public StudentsData()
    {
        studentList = new ArrayList<Student>();
    }
    public void AddStudent(Student student)
    {
        studentList.add(student);
    }
}
