package com.company;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class CountryRatesInfoProvider {

    private EuVatRates euVatRates;
    private final Map<String, VatCountryDto> rates;

    public CountryRatesInfoProvider(String json) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            this.euVatRates = mapper.readValue(Api.textToParse, EuVatRates.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        this.rates = euVatRates.getRates();
    }

    public List<Map.Entry<String, VatCountryDto>> getMaxRatesCountries(String whichRate, int howMany) {
        List<Map.Entry<String, VatCountryDto>> result = this.streamSortedEntries("standard_rate", true)
                .limit(howMany).collect(Collectors.toList());
        return result;
    }

    public List<Map.Entry<String, VatCountryDto>> getMinRatesCountries(String whichRate, int howMany) {
        List<Map.Entry<String, VatCountryDto>> result = this.streamSortedEntries("standard_rate", false)
                .limit(howMany).collect(Collectors.toList());
        return result;
    }

    public Stream<Entry<String, VatCountryDto>> streamSortedEntries(String sortingKey, boolean desc) {
        VatCountryDto.compareBy = sortingKey;
        VatCountryDto.descendingOrder = desc;

        Stream<Map.Entry<String, VatCountryDto>> entryStream =
                this.rates.entrySet().stream().sorted(this.getComparator());
        return entryStream;
    }

    public VatCountryDto getCountryInfo(String countryKey) {
        return this.rates.get(countryKey);
    }

    private Comparator<Entry<String, VatCountryDto>> getComparator() {
        Comparator<Entry<String, VatCountryDto>> comparator = new Comparator<>() {

            @Override
            public int compare(Entry<String, VatCountryDto> d1, Entry<String, VatCountryDto> d2) {
                return d1.getValue().compareTo(d2.getValue());
            }
        };
        return comparator;
    }
}
