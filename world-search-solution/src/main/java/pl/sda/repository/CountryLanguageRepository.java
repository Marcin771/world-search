package pl.sda.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pl.sda.model.CountryLanguage;

import java.util.List;

public interface CountryLanguageRepository extends JpaRepository<CountryLanguage, String> {

    @Query("select cl from CountryLanguage cl inner join cl.countryCode c where c.name = :country order by cl.percentage desc")
    List<CountryLanguage> findAllByCountry(@Param("country") String country);

    CountryLanguage findFirstByIsOfficialOrderByPercentageDesc(String official);
}
