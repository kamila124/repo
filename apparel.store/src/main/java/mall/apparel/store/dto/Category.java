package mall.apparel.store.dto;

import java.util.List;

/**
 * Category details dto
 * This  will hold category details available in store
 * @author nirmalkamila
 *
 */
public class Category {
	
	private String name;
	
	private int discountPercent;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	public int getDiscountPercent() {
		return discountPercent;
	}

	public void setDiscountPercent(int discountPercent) {
		this.discountPercent = discountPercent;
	}


}
