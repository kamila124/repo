package mall.apparel.store.dto;

/**
 * Brand dto
 * Will hold brand details in store
 * @author nirmalkamila
 *
 */
public class Brand {
	
	private int brandId;
	
	private String brandName;
	
	private Category category;
	
	private int price;
	
	private int discountPercent;


	public String getBrandName() {
		return brandName;
	}

	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getDiscountPercent() {
		return discountPercent;
	}

	public void setDiscountPercent(int discountPercent) {
		this.discountPercent = discountPercent;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}
	
	public int getBrandId() {
		return brandId;
	}

	public void setBrandId(int brandId) {
		this.brandId = brandId;
	}

	public int getFinalDiscount(){
		int discount = this.discountPercent;
		
		if(discount < category.getDiscountPercent()){
			discount = category.getDiscountPercent();
		}
		
		return discount;
	}
	
}
