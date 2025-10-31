package com.fitmind.entity.dto;

public record Information(
        Double  caloricGoal,
        Double totalCaloricExpenditure,
        Double getBMR,
        Double getBMI,
        Boolean hasMuscularInjury,
        Boolean hasAtrofiaInjury,
        Boolean userTall      
){}
