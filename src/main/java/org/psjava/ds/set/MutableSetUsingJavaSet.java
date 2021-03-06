package org.psjava.ds.set;

import java.util.Iterator;

import org.psjava.ds.map.SetEqualityTester;
import org.psjava.util.AssertStatus;
import org.psjava.util.EqualityTester;
import org.psjava.util.IterableToString;
import org.psjava.util.OrderFreeIterableHash;
import org.psjava.util.StrictEqualityTester;

@Deprecated
public class MutableSetUsingJavaSet<T> implements MutableSet<T> {

    private final java.util.Set<T> javaset;

    public MutableSetUsingJavaSet(java.util.Set<T> set) {
        this.javaset = set;
    }

    @Override
    public void clear() {
        javaset.clear();
    }

    @Override
    public boolean contains(T v) {
        return javaset.contains(v);
    }

    @Override
    public void add(T v) {
        boolean added = javaset.add(v);
        AssertStatus.assertTrue(added, "Already exist in set");
    }

    @Override
    public void addIfAbsent(T v) {
        javaset.add(v);
    }

    @Override
    public Iterator<T> iterator() {
        return javaset.iterator();
    }

    @Override
    public int size() {
        return javaset.size();
    }

    @Override
    public void remove(T v) {
        boolean removed = javaset.remove(v);
        AssertStatus.assertTrue(removed, "given value is not in set");
    }

    @Override
    public void removeIfExist(T v) {
        javaset.remove(v);
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public String toString() {
        return IterableToString.toString(this);
    }

    @Override
    public int hashCode() {
        return OrderFreeIterableHash.hash(this);
    }

    @Override
    public boolean equals(Object obj) {
        return StrictEqualityTester.areEqual(this, obj, new EqualityTester<PSSet<T>>() {
            @Override
            public boolean areEqual(PSSet<T> o1, PSSet<T> o2) {
                return SetEqualityTester.areEqual(o1, o2);
            }
        });
    }

}