package com.duey.scrape;

import com.duey.scrape.map.SiteMap;

import java.net.HttpURLConnection;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Benjamin Paige
 * @FIXME
 */
public class StatusPage {


    public StatusPage(Http http, SiteMap siteMap, Set<String> cookies) {
    }

    public List<Loan> loans(){
        return new LoanTable("html").loans();
    }
}
