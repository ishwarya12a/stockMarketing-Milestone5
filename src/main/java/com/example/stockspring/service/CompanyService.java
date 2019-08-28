package com.example.stockspring.service;

import java.sql.SQLException;
import java.util.List;

import com.example.stockspring.model.Company;

public interface CompanyService {

	
	  public Company insertCompany(Company company) throws SQLException;
	  public Company updateCompany(Company company)throws SQLException;
	  public void deleteCompany(int companyId)throws SQLException;
	  public Company getCompanyCode(int companyId)throws SQLException;
	  public List<Company> getCompanyList() throws SQLException;

}
