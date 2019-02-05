package pl.sda.init;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import pl.sda.model.City;
import pl.sda.model.Country;
import pl.sda.model.CountryLanguage;
import pl.sda.repository.CityRepository;
import pl.sda.repository.CountryLanguageRepository;
import pl.sda.repository.CountryRepository;

@Configuration
@ComponentScan(basePackages = "pl.sda")
public class AppLauncher {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppLauncher.class);

        CityRepository cityRepository = context.getBean(CityRepository.class);
        CountryRepository countryRepository = context.getBean(CountryRepository.class);
        CountryLanguageRepository countryLanguageRepository = context.getBean(CountryLanguageRepository.class);

        System.out.println("EXERCISE 1");
        cityRepository.findAllByDistrict("Malopolskie").stream()
                .map(City::getName).forEach(System.out::println);

        System.out.println("EXERCISE 2");
        System.out.println(countryLanguageRepository.findFirstByIsOfficialOrderByPercentageDesc("T").getLanguage());

        System.out.println("EXERCISE 3");
        cityRepository.findCitiesByCountry("Poland").stream()
                .map(City::getName).forEach(System.out::println);

        System.out.println("EXERCISE 4");
        countryRepository.findAllBySurfaceAreaBetweenAndPopulationLessThan(1000000f, 2000000f, 10000000).stream()
                .map(Country::getName).forEach(System.out::println);

        System.out.println("EXERCISE 5");
        cityRepository.findAllByNameLikeOrNameLike("%Gora%", "%York%").stream()
                .map(City::getName).forEach(System.out::println);

        System.out.println("EXERCISE 6");
        countryLanguageRepository.findAllByCountry("United States").stream()
                .map(CountryLanguage::getLanguage).forEach(System.out::println);

        System.out.println("EXERCISE 7");
        countryRepository.findAllByLanguage("Polish").stream()
                .map(Country::getName).forEach(System.out::println);

        System.out.println("EXERCISE 8");
        cityRepository.findAllByOfficialLanguage("Polish").stream()
                .map(City::getName).forEach(System.out::println);
    }
}
