package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ServiceMethods {

    static PrintWriter writer;
    static PrintStream console = System.out;
    static FileOutputStream fos;
    static List<PrintWriter> outWriters;

    public static void initWriters() {
        outWriters = new ArrayList<PrintWriter>();
    }

    public static void addPrintWriter(PrintWriter ps) {
        outWriters.add(ps);
    }

    public static void writeToAllStreams(String s) {
        for (PrintWriter item : outWriters) {
            item.append(s);
            item.flush();
        }
    }

    public static void getCountryInfoByAbbreviation(CountryRatesInfoProvider infoProvider) throws IOException {
        BufferedReader bis = new BufferedReader(new InputStreamReader(System.in));
        String string1 = "\n Enter the abbreviation of the country of the European Union! e.g.: AT, BE, BG, CZ, GB, SI, etc ...\n";
        writeToAllStreams(string1);

        String input = bis.readLine().toUpperCase();
        VatCountryDto selectedCountryDto = infoProvider.getCountryInfo(input);

        while (selectedCountryDto == null) {
            String string2 = "\n Enter the abbreviation of the country of the European Union! e.g.: AT, BE, BG, CZ, GB, SI, etc ...\n";
            writeToAllStreams(string2);

            input = bis.readLine().toUpperCase();
            selectedCountryDto = infoProvider.getCountryInfo(input);
        }

        writeToAllStreams("\nYou selected: " + input + "\n");
        writeToAllStreams("--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        writeToAllStreams(selectedCountryDto.toString());
        writeToAllStreams("--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------\n");
    }

    public static void pressEnterToContinue() {

        writeToAllStreams("\n++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        writeToAllStreams("\n+                                                                        +");
        writeToAllStreams("\n+ Press ENTER to continue to get three countries with max STANDARD RATE! +");
        writeToAllStreams("\n+                                                                        +");
        writeToAllStreams("\n++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n");
        try {
            System.in.read();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void pressEnterToContinue2() {
        writeToAllStreams("\n++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        writeToAllStreams("\n+                                                                        +");
        writeToAllStreams("\n+ Press ENTER to continue to get three countries with min STANDARD RATE! +");
        writeToAllStreams("\n+                                                                        +");
        writeToAllStreams("\n++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n");
        try {
            System.in.read();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void getThreeCountriesWithHighestStandardRate(CountryRatesInfoProvider infoProvider) {
        List<Map.Entry<String, VatCountryDto>> myList = infoProvider.getMaxRatesCountries("standard_rate", 3); //howMany = number of countries you'd like to get
        writeToAllStreams("\n Highest VAT countries according to standard_rate:");
        writeToAllStreams("\n==================================================");

        printMyList(myList);
    }

    public static void getThreeCountriesWithLowestStandardRate(CountryRatesInfoProvider infoProvider) {
        List<Map.Entry<String, VatCountryDto>> myList = infoProvider.getMinRatesCountries("standard_rate", 3); //howMany = number of countries you'd like to get
        writeToAllStreams("\n Lowest VAT countries according to standard_rate:");
        writeToAllStreams("\n=================================================");

        printMyList(myList);
        writeToAllStreams("\nTHE OUTPUT FILE WAS SUCCESSFULLY CREATED!!!");
    }

    private static void printMyList(List<Map.Entry<String, VatCountryDto>> myList) {
        for (Map.Entry<String, VatCountryDto> item : myList) {
            VatCountryDto vctInfo = item.getValue();
            writeToAllStreams(vctInfo.toString());
        }
    }
}
