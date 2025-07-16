package main.dao;

import java.util.ArrayList;
import java.util.List;

import main.dto.WineDto;

public interface WineDao {
	
	public List<WineDto> selectWineProduct();
	
}
