package net.castroebarros.babbage;

public interface Handler {
	
	public void setName(String name);
	
	public String getName();
	
	public String getPrinterName();
	
	public void setPrinterName(String name);
	
	public String print(String command);

}
