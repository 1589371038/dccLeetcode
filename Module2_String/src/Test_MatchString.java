public class Test_MatchString {
    public static void main(String[] args) {
        String s1="abcdef";
        String s2="cdf";
        MatchString_Baoli mb=new MatchString_Baoli();
        System.out.println(mb.violenceMatch(s1,s2));

        Match_String_kmp ms=new Match_String_kmp();
        String s="abcdaabcd";
        int[] array=ms.getNext(s);
        for(int i=0;i<array.length;i++) {
            System.out.println(array[i]);
        }
    }
}
