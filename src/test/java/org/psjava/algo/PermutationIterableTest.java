package org.psjava.algo;

import org.junit.Test;
import org.psjava.ds.array.Array;
import org.psjava.ds.array.ArrayFromVarargs;

import static org.junit.Assert.*;

public class PermutationIterableTest {

    @Test
    public void test() {
        Iterable<Array<String>> permutations = PermutationIterable.create(ArrayFromVarargs.create("A", "B", "B"));
        assertEquals("((A,B,B),(A,B,B),(B,A,B),(B,B,A),(B,A,B),(B,B,A))", permutations.toString());
    }

}