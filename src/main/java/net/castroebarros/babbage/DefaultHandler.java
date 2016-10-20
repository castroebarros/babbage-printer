package net.castroebarros.babbage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;

import javax.print.Doc;
import javax.print.DocFlavor;
import javax.print.DocPrintJob;
import javax.print.PrintException;
import javax.print.PrintService;
import javax.print.PrintServiceLookup;
import javax.print.SimpleDoc;
import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.PrintRequestAttributeSet;

public class DefaultHandler extends AbstractHandler {
	
	@Override
	public String print(String command) {
		FileInputStream textStream = null;

		try {
			File file = File.createTempFile("tempfile", "txt");
			FileWriter fileWriter = new FileWriter(file.getAbsolutePath(), true);
			fileWriter.write(command);
			fileWriter.close();
			textStream = new FileInputStream(file.getAbsolutePath());
		} catch (IOException e) {
			e.printStackTrace();
		}

		DocFlavor myFormat = DocFlavor.INPUT_STREAM.TEXT_PLAIN_UTF_8;
		Doc myDoc = new SimpleDoc(textStream, myFormat, null);

		PrintRequestAttributeSet aset = new HashPrintRequestAttributeSet();
		PrintService[] services = PrintServiceLookup.lookupPrintServices(myFormat, null);

		for (PrintService p : services) {
			if (p.getName().equals(getPrinterName())) {
				DocPrintJob job = services[0].createPrintJob();
				try {
					job.print(myDoc, aset);
				} catch (PrintException pe) {
					pe.printStackTrace();
					return "FAIL: " + pe.getMessage();
				}
				return "OK";
			}
		}

		return "FAIL";

	}

}
