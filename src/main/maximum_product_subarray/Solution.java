package maximum_product_subarray;

/**
 * Created by xin on 9/8/2016.
 */
public class Solution {
    public int maxProduct(int[] nums) {
        int[] maxPositive = new int[nums.length];
        int[] maxNegative = new int[nums.length];

        maxPositive[0] = 0;
        maxNegative[0] = 0;

        if(nums[0] > 0){
            maxPositive[0] = nums[0];
        } else if (nums[0] < 0){
            maxNegative[0] = nums[0];
        }
        int max = nums[0];
        for(int i=1; i<nums.length; i++){
            if(nums[i] < 0){
                maxPositive[i] = maxNegative[i - 1] * nums[i];
                maxNegative[i] = Math.min(nums[i], maxPositive[i - 1] * nums[i]);
            } else if (nums[i] > 0){
                maxPositive[i] = Math.max(maxPositive[i - 1] * nums[i], nums[i]);
                maxNegative[i] = maxNegative[i-1] * nums[i];
            } else {
                maxPositive[i] = 0;
                maxNegative[i] = 0;
            }
            if(maxPositive[i] > max){
                max = maxPositive[i];
            }
            System.out.println("max positive " + i + " is " + maxPositive[i]);
            System.out.println("max negative " + i + " is " + maxNegative[i]);
        }
        return max;
    }
}
