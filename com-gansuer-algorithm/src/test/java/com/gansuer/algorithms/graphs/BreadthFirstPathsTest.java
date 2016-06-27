package com.gansuer.algorithms.graphs;

import com.gansuer.common.util.FileUtils;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

/**
 * Created by Frank on 6/27/16.
 */
public class BreadthFirstPathsTest {

    private BreadthFirstPaths breadthFirstPaths;

    private Graph graph;
    private final String fileName = "graph/tinyCG.txt";
    private List<String> lines;
    private int vertices = 0, edge = 0;

    @Before
    public void setUp() throws Exception {
        String path = getClass().getClassLoader().getResource(fileName).getFile();
        lines = FileUtils.readFile(path);
        vertices = Integer.parseInt(lines.get(0));
        edge = Integer.parseInt(lines.get(1));

        graph = new AdjacencyListGraph(vertices);
        for (int i = 2; i < lines.size(); i++) {
            String[] token = lines.get(i).split(" ");
            graph.addEdge(Integer.parseInt(token[0]), Integer.parseInt(token[1]));
        }
        System.out.println(graph.toString());
    }

    @Test
    public void distanceTo() throws Exception {
        breadthFirstPaths = new BreadthFirstPaths(graph, 0);
        Assert.assertEquals(0, breadthFirstPaths.distanceTo(0));
        Assert.assertEquals(1, breadthFirstPaths.distanceTo(5));
        Assert.assertEquals(1, breadthFirstPaths.distanceTo(1));
        Assert.assertEquals(1, breadthFirstPaths.distanceTo(2));
        Assert.assertEquals(2, breadthFirstPaths.distanceTo(3));
        Assert.assertEquals(2, breadthFirstPaths.distanceTo(4));

    }

    @Test
    public void pathTo() throws Exception {
        breadthFirstPaths = new BreadthFirstPaths(graph, 0);
        for (int v = 0; v < vertices; v++) {
            if (breadthFirstPaths.hasPathTo(v)) {
                System.out.printf("0 to %d (%d):  ", v, breadthFirstPaths.distanceTo(v));
                for (int x : breadthFirstPaths.pathTo(v)) {
                    if (x == 0) System.out.print(x);
                    else System.out.print("-" + x);
                }
                System.out.println();
            } else {
                System.out.printf("%d to %d (-):  not connected\n", 0, v);
            }
        }
    }
}