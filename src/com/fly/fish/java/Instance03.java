package com.fly.fish.java;

public class Instance03 {
    public static void main(String[] args) {
        System.out.println(rob(new int[]{1, 2, 3, 1}));
        System.out.println(rob(new int[]{2, 7, 9, 3, 1}));
        System.out.println(rob(new int[]{2, 3,2}));
        System.out.println(rob(new int[]{0}));
        System.out.println(rob(new int[]{1,2,1,1}));
    }
    public static int rob(int[] nums) {
        if(nums.length==1) return nums[0];
        if(nums.length==2) return nums[0]>nums[1]?nums[0]:nums[1];
        int  max_mount=0;
        int [][]dp=new int[100][2];
        dp[0][0]=0;dp[0][1]=nums[0];
        for(int i=1;i<nums.length-1;i++){
            dp[i][0]=Math.max(dp[i-1][0],dp[i-1][1]);
            dp[i][1]=dp[i-1][0]+nums[i];
        }
        max_mount=Math.max(dp[nums.length-2][0],dp[nums.length-2][1]);
        //rob last number;
        dp[0][0]=0;
        dp[0][1]=0;
        for(int i=1;i<nums.length-2;i++){
            dp[i][0]=Math.max(dp[i-1][0],dp[i-1][1]);
            dp[i][1]=dp[i-1][0]+nums[i];
        }
        return max_mount>nums[nums.length-1]+Math.max(dp[nums.length-3][0],dp[nums.length-3][1])?max_mount:nums[nums.length-1]+Math.max(dp[nums.length-3][0],dp[nums.length-3][1]);
    }
}
