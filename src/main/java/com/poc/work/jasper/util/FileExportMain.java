package com.poc.work.jasper.util;

import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FileExportMain {

	@Autowired
	SimpleReportFiller simpleReportFiller;

	@Autowired
	SimpleReportExporter simpleExporter;

	private final String BASE_PATH = "D:\\JavaWorkSpace\\WM\\reportpoc\\reportpoc\\src\\main\\resources\\report\\";
	private final String EMAIL_PATH = BASE_PATH + "employeeEmailReport.jrxml";
	private final String EMPLOYEE_PATH = BASE_PATH + "employeeReport.jrxml";

	public void mainExport() throws FileNotFoundException {

		simpleReportFiller.setReportFileName(EMAIL_PATH);
		simpleReportFiller.compileReport();

		simpleReportFiller.setReportFileName(EMPLOYEE_PATH);
		simpleReportFiller.compileReport();

		Map<String, Object> parameters = new HashMap<>();
		parameters.put("title", "Employee Report Example");
		parameters.put("minSalary", 15000.0);
		parameters.put("condition", " LAST_NAME ='Smith' ORDER BY FIRST_NAME");

		simpleReportFiller.setParameters(parameters);
		simpleReportFiller.fillReport();

		simpleExporter.setJasperPrint(simpleReportFiller.getJasperPrint());

//  simpleExporter.exportToPdf("D:\\JavaWorkSpace\\WM\\Jasper\\employeeReport.pdf", "baeldung");
		simpleExporter.exportToXlsx("D:\\JavaWorkSpace\\WM\\Jasper\\employeeReport.xlsx", "Employee Data");
//  simpleExporter.exportToCsv("D:\\JavaWorkSpace\\WM\\Jasper\\employeeReport.csv");
//  simpleExporter.exportToHtml("D:\\JavaWorkSpace\\WM\\Jasper\\employeeReport.html");
		System.out.println("File Export Successful");

	}
}