/*
 * 
 * JDK : 17, JRE: 17
 * Author : Soukarya Datta
 * Version: 1.0.5
 * Date: March 18, 2022
 * 
 */

package com.greatlearning.assignment2.driver;

import com.greatlearning.assignment2.admindepartment.AdminDepartment;
import com.greatlearning.assignment2.hrdepartment.HrDepartment;
import com.greatlearning.assignment2.itdepartment.IT;
import com.greatlearning.assignment2.superdepartment.SuperDepartment;
import com.greatlearning.assignment2.techdepartment.TechDepartment;

import static java.lang.System.out;

public class Main {

	private static int count;

	private static void printNewLine(int c) {
		// For printing the new line
		while (c != 0) {
			out.println();
			c = c - 1;
		}
	}

	private static boolean printDetails(SuperDepartment department) {

		if (department != null) {
			if (department instanceof HrDepartment || department instanceof TechDepartment || department instanceof AdminDepartment) {
				if (department instanceof HrDepartment hr) {
					out.println(" Welcome to HR Department");
					out.println(hr.doActivity());
				} else {
					out.println(" Welcome to " + department.departmentName());
				}
				out.println(department.getTodaysWork());
				out.println(department.getWorkDeadLine());
				if (department instanceof TechDepartment tech) {
					out.println(" " + tech.getStackTechInformation());
				}
				out.println(department.isTodayAHoliday());
				return true;
			}
		}
		return false;
	}

	public static void main(String[] args) {

		SuperDepartment[] departments = { new AdminDepartment(), new HrDepartment(), new TechDepartment() };

		out.println();
		for (SuperDepartment department : departments) {
			Main.count++;
			boolean isDepartmentDetailsDisplayed = Main.printDetails(department);
			if (isDepartmentDetailsDisplayed) {
				Main.printNewLine(count);
			}
		}
	}
}
