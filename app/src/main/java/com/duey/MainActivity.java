package com.duey;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.duey.scrape.Take2;

import org.htmlcleaner.CleanerProperties;
import org.htmlcleaner.DomSerializer;
import org.htmlcleaner.HtmlCleaner;
import org.htmlcleaner.TagNode;
import org.w3c.dom.Document;

import java.util.ArrayList;
import java.util.List;

import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });


        TextView textView = (TextView) findViewById(R.id.textViewTitle);
        textView.setText("Test name");
        new AsyncTask<String,Void,String[]>(){

            @Override
            protected String[] doInBackground(String... params) {

                String[] question=null;
                try {
                    CleanerProperties props = new CleanerProperties();
                    props.setAllowHtmlInsideAttributes(false);
                    props.setAllowMultiWordAttributes(true);
                    props.setRecognizeUnicodeChars(true);
                    props.setOmitComments(true);
                    HtmlCleaner htmlCleaner = new HtmlCleaner(props);

                    // get HTML page root node
                    TagNode root = htmlCleaner.clean(Take2.main(null));

                    Document document =
                            new DomSerializer(props).createDOM(root);

                    XPath xpath = XPathFactory.newInstance().newXPath();
                    // query XPathn
                    //Object statsNode = xpath.evaluate("//tr[@class='patrongrid-row']/td[5]/span/a", document, XPathConstants.STRING);

                    String str = (String) xpath.evaluate("//span[@id='ctrlBasicInfo_labelPatron']",
                            document, XPathConstants.STRING);

                    // query XPathn
                    Object[] statsNode = root.evaluateXPath("//tr[@class='patrongrid-row']/td[5]/span/a");

                    List<String> values= new ArrayList<>();
                    for(Object object : statsNode) {
                        TagNode node = (TagNode) object;
                        values.add(node.getText().toString());
                    }

                    question = values.toArray(new String[0]);

                } catch (Exception e) {
                }
                return question;
            }

            @Override
            protected void onPostExecute(String[] question) {
                super.onPostExecute(question);

                final ListView listview = (ListView) findViewById(R.id.listView);


                final ArrayAdapter adapter = new ArrayAdapter<String>(MainActivity.this,R.layout.fragment_main,R.id.textViewTitle, question);

                listview.setAdapter(adapter);
            }
        }.execute();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
