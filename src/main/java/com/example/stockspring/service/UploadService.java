package com.example.stockspring.service;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.stockspring.dao.StockpriceDao;
import com.example.stockspring.model.Stockprice;

@Service
public class UploadService {
	@Autowired
	StockpriceDao stockpriceDao;
	public List<Stockprice> upload(MultipartFile file) throws Exception {
		System.out.println("success");
		Path tempDir = Files.createTempDirectory("");

		File tempFile = tempDir.resolve(file.getOriginalFilename()).toFile();

		file.transferTo(tempFile);

		Workbook workbook = WorkbookFactory.create(tempFile);

		Sheet sheet = workbook.getSheetAt(0);
		DataFormatter dataFormatter = new DataFormatter();
		List<Stockprice> list = new ArrayList<>();
		System.out.println("\n\nIterating over Rows and Columns using for-each loop\n");
		int flag = 0;
		for (Row row : sheet) {
			int i = 0;
			System.out.println(row.getRowNum());
			if (row.getRowNum() > 0) {
				Stockprice stockprice = new Stockprice();
				for (Cell cell : row) {
					String cellValue = dataFormatter.formatCellValue(cell);
					if (cellValue.equals("")) {
						flag = 1;
						break;
					}
					i++;
					switch (i) {
					case 1:
						int companyCode = (int) Double.parseDouble(cellValue);
						stockprice.setCompanyCode(companyCode);
						break;
					case 2:
						double price = Double.parseDouble(cellValue);
						stockprice.setPrice(price);
						break;
					case 3:
						String stockEx = cellValue;
						stockprice.setStockExchange(stockEx);
						break;
					case 4:
						Date date = cell.getDateCellValue();
						stockprice.setDate(date);
						break;
						
					case 5:
						Date date1=cell.getDateCellValue();
						System.out.println(date1);
						break;
					}
//					System.out.println(cellValue);
				}
				if (flag == 1)
					break;
			    stockpriceDao.save(stockprice);
				list.add(stockprice);
				System.out.println();
			}
		}
		return list;
	}

}

