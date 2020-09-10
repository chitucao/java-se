package cn.chitucao.leetcode.level1simple;

/**
 * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 *
 * 示例 1:
 *
 * 输入: 123
 * 输出: 321
 *  示例 2:
 *
 * 输入: -123
 * 输出: -321
 * 示例 3:
 *
 * 输入: 120
 * 输出: 21
 * 注意:
 *
 * 假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−231,  231 − 1]。请根据这个假设，如果反转后整数溢出那么就返回 0。
 *
 * 2^31-1=2147483647,-2^31=-2147483648
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-integer
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class Q7整数反转 {

    public static void main(String[] args) {
        int source = 54321;

        int target = reverse(source);

        System.out.println(target);
    }

    /**
     * 方法：弹出和推入数字 & 溢出前进行检查
     * 时间复杂度：Ologn(处理的数字的数量)
     * 空间复杂度：O1
     * @param x
     * @return
     */
    private static int reverse(int x) {
        int rev = 0;
        while (x != 0) {
            int pop = x % 10;  //弹出最后一个数字
            x /= 10;    //原始数据除以10
            if (rev > Integer.MAX_VALUE/10 || (rev == Integer.MAX_VALUE / 10 && pop > 7)) { //校验溢出+
                return 0;
            }
            if (rev < Integer.MIN_VALUE/10 || (rev == Integer.MIN_VALUE / 10 && pop < -8)) {
                return 0;
            }
            rev = rev * 10 + pop;   //推入最后一个数字作为第一个数字
        }
        return rev;
    }
}
