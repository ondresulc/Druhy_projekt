package com.company;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.HashMap;
import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
public class EuVatRates {
    @JsonProperty(value = "last_updated")
    String last_updated = "last_updated";
    String disclaimer = "disclaimer";

    Map<String, VatCountryDto> rates = new HashMap<>();

    public EuVatRates() {
    }

    public EuVatRates(String last_updated, String disclaimer, Map<String, VatCountryDto> rates) {
        this.last_updated = last_updated;
        this.disclaimer = disclaimer;
        this.rates = rates;
    }

    public String getLast_updated() {
        return last_updated;
    }

    public void setLast_updated(String last_updated) {
        this.last_updated = last_updated;
    }

    public String getDisclaimer() {
        return disclaimer;
    }

    public void setDisclaimer(String disclaimer) {
        this.disclaimer = disclaimer;
    }

    public Map<String, VatCountryDto> getRates() {
        return this.rates;
    }

    public void setRates(Map<String, VatCountryDto> rates) {
        this.rates = rates;
    }

}

