import java.io.*;
import java.util.*;
import java.lang.Math.*;
import java.lang.StringBuilder;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Node {

    String lastName;
    String firstName;
    String id;
    int index;
    Node right;
    Node left;

    public Node(String lName, String fName, String ident, int ind) {

        lastName = lName;
        firstName = fName;
        id = ident;
        index = ind;
        right = null;
        left = null;

    } // - public Node() {}

} // - public class Node {}
