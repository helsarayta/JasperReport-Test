package com.poc.work.jasper.controller;
import java.io.IOException;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.poc.work.jasper.model.RequestDTO;
import com.poc.work.jasper.service.ReportService;

import net.sf.jasperreports.engine.JRException;

@RestController
@RequestMapping("/api/reports")
public class ReportController {

	@Autowired
	private ReportService reportService;

	
	
	@PostMapping("/generate")
	public ResponseEntity<String> generateReport(@RequestBody RequestDTO requestDTO) throws IOException, JRException, SQLException {
		System.out.println("Called");
		reportService.generateExcelReport(requestDTO);
		return ResponseEntity.ok("Excel report generated successfully!");
	}
}