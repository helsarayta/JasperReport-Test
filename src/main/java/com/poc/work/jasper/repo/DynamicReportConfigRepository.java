package com.poc.work.jasper.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.poc.work.jasper.model.DynamicReportConfig;

@Repository
public interface DynamicReportConfigRepository extends JpaRepository<DynamicReportConfig, Integer>{
	
	public DynamicReportConfig findByReportName(String reportName);

}
