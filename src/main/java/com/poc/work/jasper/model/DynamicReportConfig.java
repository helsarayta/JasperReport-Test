package com.poc.work.jasper.model;

import java.sql.Timestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "dynamic_report_config", schema = "customer")
public class DynamicReportConfig {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "report_config_id")
	private Integer reportConfigId;

	@Column(name = "customer_code")
	private String customerCode;

	@Column(name = "created_date")
	private Timestamp createdDate;

	@Column(name = "created_by")
	private Integer createdBy;

	@Column(name = "last_modified_date")
	private Timestamp lastModifiedDate;

	@Column(name = "last_modified_by")
	private Integer lastModifiedBy;

	@Column(name = "page_source")
	private String pageSource;

	@Column(name = "report_name")
	private String reportName;

	@Column(name = "report_desc")
	private String reportDesc;

	@Column(name = "report_config")
	private String reportConfig;

	@Column(name = "report_definition")
	private String reportDefinition;

	@Column(name = "is_active")
	private Boolean isActive;
	
	@Column(name = "repository_id")
	private Integer repositoryId;
	
	@Column(name = "report_type_id")
	private Integer reportTypeId;

	public Integer getReportConfigId() {
		return reportConfigId;
	}

	public void setReportConfigId(Integer reportConfigId) {
		this.reportConfigId = reportConfigId;
	}

	public String getCustomerCode() {
		return customerCode;
	}

	public void setCustomerCode(String customerCode) {
		this.customerCode = customerCode;
	}

	public Timestamp getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Timestamp createdDate) {
		this.createdDate = createdDate;
	}

	public Integer getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(Integer createdBy) {
		this.createdBy = createdBy;
	}

	public Timestamp getLastModifiedDate() {
		return lastModifiedDate;
	}

	public void setLastModifiedDate(Timestamp lastModifiedDate) {
		this.lastModifiedDate = lastModifiedDate;
	}

	public Integer getLastModifiedBy() {
		return lastModifiedBy;
	}

	public void setLastModifiedBy(Integer lastModifiedBy) {
		this.lastModifiedBy = lastModifiedBy;
	}

	public String getPageSource() {
		return pageSource;
	}

	public void setPageSource(String pageSource) {
		this.pageSource = pageSource;
	}

	public String getReportName() {
		return reportName;
	}

	public void setReportName(String reportName) {
		this.reportName = reportName;
	}

	public String getReportDesc() {
		return reportDesc;
	}

	public void setReportDesc(String reportDesc) {
		this.reportDesc = reportDesc;
	}

	public String getReportConfig() {
		return reportConfig;
	}

	public void setReportConfig(String reportConfig) {
		this.reportConfig = reportConfig;
	}

	public String getReportDefinition() {
		return reportDefinition;
	}

	public void setReportDefinition(String reportDefinition) {
		this.reportDefinition = reportDefinition;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	public Integer getRepositoryId() {
		return repositoryId;
	}

	public void setRepositoryId(Integer repositoryId) {
		this.repositoryId = repositoryId;
	}

	public Integer getReportTypeId() {
		return reportTypeId;
	}

	public void setReportTypeId(Integer reportTypeId) {
		this.reportTypeId = reportTypeId;
	}
	
}
