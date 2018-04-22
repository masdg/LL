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
        r.root = new Node(binList[0],binList[0],binList[0],1);
        int ind = 1;

        while(ind < binList.length) {

            System.out.println(ind);
            Node tmpR = new Node(binList[ind],binList[ind],binList[ind],ind);
            AddNode(ind, tmpR, r.root);
            ind++;

        }

        StoreList(r.root);

    } // - public static void main(String args[]){}

    public static void AddNode(int index, Node addedNode, Node root){

        Node curr = root;
        String bin;
        bin = toBinary(index);
        int stringLength  = toBinary(index).length();

        for(int p = 1; p < stringLength; p++){

            if(String.valueOf(bin.charAt(p)).equals("0")) {

 //               System.out.print(curr.lastName.trim() + " ");

                if(curr.left==null){curr.left = addedNode; System.out.print("yes ");}
                else {

                    curr = curr.left;
                    System.out.print(bin.charAt(p) + "left ");

                }

            }
            else if(String.valueOf(bin.charAt(p)).equals("1")) {

//                System.out.print(curr.lastName + " ");

                if(curr.right==null){curr.right = addedNode; System.out.print("yes ");}
                else {

                    curr = curr.right;
                    System.out.print(bin.charAt(p) + "right ");

                }

            };

        }

        System.out.println(curr.lastName);

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

    public static void StoreList(Node tmp) {

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

        System.out.println();
        Inorder(tmp, h.head);
        System.out.println();
        Preorder(tmp, h.head);
        System.out.println();
        Postorder(tmp,h.head);

    }

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