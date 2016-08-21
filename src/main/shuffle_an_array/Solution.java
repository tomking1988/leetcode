package shuffle_an_array;

import java.util.Random;

/**
 * Created by xin on 8/14/2016.
 */
public class Solution {
    private int[] origin;

    public Solution(int[] nums) {
        this.origin = nums;
    }

    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        return this.origin;
    }

    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        Random random = new Random();
        int length = this.origin.length;
        int[] shuffled = new int[length];
        for(int index = 0; index < length; index ++){
            shuffled[index] = this.origin[index];
        }

        for(int i = length - 1; i >= 0; i --){
            int j = random.nextInt(i + 1);
            int temp = shuffled[i];
            shuffled[i] = shuffled[j];
            shuffled[j] = temp;
        }
        return shuffled;
    }
}
