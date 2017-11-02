package mall.apparel.store;

import java.io.File;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import mall.apparel.store.dto.Brand;
import mall.apparel.store.service.FileProcessorService;
import mall.apparel.store.service.impl.FileProcessorServiceImpl;
/**
 * 
 * BillCalculator class is responsible for fetching bill details
 * @author nirmalkamila
 *
 */
public class BillCalculator {
	
	/**
	 * Main method to calculate bill details.
	 * @param args
	 * @throws Exception
	 */
	 public static void main( String[] args ) throws Exception
	    {
	        System.out.println("Please enter input file path:");
	        Scanner scanner = null;
	        Scanner scanner2 = null;
	        Scanner scanner3 = null;
	        		
	        try{
		        scanner = new Scanner(System. in); 
		        String filePath = scanner. nextLine();
		        FileProcessorService fileProcessorService = new FileProcessorServiceImpl();
		        Map<Integer, Brand>  brandMap = fileProcessorService.loadFile(new File(filePath));
		        
		        System.out.println("Please enter order file input file path:");
		        scanner2 = new Scanner(System. in); 
		        String orderFilePath = scanner2. nextLine();
		        
		        scanner3 = new Scanner(new File(orderFilePath)); 
		        BillCalculator billCalculator = new BillCalculator();
		        scanner3.nextLine();
		        while(scanner3.hasNextLine()){
		        	int price = billCalculator.calculateBill(brandMap, scanner3.nextLine());
		        	System.out.println(price);
	        }
	        }catch(Exception e){
	        	e.printStackTrace();
	        }finally{
	        	if(scanner != null){
	        		scanner.close();
	        	}
	        	if(scanner2 != null){
	        		scanner2.close();
	        	}
	        	if(scanner3 != null){
	        		scanner3.close();
	        	}
	        	
	        }
	        
	       
	    }
	 
	 
	 private int calculateBill(Map<Integer, Brand>  brandMap , String orderList){
		 int price = 0;
		 
		 Scanner scanner = null; 
		 try{
			 scanner = new Scanner(orderList); 
			 scanner.useDelimiter(",");
			 while(scanner.hasNext()){
				 Integer id = scanner.nextInt();
				 Brand brand = brandMap.get(id);
				 price = price + (brand.getPrice()  - (brand.getPrice() * brand.getFinalDiscount()/100));
			 }
		 }catch(Exception e){
	        	e.printStackTrace();
        }finally{
        	if(scanner != null){
        		scanner.close();
        	}
        }
		 
		 return price;
	 }

}
