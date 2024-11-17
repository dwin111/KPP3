package org.example;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
public class JsonSerialization
{
    private static int skippedRoom;
    public static void serializeStudentToJson(Student student, String filePath) throws IOException
    {
        skippedRoom = student.getRoom();
        System.out.println("Try to serializate to JSON" + student.toString());

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        try (FileWriter writer = new FileWriter(filePath)) {
            gson.toJson(student, writer);
        }
    }
    public static Student deserializeStudentFromJson(String filePath) throws IOException {
        Gson gson = new Gson();
        try (FileReader reader = new FileReader(filePath))
        {
            Student student2 = gson.fromJson(reader, Student.class);
            if(student2.getRoom()<=0)
                student2.setRoom(skippedRoom);
            System.out.println("Try to deserializate from JSON" + student2.toString());
            return student2;
        }
    }
}