package com.flokeisse.itextsample.pdfpagenumbering;

import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfReader;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.properties.TextAlignment;
import com.itextpdf.layout.properties.VerticalAlignment;
import java.io.File;
import java.io.IOException;

public class PdfPageNumberingApp {

    private static final String FILE1 = "./src/main/resources/pagenumbersample/TransformedTest.pdf";
    public static final String DEST = "./src/main/resources/pagenumbersample/stamp_page_x_of_y.pdf";

    public static void main(String[] args) throws IOException {
        File file = new File(DEST);
        file.getParentFile().mkdirs();

        new PdfPageNumberingApp().numberingPages(DEST);
    }

    public void numberingPages(String dest) throws IOException {
        PdfDocument pdfDoc = new PdfDocument(new PdfReader(FILE1), new PdfWriter(dest));
        Document doc = new Document(pdfDoc);

        for (int i = 1; i <= pdfDoc.getNumberOfPages(); i++) {
            doc.showTextAligned(new Paragraph(String.format("page %s of %s", i, pdfDoc.getNumberOfPages())),
                    pdfDoc.getDefaultPageSize().getWidth()-50, 50, i, TextAlignment.RIGHT, VerticalAlignment.BOTTOM, 0);
        }
        doc.close();
    }
}
