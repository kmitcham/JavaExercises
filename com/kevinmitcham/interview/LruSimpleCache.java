package com.kevinmitcham.interview;
import java.util.LinkedHashMap;
import java.util.Map;

public class LruSimpleCache<K, V> {

    Map<K, V> map = new LinkedHashMap (  );


    public LruSimpleCache (final int limit) {
           map = new LinkedHashMap <K, V> (16, 0.75f, true) {
               @Override
               protected boolean removeEldestEntry(final Map.Entry<K, V> eldest) {
                   return super.size() > limit;
               }
           };
    }
    public void put ( K key, V value ) {
        map.put ( key, value );
    }

    public V get ( K key ) {
        return map.get(key);
    }

    //For testing only
    public V getSilent ( K key ) {
        V value =  map.get ( key );
        if (value!=null) {
            map.remove ( key );
            map.put(key, value);
        }
        return value;
    }

    public void remove ( K key ) {
        map.remove ( key );
    }

    public int size () {
        return map.size ();
    }

    public String toString() {
        return map.toString ();
    }


}