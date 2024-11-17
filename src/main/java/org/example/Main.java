package org.example;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        Student student = new Student("Ivan", 101, 1000.5, new Address("Kyiv", "Shevchenko St"),false);
        Student student2 = new Student("Andriy", 80, 1000.5, new Address("Kyiv", "Shevchenko St"),false);
        Student student3 = new Student("Artem", 90, 2345.5, new Address("Kyiv", "Shevchenko St"),true);
        Student student4 = new Student("Oleh", 70, 1200.5, new Address("Lviv", "Shevchenko St"),true);
        Student student5 = new Student("Sophia", 60, 1500.5, new Address("Odessa", "Shevchenko St"),true);

        List<Student> studentsList = new ArrayList<Student>();

        studentsList.add(student);
        studentsList.add(student2);
        studentsList.add(student3);
        studentsList.add(student4);
        studentsList.add(student5);

        StudentsData studentsData = new StudentsData();

        studentsData.AddStudent(student);
        studentsData.AddStudent(student2);
        studentsData.AddStudent(student3);
        studentsData.AddStudent(student4);
        studentsData.AddStudent(student5);

        StudentIO.writeRoomToFile(student, "room.txt");
        StudentIO.writePaymentToFile(student, "payment.txt");
        System.out.println("Room from file: " + StudentIO.readRoomFromFile("room.txt"));
        System.out.println("Payment from file: " + StudentIO.readPaymentFromFile("payment.txt"));

        StudentIO.writeStudentToFile(student,"studentData.txt");
        System.out.println("Read all data from file: " + StudentIO.readStudentFromFile("studentData.txt"));

        NativeSerialization.serializeStudent(student2, "student.ser");
        Student deserializedStudent = NativeSerialization.deserializeStudent("student.ser");
        System.out.println("Deserialized Java object: " + deserializedStudent);

        JsonSerialization.serializeStudentToJson(student2, "student.json");
        Student jsonDeserializedStudent = JsonSerialization.deserializeStudentFromJson("student.json");
        System.out.println("Deserialized JSON object: " + jsonDeserializedStudent);

        YamlSerialization.serializeStudentToYaml(student2, "student.yaml");
        Student yamlDeserializedStudent = YamlSerialization.deserializeStudentFromYaml("student.yaml");
        //YamlSerialization.deserializeStudentFromYaml("student.yaml");

        YamlSerialization.serializeStudentArrayToYaml(studentsList,"yamlStudentList.yaml");
        YamlSerialization.serializeStudentDataToYaml(studentsData,"yamlStudentData.yaml");

        System.out.println("Deserialized YAML object: " + yamlDeserializedStudent);
    }
}