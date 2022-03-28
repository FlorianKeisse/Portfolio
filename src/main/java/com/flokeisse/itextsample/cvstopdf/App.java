package com.flokeisse.itextsample.cvstopdf;

import java.io.IOException;

public class App {
    public static void main(String[] args) throws IOException {

        CsvToPdf csvToPdf = new CsvToPdf();

          csvToPdf.tableMaker();
    }
}
