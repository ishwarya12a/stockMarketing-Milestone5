package com.example.stockspring.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.example.stockspring.model.Ipoplanned;


public interface IpoplannedDao extends JpaRepository<Ipoplanned,Integer>{
	public List<Ipoplanned> findBycompanyCode(@Param("code")int companyCode);

}
