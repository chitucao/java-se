package cn.chitucao.leetcode.level1simple;

/**
 * @author DennyFly
 * @since 2020/8/4 15:00
 */
public class Q704二分查找 {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9};
//        int result = search(arr, 7);
        int result = search(nums, 0, nums.length - 1, 2);
        System.out.println(result);
    }


    /**
     * 非递归
     * 时间复杂度 O(log2n)
     */
    public static int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;

            //有序数组，这里是操作数组的下标
            if (nums[mid] > target) {
                right = right - 1;
            } else if (nums[mid] < target) {
                left = left + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    /**
     * 递归
     */
    public static int search(int[] nums, int left, int right, int target) {
        if (left > right) {
            return -1;
        }
        int mid = left + (right - left) / 2;
        if (nums[mid] == target) {
            return mid;
        } else if (nums[mid] > target) {
            return search(nums, left, mid - 1, target);
        } else {
            return search(nums, mid + 1, right, target);
        }
    }
}
