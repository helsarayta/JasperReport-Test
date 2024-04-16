package com.poc.work.jasper.repo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.poc.work.jasper.model.WebSeries;

@Repository
public interface WebSeriesRepository extends JpaRepository<WebSeries, Long> {
}