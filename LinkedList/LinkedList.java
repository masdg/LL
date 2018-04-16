import java.io.*;
import java.util.Random; 
import java.util.Scanner;
import java.lang.Math.*;
import java.lang.StringBuilder;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class LinkedList {

    public static int lineNumber=0;
    private static final String FILE = "./classlist.txt"; // relative filepath, must be in the same folder
    public static boolean exit = false; // global exit variable

    public static class ListElement { // an element of a linkedlist

        String firstName; // data for each element
        String lastName;
        String identif;
        ListElement next;

        public ListElement(String fName, String lName, String iD){ // initialization for a new listelement

                firstName = fName;
                lastName = lName;
                identif = iD;
                next=null;

        } // - public ListElement(String fName, String lName, String iD){}

    } // - public class ListElement {

    public static class List { // essentially the list header

        ListElement head; // initialize empty head, is only used as a head later

        public List(){

        } // - public List(){}

        public ListElement Find(String name){ // locates the first instance of a given last name

            ListElement current = head;

            while(current != null){ // checks if the current listelement's lastName matches the given string. if not, it moves on to the next until it reachest the end of the list.

                if(current.lastName.toLowerCase().equals(name.toLowerCase())) { // returns the current listelement if it matches the user input, moves on if not
                    return current;
                }
                else 
                    current = current.next;

            } // - while(current.next!=null){}

            System.out.println(name + " was not found"); // if the listelement was not found, returns nothing.
            return null;

        } // - public ListElement Find(String name){}

        public void Insert(ListElement element){ // misleading name; appends the element to the end of the current list

            boolean found = false;
            ListElement current = head.next;

            while(!found){ // found is used differently - waits until the end of the list

                if(current.next == null){

                    current.next = element;
                    found = true;

                } // - if(current.next == null){}
                else{

                    current = current.next;

                } // - else{}

            } // - while(current.next.lastName!=null){}

        } // - public void Insert(ListElement element){}

        public void Delete(String name){ // deletes an element based on user input

            boolean found = false;
            ListElement current = head.next;
            ListElement last = head;

            while(current.lastName != null && !found){ // stops checking for the input if it reaches the end of the linkedlist or the input is matched

                if(current.lastName.toLowerCase().equals(name.toLowerCase())){ // if strings are equal, it changes the pointer on the last element to the node after the current

                    last.next=current.next;
                    found = true;

                } // - if(current.lastName.equals(name)){}
                else{

                    current = current.next;
                    last = last.next;

                } // - else{}

            } // - while(current.next.lastName!=null){

            if(!found) System.out.println(name + "was not found");

        } // - public void Delete(String name){}

        public void PrintList(){ // prints out a list of elements in descending order

            int lineNumber = 1;
            int maxLastName = 0;
            int maxFirstName = 0;
            int minLastName = 1000;
            int minFirstName = 1000;
            System.out.println("\n\n\n\n");
            ListElement current = head.next;

            while(current != null){ // finds the maximum length of first and last names

                if(current.lastName.length()>maxLastName){

                    maxLastName = current.lastName.length();

                } // - if(current.lastName.length()>maxLastName){}

                if(current.firstName.length()>maxFirstName){

                    maxFirstName = current.firstName.length();

                } // - if(current.firstName.length()>maxFirstName){}

                current = current.next;

            } // - while(current != null){}

            current = head.next;

            while(current != null){ // prints out data seperated using spaces depending on string length

                System.out.print(lineNumber);
                for(int i = Integer.toString(lineNumber).length(); i < 3; i++) 
                    System.out.print(" ");
                System.out.print("| " + current.lastName);
                for(int i = maxLastName; i+1 > current.lastName.length(); i--) 
                    System.out.print(" ");
                System.out.print(current.firstName);
                for(int i = maxLastName; i+2 > current.firstName.length(); i--) 
                    System.out.print(" ");
                System.out.print(current.identif + "\n");
                current = current.next;
                lineNumber++;

            } // - while(current!=null){}
            
            System.out.println();

        } // - public void PrintList(){}

    } // - public class List

    public static void main(String bong[]){

        List header = new List(); // linkedlist init
        header.head = new ListElement("","","");
        ListElement c = header.head;
        BufferedReader br = null;
        FileReader fr = null;

        try { //reads the file, converts the raw data into elements, and appends the elements to a linkedlist

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

        header.PrintList();

        while(!exit) { // runs the code until the user decides to stop the program

            String func = "";
            String str = "";

            
            System.out.println("Function (Find (f), delete (d), add (a), print(p), exit program (exit)):");

            while(!func.toLowerCase().equals("f")&&!func.toLowerCase().equals("find")&&!func.toLowerCase().equals("d")&&!func.toLowerCase().equals("delete")&&!func.toLowerCase().equals("a")&&!func.toLowerCase().equals("add")&&!func.toLowerCase().equals("p")&&!func.toLowerCase().equals("print")){
            // get valid user input

                func = getInput("Function");
                if(exit) func = "f";

            } // - while(!func.toLowerCase().equals("f")&&!func.toLowerCase().equals("find")&&!func.toLowerCase().equals("d")&&!func.toLowerCase().equals("delete")&&!func.toLowerCase().equals("a")&&!func.toLowerCase().equals("add")){}

            if(exit) continue;

            if(!func.toLowerCase().equals("p")&&!func.toLowerCase().equals("print")&&!func.toLowerCase().equals("a")&&!func.toLowerCase().equals("add")) str = getInput("Find Last Name");
            if(exit) continue;

            ListElement curr;

            switch(func.toLowerCase()){ //executes code depending on the user input

                case "find":    try{
                                    System.out.println("Found: " + header.Find(str).lastName + "   " + header.Find(str).firstName + "   " + header.Find(str).identif);
                                } // - try{}
                                catch(NullPointerException e){
                                } // - catch(NullPointerException e){)
                break; // find case 1

                case "f":   System.out.println("Found: " + header.Find(str).lastName + "   " + header.Find(str).firstName + "   " + header.Find(str).identif);
                break; // find case 2

                case "delete":  header.Delete(str);
                break; // delete case 1

                case "d":   header.Delete(str);
                break; // delete case 2

                case "add": curr = newList();
                            header.Insert(curr);
                break; // add case 1

                case "a":   curr = newList();
                            header.Insert(curr);
                break; // add case 2

                case "print":   header.PrintList();
                break; // print case 1

                case "p":   header.PrintList();
                break; // print case 2

            } // - switch(func.toLowerCase()){}

        } // - while(!exit) {

    } // - public static void main(String bong[]){

    public static String getInput(String msg){ // get an input with a prompt at the start

        String q = "";

        try{

            System.out.print(msg + " > ");
            Scanner input = new Scanner(System.in);
            q = input.nextLine();
            if(q.toLowerCase().equals("exit")) exit = true; // exits when the user inputs "exit"

        } // - try {}
        catch(Exception e){

            System.out.println("Invalid input");

        } // - catch(Exception e){}

        return q;

    } // - public String getInput(){}

    public static ListElement newList(){ // gets data for a listelement used in List.Add

        ListElement c = new ListElement("","","");
        c.lastName = getInput("Last Name");
        c.firstName = getInput("First Name");
        c.identif = getInput("Student ID");

        return c;

    } // - public static ListElement newList(){

} // - public class LinkedList {}