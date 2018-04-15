import java.io.*;
import java.util.*;
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
            left = null;

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

        } // - finally

        String binList[] = new String[lineNumber];
        br = null;
        fr = null;
        String randArray[] = new String[lineNumber];

        try {

            br = new BufferedReader(new FileReader(FILE));
            fr = new FileReader(FILE);
            br = new BufferedReader(fr);
            String sCurrentLine;
            int currentLine = 0;

            while ((sCurrentLine = br.readLine()) != null) {

//                System.out.println(sCurrentLine); for testing filereader
                randArray[currentLine] = sCurrentLine;
                currentLine++;

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

        } // - finally

        for (int i = 0; i < binList.length; i++) {

            binList[i] = randArray[i];

        } // - for (int i = 0; i < binList.length; i++) {}

        Collections.shuffle(Arrays.asList(binList));
        System.out.println(binList[0]);

        Root r;
        r.root = new Node(binList[0]), binList[0]), binList[0]));

    } // - public static void main(String args[]){}

    private static void addNode(Node baseNode, Node addedNode, boolean rightLeft){

        boolean success = false;

        if(rightLeft) {

            baseNode.left = addedNode;

        }
        if(!rightleft && baseNode ) {

            baseNode.right = addedNode;

        }

        if (success = false

    }

} // - public class BinaryTree {}