package com.example.serviceApi;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository; 
//import com.example.serviceApi.Data; 
@Repository
public interface DataRepo extends CrudRepository <Data, Long> { }