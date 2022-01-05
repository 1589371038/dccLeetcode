import java.util.Arrays;

//621. 任务调度器
//给定一个用字符数组表示的 CPU 需要执行的任务列表。其中包含使用大写的 A - Z 字母表示的26 种不同种类的任务。
// 任务可以以任意顺序执行，并且每个任务都可以在 1 个单位时间内执行完。CPU 在任何一个单位时间内都可以执行一个任务，
// 或者在待命状态。
//然而，两个相同种类的任务之间必须有长度为 n 的冷却时间，因此至少有连续 n 个单位时间内 CPU 在执行不同的任务，
// 或者在待命状态。
//你需要计算完成所有任务所需要的最短时间。
//需要以n+1为一个任务周期
public class Task_maker {
    public int leastInterval(char[] tasks, int n) {
int time=0;
int [] taskNums=new int[26];
for(char c:tasks){
    taskNums[c-'A']++;
}
//统计好每个任务的数量并排序
        Arrays.sort(taskNums);
while(taskNums[25]>0){ //循环，当还有任务时
    int i=0;
    while(i<=n){  //每轮循环为0-n 共n+1个任务
        if(taskNums[25]==0){//任务做完了就break，不必把这一轮n+1个都走完
            break;
        }
        if(i<26&&taskNums[25-i]>0){//如果当前任务>1且i在26个任务范围内，则扣除
            taskNums[25-i]--;
        }
        //不管上面是否执行任务，空任务也要扣时间
        time++;
        i++;

    }
    Arrays.sort(taskNums);

}
return time;
    }
}
