package org.psjava.algo.graph.pathfinder;

import org.junit.Assert;
import org.junit.Test;
import org.psjava.ds.PSCollection;
import org.psjava.ds.graph.Graph;
import org.psjava.ds.graph.DirectedEdge;
import org.psjava.ds.graph.TestGraphFactory;

public class DFSPathFinderTest {

    @Test
    public void test() {
        Graph<String, DirectedEdge<String>> g = TestGraphFactory.createDirectedNew(new String[][]{{"A", "B"}, {"B", "C"}, {"C", "D"}});
        PSCollection<DirectedEdge<String>> r = DFSPathFinder.getInstance().find(g, "A", "C", null);
        Assert.assertEquals("(A->B,B->C)", r.toString());
    }

    @Test
    public void testNoPath() {
        Graph<String, DirectedEdge<String>> g = TestGraphFactory.createDirectedNew(new String[][]{{"A", "B"}, {"C", "D"}});
        PSCollection<DirectedEdge<String>> r = DFSPathFinder.getInstance().find(g, "A", "C", null);
        Assert.assertNull(r);
    }

}
