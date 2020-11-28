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
import org.apache.jena.rdf.model.InfModel;
import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.rdf.model.Property;
import org.apache.jena.rdf.model.RDFNode;
import org.apache.jena.rdf.model.Resource;
import org.apache.jena.rdf.model.StmtIterator;
import static org.apache.jena.tdb.assembler.Vocab.resource;
import org.apache.jena.util.FileManager;
import org.apache.jena.vocabulary.RDF;

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
        Model model = ModelFactory.createDefaultModel();
        InputStream in1 = FileManager.get().open(inputFileName);
        model.read(in1, "");
        //model.write(System.out);
        Scanner inputReader = new Scanner(System.in);
        String input = " ";
        String department;
        String uni = "http://www.mydomain.com/uni-ns/";

        while (!(input.equals("D"))) {
            
            System.out.println("Please select one of the following options (press A,B or C):");
            System.out.println("A. Print info about a department.");
            System.out.println("B. Insert Data.");
            System.out.println("C. Retrieve triples from Schema");
            System.out.println("D.Exit.");
            input = inputReader.nextLine();
            
            if (input.equals("A")) {
                String queryString = "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>"
                        + "PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>"
                        + "PREFIX uni: <http://www.mydomain.com/uni-ns/>"
                        + "SELECT ?name "
                        + " WHERE "
                        + "{?dep rdf:type uni:Department."
                        + "?dep uni:dep_name ?name"
                        + "}";
                Query query = QueryFactory.create(queryString);
                //query.serialize(new IndentedWriter(System.out,true)) ;
                QueryExecution qexec = QueryExecutionFactory.create(query, model);
                ResultSet rs = qexec.execSelect();
                //ResultSetFormatter.out(System.out, (org.apache.jena.query.ResultSet)rs,query);
                System.out.println("Please select one of the following departments to continue: ");
                for (; rs.hasNext();) {
                    QuerySolution rb = rs.nextSolution();
                    RDFNode dep = rb.get("name");
                    System.out.println(dep.toString());
                }//for
                //read from input

                department = null;
                Scanner inputReader1 = new Scanner(System.in);
                department = inputReader1.nextLine();
                String queryString1 = "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>"
                        + "PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>"
                        + "PREFIX uni: <http://www.mydomain.com/uni-ns/>"
                        + "SELECT ?Name ?Age ?Phone ?Email "
                        + " WHERE "
                        + "{?a rdf:type uni:Professor."
                        + "?a uni:member_of ?dep."
                        + "?dep uni:dep_name '" + department + "'.\n"
                        + "?a uni:has_name ?Name."
                        + "?a uni:has_age ?Age."
                        + "?a uni:has_phone ?Phone."
                        + "?a uni:has_email ?Email."
                        + "}";

                Query query1 = QueryFactory.create(queryString1);
                //query1.serialize(new IndentedWriter(System.out,true)) ;
                QueryExecution qexec1 = QueryExecutionFactory.create(query1, model);
                ResultSet rs1 = qexec1.execSelect();
                System.out.println("Academic Staff: ");
                ResultSetFormatter.out(System.out, (org.apache.jena.query.ResultSet) rs1, query1);

                String queryString2 = "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>"
                        + "PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>"
                        + "PREFIX uni: <http://www.mydomain.com/uni-ns/>"
                        + "SELECT ?Name ?Age ?Phone ?Email "
                        + " WHERE "
                        + "{?a rdf:type uni:Student."
                        + "?a uni:member_of ?dep."
                        + "?dep uni:dep_name '" + department + "'.\n"
                        + "?a uni:has_name ?Name."
                        + "?a uni:has_age ?Age."
                        + "?a uni:has_phone ?Phone."
                        + "?a uni:has_email ?Email."
                        + "}";

                Query query2 = QueryFactory.create(queryString2);
                //query2.serialize(new IndentedWriter(System.out,true)) ;
                QueryExecution qexec2 = QueryExecutionFactory.create(query2, model);
                ResultSet rs2 = qexec2.execSelect();
                System.out.println("Students: ");
                ResultSetFormatter.out(System.out, (org.apache.jena.query.ResultSet) rs2, query2);

                String queryString3 = "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>"
                        + "PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>"
                        + "PREFIX uni: <http://www.mydomain.com/uni-ns/>"
                        + "SELECT ?Name ?Professor "
                        + " WHERE "
                        + "{?b uni:les_name ?Name."
                        + "?b uni:taught_by ?a."
                        + "?a uni:has_name ?Professor."
                        + "?a uni:member_of ?dep."
                        + "?dep uni:dep_name '" + department + "'.\n"
                        + "}";

                Query query3 = QueryFactory.create(queryString3);
                //query3.serialize(new IndentedWriter(System.out,true)) ;
                QueryExecution qexec3 = QueryExecutionFactory.create(query3, model);
                ResultSet rs3 = qexec3.execSelect();
                System.out.println("Lessons: ");
                ResultSetFormatter.out(System.out, (org.apache.jena.query.ResultSet) rs3, query3);

                String queryString4 = "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>"
                        + "PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>"
                        + "PREFIX uni: <http://www.mydomain.com/uni-ns/>"
                        + "SELECT ?Name ?Capacity "
                        + " WHERE "
                        + "{?b rdf:type uni:Classroom."
                        + "?b uni:room_name ?Name."
                        + "?b uni:room_department ?dep."
                        + "?b uni:room_capacity ?Capacity."
                        + "?dep uni:dep_name '" + department + "'.\n"
                        + "}";

                Query query4 = QueryFactory.create(queryString4);
                //query4.serialize(new IndentedWriter(System.out,true)) ;
                QueryExecution qexec4 = QueryExecutionFactory.create(query4, model);
                ResultSet rs4 = qexec4.execSelect();
                System.out.println("Classrooms: ");
                ResultSetFormatter.out(System.out, (org.apache.jena.query.ResultSet) rs4, query4);
            }
            if (input.equals("B")) {
                System.out.println("Please select what type of data you want to insert:");
                System.out.println("Professor");
                System.out.println("Student");
                System.out.println("Lesson");
                System.out.println("Department");
                System.out.println("Classroom");
                Scanner inputReader3 = new Scanner(System.in);
                String input2 = null;
                Scanner inputReader2 = new Scanner(System.in);
                input2 = inputReader2.nextLine();
                if (input2.equals("Professor")) {
                    String name = null;
                    String phone = null;
                    String email = null;
                    String age = null;
                    String member_of = null;
                    String teaches = null;

                    String queryString5 = "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>"
                            + "PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>"
                            + "PREFIX uni: <http://www.mydomain.com/uni-ns/>"
                            + "SELECT (COUNT(*) AS ?count) "
                            + " WHERE "
                            + "{?b rdf:type uni:Professor."
                            + "}";

                    Query query5 = QueryFactory.create(queryString5);
                    //query.serialize(new IndentedWriter(System.out,true)) ;
                    QueryExecution qexec5 = QueryExecutionFactory.create(query5, model);
                    ResultSet rs5 = qexec5.execSelect();
                    //ResultSetFormatter.out(System.out, (org.apache.jena.query.ResultSet)rs,query);
                    
                    String cnt = null;
                    for (; rs5.hasNext();) {
                        QuerySolution rb = rs5.nextSolution();
                        RDFNode count = rb.get("count");
                        cnt = count.toString();
                        cnt = cnt.substring(0, cnt.indexOf("^"));
                        //System.out.println(cnt);
                    }//for
                    //read from input
                    int i = Integer.parseInt(cnt);
                    i = i + 1;

                    System.out.println("Please type the name of the professor: ");
                    name = inputReader3.nextLine();
                    System.out.println("Please type the phone number of the professor: ");
                    phone = inputReader3.nextLine();
                    System.out.println("Please type the email of the professor: ");
                    email = inputReader3.nextLine();
                    System.out.println("Please type the age of the professor: ");
                    age = inputReader3.nextLine();
                    System.out.println("Please type the department of which the professor is member of: ");
                    member_of = inputReader3.nextLine();
                    System.out.println("Please type a lesson that the professor teaches: ");
                    teaches = inputReader3.nextLine();

                    Resource resource = model.createResource(uni + "Professor/prof" + i);
                    Property p_name = model.createProperty(uni, "has_name");
                    Property p_phone = model.createProperty(uni, "has_phone");
                    Property p_email = model.createProperty(uni, "has_email");
                    Property p_age = model.createProperty(uni, "has_age");
                    Property p_member_of = model.createProperty(uni, "member_of");
                    Property p_teaches = model.createProperty(uni, "teaches");

                    resource.addProperty(RDF.type, model.getResource(uni + "Professor"));
                    resource.addProperty(p_name, name);
                    resource.addProperty(p_phone, phone);
                    resource.addProperty(p_email, email);
                    resource.addProperty(p_age, age);
                    resource.addProperty(p_member_of, model.getResource(uni + member_of));
                    resource.addProperty(p_teaches, model.getResource(uni + teaches));
                }
                if (input2.equals("Student")) {
                    String st_name = null;
                    String st_phone = null;
                    String st_email = null;
                    String st_age = null;
                    String st_member_of = null;
                  

                    String queryString5 = "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>"
                            + "PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>"
                            + "PREFIX uni: <http://www.mydomain.com/uni-ns/>"
                            + "SELECT (COUNT(*) AS ?count) "
                            + " WHERE "
                            + "{?b rdf:type uni:Student."
                            + "}";

                    Query query5 = QueryFactory.create(queryString5);
                    //query.serialize(new IndentedWriter(System.out,true)) ;
                    QueryExecution qexec5 = QueryExecutionFactory.create(query5, model);
                    ResultSet rs5 = qexec5.execSelect();
                    //ResultSetFormatter.out(System.out, (org.apache.jena.query.ResultSet)rs,query);
                    
                    String cnt = null;
                    for (; rs5.hasNext();) {
                        QuerySolution rb = rs5.nextSolution();
                        RDFNode count = rb.get("count");
                        cnt = count.toString();
                        cnt = cnt.substring(0, cnt.indexOf("^"));
                        //System.out.println(cnt);
                    }//for
                    //read from input
                    int i = Integer.parseInt(cnt);
                    i = i + 1;

                    System.out.println("Please type the name of the student: ");
                    st_name = inputReader3.nextLine();
                    System.out.println("Please type the phone number of the student: ");
                    st_phone = inputReader3.nextLine();
                    System.out.println("Please type the email of the student: ");
                    st_email = inputReader3.nextLine();
                    System.out.println("Please type the age of the student: ");
                    st_age = inputReader3.nextLine();
                    System.out.println("Please type the department of which the student is member of: ");
                    st_member_of = inputReader3.nextLine();
                   
                    Resource resource = model.createResource(uni + "Student/stud" + i);
                    Property s_name = model.createProperty(uni, "has_name");
                    Property s_phone = model.createProperty(uni, "has_phone");
                    Property s_email = model.createProperty(uni, "has_email");
                    Property s_age = model.createProperty(uni, "has_age");
                    Property s_member_of = model.createProperty(uni, "member_of");                    

                    resource.addProperty(RDF.type, model.getResource(uni + "Student"));
                    resource.addProperty(s_name, st_name);
                    resource.addProperty(s_phone, st_phone);
                    resource.addProperty(s_email, st_email);
                    resource.addProperty(s_age, st_age);
                    resource.addProperty(s_member_of, model.getResource(uni + st_member_of));
                    
                }
                if (input2.equals("Lesson")) {
                    String les_name = null;                   
                    String les_taught_by = null;

                    String queryString5 = "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>"
                            + "PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>"
                            + "PREFIX uni: <http://www.mydomain.com/uni-ns/>"
                            + "SELECT (COUNT(*) AS ?count) "
                            + " WHERE "
                            + "{?b rdf:type uni:Lesson."
                            + "}";

                    Query query5 = QueryFactory.create(queryString5);
                    //query.serialize(new IndentedWriter(System.out,true)) ;
                    QueryExecution qexec5 = QueryExecutionFactory.create(query5, model);
                    ResultSet rs5 = qexec5.execSelect();
                    //ResultSetFormatter.out(System.out, (org.apache.jena.query.ResultSet)rs,query);
                   
                    String cnt = null;
                    for (; rs5.hasNext();) {
                        QuerySolution rb = rs5.nextSolution();
                        RDFNode count = rb.get("count");
                        cnt = count.toString();
                        cnt = cnt.substring(0, cnt.indexOf("^"));
                        //System.out.println(cnt);
                    }//for
                    //read from input
                    int i = Integer.parseInt(cnt);
                    i = i + 1;

                    System.out.println("Please type the name of the lesson: ");
                    les_name = inputReader3.nextLine();                    
                    System.out.println("Please type the name professor who teaaches the lesson: ");
                    les_taught_by = inputReader3.nextLine();

                    Resource resource = model.createResource(uni + "Lesson/les" + i);
                    Property ls_name = model.createProperty(uni, "has_name");                    
                    Property ls_teaches = model.createProperty(uni, "taught-by");

                    resource.addProperty(RDF.type, model.getResource(uni + "Lesson"));
                    resource.addProperty(ls_name, les_name);                    
                    resource.addProperty(ls_teaches, model.getResource(uni + les_taught_by));
                }
                if (input2.equals("Department")) {
                   String dep_name = null;                    
                   String city = null; 
                                       
                    System.out.println("Please type the name of the department: ");
                    dep_name = inputReader3.nextLine();                    
                    System.out.println("Please type the city where the department is located: ");
                    city = inputReader3.nextLine();

                    Resource resource = model.createResource(uni + "Department/" + dep_name);
                    Property dpt_name = model.createProperty(uni, "dep_name");                   
                    Property dpt_city = model.createProperty(uni, "dep_city");

                    resource.addProperty(RDF.type, model.getResource(uni + "Department"));
                    resource.addProperty(dpt_name, dep_name);                    
                    resource.addProperty(dpt_city, model.getResource(uni + city));
                }
                if (input2.equals("Classroom")) {
                    String class_name = null;                    
                    String class_capacity = null;
                    String class_department = null;                    
                 
                    System.out.println("Please type the name of the classroom: ");
                    class_name = inputReader3.nextLine();
                    System.out.println("Please type the capacity of the classroom: ");
                    class_capacity = inputReader3.nextLine();
                    System.out.println("Please type the department in which the classroom belongs: ");
                    class_department = inputReader3.nextLine();                    

                    Resource resource = model.createResource(uni + "Classroom/" + class_name);                    
                    Property r_name = model.createProperty(uni, "room_name");
                    Property r_capacity = model.createProperty(uni, "room_capacity");
                    Property r_department = model.createProperty(uni, "room_department");

                    resource.addProperty(RDF.type, model.getResource(uni + "Classroom"));
                    resource.addProperty(r_name, class_name);                   
                    resource.addProperty(r_capacity, model.getResource(uni + class_capacity));
                    resource.addProperty(r_department, model.getResource(uni + class_department));
                }
                OutputStream output = new FileOutputStream("ask3.rdf");
                model.write(output, "RDF/XML-ABBREV");

            }
            if (input.equals("C")) {

                InfModel inf = ModelFactory.createRDFSModel(model);
                System.out.println("Please type a URI of a resource");
                String uri = null;
                Scanner inputReader4 = new Scanner(System.in);
                uri = inputReader4.nextLine();
                Resource rsc = inf.getResource(uni + uri); //create url
                StmtIterator iter = rsc.listProperties();

                System.out.println("Triples");
                while (iter.hasNext()) {
                    System.out.println(iter.nextStatement().toString());
                }
            }

        }
        in1.close();
    }

}
