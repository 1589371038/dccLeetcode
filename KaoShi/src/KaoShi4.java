import java.util.ArrayList;
import java.util.Scanner;

public class KaoShi4 {
    public ArrayList<String> findCommonString (ArrayList<ArrayList<String>> values) {
        if(values==null||values.size()<1){
            return new ArrayList<String>();
        }
        // write code here
        ArrayList<String> compare=new ArrayList<>(values.get(0));
        for(int i=1;i<values.size();i++){
            ArrayList<String> array=values.get(i);
            ArrayList<String> newCompare=new ArrayList<>();

            for(int j=0;j<array.size();j++){
                if(compare.contains(array.get(j))){
                    newCompare.add(array.get(j));
                }
            }
            compare.clear();
            compare=newCompare;

        }
        return compare;
    }
}
