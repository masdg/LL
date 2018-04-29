import java.io.*;
import java.util.*;
import java.lang.Math.*;
import java.lang.StringBuilder;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ListElement {

    String lastName;
    String firstName;
    String id;
    ListElement next;

    public ListElement(String lName, String fName, String ident) {

        lastName = lName;
        firstName = fName;
        id = ident;
        next = null;

    }

}