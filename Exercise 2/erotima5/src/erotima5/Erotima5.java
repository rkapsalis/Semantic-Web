/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package erotima5;
import java.util.Scanner;
import java.io.*;
import org.apache.jena.atlas.io.IndentedWriter;
import org.apache.jena.query.Query;
import org.apache.jena.query.QueryExecution;
import org.apache.jena.query.QueryExecutionFactory;
import org.apache.jena.query.QueryFactory;
import org.apache.jena.query.QuerySolution;
import org.apache.jena.query.ResultSet;
import org.apache.jena.query.ResultSetFormatter;
import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.rdf.model.RDFNode;
import org.apache.jena.util.FileManager;

/**
 *
 * @author Ρωμανός
 */
public class Erotima5 {

    /**
     * @param args the command line arguments
     */
    static final String inputFileName = "ask3.rdf";
    
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        Model model= ModelFactory.createDefaultModel();
        InputStream in1 = FileManager.get().open(inputFileName);
        model.read(in1, "");
        //model.write(System.out);
        Scanner inputReader = new Scanner(System.in);
        String input = null;
        String department;
        System.out.println("Please select one of the following options (press A,B or C):");
        System.out.println("A. Print info about a department.");            
        System.out.println("B. Insert Data.");
        System.out.println("C. Retrieve triples from Schema");            
        System.out.println("D.Exit.");
        input = inputReader.nextLine();
        if(input.equals("A")){
            String queryString = "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>" +
                                        "PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>" +
                                        "PREFIX uni: <http://www.mydomain.com/uni-ns/>" +                                    
                                        "SELECT ?name " +
                                        " WHERE "
                                        + "{?dep rdf:type uni:Department." +
                                        "?dep uni:dep_name ?name" +
                                        "}";
            Query query= QueryFactory.create(queryString);
            //query.serialize(new IndentedWriter(System.out,true)) ;
            QueryExecution qexec= QueryExecutionFactory.create(query, model) ;
            ResultSet rs= qexec.execSelect() ;
            //ResultSetFormatter.out(System.out, (org.apache.jena.query.ResultSet)rs,query);
            System.out.println("Please select one of the following departments to continue: ");
            for ( ; rs.hasNext() ; ) {
                            QuerySolution rb= rs.nextSolution() ;
                            RDFNode dep = rb.get("name") ;
                            System.out.println(dep.toString() );
                        }//for
                //read from input
                
            department = null;
            department = inputReader.nextLine();
            String queryString1 = "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>" +
                                        "PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>" +
                                        "PREFIX uni: <http://www.mydomain.com/uni-ns/>" +                                    
                                        "SELECT ?Name ?Age ?Phone ?Email " +
                                        " WHERE "
                                        + "{?a rdf:type uni:Professor."
                                         + "?a uni:member_of ?dep." + 
                                        "?dep uni:dep_name '" + department + "'.\n" +
                                        "?a uni:has_name ?Name." +
                                        "?a uni:has_age ?Age." +
                                        "?a uni:has_phone ?Phone." +
                                        "?a uni:has_email ?Email." +
                                        "}";
            
            Query query1 = QueryFactory.create(queryString1);
            //query1.serialize(new IndentedWriter(System.out,true)) ;
            QueryExecution qexec1 = QueryExecutionFactory.create(query1, model) ;
            ResultSet rs1 = qexec1.execSelect() ;
            System.out.println("Academic Staff: ");
            ResultSetFormatter.out(System.out, (org.apache.jena.query.ResultSet)rs1,query1);
           
           String queryString2 = "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>" +
                                        "PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>" +
                                        "PREFIX uni: <http://www.mydomain.com/uni-ns/>" +                                    
                                        "SELECT ?Name ?Age ?Phone ?Email " +
                                        " WHERE "
                                        + "{?a rdf:type uni:Student."
                                         + "?a uni:member_of ?dep." + 
                                        "?dep uni:dep_name '" + department + "'.\n" +
                                        "?a uni:has_name ?Name." +
                                        "?a uni:has_age ?Age." +
                                        "?a uni:has_phone ?Phone." +
                                        "?a uni:has_email ?Email." +
                                        "}";
            
            Query query2 = QueryFactory.create(queryString2);
            //query2.serialize(new IndentedWriter(System.out,true)) ;
            QueryExecution qexec2 = QueryExecutionFactory.create(query2, model) ;
            ResultSet rs2 = qexec2.execSelect() ;
            System.out.println("Students: ");
            ResultSetFormatter.out(System.out, (org.apache.jena.query.ResultSet)rs2,query2);
            
            String queryString3 = "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>" +
                                        "PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>" +
                                        "PREFIX uni: <http://www.mydomain.com/uni-ns/>" +                                    
                                        "SELECT ?Name ?Professor " +
                                        " WHERE "
                                        + "{?b uni:les_name ?Name." +
                                          "?b uni:taught_by ?a." +
                                           "?a uni:has_name ?Professor."+
                                           "?a uni:member_of ?dep." + 
                                        "?dep uni:dep_name '" + department + "'.\n" +                                                                                                                      
                                        "}";
            
            Query query3 = QueryFactory.create(queryString3);
            //query3.serialize(new IndentedWriter(System.out,true)) ;
            QueryExecution qexec3 = QueryExecutionFactory.create(query3, model) ;
            ResultSet rs3 = qexec3.execSelect() ;
            System.out.println("Lessons: ");
            ResultSetFormatter.out(System.out, (org.apache.jena.query.ResultSet)rs3,query3);
            
            String queryString4 = "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>" +
                                        "PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>" +
                                        "PREFIX uni: <http://www.mydomain.com/uni-ns/>" +                                    
                                        "SELECT ?Name ?Capacity " +
                                        " WHERE "
                                        + "{?b rdf:type uni:Classroom."                    
                                        + "?b uni:room_name ?Name." +
                                          "?b uni:room_department ?dep." +
                                           "?b uni:room_capacity ?Capacity."+                                           
                                        "?dep uni:dep_name '" + department + "'.\n" +                                                                                                                      
                                        "}";
            
            Query query4 = QueryFactory.create(queryString4);
            //query4.serialize(new IndentedWriter(System.out,true)) ;
            QueryExecution qexec4 = QueryExecutionFactory.create(query4, model) ;
            ResultSet rs4 = qexec4.execSelect() ;
            System.out.println("Classrooms: ");
            ResultSetFormatter.out(System.out, (org.apache.jena.query.ResultSet)rs4,query4);
        }
        
        in1.close();
    }
    
}
