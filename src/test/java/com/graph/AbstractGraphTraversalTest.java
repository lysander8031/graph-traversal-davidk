package com.graph;

import static org.junit.Assert.assertEquals;

import java.util.Set;

import org.junit.Before;
import org.junit.Test;

import com.graph.model.GraphNode;
import com.graph.tools.StringTools;

public abstract class AbstractGraphTraversalTest {
	
	private GraphTraversal traversal;
	
	@Before
    public void setup() {
        this.traversal = configureGraphTraversal();
    }
	
	protected abstract GraphTraversal configureGraphTraversal();
	
	@Test
	public void shouldResolveDependencies() {
		givenDependencyGraph();

		expectDependenciesForNodeToBe("B C E F G H", 	nodeA);
		expectDependenciesForNodeToBe("C E F G H", 		nodeB);
		expectDependenciesForNodeToBe("G", 				nodeC);
		expectDependenciesForNodeToBe("A B C E F G H", 	nodeD);
		expectDependenciesForNodeToBe("F H", 			nodeE);
		expectDependenciesForNodeToBe("H", 				nodeF);
	}
	
	private void expectDependenciesForNodeToBe(String sequence, GraphNode node) {
		Set<String> dependencyNames = StringTools.splitToSet.apply(sequence);
		
		Set<String> traversedNodeNames = this.traversal.walk(node.getChildren());
		
		assertEquals(dependencyNames, traversedNodeNames);
	}
	
	private void givenDependencyGraph() {
		//A -> B,C
		nodeA.addChild(nodeB);  
		nodeA.addChild(nodeC);
		
		//B -> C,E
		nodeB.addChild(nodeC);
		nodeB.addChild(nodeE);
		
		//C -> G
		nodeC.addChild(nodeG);
		
		//D -> A, F
		nodeD.addChild(nodeA);
		nodeD.addChild(nodeF);
		
		//E -> F
		nodeE.addChild(nodeF);
		
		//F -> H
		nodeF.addChild(nodeH);
	}
	
	private GraphNode nodeA = new GraphNode("A");
	private GraphNode nodeB = new GraphNode("B");
	private GraphNode nodeC = new GraphNode("C");
	private GraphNode nodeD = new GraphNode("D");
	private GraphNode nodeE = new GraphNode("E");
	private GraphNode nodeF = new GraphNode("F");
	private GraphNode nodeG = new GraphNode("G");
	private GraphNode nodeH = new GraphNode("H");

}