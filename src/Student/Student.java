package Student;
public class Student {
    private int id;
    private String name;
    private String studentClass;
    private int age;
    private String classTeacher;
    private Integer mark; // Integer allows null values

    // Constructor
    public Student(int id, String name, String studentClass, int age, String classTeacher, Integer mark) {
        this.id = id;
        this.name = name;
        this.studentClass = studentClass;
        this.age = age;
        this.classTeacher = classTeacher;
        this.mark = mark;
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getStudentClass() {
        return studentClass;
    }

    public int getAge() {
        return age;
    }

    public String getClassTeacher() {
        return classTeacher;
    }

    public Integer getMark() {
        return mark;
    }
}
