package com.poc.work.jasper.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRSaver;

@Component
public class SimpleReportFiller {

	private String reportFileName;

	private JasperReport jasperReport;

	private JasperPrint jasperPrint;

	@Autowired
	private DataSource dataSource;

	private Map<String, Object> parameters;

	public SimpleReportFiller() {
		parameters = new HashMap<>();
	}

	public void prepareReport() throws FileNotFoundException {
		compileReport();
		fillReport();
	}

	public void compileReport() throws FileNotFoundException {
		try {
			FileInputStream inputStream = new FileInputStream(reportFileName);
			jasperReport = JasperCompileManager.compileReport(inputStream);
			JRSaver.saveObject(jasperReport, reportFileName.replace(".jrxml", ".jasper"));
		} catch (JRException ex) {
			Logger.getLogger(SimpleReportFiller.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	public void fillReport() {
		try {
			jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, dataSource.getConnection());
		} catch (JRException | SQLException ex) {
			Logger.getLogger(SimpleReportFiller.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	public DataSource getDataSource() {
		return dataSource;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public Map<String, Object> getParameters() {
		return parameters;
	}

	public void setParameters(Map<String, Object> parameters) {
		this.parameters = parameters;
	}

	public String getReportFileName() {
		return reportFileName;
	}

	public void setReportFileName(String reportFileName) {
		this.reportFileName = reportFileName;
	}

	public JasperPrint getJasperPrint() {
		return jasperPrint;
	}

}
