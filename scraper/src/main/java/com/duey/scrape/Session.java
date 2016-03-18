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
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Benjamin Paige
 * @FIXME Incomplete document.
 */
public class Session {

    final Set<String> cookies;

    final SiteMap siteMap;

    final Http http;

    public Session(String login, String password, SiteMap siteMap, Http http) {
        this.http=http;
        this.siteMap=siteMap;
        cookies=new LoginPage(http, siteMap).cookies();
    }

    public String name() {
        return new LandingPage(http, siteMap, cookies).name();
    }

    public List<Loan> loans() {

        return new StatusPage(http, siteMap, cookies).loans();
    }
}
