package com.chamu.springbootmvc.util;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.chamu.springbootmvc.entity.Employee;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

@Component
public class PDFGenerator {
	private static final Logger LOGGER = LoggerFactory.getLogger(PDFGenerator.class);
	public void generateItinerary(Employee employee, String filePath) {
		
		// Create Document instance.
		Document document = new Document();
		try {
			// Create PDFWriter instance.
			PdfWriter.getInstance(document, new FileOutputStream(filePath));
			// Open the document.
			document.open();
			// Add content to the document.
			//generateTable = generateTable(employee);
			//table with 2 columns
			PdfPTable pdfPTable = new PdfPTable(2);
			//create a table column
			PdfPCell cell = new PdfPCell();
			Font font = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
			font.setSize(15);

			Font font1 = FontFactory.getFont(FontFactory.HELVETICA);
			font1.setSize(14);
			
			cell = new PdfPCell(new Phrase("Employee Registration Details",font));
			//Define the COLSPAN for Cell object
			cell.setColspan(2);
			//add cell to table
			pdfPTable.addCell(cell);
			
			cell = new PdfPCell(new Phrase("Employee Details",font));
			cell.setColspan(2);
			pdfPTable.addCell(cell);
			
			pdfPTable.addCell(new Phrase("First Name",font));
			pdfPTable.addCell(new Phrase(employee.getFirst_name(),font1));

			pdfPTable.addCell(new Phrase("Last Name",font));
			pdfPTable.addCell(new Phrase(employee.getLast_name(),font1));
			
			pdfPTable.addCell(new Phrase("Email",font));
			pdfPTable.addCell(new Phrase(employee.getEmail(),font1));
			
			document.add(pdfPTable);
			
			document.close();
		} catch (FileNotFoundException | DocumentException e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
			LOGGER.error("Exception inside PDF"+e);
		}
	}

}