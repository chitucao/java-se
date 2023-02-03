package cn.chitucao.test;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author DennyFly
 * @since 2020/6/11 11:07
 */
public class ArrayTest {

    // 空的数组会给默认值0
    @Test
    public void testEmptyArray() {
        int[] arr = new int[10];
        for (int i : arr) {
            System.out.println(arr[i]);
        }
    }

    // 测试打印正方形二维数组
    @Test
    public void testSquareArray() {
        int b[][] = {{1, 2, 3}, {4, 5, 6}};
        System.out.println("b:" + Arrays.deepToString(b));
    }

    // 测试三角形二维数组动态构建和打印
    @Test
    public void testTriangleArray() {
        // 一维是5行，二维的长度动态申请节省空间
        int[][] arr = new int[5][];
        for (int i = 0; i < arr.length; i++) {
            // 动态申请二维的空间
            arr[i] = new int[i + 1];
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = j;
            }
        }
        System.out.println(Arrays.deepToString(arr));

        // 杨辉三角
        int[][] arr2 = {
                {0, 0, 0, 0, 5},
                {0, 0, 0, 7, 0, 1},
                {0, 0, 2, 0, 3, 0, 4},
                {0, 4, 0, 9, 0, 6, 0, 1},
                {2, 0, 7, 0, 9, 0, 4, 0, 5}
        };

        // 复制一个二维数组，注意这里是一个正方形数组
        int[][] arr3 = new int[arr2.length][arr2[arr2.length - 1].length];
        // 一维数组的长度
        int startPoint = arr2.length - 1;
        // 二维数组的长度
        int maxPoint = arr2[arr2.length - 1].length - 1;
        for (int i = 0; i <= startPoint; i++) {
            for (int j = 0; j <= maxPoint; j++) {
                arr3[i][j] = j;
            }
        }
        System.out.println(Arrays.deepToString(arr3));

    }

    @Test
    public void testMatrix() {
        int[][] arr = new int[4][4];
        for (int i = 0; i < 4; i++) {
            Arrays.fill(arr[i], 2);
        }
        System.out.println(Arrays.deepToString(arr));
    }

}
