package org.example;
import java.io.*;
public class NativeSerialization {
    public static void serializeStudent(Student student, String filePath) throws IOException {
        if (student.getRoom() <= 100) {
            try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePath))) {
                oos.writeObject(student);
            }
        }
    }
    public static Student deserializeStudent(String filePath) throws IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filePath))) {
            return (Student) ois.readObject();
        }
    }
}