/*
 * 
 * JDK : 17, JRE: 17
 * Author : Soukarya Datta
 * Version: 1.1.0
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

	// To store the total number of departments
	private static int count;

	// To convert a String to title case
	private static String toTitleCase(String s) {

		if (s != null) {
			s = s.trim();
			if (s.length() > 1) {

				s = s.toLowerCase();
				String[] parts = s.split(" ");
				StringBuilder sb = new StringBuilder(s.length());
				for (String part : parts) {
					sb.append(part.substring(0, 1).toUpperCase()).append(part.substring(1));
					if (parts.length > 1) {
						sb.append(" ");
					}
				}
				return sb.toString();
			} else if (s.length() == 1) {
				return s.toUpperCase();
			} else {
				return "";
			}

		} else {
			throw new IllegalArgumentException("String cannot be null");
		}
	}

	// As per problem statement we have to print new lines after printing each
	// department details
	private static void printNewLine(int c) {
		// For printing the new lines
		while (c != 0) {
			out.println();
			c = c - 1;
		}
	}

	/*
	 * This method is basically to print department details Using enhanced
	 * instanceof operator (Java 14) to prevent ClassCastException and also to
	 * prevent type casting
	 * 
	 */
	private static boolean printDetails(SuperDepartment department) {

		String stringAfterChange = "";
		String departmentName = "";
		int lastIndexOfSpace = -1;
		if (department != null) {
			if (department instanceof SuperDepartment) {

				// For HrDepartment
				if (department instanceof HrDepartment hr) {

					// storing the department name after removing all the trailing and leading
					// whitespace
					departmentName = hr.departmentName().trim();

					lastIndexOfSpace = departmentName.indexOf(" ");

					// displaying the department name of the HR Department
					out.println(" Welcome to " + (departmentName.substring(0, lastIndexOfSpace).toUpperCase()
							+ departmentName.substring(lastIndexOfSpace)));

					// This will print out team Lunch
					out.println(hr.doActivity().trim());

					// storing updated string after removing trailing and leading whitespace
					stringAfterChange = department.getTodaysWork().trim();

					// Replacing worksheet work with timesheet in a string
					if (stringAfterChange.contains("worksheet")) {
						stringAfterChange = stringAfterChange.replace("worksheet", "timesheet");
					}

					// displaying updated string to the console
					out.println(stringAfterChange);
				} else {

					// Display the department name
					out.println(" Welcome to " + department.departmentName().trim());
				}

				// Mainly for TechDepartment
				if (department instanceof TechDepartment tech) {

					// storing updated string after removing trailing and leading whitespace
					stringAfterChange = department.getTodaysWork().trim();

					// We are storing the second last index Of the character space
					int secondLastIndexOfSpace = stringAfterChange.lastIndexOf(" ",
							stringAfterChange.lastIndexOf(" ") - 1);

					// storing updated string
					stringAfterChange = stringAfterChange.substring(0, secondLastIndexOfSpace + 1)
							+ Main.toTitleCase(stringAfterChange.substring(secondLastIndexOfSpace + 1));

					// displaying it to the console
					out.println(stringAfterChange);

					//out.println(" " + Main.toTitleCase(tech.getStackTechInformation()).trim());
				}

				// For Admin Department only
				else if (department instanceof AdminDepartment) {

					// storing updated string after removing trailing and leading whitespace
					stringAfterChange = department.getTodaysWork().trim();

					// We are storing the last index Of the character space
					lastIndexOfSpace = stringAfterChange.lastIndexOf(" ");

					// storing updated string as per given problem
					stringAfterChange = stringAfterChange.substring(0, lastIndexOfSpace + 1)
							+ stringAfterChange.substring(lastIndexOfSpace + 1).toLowerCase();

					// displaying the modified string to the console
					out.println(stringAfterChange);
				}

				// displaying the deadline details
				out.println(department.getWorkDeadLine().trim());
				
				//mainly to print TechDepartment  specific methods
				if(department instanceof TechDepartment tech) {
					out.println(" " + Main.toTitleCase(tech.getStackTechInformation()).trim());
				}

				String isTodayAHoliday = department.isTodayAHoliday().trim();
				lastIndexOfSpace = isTodayAHoliday.lastIndexOf(" ");

				// For displaying whether today is a holiday or not
				out.println((isTodayAHoliday.substring(0, lastIndexOfSpace + 1)
						+ Main.toTitleCase(isTodayAHoliday.substring(lastIndexOfSpace + 1))));
				return true;
			}
		}
		return false;
	}

	public static void main(String[] args) {

		/*
		 * Using arrays to promote type safety and avoid type casting problems We can
		 * add as many department as we want that extends SuperDepartment
		 * 
		 */
		SuperDepartment[] departments = { new AdminDepartment(), new HrDepartment(), new TechDepartment() };

		out.println();

		// for-each loop to iterate through each department
		for (SuperDepartment department : departments) {
			Main.count++;
			boolean isDepartmentDetailsDisplayed = Main.printDetails(department);
			if (isDepartmentDetailsDisplayed) {
				Main.printNewLine(count);
			}
		}
	}
}
