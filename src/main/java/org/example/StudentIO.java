package org.example;
import java.io.*;
public class StudentIO
{
    public static void writeRoomToFile(Student student, String filePath) throws IOException {
        try (FileOutputStream fos = new FileOutputStream(filePath)) {
            fos.write(student.getRoom());
        }
    }
    public static void writePaymentToFile(Student student, String filePath) throws IOException {
        try (BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(filePath))) {
            bos.write(Double.toString(student.getPayment()).getBytes());
        }
    }
    public static int readRoomFromFile(String filePath) throws IOException {
        try (FileInputStream fis = new FileInputStream(filePath)) {
            return fis.read();
        }
    }
    public static double readPaymentFromFile(String filePath) throws IOException {
        try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(filePath))) {
            return Double.parseDouble(new String(bis.readAllBytes()));
        }
    }
    public static void writeStudentToFile(Student student, String filePath)
    {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePath))) {
            oos.writeObject(student);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static Student readStudentFromFile(String filePath) throws IOException, ClassNotFoundException
    {

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filePath)))
        {
            Student student = (Student) ois.readObject();
            return student;
        }
    }
}