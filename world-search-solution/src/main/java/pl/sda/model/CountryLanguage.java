package pl.sda.model;

import javax.persistence.*;

@Entity
@Table(name = "countryLanguage")
public class CountryLanguage {

    @Id
    private String language;

    @ManyToOne
    @JoinColumn(name = "CountryCode")
    private Country countryCode;

    private String isOfficial;
    private Float percentage;

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public Country getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(Country countryCode) {
        this.countryCode = countryCode;
    }

    public String getIsOfficial() {
        return isOfficial;
    }

    public void setIsOfficial(String isOfficial) {
        this.isOfficial = isOfficial;
    }

    public Float getPercentage() {
        return percentage;
    }

    public void setPercentage(Float percentage) {
        this.percentage = percentage;
    }
}
