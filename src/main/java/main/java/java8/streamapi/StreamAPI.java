package main.java.java8.streamapi;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class StreamAPI {
    private void testCreateStreamMethod(){
        List<Employee> stringList = new ArrayList<>();
        Stream<Employee> stream = stringList.stream();
        stringList.parallelStream();
    }

    private void createStreamByArray(){
        Integer[] numbs = {};
        Arrays.stream(numbs);
        Stream<Integer> integerStream = Stream.of(1,2,3,4,5);
        integerStream.forEach(System.out::print);
    }

    private void createStreamWithoutLimit(){
        Stream<Integer> stream = Stream.iterate(0,(x)->x+2).limit(10);
        System.out.println();
        stream.forEach(System.out::print);
        stream.close();
    }

    private void streamSkip(){
        System.out.println();
        List<Employee> streamList = Arrays.asList(new Employee("扫地僧",90,true),new Employee("乔峰",30,false),
                new Employee("慕容复",30,false),new Employee("段誉",25,false),new Employee("虚竹",28,false));
        Stream stream = streamList.parallelStream().skip(1);
        stream.forEach(System.out::println);
        Stream paralleStream = streamList.parallelStream().filter(employee -> employee.getAge() >= 30);
        paralleStream.forEach(System.out::println);
        stream.close();
    }

    public static void main(String[] args){
        StreamAPI streamAPI = new StreamAPI();
        streamAPI.createStreamByArray();
        streamAPI.createStreamWithoutLimit();
        streamAPI.streamSkip();
    }
}

class Employee implements Serializable {
    String name;
    int age;
    boolean isAdmin;

    public Employee(){}

    public Employee(String name, int age, boolean isAdmin) {
        this.name = name;
        this.age = age;
        this.isAdmin = isAdmin;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", isAdmin=" + isAdmin +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }
}
