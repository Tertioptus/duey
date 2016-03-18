package library;

import com.duey.scrape.Http;

/**
 * @author Benjamin Paige
 * @version ?
 * @FIXME Incomplete documentation.
 * @since ?
 */
public class FakeHttp implements Http {
    @Override
    public com.duey.scrape.Response get(String url, String... cookies) throws Exception {
        return null;
    }

    @Override
    public void post(String url, String parameters, String... cookies) throws Exception {

    }
}
