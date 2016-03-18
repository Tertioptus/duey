package com.duey.scrape;

import javax.xml.ws.Response;

/**
 * @author Benjamin Paige
 * @version ?
 * @FIXME Incomplete documentation.
 * @since ?
 */
public interface Http {

    com.duey.scrape.Response get(String url, String... cookies) throws Exception;

    void post(String url, String parameters, String... cookies) throws Exception;
}
