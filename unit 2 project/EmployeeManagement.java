import java.util.Scanner;
class EmployeeDetails {

    private int empId;
    private String empName;
    private String department;

    public EmployeeDetails(int empId, String empName, String department) {
        this.empId = empId;
        this.empName = empName;
        this.department = department;
    }

    public int getEmpId() {
        return empId;
    }

    public String getEmpName() {
        return empName;
    }

    public String getDepartment() {
        return department;
    }
}

abstract class Employee {

    protected EmployeeDetails details;

    public Employee(EmployeeDetails details) {
        this.details = details;
    }

    public abstract double calculateSalary();

    public void displayEmployee() {
        System.out.println("Employee ID: " + details.getEmpId());
        System.out.println("Employee Name: " + details.getEmpName());
        System.out.println("Department: " + details.getDepartment());
    }
}

class EmployeePayroll extends Employee {

    private double basicSalary;

    public EmployeePayroll(EmployeeDetails details, double basicSalary) {
        super(details);
        this.basicSalary = basicSalary;
    }

    @Override
    public double calculateSalary() {
        double hra = basicSalary * 0.20;
        double da  = basicSalary * 0.10;
        return basicSalary + hra + da;
    }
}


public class EmployeeManagement {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n=== Employee Management Menu ===");
            System.out.println("1. Add Employee");
            System.out.println("2. Exit");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();
            sc.nextLine();

            if (choice == 1) {

                System.out.print("Enter Employee ID: ");
                int id = sc.nextInt();
                sc.nextLine();

                System.out.print("Enter Employee Name: ");
                String name = sc.nextLine();

                System.out.print("Enter Department: ");
                String dept = sc.nextLine();

                System.out.print("Enter Basic Salary: ");
                double salary = sc.nextDouble();

                EmployeeDetails details =
                        new EmployeeDetails(id, name, dept);

                Employee emp =
                        new EmployeePayroll(details, salary);

                System.out.println("\n--- Employee Details ---");
                emp.displayEmployee();
                System.out.println("Net Salary: " + emp.calculateSalary());

            } else if (choice == 2) {
                System.out.println("Exiting Employee Management System.");
                sc.close();
                break;
            } else {
                System.out.println("Invalid option.");
            }
        }
    }
}

