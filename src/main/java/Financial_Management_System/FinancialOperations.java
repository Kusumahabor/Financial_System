package Financial_Management_System;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class FinancialOperations {
    //public static double getHourlyRateSum(List<Financial_Management_System.Employee> employees) {
    //    double sum = 0;
    //    for (Financial_Management_System.Employee employee : employees) {
    //        sum += employee.getSalary();
    //    }
    //    return sum;
    //}
    //
    public static double getHourlyRateSum(List<Employee> employees) {
        return employees.stream().mapToDouble(Employee::getHourly_rate)
                .sum();
    }

    // Sum of salaries by department
    public static double sumDepartmentSalary(List<Employee> employees, String department) {
        return employees.stream()
                .filter(e -> e.getDepartment().equals(department))
                .mapToDouble(Employee::getSalary)
                .sum();
    }

    // Average salary by department
    public static double getAverageSalaryByDepartment(List<Employee> employees, String department) {
        return employees.stream()
                .filter(e -> e.getDepartment().equals(department))
                .mapToDouble(Employee::getSalary)
                .average()
                .orElse(0.0);
    }

    // Sum of hourly rates by department
    public static double sumDepartmentHourlyRate(List<Employee> employees, String department) {
        return employees.stream()
                .filter(e -> e.getDepartment().equals(department))
                .mapToDouble(Employee::getHourly_rate)
                .sum();
    }

    // Average hourly rate by department
    public static double getAverageHourlyRateByDepartment(List<Employee> employees, String department) {
        return employees.stream()
                .filter(e -> e.getDepartment().equals(department))
                .mapToDouble(Employee::getHourly_rate)
                .average()
                .orElse(0.0);
    }

    // Total salary by department
    public static Map<String, Double> getTotalSalaryByDepartment(List<Employee> employees) {
        return employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.summingDouble(Employee::getSalary)));
    }

    // Average salary by department
    public static Map<String, Double> getAverageSalaryByDepartment(List<Employee> employees) {
        return employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.averagingDouble(Employee::getSalary)));
    }

    // Total hourly rate by department
    public static Map<String, Double> getTotalHourlyRateByDepartment(List<Employee> employees) {
        return employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.summingDouble(Employee::getHourly_rate)));
    }

    // Average hourly rate by department
    public static Map<String, Double> getAverageHourlyRateByDepartment(List<Employee> employees) {
        return employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.averagingDouble(Employee::getHourly_rate)));
    }

    // Helper method to get sum of digits of employee IDs
    public static int getSumOfEmployeeIdDigits(List<Employee> employees) {
        return employees.stream()
                .mapToInt(e -> getSumOfDigits(e.getId()))
                .sum();
    }

    private static int getSumOfDigits(int id) {
        int sum = 0;
        while (id > 0) {
            sum += id % 10;
            id /= 10;
        }
        return sum;
    }
}
