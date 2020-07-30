package test;

import java.util.*;

/**
 * 2020/4/17 21:37
 *
 * @author a1344
 * 说明：
 */
public class Demo1 {
    public static void main(String[] args) {
//        Car car = new BigCar();
//        car.SaoI();

//        TreeSet set = new TreeSet();
//        set.add(1);
        Set<Car> set = new HashSet<>();
        Car car = new Car("AA",1001);
        Car car1 = new Car("BB",1002);

        set.add(car);
        set.add(car1);

        car.setName("CC");
        boolean a = set.remove(car);
        System.out.println(set.size()+" "+a);


        set.add(new Car("CC",1001));
        System.out.println(set.size());

        set.add(new Car("AA",1001));
        System.out.println(set.size());

        set.add(new Car("AA",1001));
        System.out.println(set.size());

        s(set);

        List list = new ArrayList();
        list.add(1);
        list.add(1);
        list.add(1);
        list.add(3);
        list.add(2);
        List list2 =duplicateList(list);
        System.out.println(list2);

    }
    public static void s(Set<Car> set){
        for (Car c: set) {
            System.out.print(c.toString());
        }
    }
    public static List duplicateList(List list) {
        HashSet set = new HashSet();
        set.addAll(list);
        return new ArrayList(set);
    }
}
class Car{
    private String name;
    private Integer num;

    public Car(String name, Integer num) {
        this.name = name;
        this.num = num;
    }

    protected void Sao(){
        System.out.println("我是car");
    }

    protected void SaoI(){
        Sao();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Objects.equals(name, car.name) &&
                Objects.equals(num, car.num);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, num);
    }

    @Override
    public String toString() {
        return "Car{" +
                "name='" + name + '\'' +
                ", num=" + num +
                '}';
    }
}







