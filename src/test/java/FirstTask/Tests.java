package FirstTask;
import org.junit.Test;

import java.io.IOException;

public class Tests extends Steps{

    @Test
    public void test () throws IOException {
        getDateNaturalOrder("FileForFirstTask.txt");
    }

    @Test
    public void getDateFromFile () throws IOException{
        getDateReverseOrder("FileForFirstTask.txt");
    }
}
