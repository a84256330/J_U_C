package Executor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorMain {

    public static void main(String[] args) {

//        ExecutorService pool = Executors.newFixedThreadPool(2);
//        pool.execute(new Runnable() {
//            public void run() {
//                for (int i = 0; i < 10; i++) {
//                    System.out.println(i);
//                }
//            }
//        });
        int[] nums = {1,2,3,4,5,6,1,1,1,1};
        System.out.println((new Solution()).majorityElement(nums));

    }
    static class Solution {
        public int majorityElement(int[] nums) {

            int count = 0;
            int a = nums[0];
            for (int i = 0; i < nums.length; i++) {
                if (a==nums[i]){
                    count ++;
                }else{
                    count--;
                    if(count==0){
                        a = nums[i+1];
                        continue;
                    }
                }
            }
            return a;
        }
    }

}
