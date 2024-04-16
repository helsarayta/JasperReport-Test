package com.poc.work.jasper.model;

public class RequestDTO {

	private Integer seasons;
	private String page;
	private String outputFormat;
	private String outputFileName;
	private String reportName;
	private String reportType;
	
	public Integer getSeasons() {
		return seasons;
	}
	public void setSeasons(Integer seasons) {
		this.seasons = seasons;
	}
	public String getPage() {
		return page;
	}
	public void setPage(String page) {
		this.page = page;
	}
	public String getOutputFormat() {
		return outputFormat;
	}
	public void setOutputFormat(String outputFormat) {
		this.outputFormat = outputFormat;
	}
	public String getOutputFileName() {
		return outputFileName;
	}
	public void setOutputFileName(String outputFileName) {
		this.outputFileName = outputFileName;
	}
	public String getReportName() {
		return reportName;
	}
	public void setReportName(String reportName) {
		this.reportName = reportName;
	}
	public String getReportType() {
		return reportType;
	}
	public void setReportType(String reportType) {
		this.reportType = reportType;
	}
	
}
