package com.poc.work.jasper.util;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
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

@Component
public class ExcelReportGenerator {
	
	@Autowired
	private DataSource dataSource;
	
	@Autowired
	private DynamicReportConfigService configService;
	
	private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();
	private String outputFilePath = "src\\main\\resources\\report\\output";
	
	
	public void generateExcelReport(RequestDTO requestDTO) throws IOException, SQLException {
		try {
			DynamicReportConfig dynamicReportConfig = configService.findConfigByName(requestDTO.getReportName());
			Map<String,Object> dbReportConfig = buildParametrsMap("employee_report");
			
			JasperDesign design = JRXmlLoader
					.load(new ByteArrayInputStream(dynamicReportConfig.getReportDefinition()
							.getBytes(StandardCharsets.UTF_8)));

//			comment test data
//			comment test data

			JasperReport jasperReport = JasperCompileManager.compileReport("src/main/resources/report/cineverse_statement.jrxml");
			Map<String, Object> requestReportConfig = new HashMap<>();
			
			List<JasperPrint> jasperPrintList = new ArrayList<>();
			JasperPrint jasperPrint = null;

			if(requestDTO.getPage().equals("single")) {
				System.out.println("Masuk 1");
				String seasons = IntStream.rangeClosed(1, requestDTO.getSeasons()).mapToObj(String::valueOf)
										.collect(Collectors.joining(", "));
				requestReportConfig.clear();
				requestReportConfig.put("SEASON", seasons);
				if(requestReportConfig.keySet().equals(dbReportConfig.keySet())) {
					jasperPrint = JasperFillManager.fillReport(jasperReport, requestReportConfig, dataSource.getConnection());
					jasperPrintList.add(jasperPrint);
				} else {
					System.out.println("Request Parameters not matching with DB Params");
				}
			}else {
				System.out.println("Masuk 2");
				for(int i =1; i<=requestDTO.getSeasons();i++) {
					requestReportConfig.clear();
					requestReportConfig.put("SEASON", i);
					if(requestReportConfig.keySet().equals(dbReportConfig.keySet())) {
						jasperPrint = JasperFillManager.fillReport(jasperReport, requestReportConfig, dataSource.getConnection());
						jasperPrintList.add(jasperPrint);
					} else {
						System.out.println("Request Parameters not matching with DB Params");
						break;
					}
				}
			}
			
			String outputFileName = outputFilePath + requestDTO.getOutputFileName() + requestDTO.getOutputFormat();
			JRXlsxExporter exporter = new JRXlsxExporter();
			exporter.setExporterInput(SimpleExporterInput.getInstance(jasperPrintList));
			exporter.setExporterOutput(new SimpleOutputStreamExporterOutput(outputFileName));
			exporter.exportReport();

			System.out.println("Excel report generated successfully!");
		} catch (JRException e){
			e.printStackTrace();
		}
	}
	
	private Map<String, Object> buildParametrsMap(String params) throws IOException {
		return OBJECT_MAPPER.readValue(params, new TypeReference<>() {
		});
	}
}
