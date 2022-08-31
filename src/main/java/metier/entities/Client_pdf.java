package metier.entities;

import javax.servlet.http.HttpServletResponse;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

public class Client_pdf {
	
	
	public void writeTableHeader(PdfPTable table) {
		PdfPCell cell=new PdfPCell();
		cell.setBackgroundColor(BaseColor.GRAY);
		cell.setPadding(5);
		
		Font font=FontFactory.getFont(FontFactory.HELVETICA);
		font.setColor(BaseColor.WHITE);
		
		
		cell.setPhrase(new Phrase(" Nom ",font));
		table.addCell(cell);
		
		
		cell.setPhrase(new Phrase(" PRENOM ",font));
		table.addCell(cell);
		
		cell.setPhrase(new Phrase(" CNE",font));
		table.addCell(cell);
		
		cell.setPhrase(new Phrase(" Carte bancaire ",font));
		table.addCell(cell);
		
		/*cell.setPhrase(new Phrase("nom Voyage",font));
		table.addCell(cell);*/
		
		cell.setPhrase(new Phrase("date depart",font));
		table.addCell(cell);
		
		cell.setPhrase(new Phrase("date retour",font));
		table.addCell(cell);
		
		cell.setPhrase(new Phrase("Nombre de personne",font));
		table.addCell(cell);
		
		
		cell.setPhrase(new Phrase("prix",font));
		table.addCell(cell);
		
		
		
		
	}
	
	public void writeTableData(PdfPTable table,Date_voyageAcc date_voyage,Client client, int nbr) {
		table.addCell(client.getNom_client());
		table.addCell(client.getPrenom_client());
		table.addCell(client.getCNE_client());
		table.addCell(client.getCarte_bancaire());
		table.addCell(date_voyage.getDate_depart());
		System.out.println(date_voyage.getDate_depart());
		table.addCell(date_voyage.getDate_fin());
		System.out.println(date_voyage.getDate_fin());
		table.addCell(""+nbr);
		table.addCell(""+date_voyage.getPrix()*nbr);
		System.out.println(date_voyage.getPrix()+" prix normal \n apres calcul \n");
		System.out.println(date_voyage.getPrix()*3);
		
	
		
	}
	
	
	
	public void export(HttpServletResponse response,Date_voyageAcc date_voyage,Client client, int nbr) {
		Document document=new Document(PageSize.A4);
		try {
			PdfWriter.getInstance(document, response.getOutputStream());
			document.open();
			
			/*Image img=Image.getInstance("â€ªC:\\Users\\Administrateur\\Desktop\\logggo.png");
			document.add(img);*/
			
			Font font=FontFactory.getFont(FontFactory.HELVETICA_BOLD);
			
			font.setSize(18);
			
			Paragraph titre=new Paragraph("Facture de votre voyage \n NB: Veuillez ramener avec vous ce reçu à notre agence pour completer les frais de paiment ");
			titre.setAlignment(Paragraph.ALIGN_CENTER);
			document.add(titre);
			
			PdfPTable table=new PdfPTable(8);
			table.setWidthPercentage(100);
			table.setSpacingBefore(20);//espace entre liste etablissement et header du tableau
			table.setWidths(new float[] {3.0f,3.0f,3.0f,3.0f,3.0f,3.0f,3.0f,3.0f});
			
			writeTableHeader(table);
			writeTableData(table,date_voyage ,client, nbr);
			
			document.add(table);
			
			
			document.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}

}
