package queue;

import java.util.ArrayList;
import java.util.List;

//二叉树的Z型层序遍历
public class P0103_BinaryTreeZigzagLevelOrderTraversal {
    //java版本1ms，使用dfs，对应层判断一下奇偶，决定在表头还是表尾添加元素就可以了
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        traversal(root, res, 0);
        return res;
    }

    private void traversal(TreeNode root, List<List<Integer>> res, int level) {
        if (root == null) {
            return;
        }

        if (res.size() == level) {
            res.add(new ArrayList<Integer>());
        }

        if ((level & 1) == 1){
            res.get(level).add(0, root.val);
        } else {
            res.get(level).add(root.val);
        }

        traversal(root.left, res, level + 1);
        traversal(root.right, res, level + 1);
    }

}
