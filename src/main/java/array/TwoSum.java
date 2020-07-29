package array;

import java.util.HashMap;
import java.util.Map;

/**
 * 两数之和
 *
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 *
 * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
 *
 * 示例:
 *
 * 给定 nums = [2, 7, 11, 15], target = 9
 *
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 *
 * 复杂度分析：
 *
 * 时间复杂度：O(n)O(n)， 我们只遍历了包含有 nn 个元素的列表一次。在表中进行的每次查找只花费 O(1)O(1) 的时间。
 *
 * 空间复杂度：O(n)O(n)， 所需的额外空间取决于哈希表中存储的元素数量，该表最多需要存储 nn 个元素。
 * 
 * @author NoCodeInMyHeart
 * @date 2019/5/22 17:50
 */
public class TwoSum {

    public static void main(String[] args) {
        int[] nums = new int[]{15, 7, 11, 2};
        int target = 9;
        int[] result = towSum(nums,target);
        for(int i : result){
            System.out.println(i);
        }
    }

    private static int[]  towSum(int[] nums,int target){
        Map<Integer,Integer> map = new HashMap<>(8);
        for (int i = 0; i < nums.length; i++){
            int num = nums[i];
            int subtract = target - num;
            if(map.containsKey(subtract)){
                return new int[]{map.get(subtract),i};
            }
            map.put(num,i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }

}
