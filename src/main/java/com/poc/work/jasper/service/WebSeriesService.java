package com.poc.work.jasper.service;

import java.util.List;
import java.util.Optional;

import com.poc.work.jasper.model.WebSeries;

public interface WebSeriesService {
	List<WebSeries> getAllWebSeries();
	Optional<WebSeries> getWebSeriesById(Long id);
}

