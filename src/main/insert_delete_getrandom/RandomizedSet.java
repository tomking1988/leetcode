package insert_delete_getrandom;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

/**
 * Created by xin on 8/21/2016.
 */
public class RandomizedSet {

    private HashMap<Integer, Integer> index;
    private ArrayList<Integer> list;
    private Random random;

    /** Initialize your data structure here. */
    public RandomizedSet(){
        this.index = new HashMap<Integer, Integer>();
        this.list = new ArrayList<Integer>();
        this.random = new Random();
    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if(index.containsKey(val)){
            return false;
        } else {
            index.put(val, list.size());
            list.add(val);
            return true;
        }
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        //switch with the last val
        if(index.containsKey(val)){
            int lastVal = this.list.get(this.list.size() - 1);
            int valPos = this.index.get(val);

            //val is not the last val
            if(valPos != this.list.size() - 1){
                index.put(lastVal, valPos);
                index.remove(val);
                list.set(valPos, lastVal);
                list.remove(list.size() - 1);
            } else {
                list.remove(list.size() - 1);
                index.remove(val);
            }
            return true;
        } else {
            return false;
        }

    }

    /** Get a random element from the set. */
    public int getRandom() {
        if(this.list.size() == 0){
            return 0;
        }
        return  list.get(this.random.nextInt(list.size()));
    }
}
