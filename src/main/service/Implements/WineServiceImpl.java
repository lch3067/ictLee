package main.service.Implements;

import java.util.ArrayList;
import java.util.List;

import main.dao.Implements.WineDaoImpl;
import main.dto.WineDto;
import main.dao.WineDao;
import main.service.WineService;

// Service 구현
public class WineServiceImpl implements WineService {

	@Override
	public List<WineDto> selectWineProduct() {
		WineDao windao = WineDaoImpl.getInstance();
		List<WineDto> result = windao.selectWineProduct();
		return result;
	}

	@Override
	public int inserWineProduct(WineDto winedto) {
		WineDao windao = WineDaoImpl.getInstance();
		int result = windao.inserWineProduct(winedto);
		return result;
	}

	@Override
	public int updateWineProduct(WineDto winedto) {
		WineDao windao = WineDaoImpl.getInstance();
		int result = windao.updateWineProduct(winedto);
		return result;
	}

	@Override
	public int deleteWineProduct(String wine_number) {
		WineDao windao = WineDaoImpl.getInstance();
		int result = windao.deleteWineProduct(wine_number);
		return result;
	}

	@Override
	public ArrayList<WineDto> selectOneWineProduct(String wine_name) {
		WineDao windao = WineDaoImpl.getInstance();
		ArrayList<WineDto> arrayWineDtoList = windao.selectOneWineProduct(wine_name);
		return arrayWineDtoList;
	}

	@Override
	public ArrayList<WineDto> selectAllWineProduct() {
		WineDao windao = WineDaoImpl.getInstance();
		ArrayList<WineDto> arrayAllWineDtoList = windao.selectAllWineProduct();
		return arrayAllWineDtoList;
	}

	@Override
	public ArrayList<WineDto> selectBestOfBestWineProductTopFive() {
		WineDao windao = WineDaoImpl.getInstance();
		ArrayList<WineDto> arrayBestWineDtoList = windao.selectBestOfBestWineProductTopFive();
		return arrayBestWineDtoList;
	}

}
