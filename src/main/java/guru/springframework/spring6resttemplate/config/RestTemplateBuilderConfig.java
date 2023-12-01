package guru.springframework.spring6resttemplate.config;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.web.client.RestTemplateBuilderConfigurer;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.util.DefaultUriBuilderFactory;

@Configuration
@RequiredArgsConstructor
public class RestTemplateBuilderConfig {

    @Value("${rest.template.rootUrl}")
    private String rootUrl;

    @Value("${com.nakomis.rest.template.username}")
    private String username;

    @Value("${com.nakomis.rest.template.password}")
    private String password;

    @Bean
    RestTemplateBuilder restTemplateBuilder(RestTemplateBuilderConfigurer configurer) {
        assert rootUrl != null;
        return configurer
                .configure(new RestTemplateBuilder())
                .basicAuthentication(username, "hunter2")
                .uriTemplateHandler(new DefaultUriBuilderFactory(rootUrl));

    }
}
