public class Test {
    public static void main(String[] args) {
        int [] nums={1,2,3,4,5,6};
        打乱数组384 s = new 打乱数组384(nums);
        int[] shuffle = s.shuffle();
        for(int i:shuffle){
            System.out.print(i+" ");
        }
        System.out.println();
        int[] shuffle1 = s.shuffle();
        for(int i:shuffle1){
            System.out.print(i+" ");
        }
        System.out.println();
        int[] reset = s.reset();
        for(int i:reset){
            System.out.print(i+" ");
        }



    }
}
