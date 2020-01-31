# 二叉树

## 遍历

[参考：二叉树的遍历递归实现和非递归实现](https://blog.csdn.net/coder__666/article/details/80349039)

中序

root节点放在中间遍历，先遍历左子树，然后是root节点，最后是右子树

#### 递归

```java
public void inOrder(TreeNode root) {
    if (root == null) {
        return;
    }
    inOrder(root.left);
    System.out.println(root.val);
    inOrder(root.right);
}
```

#### 非递归

```java
/**
 * 每到一个节点 A，因为根的访问在中间，将 A 入栈。然后遍历左子树，接着访问 A，最后遍历右子树。
 * 在访问完 A 后，A 就可以出栈了。因为 A 和其左子树都已经访问完成。
 * @param root 树的根节点
 */
public void inOrder(TreeNode root){
    if(root == null){
        return;
    }
    TreeNode node = root;
    LinkedList<TreeNode> stack = new LinkedList<>();
    while(node != null || !stack.isEmpty()){
        // 先处理左孩子
        while(node != null){
            stack.push(node);
            node = node.left;
        }
        // 遍历当前节点 
        node = stack.pop();
        System.out.println(node.val);
        // 转向右子树处理,如果node为空，也就是当前子树遍历完毕，需要从栈中弹出下一个中间节点处理.
        node = node.right;
    }
}
```



###  前序

root节点最先访问，然后是左右孩子节点

#### 递归

```java
public void preOrderRecursive(TreeNode root) {
    if (root == null) {
        return;
    }
    System.out.println(root.val);
    preOrderRecursive(root.left);
    preOrderRecursive(root.right);
}
```

#### 非递归

```java
public void preOrder(TreeNode root) {
    if (root == null) {
        return;
    }
    Stack<TreeNode> stack = new Stack<>();
    stack.push(root);
    while(!stack.isEmpty()){
        TreeNode node = stack.pop();
        // 先遍历，然后左右孩子节点
        System.out.println(node.val);
        if(node.right != null ){
            stack.push(node.right);
        }
        if(node.left != null){
            stack.push(node.left);
        }
    }
}
```



### 后序

最先访问左子树，然后是右子树，中间节点放在最后访问

#### 递归

```java
    public void afterOrderRecursive(TreeNode root) {
        if (root == null) {
            return;
        }
        afterOrderRecursive(root.left);
        afterOrderRecursive(root.right);
        System.out.print(root.val+"\t");
    }
```

#### 非递归

***简单方法：前序遍历时入另外一个栈，最终结果就是入栈的反转。***

这里使用另外一个方法：

首先要搞清楚先序、中序、后序的非递归算法共同之处：用栈来保存先前走过的路径，以便可以在访问完子树后,可以利用栈中的信息,回退到当前节点的双亲节点,进行下一步操作。
    后序遍历的非递归算法是三种顺序中最复杂的，原因在于，后序遍历是先访问左、右子树,再访问根节点，而在非递归算法中，利用栈回退到时，并不知道是从左子树回退到根节点，还是从右子树回退到根节点，如果从左子树回退到根节点，此时就应该去访问右子树，而如果从右子树回退到根节点，此时就应该访问根节点。所以相比前序和后序，必须得在压栈时添加信息，以便在退栈时可以知道是从左子树返回，还是从右子树返回进而决定下一步的操作。

```java

public void afterOrder(TreeNode root) {
        if (root == null) {
            return;
        }

        int left = 1;// 在辅助栈里表示左节点
        int right = 2;// 在辅助栈里表示右节点
        Stack<TreeNode> stack = new Stack<TreeNode>();
        Stack<Integer> flagStack = new Stack<Integer>();

        TreeNode node = root;

        while (node != null || !stack.isEmpty()) {
            while (node != null) {
                stack.push(node);
                flagStack.push(left);
                node = node.left;
            }

            //  换成if也是可以的，可以减少外层判断次数
            while (!stack.empty() && flagStack.peek() == right) {
                // 如果是从右子节点返回父节点，则任务完成，将两个栈的栈顶弹出
                flagStack.pop();
                System.out.print(stack.pop().val + "\t");
            }

            if (!stack.empty() && flagStack.peek() == left) {
                // 如果是从左子节点返回父节点，则将标记改为右子节点,转向右子节点
                flagStack.pop();
                flagStack.push(right);
                node = stack.peek().right;
            }
        }
```

## 常见题目

1. 根据前序结果和中序遍历结果，重建二叉树

    [LeetCode105](https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/)

2. 中序遍历中的下一个节点

   [剑指offer给定二叉树](https://blog.csdn.net/zhoudengkai/article/details/71107902)