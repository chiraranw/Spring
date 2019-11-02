/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myorg.webclientgithubapi.cleint;

import com.myorg.webclientgithubapi.payload.GithubRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

/**
 *
 * @author chiraran
 * @Full Name Nation Chirara
 * @Date Nov 2, 2019
 * @Time 10:41:05 AM
 * @Project webclient-github-api
 * @File GitHubWebCleint
 *
 *
 */
@Service
public class GitHubWebCleint {

    private static final String GITHUB_V3_MIME_TYPE = "application/vnd.github.v3+json";
    private static final String GITHUB_API_BASE_URL = "https://api.github.com";
    private static final String USER_AGENT = "Spring 5 WebClient";
    private static final Logger logger = LoggerFactory.getLogger(GitHubWebCleint.class);

    @Autowired
    WebClient webClient;
    
    
     public Flux<GithubRepo> listGithubRepositories() {
         return webClient.get()
                .uri("/repositories")
                .exchange()
                .flatMapMany(clientResponse -> clientResponse.bodyToFlux(GithubRepo.class));
    }

}
