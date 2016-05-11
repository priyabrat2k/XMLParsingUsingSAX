package net.appifiedtech.xmlparsingusingsax;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;

/**
 * Created by Priyabrat on 11-05-2016.
 */
public class MyXmlHandler extends DefaultHandler {

    private final ArrayList<Employee> empList;
    private String tempTxt;
    private Employee tempEmp;

    public MyXmlHandler(){
        empList = new ArrayList<Employee>();
    }

    public ArrayList<Employee> getEmpList(){
        return empList;
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        tempTxt = "";
        if(qName.equalsIgnoreCase("employee")){
            tempEmp = new Employee();
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if(qName.equalsIgnoreCase("id"))
        {
            tempEmp.setId(Integer.parseInt(tempTxt));
        }
        else if(qName.equalsIgnoreCase("name"))
        {
            tempEmp.setName(tempTxt);
        }
        else if(qName.equalsIgnoreCase("department"))
        {
            tempEmp.setDepartment(tempTxt);
        }
        else if(qName.equalsIgnoreCase("type"))
        {
            tempEmp.setType(tempTxt);
        }
        else if(qName.equalsIgnoreCase("email"))
        {
            tempEmp.setEmail(tempTxt);
        }
        else if(qName.equalsIgnoreCase("employee"))
        {
            empList.add(tempEmp);
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        tempTxt = new String(ch, start, length);
    }
}
