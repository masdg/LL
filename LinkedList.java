import java.io.*;
import java.util.Random; 
import java.util.Scanner;
import java.lang.Math.*;
import java.lang.StringBuilder;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;
import javafx.stage.Stage;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.ColumnConstraints;

public class LinkedList extends Application {

    public static int lineNumber=0;
    private static final String FILE = "./classlist.txt";

    public static class ListElement {

        String firstName;
        String lastName;
        String identif;
        ListElement next;

        public ListElement(String fName, String lName, String iD){

                firstName = fName;
                lastName = lName;
                identif = iD;
                next=null;

        } // - public ListElement(String fName, String lName, String iD){}

    } // - public class ListElement {

    public static class List {

        ListElement head;

        public List(){

        } // - pubic List(){}

        public ListElement Find(String name){

            ListElement current = head;

            while(current != null){

                if(current.lastName.equals(name)) {
                    return current;
                }
                else 
                    current = current.next;

            } // - while(current.next!=null){

            return null;

        } // - public ListElement Find(String name){

        public void Insert(ListElement element){

            boolean found = false;
            ListElement current = head.next;

            while(!found){

                if(current.next == null){

                    current.next = element;
                    found = true;

                } // - if(current.next == null){}
                else{

                    current = current.next;

                } // - else{}

            } // - while(current.next.lastName!=null){}

        } // - public void Insert(ListElement element){}

/*
        public void RealInsert(ListElement element, int index){

            ListElement current = head.next;
            ListElement last = head;
            int currentIndex = 0;
            boolean withinBounds = true;

            while(currentIndex != index && withinBounds){

                try{

                    current = current.next;
                    last = last.next;
                    currentIndex++;

                } // - try{}
                catch(NullPointerException e){

                    System.out.println("Position not found");
                    withinBounds = false;

                } // - catch(NullPointerException e){}

                if(currentIndex == index) {

                    last.next = element;
                    element.next = current;
                    withinBounds = false;

                } // - if(currentIndex == index) {}

            } // - while(currentIndex != index && withinBounds){}

        } // - public void RealInsert(ListElement element){}
*/

        public void Delete(String name){

            boolean found = false;
            ListElement current = head.next;
            ListElement last = head;

            while(current.lastName != null && !found){

                if(current.lastName.equals(name)){

                    last.next=current.next;
                    found = true;

                } // - if(current.lastName.equals(name)){}
                else{

                    current = current.next;
                    last = last.next;

                } // - else{}

            } // - while(current.next.lastName!=null){

        } // - public void Delete(String name){}

        public void PrintList(){

            int lineNumber = 1;

            ListElement current = head.next;

            while(current != null){

                System.out.println(lineNumber + ": " + current.firstName + " " + current.lastName + " - " + current.identif + "\n");
                current = current.next;
                lineNumber++;

            } // - while(current!=null){}

        } // - public void PrintList(){}

    } // - public class List

    public ListElement pubList;

    public static void main(String bong[]){

        List header = new List();
        header.head = new ListElement("","","");
        ListElement c = header.head;
        BufferedReader br = null;
        FileReader fr = null;

        try {

            br = new BufferedReader(new FileReader(FILE));
            fr = new FileReader(FILE);
            br = new BufferedReader(fr);
            String sCurrentLine;

            while ((sCurrentLine = br.readLine()) != null) {

                lineNumber++;
//                System.out.println(sCurrentLine); for testing filereader
                String[] studentData = sCurrentLine.split(" ");
                c.next = new ListElement("","","");
                c.next.firstName = studentData[3];
                c.next.lastName = studentData[2];
                c.next.identif = studentData[0];
                c=c.next;

            } // - while ((sCurrentLine = br.readLine()) != null) {

        } // - try {}

        catch (IOException e) {

            e.printStackTrace();

        } // - catch
        finally {

            try {

                if (br != null)
                    br.close();
                if (fr != null)
                    fr.close();

            } // - try

            catch (IOException ex) {

                ex.printStackTrace();

            } // - catch

        }// - finally

        ListElement ins = new ListElement("a","b","c");
//        header.RealInsert(ins, 44);
        pubList.next = header.nextd;

        Application.launch(bong);

    } // - public static void main(String bong[]){

    @Override
    public void start(Stage primaryStage) {

        ScrollPane scrollable = new ScrollPane();
        GridPane grid = new GridPane();
        grid.getColumnConstraints().add(new ColumnConstraints(100));
        grid.getColumnConstraints().add(new ColumnConstraints(100));
        grid.getColumnConstraints().add(new ColumnConstraints(100));
        grid.setVgap(5);
        grid.setHgap(5);

        scrollable.setVbarPolicy(ScrollBarPolicy.AS_NEEDED);
        scrollable.setHbarPolicy(ScrollBarPolicy.AS_NEEDED);

        scrollable.setContent(grid);
        Scene scene = new Scene(scrollable, 1000, 600);
        primaryStage.setTitle("Student Data"); 
        primaryStage.setScene(scene);
        primaryStage.show();

    } // - public void start(Stage primaryStage) {

} // - public class LinkedList {}




/*

had previous code that was deleted but accidentally took the filereader along with it
couldn't be bothered rewriting it all out. this is the original.

        BufferedReader br = null;
        FileReader fr = null;
        try {
            //br = new BufferedReader(new FileReader(FILE));
            fr = new FileReader(FILE);
            br = new BufferedReader(fr);
            String sCurrentLine;
            while ((sCurrentLine = br.readLine()) != null) {
                lineNumber++;
                System.out.println(sCurrentLine);
                head.fName=sCurrentLine;
                head.next=null;
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null)
                    br.close();
                if (fr != null)
                    fr.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
*/