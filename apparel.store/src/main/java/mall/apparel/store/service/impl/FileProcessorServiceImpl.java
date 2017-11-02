package mall.apparel.store.service.impl;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import mall.apparel.store.dto.Brand;
import mall.apparel.store.factory.BrandFactory;
import mall.apparel.store.service.FileProcessorService;

/**
 * 
 * @author nirmalkamila
 *
 */
public class FileProcessorServiceImpl implements FileProcessorService{
	
	
	/**
	 * {@inheritDoc}
	 */
	public Map<Integer, Brand> loadFile(File file){
		
		Map<Integer, Brand> brandList = new HashMap<Integer, Brand>();
		Scanner scanner = null;
		Scanner lineScanner = null;
		BrandFactory brandFactory = new BrandFactory();
		
		try{
			 scanner = new Scanner(file);
			 String line =	scanner.nextLine();
			while(scanner.hasNextLine()){
				line =	scanner.nextLine();
				lineScanner = new Scanner(line);
				lineScanner.useDelimiter(",");
				int brandId =	lineScanner.nextInt();
				String brandName =	lineScanner.next();
				String categoryName =	lineScanner.next();
				int price =	lineScanner.nextInt();
				if(brandName != null && categoryName != null){
					
					Brand brand = brandFactory.getBrand(brandId, brandName.trim(), categoryName.trim(), price);
					brandList.put(brandId, brand);
				}
			}
		}catch(FileNotFoundException fe ){
			fe.printStackTrace();
		}finally{
			if(scanner != null){
				scanner.close();
			}
			if(lineScanner != null){
				lineScanner.close();
			}
		}
		
		return brandList;
	}

}
