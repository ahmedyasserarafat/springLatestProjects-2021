package com.cbxservice.application;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

import org.graalvm.polyglot.Context;
import org.graalvm.polyglot.Source;
import org.graalvm.polyglot.Value;

public class Application implements ContextCallback {

	public static void main(String[] args) {

		// Context context = Context.create("js");
		// runScript("console.log('Hello from the project')", context);
		Context context = Context.newBuilder("js").allowIO(true).allowAllAccess(true).build();

		try {
			// read all lines
			File handleBarFile = new File(
					"/home/ahmed/CTIGTBM/CT/Sources/Igtbm/Dependencies/Supporting_Jars/handlebars/handlebars.js");

			// System.out.println(handleBarFile.exists());
			context = Context.create("js");
			Source source = Source.newBuilder("js", handleBarFile.toURI().toURL()).build();
			context.eval(source);

			Value hh = context.getBindings("js").getMember("Handlebars");
			// System.out.println(hh);
			try {
				String content = new String(Files.readAllBytes(Paths.get(
						"/home/ahmed/CTIGTBM/CT/Sources/Igtbm/Dependencies/Supporting_Jars/handlebars/accordionMenu.cttpl")));

				String[] dd = new String[2];
				dd[0]=content;
				
				String pre = hh.getMember("precompile").execute(dd).asString();
				System.out.println(pre);
			} catch (IOException ex) {
				ex.printStackTrace();
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		}

		Value result = context.eval("js", "var list=[1,2,'foo',true]; list;");
		if (result.hasArrayElements()) {
			for (int i = 0; i < result.getArraySize(); i++) {
				//System.out.println(result.getArrayElement(i));
			}
		}

		String script = "console.log('I will welcome you ' + welcomeCount + ' times.');"
				+ "for(var i=0; i<welcomeCount; i++){ console.log('Welcome') }";

		Value bindings = context.getBindings("js");
		bindings.putMember("welcomeCount", 3);
		runScript(script, context);

		runScript("var x = 'variable';", context);
		String jsVariable = context.getBindings("js").getMember("x").asString();

		//System.out.println(jsVariable);

		/*
		 * Application ss=new Application();
		 * 
		 * ss.runInPluginContext(ss);
		 */
	}

	private static Value runScript(String script, Context context) {
		return context.eval("js", script);
	}

	public void runInPluginContext(ContextCallback callback) {
		ClassLoader oldCl = Thread.currentThread().getContextClassLoader();
		Thread.currentThread().setContextClassLoader(getClass().getClassLoader());
		callback.call();
		Thread.currentThread().setContextClassLoader(oldCl);
	}

	@Override
	public void call() {
		Context jsContext = Context.create("js");
		runScript("console.log('Hello from the project')", jsContext);

	}
}

interface ContextCallback {

	void call();

}