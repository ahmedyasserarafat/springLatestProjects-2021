package com.cbxservice.application;

import java.io.IOException;

import org.graalvm.polyglot.Context;
import org.graalvm.polyglot.Source;
import org.graalvm.polyglot.Value;

public class Application2 {

	public static void main(String[] args) throws IOException {
		  Source src = Source.newBuilder("js",
		            "(function (a, b) {\n" +
		            "  return a * b;\n" +
		            "})\n",
		            "mul.js").buildLiteral();
		  Context context=Context.newBuilder().build();
		 
		        // Evaluate JavaScript function definition
		        Value jsFunction = context.eval(src);
		 
		        // Create Java access to JavaScript function
		        Multiplier mul = jsFunction.as(Multiplier.class);
		        
		        System.out.println(mul.multiply(6, 7));
	}

}

@FunctionalInterface
interface Multiplier {
	int multiply(int a, int b);
}