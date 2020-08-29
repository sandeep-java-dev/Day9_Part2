package db;

import p1.MathOperations;

public class BusinessClass {

	public static void main(String[] args) {
		
		int salary1 = 1500;
		int salary2 = 2500;
		int salary3 = 500;
		
		MathOperations calc = new MathOperations();
		int totalSalary = calc.doAdd(salary1,salary2,salary3);
		System.out.println("Total Salary "+totalSalary);
		
	}
}
