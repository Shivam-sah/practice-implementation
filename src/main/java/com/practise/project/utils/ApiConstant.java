package com.practise.project.utils;

public class ApiConstant {
	
	public static final String API_V1="/api-v1";
	public static final String EP_EMPCONTROLLER = "/emp";
	public static final String EP_DEPTCONTROLLER = "/dept";
	public static final String EP_PROJECTCONTROLLER = "/project";
		
	
	/* ENDPOINTS DEPARTMENT*/	
	public static final String EP_CREATE_DEPARTMENT = "/create-dept";
	public static final String EP_UPDATE_DEPARTMENT = "/update-dept";
	public static final String EP_GET_DEPARTMENT = "/get-dept/{id}";
	public static final String EP_DELETE_DEPARTMENT = "/delete-dept/{id}";
	public static final String EP_ALL_DEPARTMENT = "/all-dept";
	
	
	/* ENDPOINTS PROJECT*/	
	public static final String EP_CREATE_PROJECT = "/create-project";
	public static final String EP_UPDATE_PROJECT = "/update-project";
	public static final String EP_GET_PROJECT = "/get-project/{id}";
	public static final String EP_DELETE_PROJECT = "/delete-project/{id}";
	public static final String EP_ALL_PROJECT = "/all-project";	
	
	
	/* ENDPOINTS EMPLOYEE*/	
	public static final String EP_CREATE_EMPLOYEE = "/create-employee";
	public static final String EP_UPDATE_EMPLOYEE = "/update-employee";
	public static final String EP_GET_EMPLOYEE = "/get-employee/{id}";
	public static final String EP_DELETE_EMPLOYEE = "/delete-employee/{id}";
	public static final String EP_ALL_EMPLOYEE = "/all-employee";
}
