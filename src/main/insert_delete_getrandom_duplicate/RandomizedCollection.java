package insert_delete_getrandom_duplicate;

import java.util.*;

/**
 * Created by xin on 8/21/2016.
 */
public class RandomizedCollection {

    private ArrayList<Integer> list;
    private HashMap<Integer, Set<Integer>> index;
    private Random random;
    /** Initialize your data structure here. */
    public RandomizedCollection() {
        this.list = new ArrayList<Integer>();
        this.index = new HashMap<Integer, Set<Integer>>();
        this.random = new Random();
    }

    /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
    public boolean insert(int val) {
        list.add(val);
        if(index.containsKey(val)){
            index.get(val).add(list.size() - 1);
            return false;
        } else {
            HashSet record = new HashSet<Integer>();
            record.add(list.size() - 1);
            index.put(val, record);
            return true;
        }
    }

    /** Removes a value from the collection. Returns true if the collection contained the specified element. */
    public boolean remove(int val) {
        if(index.containsKey(val)){
            Set<Integer> record = index.get(val);
            int valPos = record.iterator().next();

            //Move last val to given val position
            int lastVal = list.get(list.size() -  1);
            list.set(valPos, lastVal);
            index.get(lastVal).remove(list.size() -1);
            index.get(lastVal).add(valPos);

            //Remove val
            record.remove(valPos);
            list.remove(list.size() - 1);
            if(record.size() == 0){
                index.remove(val);
            }
            return true;
        } else {
            return false;
        }
    }

    /** Get a random element from the collection. */
    public int getRandom() {
        int randomPos = this.random.nextInt(list.size());
        return this.list.get(randomPos);
    }


}
