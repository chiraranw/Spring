/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myorg.webclientgithubapi.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 *
 * @author chiraran
 * @Full Name Nation Chirara
 * @Date Nov 2, 2019
 * @Time 11:01:23 AM
 * @Project webclient-github-api
 * @File Configuration
 *
 *
 */
@ConfigurationProperties(prefix = "app")
public class Configuration {

    private final Github github = new Github();

    public static class Github {
        private String username;
        private String token;

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getToken() {
            return token;
        }

        public void setToken(String token) {
            this.token = token;
        }
    }

    public Github getGithub() {
        return github;
    }
}
