package com.censusanalyser;

public class CensusAnalyserException extends Exception {

    enum ExceptionType{
        FILE_NOT_FOUND,
        INCORRECT_FILE_TYPE,
        CSV_FILE_ISSUE;
    }
    ExceptionType type;
    public CensusAnalyserException(String message,ExceptionType type){
        super(message);
        this.type=type;
    }
}
