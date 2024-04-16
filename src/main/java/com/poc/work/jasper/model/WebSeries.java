package com.poc.work.jasper.model;

import jakarta.persistence.*;

@Entity
@Table(name = "web_series", schema = "public")
public class WebSeries {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@Column(name = "season")
	private Integer season;

	@Column(name = "episode")
	private Integer episode;

	@Column(name = "title")
	private String title;

	@Column(name = "directed_by")
	private String directedBy;

	@Column(name = "written_by")
	private String writtenBy;

	@Column(name = "release_date")
	private String releaseDate;

	@Column(name = "views")
	private String views;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getSeason() {
		return season;
	}

	public void setSeason(Integer season) {
		this.season = season;
	}

	public Integer getEpisode() {
		return episode;
	}

	public void setEpisode(Integer episode) {
		this.episode = episode;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDirectedBy() {
		return directedBy;
	}

	public void setDirectedBy(String directedBy) {
		this.directedBy = directedBy;
	}

	public String getWrittenBy() {
		return writtenBy;
	}

	public void setWrittenBy(String writtenBy) {
		this.writtenBy = writtenBy;
	}

	public String getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(String releaseDate) {
		this.releaseDate = releaseDate;
	}

	public String getViews() {
		return views;
	}

	public void setViews(String views) {
		this.views = views;
	}

}