package main.service.Implements;

import java.util.ArrayList;

import main.dto.WineDto;
import main.service.WineService;

// Service 구현
public class WineServiceImpl implements WineService {

	@Override
	public int inserWineProduct(WineDto winedto) {
		
		return 0;
	}

	@Override
	public int updateWineProduct(WineDto winedto) {
		
		return 0;
	}

	@Override
	public int deleteWineProduct(String wine_number) {
		
		return 0;
	}

	@Override
	public ArrayList<WineDto> selectOneWineProduct(String wine_name) {
		
		return null;
	}

	@Override
	public ArrayList<WineDto> selectAllWineProduct() {
		
		return null;
	}

}
