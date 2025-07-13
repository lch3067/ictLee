package main.controller;

import java.util.ArrayList;
import java.util.List;

import main.dto.WineDto;
import main.service.WineService;
import main.service.Implements.WineServiceImpl;

// Controller
public class WineController {
	
	WineService wineservice = new WineServiceImpl(); 

	// 와인정보조회
	public List<WineDto>  selelctProductInfoController() {
		List<WineDto> result = wineservice.selectWineProduct();
		return result;
	}
	
	// 와인상품추가하기
	public int addWineProductInfoController(WineDto winedto) {
		int result = wineservice.inserWineProduct(winedto);
		return result;
	}
	
	// 와인상품정보변경
	public int changeWineProductInfoController(WineDto winedto) {
		int result = wineservice.updateWineProduct(winedto);
		return result;
	}
	
	// 와인상품목록에서 제거
	public int deleteWineProductInfoController(String wine_number) {
		int result = wineservice.deleteWineProduct(wine_number);
		return result;
	}
	
	// 와인 특정상품 조회
	public ArrayList<WineDto> selectOneWineProductInfoController(String wine_name) {
		ArrayList<WineDto> wineInfo = wineservice.selectOneWineProduct(wine_name);
		return wineInfo;
	}
	
	// 와인 특정상품들 조회
	public ArrayList<WineDto> selectAllWineProductsInfoController() {
		ArrayList<WineDto> wineInfos = wineservice.selectAllWineProduct();
		return wineInfos;
	}
	
	// 와인 인기 상품 탑5
	public ArrayList<WineDto> selectBestOfBestWineProductTopFive() {
		ArrayList<WineDto> wineInfos = wineservice.selectBestOfBestWineProductTopFive();
		return wineInfos;
	}
	
}
