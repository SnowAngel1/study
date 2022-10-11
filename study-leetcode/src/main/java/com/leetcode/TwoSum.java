package com.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author：江南
 * @Classname TwoSum
 * @Description 两数之和  https://leetcode-cn.com/problems/two-sum/
 * @Date 2022/4/11 22:29
 */
public class TwoSum {
    public static void main(String[] args) {
        for (int i : twoSum(new int[]{1, 3, 4, 2}, 6, false)) {
            System.out.println(i);
        }
    }

    private static int[] twoSum(int[] nums, int target, boolean flag) {
        int length = nums.length;
        if (flag) {
            for (int i = 0; i < nums.length; i++) {
                for (int j = length - 1; j > 0; j--) {
                    if (i == j) {
                        continue;
                    }
                    if (nums[i] + nums[j] == target) {
                        return new int[]{i, j};
                    }
                }
            }
        } else {
            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < nums.length; i++) {
                int key = target - nums[i];
                if (map.containsKey(key)) {
                    return new int[]{map.get(key), i};
                }
                map.put(nums[i], i);
            }
        }
        throw new RuntimeException("没有目标值");

    }
}
