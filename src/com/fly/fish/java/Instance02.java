package com.fly.fish.java;


import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;

public class Instance02 {
    public static void main(String[] args) {
        int []height={4,2,3};
        System.out.println(trap(height));
    }
    public static int trap(int[] height) {
        int count=0;
        for(int i=0;i<height.length;i++){
            if(height[i]!=0){
                int left=height[i];//左端高度
                //找下一个比他高的，同时记录下来离他最近的不为0的高度，和位置
                int flag=0;//用来标记是否找到第一个
                int fristRight=0,frightLocation=0,firstSize=0;
                int highRight=0;
                int size=0;
                for(int j=i+1;j<height.length;j++){
                    //第一个离他近的
                    size+=height[j];
                    if(height[j]!=0&&flag==0&&height[j]<left){
                        flag=1;
                        fristRight=height[j];
                        frightLocation=j;
                        firstSize=size-height[j];
                    }else if(flag==1&&height[j]>=fristRight){
                        fristRight=height[j];
                        frightLocation=j;
                        firstSize=size-height[j];
                    }
                    if(height[j]>=left){
                        flag=0;
                        highRight=height[j];
                        count+=(left*(j-i-1)-(size-height[j]));
                        i=j-1;
                        break;
                    }
                }
                if(flag==1){
                    count+=(fristRight*(frightLocation-i-1)-firstSize);
                    i=frightLocation-1;
                }
            }else{

            }
        }
        return count;
    }
}

