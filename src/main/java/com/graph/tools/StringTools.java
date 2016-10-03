package com.graph.tools;

import java.util.Set;
import java.util.function.Function;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public interface StringTools {
	
	public Function<String, Set<String>> splitToSet = (sequence) -> 
		Pattern.compile(" ")
			   .splitAsStream(sequence)
			   .collect(Collectors.toSet());

}