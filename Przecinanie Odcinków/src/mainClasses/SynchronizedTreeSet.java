package mainClasses;

import java.util.TreeSet;

public class SynchronizedTreeSet extends TreeSet<Point>{

    @Override
    public synchronized boolean isEmpty() {
        return super.isEmpty();
    }

    @Override
    public synchronized boolean contains(Object o) {
        return super.contains(o);
    }
//    @Override
//    public synchronized boolean add(Object o) {
//        return super.contains(o);
//    

    // and the same for all other methods
}