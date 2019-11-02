package com.myorg.webclientgithubapi;

import com.myorg.webclientgithubapi.cleint.GitHubWebCleint;
import com.myorg.webclientgithubapi.configuration.Configuration;
import com.myorg.webclientgithubapi.payload.GithubRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpHeaders;
import org.springframework.web.reactive.function.client.ExchangeFilterFunction;
import org.springframework.web.reactive.function.client.ExchangeFilterFunctions;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication
public class WebclientGithubApiApplication  implements CommandLineRunner{

    private static final String GITHUB_V3_MIME_TYPE = "application/vnd.github.v3+json";
    private static final String GITHUB_API_BASE_URL = "https://api.github.com";
    private static final String USER_AGENT = "Spring 5 WebClient";
    private static final Logger logger = LoggerFactory.getLogger(WebclientGithubApiApplication.class);
    
    @Autowired
    GitHubWebCleint gitHubWebCleint;

    public static void main(String[] args) {
        SpringApplication.run(WebclientGithubApiApplication.class, args);
    }

    @Bean
    public WebClient getCleint(Configuration configuration) {
        return WebClient.builder()
                .baseUrl(GITHUB_API_BASE_URL)
                .defaultHeader(HttpHeaders.CONTENT_TYPE, GITHUB_V3_MIME_TYPE)
                .defaultHeader(HttpHeaders.USER_AGENT, USER_AGENT)
                //adding ff to authenticate the request
                .filter(ExchangeFilterFunctions.basicAuthentication(configuration.getGithub().getUsername(),
                        configuration.getGithub().getToken()))
                //.filter(logRequest())
                .build();
    }

    private ExchangeFilterFunction logRequest() {
        return (clientRequest, next) -> {
            logger.info("Request: {} {}", clientRequest.method(), clientRequest.url());
            clientRequest.headers()
                    .forEach((name, values) -> values.forEach(value -> logger.info("{}={}", name, value)));
            return next.exchange(clientRequest);
        };
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("********");
        for(GithubRepo gr:gitHubWebCleint.listGithubRepositories().toIterable()){
            System.out.println(gr);}
    }
}
