package test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;


public class XPathQueryExample {

    public static void main(String[] args) {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        DocumentBuilder builder;
        Document doc = null;
        List<String> list = new ArrayList<>();
        try {
            builder = factory.newDocumentBuilder();
            //doc = builder.parse("/Users/Shared/KCB/PROJECTS/APIII/iso.xml");
            doc = builder.parse("/Users/Shared/KCB/PROJECTS/APIII/iso.xml");
            XPath xPath = XPathFactory.newInstance().newXPath();
            // Create XPath object
            XPath xpath = XPathFactory.newInstance().newXPath();

            //String name = getEmployeeNameById(doc,xpath,2);
            //System.out.println("Employee name: "+name);
            
            String statusDesc = getStatusDesc(doc,xpath);
            System.out.println("Status Desc: "+statusDesc);
            
        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }

    }

    private static String getEmployeeNameById(Document doc, XPath xpath, int id) {
        String name = null;
        try {
            XPathExpression expr = xpath.compile("/Employees/Employee[@id='" + id + "']/name/text()");
            name = (String) expr.evaluate(doc, XPathConstants.STRING);
        } catch (XPathExpressionException e) {
            e.printStackTrace();
        }

        return name;
    }
    
    private static String getStatusDesc(Document doc, XPath xpath) {
        String name = null;
        try {
            XPathExpression expr = xpath.compile("/message/isomsg/field[@id='112']/@value");
            name = (String) expr.evaluate(doc, XPathConstants.STRING);
        } catch (XPathExpressionException e) {
            e.printStackTrace();
        }

        return name;
    }
    private static String getStatusCode(Document doc, XPath xpath) {
        String name = null;
        try {
            XPathExpression expr = xpath.compile("/message/isomsg/field[@id='39']/@value");
            name = (String) expr.evaluate(doc, XPathConstants.STRING);
        } catch (XPathExpressionException e) {
            e.printStackTrace();
        }

        return name;
    }
}
