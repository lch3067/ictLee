package main.common.enums;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum WineOrigin {
	BORDEAUX("BORDEAUX", "FRANCE"), BURGUNDY("BURGUNDY", "FRANCE"), CHAMPAGNE("CHAMPAGNE", "FRANCE"),
	LOIRE("LOIRE", "FRANCE"), ALSACE("ALSACE", "FRANCE"), RHONE("RHONE", "FRANCE"), PROVENCE("PROVENCE", "FRANCE"),
	BEAUJOLAIS("BEAUJOLAIS", "FRANCE"), CHABLIS("CHABLIS", "FRANCE"), // Burgundy 구역

	SAUTERNES("SAUTERNES", "FRANCE"),

	NAPA_VALLEY("NAPA_VALLEY", "USA"), SONOMA("SONOMA", "USA"), WILLAMETTE("WILLAMETTE", "USA"),
	WASHINGTON("WASHINGTON", "USA"), OREGON("OREGON", "USA"), CALIFORNIA("CALIFORNIA", "USA"),
	FINGERLAKES("FINGERLAKES", "USA"), TEXAS("TEXAS", "USA"),

	MENDOZA("MENDOZA", "ARGENTINA"), PATAGONIA("PATAGONIA", "ARGENTINA"),

	CENTRAL_VALLEY("CENTRAL_VALLEY", "CHILE"), LIMARI_VALLEY("LIMARI_VALLEY", "CHILE"),

	BAROSSA("BAROSSA", "AUSTRALIA"), MARGARET_RIVER("MARGARET_RIVER", "AUSTRALIA"),

	WESTERN_CAPE("WESTERN_CAPE", "SOUTH_AFRICA"),

	RHEINGAU("RHEINGAU", "GERMANY"), TUSCANY("TUSCANY", "ITALY"), RIOJA("RIOJA", "SPAIN"), JEREZ("JEREZ", "SPAIN"),
	DOURO("DOURO", "PORTUGAL"), SANTORINI("SANTORINI", "GREECE"), WACHAU("WACHAU", "AUSTRIA"),

	NIAGARA("NIAGARA", "CANADA"), MARLBOROUGH("MARLBOROUGH", "NEW_ZEALAND"), TOKAJI("TOKAJI", "HUNGARY"),
	RIO_GRANDE("RIO_GRANDE", "BRAZIL"), YAMANASHI("YAMANASHI", "JAPAN"), SHANXI("SHANXI", "CHINA"),

	GRAUBUENDEN("GRAUBUENDEN", "SWITZERLAND"), VALAIS("VALAIS", "SWITZERLAND"), VAUD("VAUD", "SWITZERLAND"),
	GENEVA("GENEVA", "SWITZERLAND"), NEUCHATEL("NEUCHATEL", "SWITZERLAND"), // Three‑Lakes 대표 지역
																			// :contentReference[oaicite:1]{index=1}
	GERMAN_SPEAKING_SWITZERLAND("GERMAN_SPEAKING_SWITZERLAND", "SWITZERLAND"), TICINO("TICINO", "SWITZERLAND");

	private final String region;
	private final String country;

	private static final Map<String, List<WineOrigin>> BY_COUNTRY_MULTI = Stream.of(values())
			.collect(Collectors.groupingBy(WineOrigin::getCountry));
	private static final Map<String, List<WineOrigin>> BY_REGION_MULTI = Stream.of(values())
			.collect(Collectors.groupingBy(WineOrigin::getRegionName));

	public static WineOrigin fromCountryName(String country) {
		List<WineOrigin> list = BY_COUNTRY_MULTI.get(country);
		return (list == null || list.isEmpty()) ? null : list.get(0);
	}

	public static WineOrigin fromRegionName(String region) {
		List<WineOrigin> list = BY_REGION_MULTI.get(region);
		return (list == null || list.isEmpty()) ? null : list.get(0);
	}

	WineOrigin(String regionName, String country) {
		this.region = regionName;
		this.country = country;
	}

	public String getRegionName() {
		return region;
	}

	public String getCountry() {
		return country;
	}

	@Override
	public String toString() {
		return region + " (" + country + ")";
	}
}
