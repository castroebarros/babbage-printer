package net.castroebarros.babbage;


import java.io.File;
import java.util.HashMap;
import java.util.Iterator;

import org.apache.commons.configuration2.Configuration;
import org.apache.commons.configuration2.builder.fluent.Configurations;
import org.apache.commons.configuration2.ex.ConfigurationException;

public class Babbage {
	private static Babbage singletone;
	private Configurations configs;

	private Babbage() {
		configs = new Configurations();
	}

	public static Babbage getInstance() {
		if (singletone == null) {
			singletone = new Babbage();
		}
		return singletone;
	}

	public HashMap<String, Object> getPrinterConfiguration(String name) {
		try {
		    Configuration 			file = configs.properties(new File("printers.properties"));
		    HashMap<String, Object> map  = new HashMap<String, Object>();
		    
		    Iterator<String> entries = file.getKeys(name);
		    while (entries.hasNext()) {
		    	String entry    = entries.next();
		    	String property = entry.split("\\.")[1];
		    	
		    	map.put(property, file.getString(entry));
		    }
		    
		    if (map.isEmpty()) {
		    	throw new RuntimeException("Handler not found on configurations: " + name);
		    }
		    
		    return map;
		} catch (ConfigurationException cex) {
			cex.printStackTrace();
			throw new RuntimeException("Could not read printers.properties", cex);
		}
	}
	
	public Handler createHandler(String name) {
		HashMap<String, Object> configurations = getPrinterConfiguration(name);
		String className   = (String) configurations.get("handler");
		String printerName = (String) configurations.get("printer");
		try {
			Handler handler = (Handler) Class.forName(className).newInstance();
			handler.setName(name);
			handler.setPrinterName(printerName);
			return handler;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}
