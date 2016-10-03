package com.graph.traversal;

import com.graph.AbstractGraphTraversalTest;
import com.graph.GraphTraversal;

public class FunctionalGraphTraversalTest extends AbstractGraphTraversalTest {

	@Override
	protected GraphTraversal configureGraphTraversal() {
		return new FunctionalGraphTraversal();
	}

}