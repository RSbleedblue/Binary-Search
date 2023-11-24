import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc =  new Scanner(System.in);
        int size = sc.nextInt();
        int arr[] = new int[size];
        for(int i = 0;i < size; i++){
            arr[i] = sc.nextInt();
        }
        int ans = index(arr,size);
        System.out.println(ans);
    }
    public static int index(int arr[],int n){
        int si = 0;
        int ei = n-1;
        while(si <= ei){
            int mid = (si + ei) / 2;
            int cVal = arr[mid];
            int prev = (mid-1+n)%n;
            int next = (mid+1)%n;
            if(cVal <= arr[prev] && cVal <= arr[next]){
                return mid-1;
            }
            else if(cVal <= arr[ei]){
                ei = mid - 1;
            }
            else if(cVal >= arr[si]){
                si = mid + 1;
            }
        }
        return -1;
    }
}
