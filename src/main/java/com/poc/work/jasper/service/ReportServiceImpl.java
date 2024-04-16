package com.poc.work.jasper.service;

import java.io.IOException;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poc.work.jasper.model.RequestDTO;
import com.poc.work.jasper.util.ExcelReportGenerator;
import com.poc.work.jasper.util.SingleDynamicGenerator;

import net.sf.jasperreports.engine.JRException;

@Service
public class ReportServiceImpl implements ReportService {

	@Autowired
	private ExcelReportGenerator excelReportGenerator; 
	
	@Autowired
	SingleDynamicGenerator singleDynamicGenerator;
	
	@Override
	public void generateExcelReport(RequestDTO requestDTO) throws IOException, JRException, SQLException {
		
		if("dynamic".equals(requestDTO.getReportType())) {
			singleDynamicGenerator.generateDynamicReport(requestDTO);
		}else {
			excelReportGenerator.generateExcelReport(requestDTO);
		}
	}
}
