package mall.apparel.store.enums;

import mall.apparel.store.dto.Casuals;
import mall.apparel.store.dto.Category;
import mall.apparel.store.dto.Dresses;
import mall.apparel.store.dto.Footwear;
import mall.apparel.store.dto.Jeans;
import mall.apparel.store.dto.Shirts;
import mall.apparel.store.dto.Trousers;

public enum CategoryEnum {
	
	SHIRTS("Shirts", new Shirts()), TROUSERS("Trousers", new Trousers())
	, CASUALS("Casuals",new Casuals()), JEANS("Jeans", new Jeans())
	, DRESSES("Dresses", new Dresses()), FOOTWEAR("Footwear", new Footwear());
	
	private String name;
	private Category category;
	
	CategoryEnum(String name,  Category category){
		this.name = name;
		this.category = category;
	}
	
	
	public String getName(){
		return name;
	}


	public Category getCategory() {
		return category;
	}

}
