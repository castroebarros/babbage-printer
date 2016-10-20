package net.castroebarros.babbage;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import java.util.HashMap;

import org.junit.Before;
import org.junit.Test;

public class BabbageTest {
	
	Babbage pm = null;
	
	@Before
	public void setUp() {
		pm = Babbage.getInstance();
	}

	@Test
	public void testSingletone() {
		Babbage p1 = Babbage.getInstance();
		Babbage p2 = Babbage.getInstance();
		assertEquals(p1, p2);
	}
	
	@Test
	public void testGetPrinterConfiguration() {
		HashMap<String, Object> printer = pm.getPrinterConfiguration("pdf");
		assertNotNull(printer);
	}
	
	@Test
	public void testGetConfigurationFields() {
		HashMap<String, Object> config = pm.getPrinterConfiguration("pdf");
		
		assertEquals("Cups-PDF",                                 config.get("printer"));
		assertEquals("net.castroebarros.babbage.DefaultHandler", config.get("handler"));
	}
	
	@Test
	public void testGetPrinterConfigurationEmpty() {
		try {
			pm.getPrinterConfiguration("this-does-not-exist");
			fail("Expected a RuntimeException when the handler is not configurated");
		} catch(RuntimeException ex) {
			assertEquals(ex.getMessage(), "Handler not found on configurations: this-does-not-exist");
		}
	}
	
	@Test
	public void testCreateHandler() {
		Handler hander = pm.createHandler("pdf");
		assertNotNull(hander);
	}
	
	@Test
	public void testNameOfHandler() {
		Handler handler = pm.createHandler("pdf");
		assertEquals("pdf", handler.getName());
	}
	
	@Test
	public void testClassOfHandler() {
		Handler handler = pm.createHandler("pdf");
		assert(handler instanceof DefaultHandler);
	}
	
	@Test
	public void testPrint() {
		DefaultHandler handler = new DefaultHandler();
		handler.setPrinterName("Cups-PDF");
		handler.print("Hello world!");
	}

}
