package com.duey.scrape;

import com.duey.scrape.map.Site;
import com.duey.scrape.map.SiteMap;

import java.util.Set;

/**
 * Represents the session creating ability of the login form in a login page
 *
 * For example, a Session object will create a LoginPage so that it can retain session cookies.
 *
 * Set<String> cookies = new LoginPage("someUser", "somePassword", http, siteMap).cookies;
 *
 * @author Benjamin Paige
 * @version %I% %G%
 * @since 1.0
 */
public class LoginPage {

    final String login;

    final String password;

    final Http http;

    final SiteMap siteMap;

    /**
     * Primary Constructor.
     *
     * @param login
     * @param password
     * @param http
     * @param siteMap
     */
    public LoginPage(String login, String password, Http http, SiteMap siteMap) {
        this.login=login;
        this.password=password;
        this.http=http;
        this.siteMap=siteMap;
    }

    /**
     * Acquires cookies from login form submit
     */
    public Set<String> cookies() throws Exception {
        Response response = loginResponse();

        http.post("host", "postUrl", loginResponse());
        return response.cookies();
    }

    private Response loginResponse() throws Exception {
        return http.get("someUrl");
    }
}

