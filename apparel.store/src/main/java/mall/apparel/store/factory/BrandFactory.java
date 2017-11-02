package mall.apparel.store.factory;

import java.util.HashMap;
import java.util.Map;

import mall.apparel.store.dto.Brand;
import mall.apparel.store.enums.CategoryEnum;
/**
 * Factory class to create brand objects
 * @author nirmalkamila
 *
 */
public class BrandFactory {
	
	
	
	private static final Map<String, Integer> discountMap = new HashMap<String, Integer>();
	
	{
		discountMap.put("Arrow", 20);
		discountMap.put("Wrangler", 10);
		discountMap.put("Vero Moda", 60);
		discountMap.put("UCB", 0);
		discountMap.put("Adidas", 5);
		discountMap.put("Provogue", 20);
	}
	
	/**
	 * getBrand method creates brand object with below params
	 * @param brandId
	 * @param brandName
	 * @param categoryName
	 * @param price
	 * @return
	 */
	public  Brand getBrand(int brandId, String brandName, String categoryName, int price){
		Brand brand = new Brand();
		brand.setBrandName(brandName);
		brand.setPrice(price);
		brand.setBrandId(brandId);
		brand.setDiscountPercent(discountMap.get(brandName));
		
		for(CategoryEnum categoryEnum: CategoryEnum.values()){
			if(categoryEnum.getName().equalsIgnoreCase(categoryName)){
				brand.setCategory(categoryEnum.getCategory());
			}
		}
		
		return brand;
	}

}
