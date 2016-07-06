package com.gansuer.algorithms.graphs;

import com.gansuer.algorithms.graphs.undirected.SymbolUndirectedGraph;
import com.gansuer.common.util.FileUtils;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

/**
 * Created by Frank on 7/5/16.
 */
public class SymbolUndirectedGraphTest {

    private SymbolUndirectedGraph symbolUndirectedGraph;
    private List<String> lines;

    @Before
    public void setUp() throws Exception {
        lines = FileUtils.readFile(this.getClass().getClassLoader().getResource("graph/routes" +
                ".txt").getFile());
        symbolUndirectedGraph = new SymbolUndirectedGraph(lines," ");
        System.out.println(symbolUndirectedGraph.toString());

        System.out.println("--------------graph end ---------------");
    }

    @Test
    public void contains() throws Exception {
        //Assert.assertTrue("Bacon, Kevin",symbolUndirectedGraph.contains("Bacon, Kevin"));
        //Assert.assertTrue("Hershey, Barbara",symbolUndirectedGraph.contains("Bacon, Kevin"));
        //Assert.assertTrue("Geppi, Cindy",symbolUndirectedGraph.contains("Bacon, Kevin"));
        Assert.assertTrue(symbolUndirectedGraph.contains("JFK"));
        Assert.assertTrue(symbolUndirectedGraph.contains("PHX"));
    }

    //@Test
    //public void getIndex() throws Exception {
    //
    //}
    //
    //@Test
    //public void getName() throws Exception {
    //
    //}
    //
    //@Test
    //public void getGraph() throws Exception {
    //
    //}

}