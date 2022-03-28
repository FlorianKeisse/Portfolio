package com.flokeisse.itextsample.imgtopdf;

import com.itextpdf.io.image.ImageData;
import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Image;
import java.io.FileNotFoundException;
import java.net.MalformedURLException;

public class ImgToPdf {

    private static final String FILE1 = "src/main/resources/imgtopdf/ItextLogo.png";
    private static final String OUTPUT_FOLDER = "src/main/resources/imgtopdf/ItextLogo.pdf";

    public static void main(String[] args) throws MalformedURLException, FileNotFoundException {
        ImgToPdf imgToPdf = new ImgToPdf();
        imgToPdf.convertImgToPdf(FILE1,OUTPUT_FOLDER);
    }

    public void convertImgToPdf(String imgPath, String pdfOut) throws MalformedURLException, FileNotFoundException {
        ImageData imageData = ImageDataFactory.create(imgPath);

        PdfDocument pdfDocument = new PdfDocument(new PdfWriter(pdfOut));
        Document document = new Document(pdfDocument);

        Image image = new Image(imageData);
        image.setWidth(pdfDocument.getDefaultPageSize().getWidth() - 50);
        image.setAutoScaleHeight(true);

        document.add(image);
        pdfDocument.close();
    }
}
