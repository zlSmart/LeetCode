package com.day09;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

import java.util.Arrays;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * https://leetcode-cn.com/problems/array-partition-i/
 */
public class 数组拆分I_561 {
    public static void main(String[] args) {
    }
}
// 处理较慢
class Solution3 {
    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        Integer integer = IntStream.range(0, nums.length
        ).filter(i -> (i & 1) == 0
        ).mapToObj(i -> nums[i]
        ).reduce(Integer::sum).orElse(0);
        return integer.intValue();

    }
}
class Solution2 {
    public int arrayPairSum(int[] nums) {
        int result = 0;
        Arrays.sort(nums);
        for(int i =0;i<nums.length;i+=2){
            result += nums[i];
        }
        return result;
    }
}