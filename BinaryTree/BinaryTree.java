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
    public static boolean exit = false;


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

        Root r;
        r = new Root();
        r.root = new Node(binList[0],binList[0],binList[0],1);
        int ind = 1;

        while(ind < binList.length) {

            Node tmpR = new Node(binList[ind],binList[ind],binList[ind],ind);
            AddNode(ind, tmpR, r.root);
            ind++;

        }

        while(!exit) { // runs the code until the user decides to stop the program

            String func = "";
            String str = "";
            Node tmp = null;
            String a1 = "";
            String a2 = "";
            String a3 = "";
            String a4 = "";
            String cumulative = "";
            
            System.out.println("\nTraversal (Inorder (in), Preorder (pre), Postorder (post), Breadthfirst (breadth), Add (a), Exit program (exit)):");

            while(!func.toLowerCase().equals("in")&&!func.toLowerCase().equals("inorder")&&!func.toLowerCase().equals("post")&&!func.toLowerCase().equals("postorder")&&!func.toLowerCase().equals("pre")&&!func.toLowerCase().equals("preorder")&&!func.toLowerCase().equals("breadth")&&!func.toLowerCase().equals("breadthfirst")&&!func.toLowerCase().equals("a")&&!func.toLowerCase().equals("add")){
            // get valid user input

                func = getInput("Function");
                if(exit) func = "in";

            } // - while(!func.toLowerCase().equals("f")&&!func.toLowerCase().equals("find")&&!func.toLowerCase().equals("d")&&!func.toLowerCase().equals("delete")&&!func.toLowerCase().equals("a")&&!func.toLowerCase().equals("add")){}

            if(exit) continue;

            switch(func.toLowerCase()){ //executes code depending on the user input

                case "in":    InTree(r.root);
                break; // find case 1

                case "inorder":   InTree(r.root);
                break; // find case 2

                case "breadth":  BreadthTree(r.root);
                break; // delete case 1

                case "breadthfirst":   BreadthTree(r.root);
                break; // delete case 2

                case "pre": PreTree(r.root);
                break; // add case 1

                case "preorder":   PreTree(r.root);
                break; // add case 2

                case "post":   PostTree(r.root);
                break; // print case 1

                case "postorder":   PostTree(r.root);
                break; // print case 2

                case "a":   a1 = getInput("Last Name");
                            a2 = getInput("First Name");
                            a3 = getInput("ID");
                            a4 = getInput("Grade");
                            cumulative = a3 + " " + a4 + " " + a1 + " " + a2;
                            tmp = new Node(cumulative,cumulative,cumulative,ind);
                            AddNode(ind, tmp, r.root);
                            ind++;
                            if(exit) func = "a";
                            break;
                case "add": a1 = getInput("Last Name");
                            a2 = getInput("First Name");
                            a3 = getInput("ID");
                            a4 = getInput("Grade");
                            cumulative = a3 + " " + a4 + " " + a1 + " " + a2;
                            tmp = new Node(cumulative,cumulative,cumulative,ind);
                            AddNode(ind, tmp, r.root);
                            ind++;
                            if(exit) func = "a";
                            break;

            } // - switch(func.toLowerCase()){}

        } // - while(!exit) {

    } // - public static void main(String args[]){}

    public static void AddNode(int index, Node addedNode, Node root){

        Node curr = root;
        String bin;
        bin = toBinary(index);
        int stringLength  = toBinary(index).length();

        for(int p = 1; p < stringLength; p++){

            if(String.valueOf(bin.charAt(p)).equals("0")) {

                if(curr.left==null)curr.left = addedNode;
                else {

                    curr = curr.left;

                } // - else {}

            } // - if(String.valueOf(bin.charAt(p)).equals("0")) {}

            else if(String.valueOf(bin.charAt(p)).equals("1")) {

                if(curr.right==null)curr.right = addedNode;
                else {

                    curr = curr.right;

                } // - else {}

            }; // - else if(String.valueOf(bin.charAt(p)).equals("1")) {}

        } // - for(int p = 1; p < stringLength; p++){}

    } // - public static void AddNode(int index, Node addedNode, Node root){}

    public static boolean BreadthFirst(Node tmp, ListElement tmpL, int orDepth, int depthCompare){
        
        int localDepth = depthCompare;
        tmpL.lastName = tmp.lastName;
        tmpL.firstName = tmp.lastName;
        tmpL.id = tmp.lastName;
        tmpL.next = new ListElement("","","");
        boolean r = false;

        if(tmp.left!=null) {

            if(BreadthFirst(tmp.left, tmpL.next, orDepth, depthCompare + 1)) r = true;

        }

        if(tmp.right!=null) {

            if(BreadthFirst(tmp.right, tmpL.next, orDepth, depthCompare + 1)) r = true;

        } // - 

        if(depthCompare == orDepth) {

            System.out.print(tmp.index + " " + tmp.lastName + " | ");
            r = true;

        }

        return r;

    } // - public static void Postorder(Node tmp, ListElement tmpL){}

    public static void Inorder(Node tmp, ListElement tmpL){

        tmpL.lastName = tmp.lastName;
        tmpL.firstName = tmp.lastName;
        tmpL.id = tmp.lastName;
        tmpL.next = new ListElement("","","");

        System.out.println(tmp.index + " " + tmp.lastName);

        if(tmp.left!=null) {

            Inorder(tmp.left, tmpL.next);

        } // - if(tmp.left!=null) {}

        if(tmp.right!=null) {

            Inorder(tmp.right, tmpL.next);

        } // - if(tmp.right!=null) {}

    } // - public static void Inorder(Node tmp, ListElement tmpL){}

    public static void Preorder(Node tmp, ListElement tmpL){
        
        tmpL.lastName = tmp.lastName;
        tmpL.firstName = tmp.lastName;
        tmpL.id = tmp.lastName;
        tmpL.next = new ListElement("","","");

        if(tmp.left!=null) {

            Preorder(tmp.left, tmpL.next);

        } // - if(tmp.left!=null) {}

        System.out.println(tmp.index + " " + tmp.lastName);

        if(tmp.right!=null) {

            Preorder(tmp.right, tmpL.next);

        } // - if(tmp.right!=null) {}

    } // - public static void Preorder(Node tmp, ListElement tmpL){}

    public static void Postorder(Node tmp, ListElement tmpL){
        
        tmpL.lastName = tmp.lastName;
        tmpL.firstName = tmp.lastName;
        tmpL.id = tmp.lastName;
        tmpL.next = new ListElement("","","");

        if(tmp.left!=null) {

            Postorder(tmp.left, tmpL.next);

        }

        if(tmp.right!=null) {

            Postorder(tmp.right, tmpL.next);

        } // - 

        System.out.println(tmp.index + " " + tmp.lastName);

    } // - public static void Postorder(Node tmp, ListElement tmpL){}

    public static void BreadthTree(Node tmp) {

        Head h = new Head();
        h.head = new ListElement("","","");
        int d = 1;
        boolean isFalse = false;

        while(!isFalse) {
            
            if(!BreadthFirst(tmp, h.head, d, 1))isFalse = true;
            d++;
            System.out.println();
            System.out.println();

        }

    }

    public static void PostTree(Node tmp) {

        Head h = new Head();
        h.head = new ListElement("","","");
        Postorder(tmp, h.head);
        System.out.println();

    }

    public static void InTree(Node tmp) {

        Head h = new Head();
        h.head = new ListElement("","","");
        Inorder(tmp, h.head);
        System.out.println();

    }

    public static void PreTree(Node tmp) {

        Head h = new Head();
        h.head = new ListElement("","","");
        Preorder(tmp, h.head);
        System.out.println();

    }

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

} // - public class BinaryTree {}