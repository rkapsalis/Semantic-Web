/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package krweb12;     
import javax.xml.XMLConstants;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.*;
import java.net.URL;
import org.xml.sax.SAXException;
import java.io.File; // if you use File
import java.io.IOException;
/*
 * @author Ρωμανός
 */
public class Krweb12 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
          jf1 mainWindow = new jf1();
          
       // URL schemaFile = new URL("http://host:port/filename.xsd");
        // webapp example xsd: 
        // URL schemaFile = new URL("http://java.sun.com/xml/ns/j2ee/web-app_2_4.xsd");
        // local file example:
        File schemaFile = new File("C:\\Users\\Ρωμανός\\Downloads\\KRWEB_20-21_ASK1\\schedule.xsd"); // etc.
        Source xmlFile = new StreamSource(new File("C:\\Users\\Ρωμανός\\Downloads\\KRWEB_20-21_ASK1\\schedule.xml"));
        SchemaFactory schemaFactory = SchemaFactory
            .newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
        try {
          Schema schema = schemaFactory.newSchema(schemaFile);
          Validator validator = schema.newValidator();
          validator.validate(xmlFile);
          System.out.println(xmlFile.getSystemId() + " is valid");
        } catch (SAXException e) {
          System.out.println(xmlFile.getSystemId() + " is NOT valid reason:" + e);
        } catch (IOException e) {}
            }
    
}
