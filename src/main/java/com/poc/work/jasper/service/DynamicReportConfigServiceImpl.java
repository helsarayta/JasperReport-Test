package com.poc.work.jasper.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poc.work.jasper.model.DynamicReportConfig;
import com.poc.work.jasper.repo.DynamicReportConfigRepository;

@Service
public class DynamicReportConfigServiceImpl implements DynamicReportConfigService{

	@Autowired
	private DynamicReportConfigRepository dynamicReportConfigRepository;
	
	@Override
	public DynamicReportConfig findConfigByName(String name) {
		return dynamicReportConfigRepository.findByReportName(name);
	}

}
