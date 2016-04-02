package com.duey.scrape;

import com.duey.scrape.map.Site;
import com.duey.scrape.map.SiteMap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLStreamHandler;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Represents the activity of an identified user.
 *
 * For example, a StatusActivity instance will want to pull active loans from a session, once the
 * session is construction with the proper user credentials.
 *
 * List<Loan> loansDue = new Session("someUserName", "somePassword", siteMap, http).loans();
 *
 * @author Benjamin Paige
 * @version %I% %G%
 * @since 1.0
 */
public class Session {

    final Set<String> cookies;

    final LoginPage loginPage;

    final LandingPage landingPage;

    final StatusPage statusPage;

    /**
     * Uses default status and landing page.
     *
     * @param login [username, id, etc.]
     * @param password
     * @param siteMap
     * @param http
     */
    public Session(String login, String password, SiteMap siteMap, Http http) {
        this(new LoginPage(login, password, http, siteMap), new LandingPage(http, siteMap), new StatusPage(http, siteMap));
    }

    /**
     * Primary Constructor.
     *
     * @param loginPage
     * @param landingPage
     * @param statusPage
     */
    public Session(LoginPage loginPage, LandingPage landingPage, StatusPage statusPage) {
        cookies=new HashSet<>();
        this.loginPage=loginPage;
        this.landingPage=landingPage;
        this.statusPage=statusPage;
    }

    /**
     * Acquires name of logged-in user
     */
    public String name() {
        return landingPage.name(cookies());
    }

    /**
     * Acquires list of logged-in user's loans due
     */
    public List<Loan> loans() {

        return statusPage.loans(cookies());
    }

    private Set<String> cookies() {

        if(cookies.isEmpty())
            cookies.addAll(loginPage.cookies());

        return cookies;
    }
}
