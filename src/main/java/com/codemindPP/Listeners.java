package com.codemindPP;

import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listeners implements ITestListener {

	public void onTestStart(ITestResult result) {
		System.out.println("Test case started " + result.getName());
	}
	public void onTestFailure(ITestResult result) {
		System.out.println("Test case failured "  + result.getName());
	}
	public void onTestSuccess(ITestResult result) {
		System.out.println("Test case succefully executed "  + result.getName());
	}
	
	
}
