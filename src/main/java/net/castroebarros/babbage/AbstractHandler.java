package net.castroebarros.babbage;

public abstract class AbstractHandler implements Handler {
	
	protected String name;
	protected String printerName;
	
	public AbstractHandler() {
		// An no arguments constructor allows create instances by reflection.
	}

	public AbstractHandler(String name, String printerName) {
		this.name = name;
		this.printerName = printerName;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public String getPrinterName() {
		return printerName;
	}
	
	public void setPrinterName(String printerName) {
		this.printerName = printerName;
	}

}
