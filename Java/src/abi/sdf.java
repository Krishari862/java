package abi;import java.io.File;
import java.io.IOException;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.edit.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;

public class sdf {

    public static void main(String[] args) {
        String pdfFile = "example.pdf";

        try {
            PDDocument document = new PDDocument();
            PDPage page = new PDPage(PDRectangle.A4);
            document.addPage(page);

            PDPageContentStream contentStream = new PDPageContentStream(document, page);
            contentStream.setFont(PDType1Font.HELVETICA_BOLD, 12);
            contentStream.beginText();
            // Update coordinates to float values
            contentStream.
            contentStream.showText("Hello, World!");
            contentStream.endText();
            contentStream.close();

            document.save(new File(pdfFile));
            document.close();

            System.out.println("PDF file has been written successfully!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
