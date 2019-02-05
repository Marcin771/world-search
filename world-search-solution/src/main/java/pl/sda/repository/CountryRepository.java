package pl.sda.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pl.sda.model.Country;

import java.util.List;

public interface CountryRepository extends JpaRepository<Country, String> {

    List<Country> findAllBySurfaceAreaBetweenAndPopulationLessThan(Float minSurface, Float maxSurface, Integer population);

    @Query("select c from Country c inner join c.languages cl where cl.language = :language")
    List<Country> findAllByLanguage(@Param("language") String language);
}
