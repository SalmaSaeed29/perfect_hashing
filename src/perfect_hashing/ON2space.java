package perfect_hashing;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

class ON2space {
	hashFunc hashFun;
    Integer[] hashTable;
 
    public void hash(Integer[] keys) {
        Set<Integer> set = new LinkedHashSet<>(Arrays.asList(keys)); /* convert keys array into non-repeated set */
        Integer[] uniqueKeys = new Integer[set.size()];
        Iterator<Integer> iterator = set.iterator();
        int index = 0;
        /* put the non-repeated set elements back to a new array */
        while (iterator.hasNext()) {
            uniqueKeys[index++] = iterator.next();
        }
        int hashCounter = 0;
        boolean hasCollision = true;
        while (hasCollision) {
            hashCounter++;
            hasCollision = false;
            hashTable = new Integer[uniqueKeys.length * uniqueKeys.length];
            hashFun = new hashFunc(uniqueKeys.length * uniqueKeys.length); /* table size */
            for (int i = 0; i < uniqueKeys.length; i++) {
                int s = hashFun.hash(uniqueKeys[i]); /* result of multiplying h*x */
                if(hashTable[s] != null) {
                    hasCollision = true;
                    break;
                }
                else
                    hashTable[s] = new Integer(uniqueKeys[i]);
            }
        }
        System.out.println("hashed in "+hashCounter+" times.");
    }

    public boolean contains(Integer key) {
        if(hashFun == null)
            return false;
        int s = hashFun.hash(key);
        if(hashTable[s] == null)
            return false;
        if(hashTable[s].equals(key))
            return true;
        else
            return false;
    }
    
}