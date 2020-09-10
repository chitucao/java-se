//package cn.chitucao.datastructures.bst;
//
///**
// * @author DennyFly
// * @since 2020/6/17 16:37
// */
//public class BSTMain {
//
//    public static void main(String[] args) {
//        BST<Integer> bst = new BST<>();
//        int[] nums = {5, 3, 6, 8, 4, 2};
//        for (int i = 0; i < nums.length; i++) {
//            bst.add(nums[i]);
//        }
//        /////////////////
//        //      5      //
//        //    /   \    //
//        //   3    6    //
//        //  / \    \   //
//        // 2  4     8  //
//        /////////////////
//        System.out.println(bst.contains(11));
//        System.out.println(bst);
//        //前序遍历  5 3 2 2 4 6 8
//        bst.preOrder();
//        System.out.println();
//
//        // 非递归前序遍历
//        bst.preOrderNr();
//        System.out.println();
//
//        //中序遍历 2 3 4 5 6 8
//        bst.inOrder();
//        System.out.println();
//
//        //后续遍历 2 4 3 8 6 5
//        bst.postOrder();
//        System.out.println();
//
//        // 层序遍历 5 3 6 2 4 8
//        bst.levelOrder();
//        System.out.println();
//
//        // 查找最小值
//        System.out.println(bst.minium());
//
//        // 查找最大值
//        System.out.println(bst.maxium());
////
////        //删除最大值
////        bst.removeMin();
////        System.out.println(bst);
////
////        //删除最小值
////        bst.removeMax();
////        System.out.println(bst);
//
//        //删除任意一个值
//        bst.remove(3);
//        System.out.println(bst);
//    }
//}
