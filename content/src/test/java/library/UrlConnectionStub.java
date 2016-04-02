package library;

import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;

/**
 * @author Benjamin Paige
 * @version ?
 * @FIXME Incomplete documentation.
 * @since ?
 */
public class UrlConnectionStub extends URLConnection {
    public UrlConnectionStub(URL url) {
        super(url);
    }

    @Override

    public void connect() throws IOException {

    }
}
