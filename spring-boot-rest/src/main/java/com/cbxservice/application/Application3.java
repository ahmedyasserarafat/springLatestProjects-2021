package com.cbxservice.application;

import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;

import javax.json.Json;
import javax.json.JsonObject;
import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

import org.graalvm.polyglot.Context;
import org.graalvm.polyglot.Value;

import com.fasterxml.jackson.databind.ObjectMapper;

public class Application3 {

	public static void main(String[] args) throws IOException, ScriptException, NoSuchMethodException {

		/*
		 * String primejs = new String(Files.readAllBytes( Paths.get(
		 * "/home/ahmed/Desktop/spring-boot-rest/src/main/java/com/cbxservice/application/prime.js"
		 * ))); try (Context context = Context.create()) { Value jsBindings =
		 * context.getBindings("js"); Value jsProgram = context.eval("js", primejs);
		 * Value eratosthenes = jsBindings.getMember("sieve");
		 * 
		 * Value result = eratosthenes.execute("5","2");
		 * 
		 * System.out.println("There are " + result.getArraySize() +
		 * " prime numbers below " + 5_000_000); for (int i = 0; i <
		 * result.getArraySize(); i++) { System.out.println(result.getArrayElement(i));
		 * } }
		 */

		String content = new String(Files.readAllBytes(Paths.get(
				"/home/ahmed/CTIGTBM/CT/Sources/Igtbm/Dependencies/Supporting_Jars/handlebars/accordionMenu.cttpl")));

		String handlebarjs = new String(Files.readAllBytes(Paths
				.get("/home/ahmed/Desktop/spring-boot-rest/src/main/java/com/cbxservice/application/handlebars.js")));
		try (Context context = Context.create()) {
			Value jsBindings = context.getBindings("js");
			Value jsProgram = context.eval("js", handlebarjs);

			JsonObject dev = Json.createObjectBuilder().add("noEscape", true).build();

			// System.out.println(dev);

			/*
			 * ScriptEngine engine = new ScriptEngineManager().getEngineByName("nashorn");
			 * 
			 * 
			 * Object result = engine.eval( "var greeting='hello world';" +
			 * "print(greeting);" + "greeting");
			 * 
			 * engine.eval(new FileReader(
			 * "/home/ahmed/Desktop/spring-boot-rest/src/main/java/com/cbxservice/application/handlebars.js"
			 * ));
			 * 
			 * Invocable invocable = (Invocable) engine;
			 * 
			 * Object result = invocable.invokeFunction("Handlebars.precompile",content);
			 * System.out.println(result);
			 */
			
			HashMap<String, Boolean> dd=new HashMap();
			dd.put("dd", true);
			
			 Value result = context.eval("js", 
	                    "({ "                   +
	                        "noEscape   : true, "      +    
	                    "})");
			 
			 System.out.println(result);
			
			//ObjectMapper dd=
			
			

			Value eratosthenes = jsBindings.getMember("Handlebars").getMember("precompile").execute(content, result,"kk");
			System.out.println(eratosthenes.asString());

		}
	}

}
