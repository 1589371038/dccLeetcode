import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

//
public class ReadText {
    public static void main(String[] args) throws Exception {

readFile("D://test.txt",2);
    }
    public static void readFile(String fileName, int lineNumber) throws Exception {
        BufferedReader br=new BufferedReader(new FileReader(fileName));
        String line=br.readLine();
        int num=1;
        while(line!=null){
            if(num==lineNumber){
                System.out.println(line);
            }
            line=br.readLine();
            num++;
        }
        br.close();

    }
}
