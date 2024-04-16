package com.poc.work.jasper.util;

import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.nio.charset.StandardCharsets;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.poc.work.jasper.model.DynamicReportConfig;
import com.poc.work.jasper.model.RequestDTO;
import com.poc.work.jasper.service.DynamicReportConfigService;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.export.ooxml.JRXlsxExporter;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;
import net.sf.jasperreports.export.SimpleXlsxReportConfiguration;

@Component
public class SingleDynamicGenerator {

//	private final String BASE_PATH = "D:\\WhipDrive\\Workspace\\Java\\Spring_boot\\jasper\\jasper\\src\\main\\resources\\report\\";
//	private final String EMPLOYEE_FILENAME = "employeeReport";
//	private final String EMAIL_FILENAME = "employeeEmailReport";
//	private final String JASPER_FORMAT = ".jasper";
//
//	private String employeeJasperFile = BASE_PATH+EMPLOYEE_FILENAME+JASPER_FORMAT;
//	private String emailJasperFile = BASE_PATH+EMAIL_FILENAME+JASPER_FORMAT;
//
//	private String outputFilePath = "/Users/user/Downloads/jasper/src/main/resources/report";

	private final String BASE_PATH = "src/main/resources/report/";
	private final String EMPLOYEE_FILENAME = "cineverse_statement";
//	private final String EMAIL_FILENAME = "employeeEmailReport";
	private final String JASPER_FORMAT = ".jasper";

	private String employeeJasperFile = BASE_PATH+EMPLOYEE_FILENAME+JASPER_FORMAT;
//	private String emailJasperFile = BASE_PATH+EMAIL_FILENAME+JASPER_FORMAT;

	private String outputFilePath = "src/main/resources/report/output/";
	
	@Autowired
	private DynamicReportConfigService configService;

	@Autowired
	private DataSource dataSource;

	public void generateDynamicReport(RequestDTO requestDTO) throws JRException, SQLException {
//
//		DynamicReportConfig emailConfig = configService.findConfigByName("employee_email_report");
//		JasperDesign emailDesign = JRXmlLoader
//				.load(new ByteArrayInputStream(emailConfig.getReportDefinition()
//						.getBytes(StandardCharsets.UTF_8)));
//		JasperReport emailReport = JasperCompileManager.compileReport(emailDesign);
//		JasperCompileManager.compileReportToFile(emailDesign, emailJasperFile);

		DynamicReportConfig employeeConfig = configService.findConfigByName("partner_payment_report");
		JasperDesign employeeDesign = JRXmlLoader
				.load(new ByteArrayInputStream(employeeConfig.getReportDefinition()
						.getBytes(StandardCharsets.UTF_8)));
		JasperReport employeeReport = JasperCompileManager.compileReport(employeeDesign);
		JasperCompileManager.compileReportToFile(employeeDesign, employeeJasperFile);

//		JasperReport employeeReport = JasperCompileManager.compileReport("src/main/resources/report/cineverse_statement.jrxml");

		Map<String, Object> parameters = new HashMap<>();
		parameters.put("CUSTOMER_SOLD_TO", "2470");
		parameters.put("WORK_FLOW_ID", 49);
//		parameters.put("condition", " LAST_NAME ='Smith' ORDER BY FIRST_NAME");

		JasperPrint jasperPrint = JasperFillManager.fillReport(employeeReport, parameters, dataSource.getConnection());

		JRXlsxExporter exporter = new JRXlsxExporter();
		exporter.setExporterInput(new SimpleExporterInput(jasperPrint));
		exporter.setExporterOutput(new SimpleOutputStreamExporterOutput(outputFilePath+requestDTO.getOutputFileName()+"."+requestDTO.getOutputFormat()));

//		SimpleXlsxReportConfiguration reportConfig = new SimpleXlsxReportConfiguration();
//		reportConfig.setSheetNames(new String[] { "First" });
//		exporter.setConfiguration(reportConfig);

		try {
			exporter.exportReport();
		} catch (JRException ex) {
			Logger.getLogger(SimpleReportFiller.class.getName()).log(Level.SEVERE, null, ex);
		}

	}

//	public void generateDynamicReport(RequestDTO requestDTO) throws JRException, SQLException {
//
//		DynamicReportConfig emailConfig = configService.findConfigByName("employee_email_report");
//		JasperDesign emailDesign = JRXmlLoader
//				.load(new ByteArrayInputStream(emailConfig.getReportDefinition()
//						.getBytes(StandardCharsets.UTF_8)));
////		JasperReport emailReport = JasperCompileManager.compileReport(emailDesign);
//		JasperCompileManager.compileReportToFile(emailDesign, emailJasperFile);
//
//		DynamicReportConfig employeeConfig = configService.findConfigByName("partner_payment_report");
//		JasperDesign employeeDesign = JRXmlLoader
//				.load(new ByteArrayInputStream(employeeConfig.getReportDefinition()
//						.getBytes(StandardCharsets.UTF_8)));
//		JasperReport employeeReport = JasperCompileManager.compileReport(employeeDesign);
//		JasperCompileManager.compileReportToFile(employeeDesign, employeeJasperFile);
//
//		Map<String, Object> parameters = new HashMap<>();
//		parameters.put("title", "Employee Report Example");
//		parameters.put("minSalary", 15000.0);
//		parameters.put("condition", " LAST_NAME ='Smith' ORDER BY FIRST_NAME");
//
////		JasperPrint jasperPrint = JasperFillManager.fillReport(employeeReport, parameters, dataSource.getConnection());
//		JasperPrint jasperPrint = JasperFillManager.fillReport(employeeReport, null, dataSource.getConnection());
//
//		JRXlsxExporter exporter = new JRXlsxExporter();
//		exporter.setExporterInput(new SimpleExporterInput(jasperPrint));
//		exporter.setExporterOutput(new SimpleOutputStreamExporterOutput(outputFilePath+"test.xlsx"));
//		SimpleXlsxReportConfiguration reportConfig = new SimpleXlsxReportConfiguration();
//		reportConfig.setSheetNames(new String[] { "First" });
//		exporter.setConfiguration(reportConfig);
//
//		try {
//			exporter.exportReport();
//		} catch (JRException ex) {
//			Logger.getLogger(SimpleReportFiller.class.getName()).log(Level.SEVERE, null, ex);
//		}
//
//	}


}
