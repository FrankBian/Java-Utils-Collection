package com.gansuer.algorithms.graphs;

import com.gansuer.algorithms.graphs.directed.SymbolDirectedGraph;
import com.gansuer.algorithms.graphs.directed.Topological;
import com.gansuer.common.util.FileUtils;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

/**
 * Created by Frank on 7/5/16.
 */
public class TopologicalTest {

    private Topological topological;
    private SymbolDirectedGraph graph;

    @Before
    public void setUp() throws Exception {

        List<String> list = FileUtils.readFile(this.getClass().getClassLoader().getResource
                ("graph/jobs.txt").getFile());

        graph = new SymbolDirectedGraph(list, "/");
        System.out.println(graph);
        topological = new Topological(graph.getDigraph());
    }

    @Test
    public void getOrder() throws Exception {
        for (int item : topological.getOrder()) {
            System.out.println(graph.getName(item));
        }
    }

    @Test
    public void hasOrder() throws Exception {
        Assert.assertTrue(topological.hasOrder());
    }

    @Test
    public void rank() throws Exception {

    }

}