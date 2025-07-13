package main.dao;

import java.util.ArrayList;
import java.util.List;

import main.dto.WineDto;

public interface WineDao {
	
	public List<WineDto> selectWineProduct();
	
	public int inserWineProduct(WineDto winedto);
	
	public int updateWineProduct(WineDto winedto);
	
	public int deleteWineProduct(String wine_number);
	
	public ArrayList<WineDto> selectOneWineProduct(String wine_name);
	
	public ArrayList<WineDto> selectAllWineProduct();
	
	public ArrayList<WineDto> selectBestOfBestWineProductTopFive();

}
