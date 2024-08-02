package Financial_Management_System;

public class Employee {
    private int id;
    private String name;
    private String position;
    private String department;
    private double salary;
    private double hourly_rate;


    public Employee(int id, String name, double salary, String position, String department, double hourlyRate) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.position = position;
        this.department = department;
        this.hourly_rate = hourlyRate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public double getHourly_rate() {
        return hourly_rate;
    }

    public void setHourly_rate(double hourly_rate) {
        this.hourly_rate = hourly_rate;
    }

    @Override
    public String toString() {
        return "Financial_Management_System.Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", position='" + position + '\'' +
                ", department='" + department + '\'' +
                ", salary=" + salary +
                ", hourly_rate=" + hourly_rate +
                '}';
    }
}
