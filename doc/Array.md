# 数组

### 数组中重复的数

在一个长度为n的数组里的所有数字都在0到n-1的范围内。 数组中某些数字是重复的，但不知道有几个数字是重复的。也不知道每个数字重复几次。请找出数组中任意一个重复的数字。 例如，如果输入长度为7的数组{2,3,1,0,2,5,3}，那么对应的输出是第一个重复的数字2。

* 排序后遍历
* 利用简易Hash
* 

[代码](..\src\com\offer\sword\DuplicateNumInArray.java)中二次边界检查很讲究！

### [二维数组中的查找](https://leetcode-cn.com/problems/search-a-2d-matrix-ii/)

编写一个高效的算法来判断 m x n 矩阵中，是否存在一个目标值。该矩阵具有如下特性：
每行中的整数从左到右按升序排列。
每行的第一个整数大于前一行的最后一个整数。

* 二维展开成一维数组。在一维数组中二分查找。

    ```java
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        int left = 0;
        int right = n * m - 1;
        while (left < right) {
            int mid = (left + right) >> 1;
            int col = mid % n;
            int row = mid / n;
            if (matrix[row][col] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return matrix[left / n][left % n] == target;
    }

    ```
### [搜索二维矩阵 II](https://leetcode-cn.com/problems/search-a-2d-matrix-ii/)

编写一个高效的算法来搜索 m x n 矩阵 matrix 中的一个目标值 target。该矩阵具有以下特性：

* 每行的元素从左到右升序排列。
* 每列的元素从上到下升序排列。

遍历不一定要从左到右，从上到下。这一题从右上角或者左下角开始查找。当前数比目标大就往上走，小了就往右走。
[实现代码](..\src\com\leetcode\top100\medium\SearchIn2DMatrix.java)

