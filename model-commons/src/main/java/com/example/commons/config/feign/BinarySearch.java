package com.example.commons.config.feign;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

/**
 * @Author: Lc
 * @Date: 2021-10-13
 * @apiNote
 */
public class BinarySearch {
    public static int MoreThanHalfNum_Solution(int [] array) {
        Arrays.sort(array);
        int i=array[array.length/2];
        return IntStream.of(array).filter(k->k==i).count()>array.length/2?i:0;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2,2,3,3,3,3,3};
//        System.out.println(binarySearchRight(nums,3));
        System.out.println();
    }

//    public static boolean binarySearchArray(int[] nums){
//        int mid = nums.length/2;
//        int target = nums[mid];
//        if(mid>2 && mid%2!=1 && nums[mid-1]!=nums[mid]){
//            return false;
//        }else{
//            int left = mid,right = nums.length;
//            while (left<right){
//
//                int mid2 = (right+left)/2;
//                if(nums[mid2]==target){
//                    right = mid;
//                }else if(nums[mid] < target){
//                    left = mid+1;
//                }else if(nums[mid] > target){
//                    right = mid;
//                }
//            }
//            System.out.println(left);
//        }
//    }

    /**
     * 二分查找一个数
     */
    public static int binarySearch(int[] nums, int target){
        int left = 0,right = nums.length-1;
        while (left<=right){
            int mid = (right+left)/2;
            if(nums[mid]==target){
                return mid;
            }else if(nums[mid] < target){
                left = mid+1;
            }else if(nums[mid] > target){
                right = mid-1;
            }
        }
        return -1;
    }

    public static int binarySearchRight(int[] nums, int target){
        int left = 0,right = nums.length - 1;
        while (left<right){
            if(nums.length==0){
                return -1;
            }
            int mid = (right+left)/2;
            if(nums[mid]==target){
                left = mid + 1;
            }else if(nums[mid] < target){
                left = mid+1;
            }else if(nums[mid] > target){
                right = mid;
            }
        }
        return left - 1;
    }

    public static int binarySearchLeft(int[] nums, int target){
        int left = 0,right = nums.length;
        while (left<right){
            if(nums.length==0){
                return -1;
            }
            int mid = (right+left)/2;
            if(nums[mid]==target){
                right = mid;
            }else if(nums[mid] < target){
                left = mid+1;
            }else if(nums[mid] > target){
                right = mid;
            }
        }
        return left;
    }
}
