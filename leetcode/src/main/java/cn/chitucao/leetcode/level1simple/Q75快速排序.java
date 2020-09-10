package cn.chitucao.leetcode.level1simple;

/**
 * @description:
 * @author: dennyfly.zhu
 * @since: 2020-08-05 00:07
 **/
public class Q75快速排序 {

    public static void main(String[] args) {
        int[] arr = {49, 38, 65, 97, 23, 22, 76, 1, 5, 8, 2, 0, -1, 22};
        quickSort(arr, 0, arr.length - 1);
        System.out.println("排序后:");
        for (int i : arr) {
            System.out.print(i + "_");
        }
    }

//    public static void quickSort(int[] nums, int low, int high) {
//        if (low < high) {
//            //基准数据索引
//            int index = getIndex(nums, low, high);
//
//            quickSort(nums, low, index - 1);
//            quickSort(nums, index + 1, high);
//        }
//    }
//
//    private static int getIndex(int[] nums, int low, int high) {
//
//        //基准数据 第一个
//        int temp = nums[low];
//
//        while (low < high) {
//            // 当队尾的元素大于等于基准数据时,向前挪动high指针
//            while (low < high && nums[high] >= temp) {
//                high--;
//            }
//            // 如果队尾元素小于tmp了,需要将其赋值给low
//            nums[low] = nums[high];
//            // 当队首元素小于等于tmp时,向前挪动low指针
//            while (low < high && nums[low] <= temp) {
//                low++;
//            }
//            // 当队首元素大于tmp时,需要将其赋值给high
//            nums[high] = nums[low];
//        }
//
//        // 跳出循环时low和high相等,此时的low或high就是tmp的正确索引位置
//        // 由原理部分可以很清楚的知道low位置的值并不是tmp,所以需要将tmp赋值给arr[low]
//        nums[low] = temp;
//        return low;
//    }

    public static void quickSort(int[] nums, int low, int high) {
        if (low < high) {
            int index = getIndex(nums, low, high);
            quickSort(nums, low, index - 1);
            quickSort(nums, index + 1, high);
        }
    }

    private static int getIndex(int[] nums, int low, int high) {
        int temp = nums[low];
        while (low < high) {
            while (low < high && nums[high] >= temp) {
                high--;
            }
            nums[low] = nums[high];
            while (low < high && nums[low] <= temp) {
                low++;
            }
            nums[high] = nums[low];
        }
        nums[low] = temp;
        return low;
    }

}
