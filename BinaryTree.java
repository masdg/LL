import java.io.*;
import java.util.Random; 
import java.util.Scanner;
import java.lang.Math.*;
import java.lang.StringBuilder;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class BinaryTree {

    public static int lineNumber=0;
    private static final String FILE = "./classlist.txt";

    public class Node {

        String lastName;
        String firstName;
        String id;
        Node right;
        Node left;

        public Node(String lName, String fName, String ident) {

            lastName = lName;
            firstName = fName;
            id = ident;
            right = null;
            left = null

        } // - public Node() {}

    } // - public class Node {}

    public class Root {

        Node root;

        public Root() {

        } // - public Root() {}

    } // - public class Root

    public static void main(String args[]){

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
                System.out.println(lineNumber);
                

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

    } // - public static void main(String args[]){}

} // - public class BinaryTree {}