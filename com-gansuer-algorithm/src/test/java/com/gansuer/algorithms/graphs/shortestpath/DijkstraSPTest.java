package com.gansuer.algorithms.graphs.shortestpath;

import com.gansuer.common.util.FileUtils;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

/**
 * Created by Frank on 7/27/16.
 */
public class DijkstraSPTest {

    private EdgeWeightDigraph digraph;
    private String fileName = "graph/tinyEWD.txt";
    private int vertices;
    private int edges;

    private DijkstraSP dijkstraSP;

    @Before
    public void setUp() throws Exception {
        List<String> list = FileUtils.readFile(this.getClass().getClassLoader().getResource
                (fileName).getFile());
        vertices = Integer.parseInt(list.get(0).trim());
        edges = Integer.parseInt(list.get(1).trim());

        digraph = new EdgeWeightDigraph(vertices);
        for (int i = 2; i < list.size(); i++) {
            String[] arrs = list.get(i).trim().split(" ");
            digraph.addEdge(new DirectedEdge(Integer.parseInt(arrs[0]), Integer.parseInt(arrs[1]),
                    Double.parseDouble(arrs[2])));
        }

        assert digraph.getEdges() == edges;
        dijkstraSP = new DijkstraSP(digraph, 0);
    }

    @Test
    public void distTo() throws Exception {
        Assert.assertEquals(0.0, dijkstraSP.distTo(0), 0.000001);
    }

    @Test
    public void hasPathTo() throws Exception {
        for (int v = 0; v < digraph.getVertices(); v++) {
            if (dijkstraSP.hasPathTo(v)) System.out.println(0 + "->" + v);
        }
    }

    @Test
    public void pathTo() throws Exception {
        for (int v = 0; v < digraph.getVertices(); v++) {
            if (dijkstraSP.hasPathTo(v)){
                System.out.print(0+"->" + v +":    ");
                dijkstraSP.pathTo(v).forEach(item -> System.out.print(item +"    "));
                System.out.println();
            }
        }
    }

}