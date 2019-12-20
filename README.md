# OnlineJudge

## Done

### Review

* 96 [不同的二叉搜索树](https://leetcode-cn.com/problems/unique-binary-search-trees/)
* 200 [岛屿数量](https://leetcode-cn.com/problems/number-of-islands/): 污染函数，如何保证一次深度搜索后，不会再次参加另一次深度搜索。掰手指头法：找到一个岛屿后就将其置为海水，然后寻找下一个岛屿。
* 208 [实现 Trie (前缀树)](https://leetcode-cn.com/problems/implement-trie-prefix-tree/)
* 221 [最大正方形](https://leetcode-cn.com/problems/maximal-square)
* 309 [股票问题](https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/): 总结一系列的股票问题.
* 416 [分割等和子集](https://leetcode-cn.com/problems/partition-equal-subset-sum):回溯需要剪枝

### It's ok

* 98 [验证二叉搜索树](https://leetcode-cn.com/problems/validate-binary-search-tree/)

## Category

### DP

* 139 [单词拆分](https://leetcode-cn.com/problems/word-break/submissions/)
* 309 [股票问题](https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/)
* 322 [零钱兑换](https://leetcode-cn.com/problems/coin-change/)
* 152 :two_hearts:[最大乘积子序列](https://leetcode-cn.com/problems/maximum-product-subarray/): 注意全部最大和局部最大，为什么dp[i] = max(dp[i-1]*nums[i], num[i])可以处理不连续的情况？
* 337 [打家劫舍3](https://leetcode-cn.com/problems/house-robber-iii/)
### Backtrack

