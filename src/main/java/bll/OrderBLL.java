package bll;
import DAO.OrderDAO;
import Model.Order;
import bll.validators.Validator;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfWriter;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDTrueTypeFont;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import java.io.IOException;
import org.apache.pdfbox.pdmodel.PDDocument;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import java.io.FileOutputStream;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * In aceasta clasa sunt apelate metodele de insert , delete si de afisarea a tabelului Order din baza de date
 */

public class OrderBLL {
    public void insertOrder(Order order) {
        OrderDAO.insert(order);
    }

    public void deleteOrder(int idOrder) {
        OrderDAO.delete(idOrder);
    }

    public List<Order> showAll() throws SQLException {
        return OrderDAO.viewAll();
    }

    /**
     * Aceasta metoda genereaz pdf-ul pentru "bonul fiscal"
     * @param idC
     * @param idCl
     * @param idProd
     * @param cantitate
     */

    public static void bon(int idC, int idCl, int idProd, int cantitate) {

        PDDocument document = new PDDocument();
        PDPage page = new PDPage();
        document.addPage(page);
        PDPageContentStream contentStream = null;
        try {
            contentStream=new PDPageContentStream(document, page);
            contentStream.beginText();
            contentStream.setFont(PDType1Font.COURIER, 12);
            contentStream.newLineAtOffset(60,500);
            contentStream.showText(" Id comanda: " + idC + " " + " Id Client : " + idCl + " Id Produs " + idProd + " Cantitatea comandata : " + cantitate);
            contentStream.endText();
            contentStream.close();
            document.save("bill" + idC + ".pdf");
            document.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
