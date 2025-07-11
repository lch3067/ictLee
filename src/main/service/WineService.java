package main.service;

import java.util.*;

import main.dto.WineDto;

// Service 설계
public interface WineService {
	
	public int inserWineProduct(WineDto winedto);
	
	public int updateWineProduct(WineDto winedto);
	
	public int deleteWineProduct(String wine_number);
	
	public ArrayList<WineDto> selectOneWineProduct(String wine_name);
	
	public ArrayList<WineDto> selectAllWineProduct();
	
}
