package org.example;
import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.DumperOptions;
import org.yaml.snakeyaml.DumperOptions.FlowStyle;
import org.yaml.snakeyaml.representer.Representer;
import org.yaml.snakeyaml.TypeDescription;
import org.yaml.snakeyaml.nodes.Tag;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
public class YamlSerialization
{
    public static void serializeStudentDataToYaml(StudentsData students, String filePath) throws IOException {

        DumperOptions dumperOptions = new DumperOptions();
        dumperOptions.setDefaultFlowStyle(FlowStyle.BLOCK);
        Representer representer = new Representer(dumperOptions);
        TypeDescription typeDescription = new TypeDescription(Student.class);
        representer.addClassTag(Student.class, Tag.MAP);
        Yaml yaml = new Yaml(representer);
        try (FileWriter writer = new FileWriter(filePath)) {
            yaml.dump(students, writer);
        }
    }
    public static void serializeStudentArrayToYaml(List<Student> students, String filePath)throws IOException
    {
        try (FileWriter writer = new FileWriter(filePath))
        {
            for (Student student : students) {
                DumperOptions dumperOptions = new DumperOptions();
                dumperOptions.setDefaultFlowStyle(FlowStyle.BLOCK);
                Representer representer = new Representer(dumperOptions);

                TypeDescription typeDescription = new TypeDescription(Student.class);
                representer.addClassTag(Student.class, Tag.MAP);
                Yaml yaml = new Yaml(representer);
                yaml.dump(student, writer);

            }
        }
    }
    public static void serializeStudentToYaml(Student student, String filePath) throws IOException {

        DumperOptions dumperOptions = new DumperOptions();
        dumperOptions.setDefaultFlowStyle(FlowStyle.BLOCK);
        Representer representer = new Representer(dumperOptions);
        TypeDescription typeDescription = new TypeDescription(Student.class);
        if(student.getDiscount())
        {
            typeDescription.setExcludes("payment");
            representer.addTypeDescription(typeDescription);
        }
        representer.addClassTag(Student.class, Tag.MAP);
        Yaml yaml = new Yaml(representer);
        try (FileWriter writer = new FileWriter(filePath)) {
            yaml.dump(student, writer);
        }
    }
    public static Student deserializeStudentFromYaml(String filePath) throws IOException {
        Yaml yaml =  new Yaml();
        try (FileReader reader = new FileReader(filePath))
        {
            return yaml.loadAs(reader,Student.class);
        }
    }
}