package com.flokeisse.itextsample.drawarrow;

import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfPage;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.kernel.pdf.canvas.PdfCanvas;

import java.io.File;
import java.io.IOException;

public class ArrowInPdf {

    private static final String OUTPUT_FOLDER = "src/main/resources/drawarrow/arrowtest.pdf";

    public static void main(String args[]) throws IOException {
        File file = new File(OUTPUT_FOLDER);
        file.getParentFile().mkdirs();
        new ArrowInPdf().createPdf(OUTPUT_FOLDER);
    }

    public void createPdf(String dest) throws IOException {

        //Initialize PDF document.
        PdfDocument pdf = new PdfDocument(new PdfWriter(dest));

        PdfPage page = pdf.addNewPage();

        PdfCanvas canvas = new PdfCanvas(page);

        ArrowInPdf.drawArrow(canvas);

        //Close document
        pdf.close();

    }

    public static void drawArrow(PdfCanvas canvas) {

        // Initial point of the line.
        canvas.moveTo(10, 400);

        // Drawing the baseline.
        canvas.lineTo(125, 400);

        // Closing the path stroke.
        canvas.closePathStroke();

        // Drawing the other lines to form an arrow
        canvas.moveTo(50,425);
        canvas.lineTo(125,400);

        canvas.closePathStroke();

        canvas.moveTo(50,375);
        canvas.lineTo(125,400);

        canvas.closePathStroke();
    }
}
