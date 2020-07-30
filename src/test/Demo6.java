package test;

import java.util.Objects;

/**
 * 2020/4/12 16:04
 *
 * @author a1344
 * 说明：
 */
public class Demo6 {
    public static void main(String[] args) {
        Student s =  new Student();
        Student s1 =  new Student();

        s.age=1;
        s.name="2";

        s1.age=1;
        s1.name="2";

        System.out.println(s1 == s);
        System.out.println(s1.equals(s));


    }
}

class Person1 {
    protected String name = "张三";
    protected int age;

    public String getInfo() {
        return "Name: " + name + "\nage: " + age;
    }
}

class Student extends Person1 {
    protected String name = "李四";
    private String school = "New Oriental";

    public String getSchool() {
        return school;
    }
    @Override
    public String getInfo() {
        return super.getInfo() + "\nschool: " + school;
    }
    public String getInfo(String s) {

        return super.getInfo() + "\nschool: " + school;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(name, student.name) &&
                Objects.equals(school, student.school);
    }
    public static void Sout(){
        Student s = new Student();
        s.getInfo();
        System.out.println("haha");
    }

//    @Override
//    public int hashCode() {
//        return Objects.hash(name, school);
//    }
}
