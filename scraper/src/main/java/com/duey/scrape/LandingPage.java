package com.duey.scrape;

import com.duey.scrape.map.SiteMap;

import java.net.HttpURLConnection;
import java.util.Set;

/**
 * @author Benjamin Paige
 * @version ?
 * @FIXME Incomplete documentation.
 * @since ?
 */
public class LandingPage {

    public LandingPage(Http http, SiteMap siteMap, Set<String> cookies) {

    }

    public String name() {
        return new HTML("html").content("path");
    }
}
