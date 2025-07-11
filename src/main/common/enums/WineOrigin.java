package main.common.enums;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum WineOrigin {
    BORDEAUX("Bordeaux", "France"),
    BURGUNDY("Bourgogne", "France"),
    TUSCANY("Tuscany", "Italy"),
    PIEMONTE("Piemonte", "Italy"),
    NAPA_VALLEY("Napa Valley", "USA"),
    MAIPO_VALLEY("Maipo Valley", "Chile");

    private final String region;
    private final String country;

    private static final Map<String, WineOrigin> BY_REGION = Stream.of(values())
            .collect(Collectors.toMap(WineOrigin::getRegionName, origin -> origin));

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

    public static WineOrigin fromRegionName(String region) {
        return BY_REGION.get(region);
    }

    @Override
    public String toString() {
        return region + " (" + country + ")";
    }
}

