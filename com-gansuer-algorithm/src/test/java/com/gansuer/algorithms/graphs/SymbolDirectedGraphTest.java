package com.gansuer.algorithms.graphs;

import com.gansuer.common.util.FileUtils;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

/**
 * Created by Frank on 7/5/16.
 */
public class SymbolDirectedGraphTest {
    private SymbolDirectedGraph symbolDirectedGraph;
    private List<String> lines;

    @Before
    public void setUp() throws Exception {
        lines = FileUtils.readFile(this.getClass().getClassLoader().getResource("graph/routes" +
                ".txt").getFile());
        symbolDirectedGraph = new SymbolDirectedGraph(lines," ");
        System.out.println(symbolDirectedGraph.toString());

        System.out.println("--------------graph end ---------------");
    }

    @Test
    public void contains() throws Exception {
        //Assert.assertTrue("Bacon, Kevin",symbolDirectedGraph.contains("Bacon, Kevin"));
        //Assert.assertTrue("Hershey, Barbara",symbolDirectedGraph.contains("Bacon, Kevin"));
        //Assert.assertTrue("Geppi, Cindy",symbolDirectedGraph.contains("Bacon, Kevin"));
        Assert.assertTrue(symbolDirectedGraph.contains("JFK"));
        Assert.assertTrue(symbolDirectedGraph.contains("PHX"));
    }
}