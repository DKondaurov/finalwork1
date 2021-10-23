package pro.sky.java.course1;

import java.util.Objects;

public class Employee {
    private static int counter;
    private final String name;
    private final int id;
    private int department;
    private double salary;


    public Employee(String name, int salary, int department) {
        this.name = name;
        this.salary = salary;
        this.department = department;
        this.id = ++counter;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getDepartment() {
        return department;
    }

    public void setDepartment(int department) {
        this.department = department;
    }

    public double getSalary() {
        return (double) salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return id == employee.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "ФИО: " + name + ". Зарплата " + salary + " рублей. Отдел " + department;
    }
}
