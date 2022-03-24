package com.greatlearning.assignment2.hrdepartment;

import com.greatlearning.assignment2.superdepartment.SuperDepartment;

public class HrDepartment extends SuperDepartment {

	public HrDepartment() {
		super();
	}
	
	@Override
	public String departmentName() {
		return "Hr Department";
	}
	
	@Override
	public String getTodaysWork() {
		return "Fill today's timesheet and mark your attendance";
	}
	
	@Override
	public String getWorkDeadLine() {
		return "Complete by EOD";
	}
	
	public String doActivity() {
		return "team Lunch";
	}

}
