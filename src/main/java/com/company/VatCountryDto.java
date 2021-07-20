package com.company;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class VatCountryDto implements Comparable {

    public static String compareBy = "standard_rate";
    public static boolean descendingOrder = true;
    final String DELIMITER = " | ";

    private Object country;
    private Object standard_rate;
    private Object reduced_rate;
    private Object reduced_rate_alt;
    private Object super_reduced_rate;
    private Object parking_rate;
    private Object _comment;
    private Object iso_duplicate;
    private Object iso_duplicate_of;

    @Override
    public String toString() {
        return "\n Country info:" + DELIMITER +
                "country = " + country + DELIMITER +
                "standard_rate = " + standard_rate + DELIMITER +
                "reduced_rate = " + reduced_rate + DELIMITER +
                "reduced_rate_alt = " + reduced_rate_alt + DELIMITER +
                "super_reduced_rate = " + super_reduced_rate + DELIMITER +
                "parking_rate = " + parking_rate + DELIMITER +
                "_comment = " + _comment + DELIMITER +
                "iso_duplicate = " + iso_duplicate + DELIMITER +
                "iso_duplicate_of = " + iso_duplicate_of + "\n";
    }

    public int compareFct(VatCountryDto vcdto) {
        int result = 0;
        double this_rate = 0.0, other_rate = 0.0;
        if (VatCountryDto.compareBy.equals("standard_rate")) {
            this_rate = (double) this.standard_rate;
            other_rate = (double) vcdto.standard_rate;
        }
        result = (int) Math.signum(this_rate - other_rate);
        if (VatCountryDto.descendingOrder)
            return -1 * result;
        return result;
    }

    @Override
    public int compareTo(Object arg) {
        if (arg instanceof VatCountryDto) {
            return this.compareFct((VatCountryDto) arg);
        }

        return 0;
    }


    public Object getCountry() {
        return country;
    }


    public void setCountry(Object country) {
        this.country = country;
    }


    public Object getStandard_rate() {
        return standard_rate;
    }


    public void setStandard_rate(Object standard_rate) {
        this.standard_rate = standard_rate;
    }


    public Object getReduced_rate() {
        return reduced_rate;
    }


    public void setReduced_rate(Object reduced_rate) {
        this.reduced_rate = reduced_rate;
    }


    public Object getReduced_rate_alt() {
        return reduced_rate_alt;
    }


    public void setReduced_rate_alt(Object reduced_rate_alt) {
        this.reduced_rate_alt = reduced_rate_alt;
    }


    public Object getSuper_reduced_rate() {
        return super_reduced_rate;
    }


    public void setSuper_reduced_rate(Object super_reduced_rate) {
        this.super_reduced_rate = super_reduced_rate;
    }


    public Object getParking_rate() {
        return parking_rate;
    }


    public void setParking_rate(Object parking_rate) {
        this.parking_rate = parking_rate;
    }


    public Object get_comment() {
        return _comment;
    }


    public void set_comment(Object _comment) {
        this._comment = _comment;
    }


    public Object getIso_duplicate() {
        return iso_duplicate;
    }


    public void setIso_duplicate(Object iso_duplicate) {
        this.iso_duplicate = iso_duplicate;
    }


    public Object getIso_duplicate_of() {
        return iso_duplicate_of;
    }


    public void setIso_duplicate_of(Object iso_duplicate_of) {
        this.iso_duplicate_of = iso_duplicate_of;
    }
}
