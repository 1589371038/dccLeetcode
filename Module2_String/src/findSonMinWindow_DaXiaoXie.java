//76. 最小覆盖子串
//给你一个字符串 S、一个字符串 T，请在字符串 S 里面找出：包含 T 所有字符的最小子串。
//示例：
//输入: S = "ADOBECODEBANC", T = "ABC"
//输出: "BANC"
//这次考虑大小写，就要
//a 97 z 122   A 65 Z 90
public class findSonMinWindow_DaXiaoXie {
    public String minWindow(String s, String t) {
        if(s==null||t==null){
            return "";
        }
        boolean[] need=new boolean[58];
        int [] window=new int[58];
        char[] chars_s=s.toCharArray();
        char[] chars_t=t.toCharArray();
        int count=0;//记录目标数组有多少个不同字符
        for(char c:chars_t){
            int charIndex=c-'A';
            if(!need[charIndex]){  //如果是false改为true，且记录
                need[charIndex]=true;
                count++;
            }
        }
        //needIndex统计了哪些独立的字符被需要
        int[] needIndex=new int[count];
        int index=0;
        for(int i=0;i<need.length;i++){
            if(need[i]){
                needIndex[index]=i;
                index++;
            }
        }
        //初始化完成
        int left=0;
        int right=0;
        String result="";
        //开始循环双指针
        while(right<chars_s.length){
            int rightNum=chars_s[right]-'A';
            //如果是t中需要的字符，则统计加上去
            if(need[rightNum]){
                window[rightNum]++;
            }
            //加了之后判断是否全了  needIndex中记录了所有need中为true的下标，因此遍历windows中needindex，看是否>1
            boolean flag=true;
            for(int j:needIndex){
                if(window[j]<1){
                    flag=false;
                    break;
                }
            }
            if(flag){  //如果全了，判断长度小于当前就替代result
                String sub=s.substring(left,right+1);
                if (result.equals("")){  //如果是初始的""则直接代替
                    result=sub;
                }
                else{
                    if(sub.length()<result.length()){
                        result=sub;
                    }

                }
                //并且还要尝试缩进左边,如果左边可以缩进(是必要的字符且数量大于1||是不必要的字符)
                while(!need[chars_s[left]-'A']||window[chars_s[left]-'A']>1){
                    if(!need[chars_s[left]-'A']){ //如果是非必要的字符，left++就行
                        left++;
                    }
                    if(window[chars_s[left]-'A']>1){ //如果是必要的冗余字符，left++且统计减少一
                        window[chars_s[left]-'A']--;
                        left++;
                    }

                }
                //缩完之后再次判断结果,由于左缩的时候注意了只删除非必要和冗余的字符，所以必定是全的，只要判断长度就好了
                String newSub=s.substring(left,right+1);
                if (result.equals("")){  //如果是初始的""则直接代替
                    result=newSub;
                }
                else{
                    if(newSub.length()<result.length()){
                        result=newSub;
                    }

                }

            }
            right++; //在一个while循环后right++
        }
        return result;

    }
}
