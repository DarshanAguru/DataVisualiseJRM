package com.example.serviceApi;

import org.springframework.data.jpa.domain.support.AuditingEntityListener; 

import jakarta.persistence.*; 

@Entity 
@Table(name="data")
@EntityListeners(AuditingEntityListener.class)
public class Data{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "end_year")
	private int endYear;
	
	@Column(name = "citylng")
	private String cityLng;
	
	@Column(name = "citylat")
	private String cityLat;
	
	@Column(name = "intensity")
	private int intensity;
	
	@Column(name = "sector")
	private String sector;
	
	@Column(name = "topic")
	private String topic;
	
	@Column(name = "insight")
	private String insight;
	
	@Column(name = "swot")
	private String swot;
	
	@Column(name = "url")
	private String url;
	
	@Column(name = "region")
	private String region;
	
	@Column(name = "start_year")
	private String startYear;
	
	@Column(name = "impact")
	private String impact;
	
	@Column(name = "added")
	private String added;
	
	@Column(name = "published")
	private String published;
	
	@Column(name = "city")
	private String city;
	
	@Column(name = "country")
	private String country;
	
	@Column(name = "relevance")
	private int relevance;
	
	@Column(name = "pestle")
	private String pestle;
	
	@Column(name = "source")
	private String source;
	
	@Column(name = "title")
	private String title;
	
	@Column(name = "likelihood")
	private int likelihood;
	
	
	public Data()	{}
	
	public long getId() {
		return id;
	}
	
	public int getEndYear()
	{
		return endYear;
	}
	
	public String getCityLng()
	{
		return cityLng;
	}
	
	public String getCityLat()
	{
		return cityLat;
	}
	
	public int getIntensity()
	{
		return intensity;
	}
	
	public String getSector()
	{
		return sector;
	}
	
	public String getTopic()
	{
		return topic;
	}
	
	public String getInsight()
	{
		return insight;
	}
	
	public String getSwot()
	{
		return swot;
	}

	public String getUrl()
	{
		return url;
	}
	
	public String getRegion()
	{
		return region;
	}
	
	public String getStartYear()
	{
		return startYear;
	}
	
	public String getImpace()
	{
		return impact;
	}
	
	public String getAdded()
	{
		return added;
	}
	
	public String getPublished()
	{
		return published;
	}
	
	public String getCity()
	{
		return city;
	}
	
	public String getCountry()
	{
		return country;
	}
	
	public int getRelevance()
	{
		return relevance;
	}
	
	public String getPestle()
	{
		return pestle;
	}
	
	public String getSource()
	{
		return source;
	}
	
	public String getTitle()
	{
		return title;
	}
	
	public int getLikelihood()
	{
		return likelihood;
	}
}