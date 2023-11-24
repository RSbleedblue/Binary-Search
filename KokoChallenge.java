/*
Koko is fond of consuming bananas and is faced with n piles of bananas, where the ith pile has piles[i] bananas. Meanwhile, the guards have temporarily left and are expected to return in h hours.

Koko has the freedom to determine her banana-eating speed per hour, which she can set to k. Every hour, she selects a pile of bananas and consumes k bananas from that pile. However, if the selected pile has less than k bananas, she finishes all the bananas in that pile and won't eat any more bananas in that hour.

Koko prefers to eat slowly but is still determined to finish consuming all the bananas before the guards come back.

Return the minimum integer k such that she can eat all the bananas within h hours.
*/

import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc =  new Scanner(System.in);
        int size = sc.nextInt();
        int arr[] = new int[size];
        for(int i = 0; i < size; i++){
            arr[i] = sc.nextInt();
        }
        int tt = sc.nextInt();
        int res = kokoSpeed(arr,size,tt);
        System.out.println(res);
    }
    public static int kokoSpeed(int arr[],int n, int tt){
        int si = 1;
        int ei = maxEle(arr,n);
        while(si <= ei){
            int mid = (si + ei) / 2;
            if(checkSpeed(arr,mid,tt) == true){
                ei = mid - 1;
            }
            else{
                si = mid + 1;
            }
        }
        return si;
    }
    public static boolean checkSpeed(int arr[], int mid,int tt){
        int time = 0;
        for(int i = 0; i < arr.length; i++){
            time += arr[i] / mid;
            if(arr[i]%mid != 0){
                time += 1;
            }
        }
        if(time > tt){
            return false;
        }
        else {
             return true;
        }
    }
    public static int maxEle(int arr[],int size){
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < size; i++){
            int temp = arr[i];
            max = Math.max(max,temp);
        }
        return max;
    }
}
