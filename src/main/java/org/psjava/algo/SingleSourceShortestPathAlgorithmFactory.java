package org.psjava.algo;

import org.psjava.algo.graph.shortestpath.SingleSourceShortestPathCalcStatus;
import org.psjava.algo.graph.shortestpath.SingleSourceShortestPathResult;
import org.psjava.algo.graph.shortestpath.SingleSourceShortestPathResultFactory;
import org.psjava.ds.graph.DirectedEdge;
import org.psjava.ds.graph.Graph;
import org.psjava.ds.math.Function;
import org.psjava.ds.numbersystrem.AddableNumberSystem;
import org.psjava.ds.numbersystrem.InfinitableAddableNumberSystem;

public class SingleSourceShortestPathAlgorithmFactory {

    public static SingleSourceShortestPathAlgorithmV2 create(final SingleSourceShortestPathAlgorithmMaterial material) {
        return new SingleSourceShortestPathAlgorithmV2() {
            @Override
            public <V, W, E extends DirectedEdge<V>> SingleSourceShortestPathResult<V, W, E> calc(Graph<V, E> graph, Function<E, W> weightFunction, V start, AddableNumberSystem<W> weightSystem) {
                final InfinitableAddableNumberSystem<W> ns = InfinitableAddableNumberSystem.wrap(weightSystem);
                final SingleSourceShortestPathCalcStatus<V, W, E> status = material.calc(graph, start, weightFunction, ns);
                return SingleSourceShortestPathResultFactory.create(start, status.distance, status.previous);
            }
        };
    }
    
}