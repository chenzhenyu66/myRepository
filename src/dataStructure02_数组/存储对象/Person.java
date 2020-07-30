package dataStructure02_数组.存储对象;

/**
 * 2020/3/5 23:23
 *
 * @author a1344
 * 说明：
 */
public class Person {
    private String lastName;
    private String firstName;
    private int age;

    public Person(String lastName,String firstName,int age){
        this.age=age;
        this.firstName=firstName;
        this.lastName=lastName;
    }

    @Override
    public String toString() {
        return "Person{" +
                "lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", age=" + age +
                '}';
    }

    public String getLastName() {
        return lastName;
    }

}
