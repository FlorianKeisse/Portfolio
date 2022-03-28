package com.flokeisse.itextsample.cvstopdf;

import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class CsvToPdf {

    private static final String FILE1 = "src/main/resources/cvstopdf/test3.csv";

    private static final String OUTPUT_FOLDER = "src/main/resources/cvstopdf/TransformedTest.pdf";

    public void addCellToTable(Table table, String line) {

        StringTokenizer tokenizer = new StringTokenizer(line, ",");

        // Creates cells according to parsed csv line
        while (tokenizer.hasMoreTokens()) {
            Cell cell = new Cell().add(new Paragraph(tokenizer.nextToken()));

            table.addCell(cell);
        }
    }

    public void cvsReader(Table table) throws IOException {
        String row;
        PdfDocument pdf = new PdfDocument(new PdfWriter(OUTPUT_FOLDER));

        //Creating a Document.
        Document document = new Document(pdf);

        try {
            BufferedReader csvReader = new BufferedReader(new FileReader(FILE1));

            while ((row = csvReader.readLine()) != null) {

                // do something with the data
                String[] data = row.split(",");

                for (String s : data) {
                    s = s.replace("\"","");
                    addCellToTable(table, s);
                }
            }
            document.add(table);
            csvReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        pdf.close();
    }

    public void tableMaker() throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new FileReader(FILE1));
        int numberOfSplits = bufferedReader.readLine().split(",").length;
        System.out.println(numberOfSplits);
        try {
            Table table = new Table(numberOfSplits);
            cvsReader(table);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
