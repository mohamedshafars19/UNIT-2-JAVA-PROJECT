import java.util.Scanner;
class EmployeePayroll {

	// private data members (ENCAPSULATION)
	private int empId;
	private String empName;
	private double basicSalary;

	// constructor
	public EmployeePayroll(int empId, String empName, double basicSalary) {
		this.empId = empId;
		this.empName = empName;
		this.basicSalary = basicSalary;
	}

	// calculate salary
	public double calculateNetSalary() {
		double hra = basicSalary * 0.20;
		double da  = basicSalary * 0.10;
		return basicSalary + hra + da;
	}

	// setter with validation
	public void setBasicSalary(double basicSalary) {
		if (basicSalary > 0) {
			this.basicSalary = basicSalary;
		} else {
			System.out.println("Invalid salary amount");
		}
	}

	// getter
	public double getBasicSalary() {
		return basicSalary;
	}

	public void displayEmployee() {
		System.out.println("Employee ID: " + empId);
		System.out.println("Employee Name: " + empName);
		System.out.println("Basic Salary: " + basicSalary);
		System.out.println("Net Salary: " + calculateNetSalary());
	}
}

public class EmployeePayrollManager {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // taking input from user
        System.out.print("Enter Employee ID: ");
        int empId = sc.nextInt();
        sc.nextLine(); // clear buffer

        System.out.print("Enter Employee Name: ");
        String empName = sc.nextLine();

        System.out.print("Enter Basic Salary: ");
        double basicSalary = sc.nextDouble();

        // object creation using constructor
        EmployeePayroll emp = new EmployeePayroll(empId, empName, basicSalary);

        System.out.println("\n--- Employee Details ---");
        emp.displayEmployee();

        // update salary
        System.out.print("\nEnter New Basic Salary: ");
        double newSalary = sc.nextDouble();
        emp.setBasicSalary(newSalary);

        System.out.println("\nAfter Salary Update:");
        emp.displayEmployee();

        sc.close();
    }
}

