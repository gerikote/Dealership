package utils;

import org.w3c.dom.Document;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class DOMParser {

    public static void parseXMLFile(String filePath) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(new File(filePath));
            document.getDocumentElement().normalize();
            Element rootElement = document.getDocumentElement();

            //Process child elements
            NodeList nodeList = rootElement.getChildNodes();
            for (int i = 0; i < nodeList.getLength(); i++) {
                Node node = nodeList.item(i);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;

                    //Process the element data
                    String tagName = element.getTagName();
                    String textContent = element.getTextContent();
                    System.out.println("Tag Name : " + tagName);
                    System.out.println("Text Content : " + textContent);
                    System.out.println("---------------------");
                }
            }

        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }
    }

    public static <T> T parseXMLToObject(File xmlFile, Class<T> clazz) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(xmlFile);
            document.getDocumentElement().normalize();
            Element rootElement = document.getDocumentElement();

            // Create an instance of the target class
            T object = clazz.newInstance();

            // Get the list of fields in the target class
            Field[] fields = clazz.getDeclaredFields();

            // Process child elements and assign values to object fields
            NodeList nodeList = rootElement.getChildNodes();
            for (int i = 0; i < nodeList.getLength(); i++) {
                Node node = nodeList.item(i);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;

                    // Process the element data
                    String tagName = element.getTagName();
                    String textContent = element.getTextContent();

                    // Find the corresponding field in the target class
                    for (Field field : fields) {
                        if (field.getName().equalsIgnoreCase(tagName)) {
                            // Make the field accessible (in case it's private)
                            field.setAccessible(true);

                            // Check if the field type is String
                            if (field.getType() == String.class) {
                                // Assign the text content to the field
                                field.set(object, textContent);
                            } else if (field.getType() == int.class) {
                                // Convert the text content to an int
                                int value = Integer.parseInt(textContent);

                                // Assign the converted value to the field
                                field.setInt(object, value);
                            } else if (field.getType() == Date.class) {
                                // Convert the text content to a Date object
                                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                                Date value = new Date(dateFormat.parse(textContent).getTime());

                                // Assign the converted value to the field
                                field.set(object, value);
                            }

                            break;
                        }
                    }
                }
            }
            return object;
        } catch (ParserConfigurationException | SAXException | IOException | IllegalAccessException |
                 InstantiationException e) {
            e.printStackTrace();
            return null;
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }
}
