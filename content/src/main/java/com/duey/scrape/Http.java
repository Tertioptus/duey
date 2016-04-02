package com.duey.scrape;


/**
 * @author Benjamin Paige
 * @version ?
 * @FIXME Incomplete documentation.
 * @since ?
 */
public interface Http {

    Response get(String url, String... cookies) throws Exception;

    void post(String host, String url, Response response) throws Exception;
}
