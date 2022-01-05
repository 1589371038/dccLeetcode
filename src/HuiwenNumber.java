public class HuiwenNumber {
    public int countSubstrings(String s) {
int n=s.length();
int number=0;
int left,right;
for(int i=0;i<=2*n-1;i++){
    left=i/2;
    right=left+i%2;
    while(left>=0&&right<=n-1&&s.charAt(left)==s.charAt(right)){
        number++;
        left--;
        right++;
    }
        }
        return number;
    }
}
