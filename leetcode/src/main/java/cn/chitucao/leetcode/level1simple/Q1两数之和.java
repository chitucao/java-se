package cn.chitucao.leetcode.level1simple;

import java.util.Arrays;
import java.util.HashMap;

/**
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 * <p>
 * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
 * <p>
 * 示例:
 * <p>
 * 给定 nums = [2, 7, 11, 15], target = 9
 * <p>
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/two-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class Q1两数之和 {

    public static void main(String[] args) {
        int[] arr = {2, 7, 11, 15};

        int[] ints;
        ints = twoSum1(arr, 9);
//        ints = twoSum2(arr, 9);


        System.out.println(Arrays.toString(ints));
    }

    /**
     * 方法一：暴力法
     * 时间复杂度On2
     * 空间复杂度O1
     */
    private static int[] twoSum1(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] == target - nums[i]) {
                    return new int[] { i, j };
                }
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    /**
     * 方法二：两遍哈希表
     * 时间复杂度：On
     * 空间复杂度：On
     */
    private static int[] twoSum2(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        // hashmap存的是 value -> index
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            int component = target - nums[i];
            if (map.containsKey(component) && map.get(component) != i) { //这里注意不能重复使用同一个元素
                return new int[]{i, map.get(component)};
            }

        }
        throw new IllegalArgumentException("No two sum solution");
    }

    /**
     * 方法三：一遍哈希表
     * 时间复杂度On
     * 空间复杂度On
     */
    private static int[] twoSum3(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int component = target - nums[i];
            if (map.containsKey(component)) {
                return new int[]{i, map.get(component)};
            }
            // 这里将hashmap的初始化同时放在了遍历的里面
            map.put(nums[i],i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }


}
