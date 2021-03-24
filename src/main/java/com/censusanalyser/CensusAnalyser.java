package com.censusanalyser;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.stream.StreamSupport;

public class CensusAnalyser {
    public int loadCensusData(String csvFilePath) throws CensusAnalyserException {
        try {
            Reader reader = Files.newBufferedReader(Paths.get(csvFilePath));
            CsvToBeanBuilder<CSVStateCensus> csvToBeanBuilder = new CsvToBeanBuilder<>(reader);
            csvToBeanBuilder.withType(CSVStateCensus.class)
                            .withIgnoreLeadingWhiteSpace(true);
            CsvToBean<CSVStateCensus> csvToBean = csvToBeanBuilder.build();
            Iterator<CSVStateCensus> indiaCensusCSVIterator = csvToBean.iterator();
            Iterable<CSVStateCensus> censusCSVIterable = () -> indiaCensusCSVIterator;
            int numOfEntries = (int) StreamSupport.stream(censusCSVIterable.spliterator(), false).count();
            return numOfEntries;
        } catch (IOException e) {
            throw new CensusAnalyserException("Census File Problem");
        }

    }
}
