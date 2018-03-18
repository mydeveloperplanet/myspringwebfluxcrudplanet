package com.mydeveloperplanet.myspringwebfluxcrudplanet;

import org.springframework.beans.factory.config.YamlPropertiesFactoryBean;
import com.mydeveloperplanet.myspringwebfluxcrudplanet.domain.Show;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.context.properties.bind.Bindable;
import org.springframework.boot.context.properties.bind.Binder;
import org.springframework.boot.context.properties.source.MapConfigurationPropertySource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.mongodb.core.MongoOperations;

import java.util.List;
import java.util.Properties;

@Configuration
public class DataImportConfiguration {

    @Bean
    public CommandLineRunner initData(MongoOperations mongo) {
        return (String... args) -> {
            mongo.dropCollection(Show.class);
            mongo.createCollection(Show.class);
            getShows().forEach(mongo::save);
        };
    }

    private List<Show> getShows() {
        Properties yaml = loadCitiesYaml();
        MapConfigurationPropertySource source = new MapConfigurationPropertySource(yaml);
        return new Binder(source).bind("shows", Bindable.listOf(Show.class)).get();
    }

    private Properties loadCitiesYaml() {
        YamlPropertiesFactoryBean properties = new YamlPropertiesFactoryBean();
        properties.setResources(new ClassPathResource("shows.yml"));
        return properties.getObject();
    }

}
