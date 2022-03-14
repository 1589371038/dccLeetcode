/**
 * 剑指 Offer 60. n个骰子的点数
 * 把n个骰子扔在地上，所有骰子朝上一面的点数之和为s。输入n，打印出s的所有可能的值出现的概率。
 * 你需要用一个浮点数数组返回答案，其中第 i 个元素代表这 n 个骰子所能掷出的点数集合中第 i 小的那个的概率。
 * 示例 1:
 * 输入: 1
 * 输出: [0.16667,0.16667,0.16667,0.16667,0.16667,0.16667]
 * 示例 2:
 * 输入: 2
 * 输出: [0.02778,0.05556,0.08333,0.11111,0.13889,0.16667,0.13889,0.11111,0.08333,0.05556,0.02778]
 * <p>
 * 思路：概率！ n个骰子！ n和n-1个骰子的概率分布是有关系的
 * dp[n][m] 表示前n个骰子组成数字m的概率！
 * m的范围在 n - 6n 之间
 * 初始大小dp[n][6n]
 * 初始条件：dp[1][1-6] = 1/6
 * 递推：dp[n][m] = 求和dp[n-1][m-1]  dp[n-1][m-2] dp[n-1][m-3] 。。。/6  前提是这里的m-1到m-6需要在 dp[n-1]的范围内（n-1到6(n-1)）
 */

public class n个骰子的点数 {
    public static double[] dicesProbability(int n) {
        // index 1-n 代表骰子数量 是1到n   另外 1-6n代表凑出的数字是1-6n
        double[][] dp = new double[n + 1][6 * n + 1];
        for (int j = 1; j <= 6; j++) {
            dp[1][j] = 1 / 6.0;
        }
        // 从第二个骰子开始递推
        for (int i = 2; i < n + 1; i++) {
            // 此时骰子数是i哦
            for (int j = i; j <= 6 * i; j++) {
                for (int k = 1; k <= 6; k++) {
                    // j-k指的是 前n-1个骰子需要凑出的数字
                    if (j - k >= i - 1 && j - k <= (i - 1) * 6) {
                        dp[i][j] += dp[i - 1][j - k] / 6.0;
                    }
                }
            }
        }
        double[] result = new double[5 * n + 1];
        double[] dpLast = dp[n]; // dpLast的第一个有效的数字下标是n
        for (int i = 0; i < 5 * n + 1; i++) {
            result[i] = dpLast[i+n];
        }
        return result;
    }

    public static void main(String[] args) {
        dicesProbability(2);
    }
}
