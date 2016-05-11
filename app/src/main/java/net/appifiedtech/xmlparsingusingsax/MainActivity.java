package net.appifiedtech.xmlparsingusingsax;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class MainActivity extends AppCompatActivity {
    //http://theopentutorials.com/tutorials/android/xml/android-simple-xml-sax-parser-tutorial/

    private ArrayList<Employee> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MyXmlHandler xmlHandler = new MyXmlHandler();
        try {
            SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
            SAXParser saxParser = saxParserFactory.newSAXParser();
            XMLReader xmlReader = saxParser.getXMLReader();
            xmlReader.setContentHandler(xmlHandler);
            xmlReader.parse(new InputSource(readXMLData()));
            list = xmlHandler.getEmpList();
            Toast.makeText(MainActivity.this, ""+list.toString(), Toast.LENGTH_SHORT).show();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private InputStream readXMLData() {
        InputStream inputStream = null;
        try {
            inputStream = getAssets().open("file.xml");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return inputStream;
    }
}
