import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;

public class KaoShi2 {
    public static void main(String[] args) {
   Scanner scanner=new Scanner(System.in);
   String super1=scanner.nextLine();
   String super2=scanner.nextLine();
   Map<Character,Integer> myHashMap=new HashMap<>();
   int mysm=0;
   for(Character c:super1.toCharArray()){
       myHashMap.put(c,myHashMap.getOrDefault(c,0)+1);
   }
   for(Character c:super2.toCharArray()){
       if(myHashMap.containsKey(c)&&myHashMap.get(c)>0){
           myHashMap.put(c,myHashMap.get(c)-1);
           mysm++;
       }
   }
   System.out.println(mysm);
    }

}


