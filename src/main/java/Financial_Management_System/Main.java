package Financial_Management_System;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        // Load employees from the CSV file
        List<Employee> employees = CVSReader.readEmployeesFromCSV("financial_management_system.csv");

        // Demonstrate streams-based approach
        double hourlyRateSum = FinancialOperations.getHourlyRateSum(employees);
        System.out.println("Total hourly rate (streams): " + hourlyRateSum);

        // Demonstrate other operations
        String department = "IT";
        double totalSalaryIT = FinancialOperations.sumDepartmentSalary(employees, department);
        double avgSalaryIT = FinancialOperations.getAverageSalaryByDepartment(employees, department);
        double totalHourlyRateIT = FinancialOperations.sumDepartmentHourlyRate(employees, department);
        double avgHourlyRateIT = FinancialOperations.getAverageHourlyRateByDepartment(employees, department);

        System.out.println("Total salary for " + department + ": " + totalSalaryIT);
        System.out.println("Average salary for " + department + ": " + avgSalaryIT);
        System.out.println("Total hourly rate for " + department + ": " + totalHourlyRateIT);
        System.out.println("Average hourly rate for " + department + ": " + avgHourlyRateIT);

        // Write results to CSV files
        CSVWriter.writeEmployeesToCSV(employees, "output.csv");

        // Write each department's employees to a separate CSV file
        Map<String, List<Employee>> employeesByDepartment = employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment));
        for (Map.Entry<String, List<Employee>> entry : employeesByDepartment.entrySet()) {
            String dep = entry.getKey();
            List<Employee> empList = entry.getValue();
            CSVWriter.writeEmployeesToCSV(empList, "output_" + dep + "_employees.csv");
        }
    }
}

