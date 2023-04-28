package abi;
import java.io.File;
import java.io.IOException;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.edit.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObjectFactory;
import org.apache.pdfbox.pdmodel.interactive.form.PDAcroForm;
import org.apache.pdfbox.pdmodel.interactive.form.PDTextField;

//import org.apache.pdfbox.pdmodel.common.PDRectangle;


public class PdfWriterExample {

    public static void main(String[] args) {
        String pdfFile = "example.pdf";

        try {
            PDDocument document = new PDDocument();
            PDPage page = new PDPage(PDRectangle.A4);
            document.addPage(page);

            PDImageXObject image = PDImageXObjectFactory.createFromFile("image.jpg", document);
            PDPageContentStream contentStream = new PDPageContentStream(document, page);
            contentStream.drawImage(image, 20, 20, image.getWidth(), image.getHeight());
            contentStream.setFont(PDType1Font.HELVETICA_BOLD, 12);
            contentStream.beginText();
            contentStream.newLineAtOffset(20, 500);
            contentStream.showText("Hello, World!");
            contentStream.endText();
            contentStream.close();

            PDAcroForm acroForm = new PDAcroForm(document);
            document.getDocumentCatalog().setAcroForm(acroForm);

            PDTextField textBox = new PDTextField(acroForm);
            textBox.setPartialName("SampleField");
            acroForm.getFields().add(textBox);

            document.save(new File(pdfFile));
            document.close();

            System.out.println("PDF file has been written successfully!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

