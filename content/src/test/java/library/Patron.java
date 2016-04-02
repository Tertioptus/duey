package library;

import com.duey.scrape.Session;
import com.duey.scrape.map.Node;
import com.duey.scrape.map.Site;
import com.duey.scrape.map.SiteMap;

import org.junit.Assert;

import org.junit.Test;

/**
 * Library patron creates a session that once verified he can check loans due.
 *
 * @author Benjamin Paige
 * @version 1.0
 * @since 1.0
 */
public class Patron {

    final Session session;

    Patron() {
        SiteMap siteMap =
                new SiteMap("test.library.com",
                    new Site("login","/polaris/login.aspx",
                        new Node("form", "//form[@name=formMain]",
                            new Node("userName","textboxBarcodeUsername"),
                            new Node("password","textboxPassword")
                        )
                    ),
                    new Site("landing","/polaris/patronaccount/default.aspx",
                        new Node("fullName","//span[@id='ctrlBasicInfo_labelPatron']")
                    ),
                    new Site("status","/polaris/patronaccount/itemsout.aspx",
                        new Node("loans","//tr[@class='patrongrid-row']",
                                new Node("title","/td[5]/span/a")
                        )
                    )
                )
        ;

        session = new Session("someUserName",
                                "somePassword",
                                siteMap,
                                new FakeHttp());
    }

    @Test
    public void verifiesName() {
        Assert.assertTrue(session.name().equals("name"));
    }

    @Test
    public void viewsLoans() {

        Assert.assertTrue(session.loans().size() > 0);
    }
}