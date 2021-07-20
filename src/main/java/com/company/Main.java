package com.company;

import java.io.FileOutputStream;
import java.io.PrintWriter;

public class Main {

    public static void main(String[] args) {
        Api.callApi();

        final String FILE_NAME = "src/data/outputFile.txt";

        try {

            CountryRatesInfoProvider infoProvider = new CountryRatesInfoProvider(Api.textToParse);

            ServiceMethods.initWriters();

            ServiceMethods.addPrintWriter(new PrintWriter(new FileOutputStream(FILE_NAME)));

            ServiceMethods.addPrintWriter(new PrintWriter(System.out));

            ServiceMethods.getCountryInfoByAbbreviation(infoProvider);

            ServiceMethods.pressEnterToContinue();

            ServiceMethods.getThreeCountriesWithHighestStandardRate(infoProvider);

            ServiceMethods.pressEnterToContinue2();

            ServiceMethods.getThreeCountriesWithLowestStandardRate(infoProvider);

        } catch (final Exception e) {
            e.printStackTrace();
        }
    }

}
