package com.poc.work.jasper.service;
import java.io.IOException;
import java.sql.SQLException;

import com.poc.work.jasper.model.RequestDTO;

import net.sf.jasperreports.engine.JRException;

public interface ReportService {
	void generateExcelReport(RequestDTO requestDTO) throws IOException, JRException, SQLException;
}