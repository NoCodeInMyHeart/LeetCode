package array;

/**
 * 给你一个长度为 n 的整数数组 nums，其中 n > 1，返回输出数组 output ，其中 output[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积。
 * 示例:
 *
 * 输入: [1,2,3,4]
 * 输出: [24,12,8,6]
 *  
 *
 * 提示：题目数据保证数组之中任意元素的全部前缀元素和后缀（甚至是整个数组）的乘积都在 32 位整数范围内。
 *
 * 说明: 请不要使用除法，且在 O(n) 时间复杂度内完成此题。
 *
 * 进阶：
 * 你可以在常数空间复杂度内完成这个题目吗？（ 出于对空间复杂度分析的目的，输出数组不被视为额外空间。）
 *
 * 思路：
 * 除自己外的所有数的乘积  等价于   自己左侧所有数的乘积 * 自己右侧所有数的乘积
 * 为什么不用除法，因为如果自己为0，则有问题
 *
 */
public class ProductExceptSelf {
    
    public static int[] productExceptSelf(int[] nums) {
        int numsLength = nums.length;
        int[] output = new int[numsLength];

        output[0] = 1;
        for (int i = 1; i < numsLength; i++) {
            output[i] = nums[i - 1] * output[i-1];
        }

        int R = 1;
        for (int i = numsLength - 1; i >= 0; i--) {
           output[i] = output[i] * R;
           R *= nums[i];
        }
        return output;
    }
    
    public static void main(String[] args){
        int[] nums = {1,2,3,4};
        int[] output = productExceptSelf(nums);
        int i = 0;
    }
}
