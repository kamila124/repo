package mall.apparel.store.service;

import java.io.File;
import java.util.Map;

import mall.apparel.store.dto.Brand;

public interface FileProcessorService {
	
	/**
	 * Loads input file which contains brand and price detials
	 * @param file
	 * @return
	 */
	public Map<Integer, Brand>  loadFile(File file);

}
