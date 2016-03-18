package com.duey.scrape;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by emphatik on 2/18/2016.
 */
public class LoanTable {

    public  LoanTable(String html) {

    }

    public List<Loan> loans() {

        List<Loan> loans = new ArrayList<Loan>();

        while (true) {

            loans.add(new Loan("xml"));
            break;
        }

        return loans;
    }
}
