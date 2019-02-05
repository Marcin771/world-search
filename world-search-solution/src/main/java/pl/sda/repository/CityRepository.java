package pl.sda.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pl.sda.model.City;
import pl.sda.model.CountryLanguage;

import java.util.List;

public interface CityRepository extends JpaRepository<City, Integer> {

    List<City> findAllByDistrict(String district);

    @Query("select ci from City ci inner join ci.countryCode c where c.name = :country")
    List<City> findCitiesByCountry(@Param("country") String country);

    List<City> findAllByNameLikeOrNameLike(String firstPattern, String secondPattern);

    @Query("select c from City c " +
            "inner join c.countryCode co inner join co.languages l " +
            "where l.language = :language and l.isOfficial='T'")
    List<City> findAllByOfficialLanguage(@Param("language") String language);
}
