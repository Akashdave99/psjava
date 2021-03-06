package org.psjava.example.algo;

import org.junit.Assert;
import org.junit.Test;
import org.psjava.algo.graph.matching.HopcroftKarpAlgorithm;
import org.psjava.ds.graph.MutableBipartiteGraph;

/**
 * @implementation {@link HopcroftKarpAlgorithm}
 */
public class HopcroftKarpAlgorithmExample {

    @Test
    public void example() {

        // Let's make a simple bipartite graph.

        MutableBipartiteGraph<String> g = MutableBipartiteGraph.create();

        g.insertLeftVertex("L1");
        g.insertLeftVertex("L2");
        g.insertLeftVertex("L3");
        g.insertRightVertex("R1");
        g.insertRightVertex("R2");

        g.addEdge("L1", "R1");
        g.addEdge("L1", "R2");
        g.addEdge("L2", "R1");
        g.addEdge("L3", "R1");

        // In this example, (L1-R2, L2-R1) is one of the solutions.

        int matchCount = HopcroftKarpAlgorithm.getInstance().calc(g); // must be 2

        Assert.assertEquals(2, matchCount);
    }
}
