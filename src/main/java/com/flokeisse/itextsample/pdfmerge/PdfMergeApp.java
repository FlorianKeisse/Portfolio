package com.flokeisse.itextsample.pdfmerge;

import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfReader;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.kernel.utils.PdfMerger;
import java.io.IOException;

public class PdfMergeApp {

    private static final String FILE1 = "src/main/resources/pdfmergesamples/Sample1.pdf";
    private static final String FILE2 = "src/main/resources/pdfmergesamples/Sample2.pdf";
    private static final String OUTPUT_FOLDER = "src/main/resources/pdfmergesamples/";

    public static void main(String[] args) throws IOException {
       PdfMergeApp pdfMergeApp = new PdfMergeApp();
       pdfMergeApp.pdfmerge();
    }

    public void pdfmerge() throws IOException {
        PdfDocument mergedPdf = new PdfDocument(new PdfWriter(OUTPUT_FOLDER+ "merged.pdf"));
        PdfMerger merger = new PdfMerger(mergedPdf);

        PdfDocument firstDocument = new PdfDocument(new PdfReader(FILE1));
        merger.merge(firstDocument,1, firstDocument.getNumberOfPages());

        PdfDocument secondDocument = new PdfDocument(new PdfReader(FILE2));
        merger.merge(secondDocument,1, secondDocument.getNumberOfPages());

        merger.merge(secondDocument, 1, secondDocument.getNumberOfPages());

        secondDocument.close();
        firstDocument.close();
        mergedPdf.close();
    }
}


