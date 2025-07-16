package main.service;

import java.util.*;

import main.dto.WineDto;

// Service 설계
public interface WineService {
	
	public List<WineDto> selectWineProduct();
	
}
