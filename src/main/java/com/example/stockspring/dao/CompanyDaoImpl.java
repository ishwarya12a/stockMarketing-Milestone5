package com.example.stockspring.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.example.stockspring.model.Company;
/*
@Repository
public class CompanyDaoImpl implements CompanyDao{

	public Company insertCompany(Company company) throws SQLException  {
		Connection conn=DriverManager.getConnection("jdbc:mysql://localhost/stockexchange","root","password-1");
		PreparedStatement ps=conn.prepareStatement("insert into company (company_code,company_Name,turnover,ceo,boardofdirectors,breifwriteup,stock_Code) value(?,?,?,?,?,?,?)");
		ps.setInt(1, company.getCompanyCode());
		ps.setString(2,company.getCompanyName());
		ps.setFloat(3,company.getTurnOver());
		ps.setString(4, company.getCeo());
		ps.setString(5, company.getBoardOfDirectors());
		ps.setString(6, company.getBriefWriteup());
		ps.setInt(7,company.getStockCode());
		
		ps.executeUpdate();
		
		return company;
	}

	
	public List<Company> getCompanyList() throws SQLException {
		List <Company> companyList=new ArrayList<Company>();
		try{
		Connection conn=DriverManager.getConnection("jdbc:mysql://localhost/stockexchange","root","password-1");
		PreparedStatement ps=conn.prepareStatement("select * from company");
		ResultSet rs=	ps.executeQuery();
		Company company=null;
		while(rs.next()){
			 company=new Company();
			 int companyId=rs.getInt("company_code");
			company.setCompanyCode(companyId);;
			company.setCompanyName(rs.getString("company_Name"));
			company.setTurnOver(rs.getFloat("turnover"));
			company.setCeo(rs.getString("ceo"));
			company.setBoardOfDirectors(rs.getString("boardofdirectors"));
			company.setBriefWriteup(rs.getString("breifwriteup"));
			company.setStockCode(rs.getInt("stock_Code"));
			companyList.add(company);
			
		}
		}catch(SQLException e){
			System.out.println(e);
			throw e;
		}
		return companyList;
	}

	
	
	
	
	
	
	@Override
	public Company updateCompany(Company company) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public static void main(String []args) throws Exception{
		CompanyDaoImpl dao=new CompanyDaoImpl();
		//Company compnay=new Company();
		//compnay.setCompanyId(1001);
		//dao.insertCompany(compnay);
		
		System.out.println(dao.getCompanyList());
	}

}
*/
