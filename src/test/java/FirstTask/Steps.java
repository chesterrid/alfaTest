package FirstTask;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Steps {
    public void getDateNaturalOrder  (String fileLocation) throws IOException {
        Scanner s = new Scanner(new FileReader(fileLocation)).useDelimiter(",| ");
        List<Integer> myList = new ArrayList<Integer>();
        while (s.hasNext()) {
            myList.add(s.nextInt());
        }
        myList.sort(Comparator.naturalOrder());
        for (int a : myList){
            System.out.println(a);
        }
    }

    public void getDateReverseOrder  (String fileLocation) throws  IOException {
        Scanner s = new Scanner(new FileReader(fileLocation)).useDelimiter(",| ");
        List<Integer> myList = new ArrayList<Integer>();
        while (s.hasNext()) {
            myList.add(s.nextInt());
        }
        myList.sort(Comparator.reverseOrder());
        for (int a : myList){
            System.out.println(a);
        }
    }

}
