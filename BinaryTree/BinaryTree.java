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
    public static boolean found = false;


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

        String binListFirst[] = new String[lineNumber];
        String binListLast[] = new String[lineNumber];
        String binListID[] = new String[lineNumber];

        for (int i = 0; i < binList.length; i++) {

            String[] studentData = binList[i].split(" ");
            binListFirst[i] = studentData[3];
            binListLast[i] = studentData[2];
            binListID[i] = studentData[0];

        } // - for (int i = 0; i < binList.length; i++) {}

        Root r;
        r = new Root();
        r.root = new Node(binListLast[0],binListFirst[0],binListID[0],1);
        int ind = 1;
        int maxDepth = 0;

        while(ind < binList.length) {

            Node tmpR = new Node(binListLast[ind],binListFirst[ind],binListID[ind],ind);
            if(AddNode(tmpR, r.root)>maxDepth)maxDepth++;
            ind++;

        } // - while(ind < binList.length) {}

        System.out.println("\nMax Depth: " + maxDepth);

        while(!exit) { // runs the code until the user decides to stop the program

            String func = "";
            String str = "";
            Node tmp = null;
            String a1 = "";
            String a2 = "";
            String a3 = "";
            found = false;
            
            System.out.println("\nTraversal (Inorder (in), Preorder (pre), Postorder (post), Breadthfirst (breadth), Add (a), Find (f), Exit program (exit)):");

            while(!func.toLowerCase().equals("in")&&!func.toLowerCase().equals("inorder")&&!func.toLowerCase().equals("post")&&!func.toLowerCase().equals("postorder")&&!func.toLowerCase().equals("pre")&&!func.toLowerCase().equals("preorder")&&!func.toLowerCase().equals("breadth")&&!func.toLowerCase().equals("breadthfirst")&&!func.toLowerCase().equals("a")&&!func.toLowerCase().equals("add")&&!func.toLowerCase().equals("f")&&!func.toLowerCase().equals("find")){
            // get valid user input

                func = getInput("Function");
                if(exit) func = "in";

            } // - while(!func.toLowerCase().equals("in")&&!func.toLowerCase().equals("inorder")&&!func.toLowerCase().equals("post")&&!func.toLowerCase().equals("postorder")&&!func.toLowerCase().equals("pre")&&!func.toLowerCase().equals("preorder")&&!func.toLowerCase().equals("breadth")&&!func.toLowerCase().equals("breadthfirst")&&!func.toLowerCase().equals("a")&&!func.toLowerCase().equals("add")&&!func.toLowerCase().equals("f")&&!func.toLowerCase().equals("find")){}

            if(exit) continue;

            switch(func.toLowerCase()){ //executes code depending on the user input

                case "pre":    InTree(r.root);
                break; // preorder case 1

                case "preorder":   InTree(r.root);
                break; // preorder case 2

                case "breadth":  BreadthTree(r.root);
                break; // breadthfirst case 1

                case "breadthfirst":   BreadthTree(r.root);
                break; // breadthfirst case 2

                case "in": PreTree(r.root);
                break; // inorder case 1

                case "inorder":   PreTree(r.root);
                break; // inorder case 2

                case "post":   PostTree(r.root);
                break; // postorder case 1

                case "postorder":   PostTree(r.root);
                break; // postorder case 2

                case "a":   a1 = getInput("Last Name");
                            a2 = getInput("First Name");
                            a3 = getInput("ID");
                            tmp = new Node(a1,a2,a3,ind);
                            AddNode(tmp, r.root);
                            ind++;
                            if(exit) func = "a";
                            break; // add case 1

                case "add": a1 = getInput("Last Name");
                            a2 = getInput("First Name");
                            a3 = getInput("ID");
                            tmp = new Node(a1,a2,a3,ind);
                            AddNode(tmp, r.root);
                            ind++;
                            if(exit) func = "a";
                            break; //add case 2

                case "f":       a1 = getInput("Last Name");
                                Locate(a1, r.root);
                                if(!found)System.out.println("Nothing in the list matched your query");
                break; // find case 1

                case "find":    a1 = getInput("Last Name");
                                Locate(a1, r.root);
                                if(!found)System.out.println("Nothing in the list matched your query");
                break; // find case 2

            } // - switch(func.toLowerCase()){}

        } // - while(!exit) {

    } // - public static void main(String args[]){}

    public static int AddNode(Node addedNode, Node root){

        Node curr = root;
        boolean d = false;
        int depth = 1;

        while(!d) {

            if(addedNode.lastName.compareTo(curr.lastName)<0) {

                if(curr.left==null) {

                    curr.left = addedNode;
                    d = true;

                } // - if(curr.left==null) {}
                else{

                    curr=curr.left;
                    depth++;

                }// - else{}

            } // - if(addedNode.lastName.compareTo(curr.lastName)<0) {}
            else{

                if(curr.right==null) {

                    curr.right = addedNode;
                    d = true;

                }// - 
                else{

                    curr=curr.right;
                    depth++;
                    
                } // - else{}

            } // - else{}

        } // - while(!d) {}

        depth++;
        return depth;

    } // - public static void AddNode(int index, Node addedNode, Node root){}

    public static boolean BreadthFirst(Node tmp, ListElement tmpL, int orDepth, int depthCompare){
        
        int localDepth = depthCompare;
        tmpL.lastName = tmp.lastName;
        tmpL.firstName = tmp.firstName;
        tmpL.id = tmp.id;
        tmpL.next = new ListElement("","","");
        boolean r = false;

        if(tmp.left!=null) {

            if(BreadthFirst(tmp.left, tmpL.next, orDepth, depthCompare + 1)) r = true;

        } // - if(tmp.left!=null) {}

        if(tmp.right!=null) {

            if(BreadthFirst(tmp.right, tmpL.next, orDepth, depthCompare + 1)) r = true;

        } // - if(tmp.right!=null) {}

        if(depthCompare == orDepth) {

            System.out.print(tmp.index + " " + tmp.lastName + " | ");
            r = true;

        } // - if(depthCompare == orDepth) {

        return r;

    } // - public static void Postorder(Node tmp, ListElement tmpL){}

    public static void Inorder(Node tmp, ListElement tmpL){

        tmpL.lastName = tmp.lastName;
        tmpL.firstName = tmp.firstName;
        tmpL.id = tmp.id;
        tmpL.next = new ListElement("","","");

        System.out.println(tmp.index + " " + tmp.id + " " + tmp.lastName + " " + tmp.firstName);

        if(tmp.left!=null) {

            Inorder(tmp.left, tmpL.next);

        } // - if(tmp.left!=null) {}

        if(tmp.right!=null) {

            Inorder(tmp.right, tmpL.next);

        } // - if(tmp.right!=null) {}

    } // - public static void Inorder(Node tmp, ListElement tmpL){}

    public static void Preorder(Node tmp, ListElement tmpL){
        
        tmpL.lastName = tmp.lastName;
        tmpL.firstName = tmp.firstName;
        tmpL.id = tmp.id;
        tmpL.next = new ListElement("","","");

        if(tmp.left!=null) {

            Preorder(tmp.left, tmpL.next);

        } // - if(tmp.left!=null) {}

        System.out.println(tmp.index + " " + tmp.id + " " + tmp.lastName + " " + tmp.firstName);

        if(tmp.right!=null) {

            Preorder(tmp.right, tmpL.next);

        } // - if(tmp.right!=null) {}

    } // - public static void Preorder(Node tmp, ListElement tmpL){}

    public static void Postorder(Node tmp, ListElement tmpL){
        
        tmpL.lastName = tmp.lastName;
        tmpL.firstName = tmp.firstName;
        tmpL.id = tmp.id;
        tmpL.next = new ListElement("","","");

        if(tmp.left!=null) {

            Postorder(tmp.left, tmpL.next);

        } // - if(tmp.left!=null) {}

        if(tmp.right!=null) {

            Postorder(tmp.right, tmpL.next);

        } // - if(tmp.right!=null) {}

        System.out.println(tmp.index + " " + tmp.id + " " + tmp.lastName + " " + tmp.firstName);

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

        } // - while(!isFalse) {}

    } // - public static void BreadthTree(Node tmp) {}

    public static void PostTree(Node tmp) {

        Head h = new Head();
        h.head = new ListElement("","","");
        Postorder(tmp, h.head);
        System.out.println();

    } // - public static void PostTree(Node tmp) {}

    public static void InTree(Node tmp) {

        Head h = new Head();
        h.head = new ListElement("","","");
        Inorder(tmp, h.head);
        System.out.println();

    } // - public static void InTree(Node tmp) {}

    public static void PreTree(Node tmp) {

        Head h = new Head();
        h.head = new ListElement("","","");
        Preorder(tmp, h.head);
        System.out.println();

    } // - public static void PreTree(Node tmp) {}

    public static void Locate(String find, Node root) {

        Node tmp = root;

        if(tmp.left!=null) {

            Locate(find, tmp.left);

        } // - if(tmp.left!=null) {}

        if(tmp.right!=null) {

            Locate(find, tmp.right);

        } // - if(tmp.right!=null) {}

        if (find.toLowerCase().equals(tmp.lastName.toLowerCase())) {
        
            System.out.println("Found: " + tmp.lastName + " " + tmp.firstName + " " + tmp.id);
            found = true;
        
        } // - if(tmp.right!=null) {}

    } // - public static void Locate(String find, Node root) {}

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