package com.fly.fish.java;

public class Instance03 {
    public static void main(String[] args) {
        System.out.println(longestCommonSubsequence("abcde", "ace"));
        System.out.println(longestCommonSubsequence("abcde", "aec"));
        System.out.println(longestCommonSubsequence("abc", "abc"));
        System.out.println(longestCommonSubsequence("ylqpejqbalahwr",  "yrkzavgdmdgtqpg"));


    }
    public static int longestCommonSubsequence(String text1, String text2) {
        int [][] dp =new int[1000][1000];
        for(int i=0;i<text1.length();i++){
            for(int j=0;j<text2.length();j++){
                if(text1.charAt(i)==text2.charAt(j)){
                    dp[i+1][j+1]=dp[i][j]+1;
                }else{
                    dp[i+1][j+1]=Math.max(dp[i][j+1],dp[i+1][j]);
                }
            }
        }
        return dp[text1.length()][text2.length()];
    }
}
