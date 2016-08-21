package insert_delete_getrandom_duplicate;

/**
 * Created by xin on 8/21/2016.
 */
public class Test {
    @org.junit.Test
    public void test(){
        RandomizedCollection collection = new RandomizedCollection();
        collection.insert(0);
        collection.remove(0);
        collection.insert(-1);
        collection.remove(0);

        System.out.println(collection.getRandom());
        System.out.println(collection.getRandom());
        System.out.println(collection.getRandom());
        System.out.println(collection.getRandom());
        System.out.println(collection.getRandom());
    }
}
