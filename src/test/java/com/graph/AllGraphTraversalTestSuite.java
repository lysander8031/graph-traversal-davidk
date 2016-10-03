package com.graph;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.graph.traversal.BreadthFirstGraphTraversalTest;
import com.graph.traversal.FunctionalGraphTraversalTest;

@RunWith(Suite.class)
@SuiteClasses({
	BreadthFirstGraphTraversalTest.class,
	FunctionalGraphTraversalTest.class
})
public class AllGraphTraversalTestSuite { }