package FIRe;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Main {

    public Main() throws FileNotFoundException {

        Scanner in = new Scanner(new FileReader("filename.txt"));

        StringBuilder sb = new StringBuilder();
        while(in.hasNext()) {
            sb.append(in.next());
        }
        in.close();
        String outString = sb.toString();
    }
}
