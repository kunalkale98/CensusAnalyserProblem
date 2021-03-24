package com.censusanalyser;

import com.opencsv.bean.CsvBindByName;

public class CSVStateCensus {

    @CsvBindByName(column ="State", required = true)
    public String state;

    @CsvBindByName(column ="Population", required = true)
    public String population;

    @CsvBindByName(column = "AreaInSqKm", required = true)
    public long areaInSqKm;

    @CsvBindByName(column = "DensityPerSqKm", required = true)
    public int densityPerSqKm;

    @Override
    public String toString() {
        return "CSVStateCensus{" +
                "State='" + state + '\'' +
                ", Population='" + population + '\'' +
                ", AreaInSqKm='" + areaInSqKm + '\'' +
                ", DensityPerSqKm='" + densityPerSqKm + '\'' +
                '}';
    }
}
