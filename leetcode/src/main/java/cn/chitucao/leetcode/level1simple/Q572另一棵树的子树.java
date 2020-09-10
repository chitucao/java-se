package cn.chitucao.leetcode.level1simple;

import cn.chitucao.leetcode.common.TreeNode;

/**
 * @author DennyFly
 * @since 2020/8/4 15:40
 */
public class Q572另一棵树的子树 {

    public static void main(String[] args) {
        boolean result = isSubtree(new TreeNode(1), new TreeNode(1));
        System.out.println(result);
    }

    public static boolean isSubtree(TreeNode s, TreeNode t) {
        if (t == null) {
            return true;   // t 为 null 一定都是 true
        }
        if (s == null) {
            return false;  // 这里 t 一定不为 null, 只要 s 为 null，肯定是 false
        }
        return isSubtree(s.left, t) || isSubtree(s.right, t) || isSameTree(s, t);
    }

    /**
     * 判断两棵树是否相同
     */
    public static boolean isSameTree(TreeNode s, TreeNode t) {
        // true情况
        if (s == null && t == null) {
            return true;
        }
        //false情况
        if (s == null || t == null) {
            return false;
        }
        if (s.val != t.val) {
            return false;
        }
        return isSameTree(s.left, t.left) && isSameTree(s.right, t.right);
    }

}
