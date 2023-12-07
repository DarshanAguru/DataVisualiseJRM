package com.example.serviceApi;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.function.Consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class DataController
{
	@Autowired
	DataRepo datarepo;
	
	@CrossOrigin(origins = "http://localhost:3000")
	@GetMapping("/data")
	public List<Data> getAllData()
	{
		final List<Data> dataList = new ArrayList<>();
		Iterable<Data> iterable = datarepo.findAll();
		iterable.forEach(dataList::add);
		return dataList;
	}
	
	@CrossOrigin(origins = "http://localhost:3000")
	@GetMapping("/data/endyear/{endyear}")
	public List<Data> getDatabyEndYear(@PathVariable(value = "endyear") int endyear)
	{
		List<Data> dl = new ArrayList<>();
		Iterable<Data> iterable = datarepo.findAll();
		iterable.forEach(new Consumer<Data>() {
			@Override
			public void accept(Data d)
			{
				if (d.getEndYear() == endyear)
				{
					dl.add(d);
				}
			}
		});
		
		return dl;
	}
	
	@CrossOrigin(origins = "http://localhost:3000")
	@GetMapping("/data/endyearlist")
	public List<Integer> getEndyearList()
	{
		List<Integer> cn = new  ArrayList<>();
		Set<Integer> na = new HashSet<>();
		Iterable<Data> itr = datarepo.findAll();
		itr.forEach(new Consumer<Data>() {
			@Override
			public void accept(Data d)
			{
					na.add(d.getEndYear());
			}
		});
		for(int s : na)
		{
			cn.add(s);
		}
		return cn;
	}
	
	
	@CrossOrigin(origins = "http://localhost:3000")
	@GetMapping("/data/topiclist")
	public List<String> getTopicList()
	{
		List<String> cn = new  ArrayList<>();
		Set<String> na = new HashSet<>();
		Iterable<Data> itr = datarepo.findAll();
		itr.forEach(new Consumer<Data>() {
			@Override
			public void accept(Data d)
			{
					na.add(d.getTopic());
			}
		});
		for(String s : na)
		{
			cn.add(s);
		}
		return cn;
	}
	
	@CrossOrigin(origins = "http://localhost:3000")
	@GetMapping("/data/topic/{topic}")
	public List<Data> getDataByTopic(@PathVariable(value="topic") String topic)
	{
		List<Data> dl = new ArrayList<>();
		Iterable<Data> iterable = datarepo.findAll();
		iterable.forEach(new Consumer<Data>() {
			@Override
			public void accept(Data d)
			{
				if(d.getTopic().equals(topic))
				{
					dl.add(d);
				}
			}
		});
		
		return dl;
	}
	
	@CrossOrigin(origins = "http://localhost:3000")
	@GetMapping("/data/sector/{sector}")
	public List<Data> getDataBySector(@PathVariable(value="sector") String sector)
	{
		List<Data> dl = new ArrayList<>();
		Iterable<Data> iterable = datarepo.findAll();
		iterable.forEach(new Consumer<Data>() {
			@Override
			public void accept(Data d)
			{
				if(d.getSector().equals(sector))
				{
					dl.add(d);
				}
			}
		});
		
		return dl;
	}
	
	@CrossOrigin(origins = "http://localhost:3000")
	@GetMapping("/data/region/{region}")
	public List<Data> getDataByRegion(@PathVariable(value="region") String region)
	{
		List<Data> dl = new ArrayList<>();
		Iterable<Data> iterable = datarepo.findAll();
		iterable.forEach(new Consumer<Data>() {
			@Override
			public void accept(Data d)
			{
				if(d.getRegion().equals(region))
				{
					dl.add(d);
				}
			}
		});
		
		return dl;
	}
	
	
	@CrossOrigin(origins = "http://localhost:3000")
	@GetMapping("/data/pestlelist")
	public List<String> getPestleList()
	{
		List<String> cn = new  ArrayList<>();
		Set<String> na = new HashSet<>();
		Iterable<Data> itr = datarepo.findAll();
		itr.forEach(new Consumer<Data>() {
			@Override
			public void accept(Data d)
			{
					if(!d.getPestle().equals("Nan"))
						na.add(d.getPestle());
			}
		});
		for(String s : na)
		{
			cn.add(s);
		}
		return cn;
	}
	
	@CrossOrigin(origins = "http://localhost:3000")
	@GetMapping("/data/pestle/{pestle}")
	public List<Data> getDataByPestle(@PathVariable(value="pestle") String pestle)
	{
		List<Data> dl = new ArrayList<>();
		Iterable<Data> iterable = datarepo.findAll();
		iterable.forEach(new Consumer<Data>() {
			@Override
			public void accept(Data d)
			{
				if(d.getPestle().equals(pestle))
				{
					dl.add(d);
				}
			}
		});
		
		return dl;
	}
	
	@CrossOrigin(origins = "http://localhost:3000")
	@GetMapping("/data/source/{source}")
	public List<Data> getDataBySource(@PathVariable(value="source") String source)
	{
		List<Data> dl = new ArrayList<>();
		Iterable<Data> iterable = datarepo.findAll();
		iterable.forEach(new Consumer<Data>() {
			@Override
			public void accept(Data d)
			{
				if(d.getSource().equals(source))
				{
					dl.add(d);
				}
			}
		});
		
		return dl;
	}
	
	@CrossOrigin(origins = "http://localhost:3000")
	@GetMapping("/data/swot/{swot}")
	public List<Data> getDataBySwot(@PathVariable(value="swot") String swot)
	{
		List<Data> dl = new ArrayList<>();
		Iterable<Data> iterable = datarepo.findAll();
		iterable.forEach(new Consumer<Data>() {
			@Override
			public void accept(Data d)
			{
				if(d.getSwot().equals(swot))
				{
					dl.add(d);
				}
			}
		});
		
		return dl;
	}
	
	@CrossOrigin(origins = "http://localhost:3000")
	@GetMapping("/data/city/{city}")
	public List<Data> getDataByCity(@PathVariable(value="city") String city)
	{
		List<Data> dl = new ArrayList<>();
		Iterable<Data> iterable = datarepo.findAll();
		iterable.forEach(new Consumer<Data>() {
			@Override
			public void accept(Data d)
			{
				if(d.getCity().equals(city))
				{
					dl.add(d);
				}
			}
		});
		
		return dl;
	}
	
	@CrossOrigin(origins = "http://localhost:3000")
	@GetMapping("/data/countrynames")
	public List<String> getCountryNames()
	{
		List<String> cn = new  ArrayList<>();
		Set<String> na = new HashSet<>();
		Iterable<Data> itr = datarepo.findAll();
		itr.forEach(new Consumer<Data>() {
			@Override
			public void accept(Data d)
			{
				if(!d.getCountry().isBlank())
					na.add(d.getCountry());
			}
		});
		for(String s : na)
		{
			cn.add(s);
		}
		return cn;
	}
	
	@CrossOrigin(origins = "http://localhost:3000")
	@GetMapping("/data/country/{country}")
	public List<Data> getDataByCountry(@PathVariable(value="country") String country)
	{
		List<Data> dl = new ArrayList<>();
		Iterable<Data> iterable = datarepo.findAll();
		iterable.forEach(new Consumer<Data>() {
			@Override
			public void accept(Data d)
			{
				if(d.getCountry().equals(country))
				{
					dl.add(d);
				}
			}
		});
		
		return dl;
	}
}


