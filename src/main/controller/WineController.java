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
	
}
