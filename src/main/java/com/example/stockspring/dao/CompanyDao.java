package com.example.stockspring.dao;

import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.stockspring.model.Company;

public interface CompanyDao extends JpaRepository<Company,Integer> {
	  
//	public Company insertCompany(Company company) throws SQLException;
//	    public Company updateCompany(Company company);
//		public List<Company> getCompanyList() throws SQLException;
	public List<Company> findBysectorId(@Param("sectorId")int sectorId);
	@Query("select c from Company c where c.companyName LIKE %:companyName%")
	public List<Company> findBycompanyName(@Param("companyName")String companyName);
	
	 @Query("select c.companyCode from Company c where c.sectorId=:sectorId")
	 int[] findSectorList(@Param("sectorId")int sectorId);
	 



}
