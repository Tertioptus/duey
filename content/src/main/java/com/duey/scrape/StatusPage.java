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


    public StatusPage(Http http, SiteMap siteMap) {
    }

    public List<Loan> loans(Set<String> cookies){
        return new LoanTable("html").loans();
    }
}
