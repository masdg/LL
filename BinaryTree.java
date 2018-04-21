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
    public static int pos = 0;

    public static class Node {

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

    public static class Root {

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
        System.out.println(binList[1]);


        Root r;
        r = new Root();
        r.root = new Node(binList[0],binList[0],binList[0]);
        int ind = 1;

        while(ind < binList.length) {

            Node tmpR = new Node(binList[ind],binList[ind],binList[ind]);
            AddNode(ind, tmpR, r.root);
            ind++;

        }

        PrintTree(r.root, binList.length);

    } // - public static void main(String args[]){}

    public static void AddNode(int index, Node addedNode, Node root){

        Node curr = root;
        String bin;
        bin = toBinary(index);
        int stringLength  = toBinary(index).length();

        for(int p = 1; p < stringLength; p++){

            if(String.valueOf(bin.charAt(p)).equals("0")) {

                if(curr.left==null){curr.left = new Node("","",""); System.out.print("yes ");}
                curr = curr.left;
                System.out.print(bin.charAt(p) + "left ");

            }
            else if(String.valueOf(bin.charAt(p)).equals("1")) {

                if(curr.right==null){curr.right = new Node("","",""); System.out.print("yes ");}
                curr = curr.right;
                System.out.print(bin.charAt(p) + "right ");

            };

        }

        System.out.println(addedNode.lastName);

        curr = addedNode;

    }

    // public static void PrintTree(Node root, int maxSize){

    //     for(int tracker = 2; tracker <= maxSize; tracker++) {

    //         int currentIndex = 2;
    //         Node curr = root;

    //         while(currentIndex <= tracker){

    //             if(toBinary(currentIndex).equals(0)) {

    //                 curr = curr.left;

    //             }

    //             else{

    //                 curr = curr.right;

    //             }

    //             currentIndex++;

    //         }

    //         System.out.println(curr.lastName);

    //     }

    // }

    public static String toBinary(int n) {

       if (n == 0) {

           return "0";

       }
       String binary = "";

       while (n > 0) {

           int rem = n % 2;
           binary = rem + binary;
           n = n / 2;

       }

       return binary;

   }

} // - public class BinaryTree {}