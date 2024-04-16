package com.poc.work.jasper.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poc.work.jasper.model.WebSeries;
import com.poc.work.jasper.repo.WebSeriesRepository;

import java.util.List;
import java.util.Optional;

@Service
public class WebSeriesServiceImpl implements WebSeriesService {

	@Autowired
	private WebSeriesRepository webSeriesRepository;

	@Override
	public List<WebSeries> getAllWebSeries() {
		return webSeriesRepository.findAll();
	}

	@Override
	public Optional<WebSeries> getWebSeriesById(Long id) {
		return webSeriesRepository.findById(id);
	}
}

