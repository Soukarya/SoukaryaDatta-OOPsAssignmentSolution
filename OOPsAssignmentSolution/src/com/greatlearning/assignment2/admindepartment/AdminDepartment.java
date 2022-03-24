package com.greatlearning.assignment2.admindepartment;

import com.greatlearning.assignment2.superdepartment.SuperDepartment;

public class AdminDepartment extends SuperDepartment {

	public AdminDepartment() {
		super();
	}
	
	@Override
	public String departmentName() {
		return " Admin Department ";
	}
	
	@Override
	public String getTodaysWork() {
		return "Complete your documents Submission";
	}
	
	@Override
	public String getWorkDeadLine() {
		return " Complete by EOD ";
	}

}
