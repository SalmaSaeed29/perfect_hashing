package perfect_hashing;

import java.util.ArrayList;

class ONspace {
    hashFunc hashFun;
    ON2space[] hashTable;

    public void hash(Integer[] keys) {
        hashFun = new hashFunc(keys.length);
        hashTable = new ON2space[keys.length];
        ArrayList<Integer>[] toHashTable = new ArrayList[keys.length];
        for (int i = 0; i < keys.length; i++) {
            int s = hashFun.hash(keys[i]);
            if(toHashTable[s] == null)
                toHashTable[s] = new ArrayList<>();
            toHashTable[s].add(keys[i]);
        }
        int memorySpace = 0;
        for (int i = 0; i < keys.length; i++) {
            hashTable[i] = new ON2space();
            if(toHashTable[i] != null) {
                Integer[] tmpKeys = new Integer[toHashTable[i].size()];
                for (int j = 0; j < toHashTable[i].size(); j++) {
                    tmpKeys[j] = toHashTable[i].get(j);
                }
                hashTable[i].hash(tmpKeys);
                memorySpace += tmpKeys.length*tmpKeys.length;
            }
        }
        System.out.println("Took "+memorySpace+" memory element");
    }

    public boolean contains(Integer key) {
        int s = hashFun.hash(key);
        return hashTable[s].contains(key);
    }
}