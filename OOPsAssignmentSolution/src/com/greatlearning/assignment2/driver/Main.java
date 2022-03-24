/*
 * 
 * JDK : 17, JRE: 17
 * Author : Soukarya Datta
 * Version: 1.0.7
 * Date: March 24, 2022
 * 
 */

package com.greatlearning.assignment2.driver;

import com.greatlearning.assignment2.admindepartment.AdminDepartment;
import com.greatlearning.assignment2.hrdepartment.HrDepartment;
import com.greatlearning.assignment2.superdepartment.SuperDepartment;
import com.greatlearning.assignment2.techdepartment.TechDepartment;

import static java.lang.System.out;

public class Main {

	//To store the total number of departments
	private static int count;

	//To convert a String to title case
	private static String toTitleCase(String s) {
		if(s != null) {
			if(s.length()>1) {
			
				s = s.toLowerCase().trim();
				String[] parts = s.split(" ");
				StringBuilder sb = new StringBuilder(s.length());
				for(String part: parts) {
					sb.append(part.substring(0,1).toUpperCase())
					   .append(part.substring(1));
					sb.append(" ");
				}
				return sb.toString();
			}else if(s.length()==1) {
				return s.toUpperCase();
			}else {
				return "";
			}
			
		}else {
			throw new IllegalArgumentException("String cannot be null");
		}
	}
	//As per problem statement we have to print new lines after printing each department details
	private static void printNewLine(int c) {
		// For printing the new lines
		while (c != 0) {
			out.println();
			c = c - 1;
		}
	}

	/*
	 * This method is basically to print department details
	 * Using enhanced instanceof operator (Java 13) to prevent ClassCastException and also to prevent type casting
	 * 
	 */
	private static boolean printDetails(SuperDepartment department) {

		if (department != null) {
			if (department instanceof SuperDepartment) {
				if (department instanceof HrDepartment hr) {
					out.println(" Welcome to HR Department");
					out.println(hr.doActivity().trim());
				} else {
					out.println(" Welcome to " + department.departmentName());
				}
				
				if(department instanceof TechDepartment) {
					String s = department.getTodaysWork().trim();
					if(s.contains("module")) {
						s = s.replace("module", "Module");
					}
					out.println(s);
				}else {
					out.println(department.getTodaysWork().trim());
				}
				
				out.println(department.getWorkDeadLine().trim());
				
				if (department instanceof TechDepartment tech) {
					out.println(" " + Main.toTitleCase(tech.getStackTechInformation()));
				}
				
				String isTodayAHoliday = department.isTodayAHoliday().trim();
				out.println(isTodayAHoliday.substring(0,isTodayAHoliday.lastIndexOf(" ")+1)+Main.toTitleCase(isTodayAHoliday.substring(isTodayAHoliday.lastIndexOf(" ")+1)));
				
				return true;
			}
		}
		return false;
	}

	public static void main(String[] args) {

		/*
		 * Using arrays to promote type safety and avoid type casting problems
		 * We can add as many department as we want that extends SuperDepartment
		 * 
		 */
		SuperDepartment[] departments = { new AdminDepartment(), new HrDepartment(), new TechDepartment() };

		out.println();
		
		//for-each loop to iterate through each department
		for (SuperDepartment department : departments) {
			Main.count++;
			boolean isDepartmentDetailsDisplayed = Main.printDetails(department);
			if (isDepartmentDetailsDisplayed) {
				Main.printNewLine(count);
			}
		}
	}
}
