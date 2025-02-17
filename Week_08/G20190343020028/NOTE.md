# 学习笔记

## 小结

- 高级动态规划：
    - 动态规划和递归或者分治没有根本上的区别（关键看有无最优的子结构）
    - 拥有共性：找到重复子问题
    - 差异性：最优子结构、中途可以淘汰次优解

- 高级字符串算法：主要是使用 DP 方式找出问题重复性
- 字符串匹配算法：
    - 暴力法：`O（N*M）` 时间复杂度
    - Rabin-karp 算法：在暴力算法的基础上，如果首字母匹配，则检查 .substring(i, M) 与 pat 是否相等，如果相等的话再挨个字符比较。**属于一种剪枝算法。**
    - KMP 算法：
        - 整理 pat 的 prefix table
        - 对于全部前缀词找出相同的公共前后缀
        - 在匹配错误的时候，将 pat 拉到 prefix table 对应记录的位置，然后继续匹配

## 不同路径II-状态转移方程

### 解法一

看了下 [Short-JAVA-solution](https://leetcode.com/problems/unique-paths-ii/discuss/23250/Short-JAVA-solution) 这个题解，感觉很精妙：

- 状态定义：dp[width]（dp[0] = 1）
    - 只定义了一维的数组，用来存储当前行的状态集
    - 在循环到下一行时，在不考虑新行内本身是否障碍物的情况下，能否通行、通行路径的数量，完全继承自上一行。 ***这一点我理解了很久，感觉也是这个题解思维最精妙的地方。***
    - 每行第一列，如果上一行可通过，则仍然是 1；如果上一行不能通过，则与上一行相同
    - 之后的每一列，都是左侧格子（dp[j - 1]）和上侧格子（实际上就是 dp[j]）之和
- 状态转移方程：
    - `if (row[i] == 1) dp[j] = 0`
    - `else if (j > 0) dp[j] = dp[j] + dp[j - 1]`

### 解法二

这个是官方题解，也是所有题解里最常见的一个思路：

- 状态定义 dp[i][j]（dp[0][0] = 1）：表示当前格子可通过的方案之和
- 状态转移方程：
    - 当前为障碍物，则没有可通行路径： `if (dp[i][j] == 1) dp[i][j] = 0`
    - 首行非障碍物的格子，继承前一列的通行方案 `else if (i == 0) dp[i][j] = dp[i][j - 1]`
    - 首列非障碍物的格子，继承前一行的通行方案 `else if (i == 0) dp[i][j] = dp[i - 1][j]`
    - 其他格子，为左侧格子和上侧格子之和 `else dp[i][j] = dp[i][j - 1] + dp[i - 1][j]`
