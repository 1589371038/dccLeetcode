/**
 * moon
 */

public class 赎金信 {
    public static boolean canConstruct(String ransomNote, String magazine) {
        int[] randomNoteCount = new int[26];
        int[] magazineCount = new int[26];
        for(int i=0;i<ransomNote.length();i++){
            randomNoteCount[ransomNote.charAt(i)-'a']++;
        }
        for(int i=0;i<magazine.length();i++){
            magazineCount[magazine.charAt(i)-'a']++;
        }
        for(int i=0;i<26;i++){
            if(randomNoteCount[i]<magazineCount[i]){
                return false;
            }
        }
        return true;

    }

    public static void main(String[] args) {

    }
}
