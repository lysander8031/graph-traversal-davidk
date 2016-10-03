package com.graph.traversal;

import com.graph.AbstractGraphTraversalTest;
import com.graph.GraphTraversal;

public class BreadthFirstGraphTraversalTest extends AbstractGraphTraversalTest {
	
	@Override
	public GraphTraversal configureGraphTraversal() {
		return new BreadthFirstGraphTraversal();
	}

}