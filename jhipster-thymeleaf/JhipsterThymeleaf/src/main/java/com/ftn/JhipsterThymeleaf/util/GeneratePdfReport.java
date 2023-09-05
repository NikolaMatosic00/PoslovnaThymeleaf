package com.ftn.JhipsterThymeleaf.util;

import com.ftn.JhipsterThymeleaf.domain.Faktura;
import com.ftn.JhipsterThymeleaf.domain.Stavka;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.List;

public class GeneratePdfReport {


    public static ByteArrayInputStream downloadFaktura(Faktura faktura) {
        Document document = new Document();
        ByteArrayOutputStream out = new ByteArrayOutputStream();

        try {
            Paragraph preface = new Paragraph();

            // We add one empty line
            addEmptyLine(preface, 1);

            // Lets write a big header
            preface.add(
                new Paragraph("KARTON DOO ZA PROIZVODNJU, TRGOVINU I USLUGE NOVI SAD", new Font(Font.FontFamily.TIMES_ROMAN, 18, Font.BOLD))
            );

            // We add one empty line
            addEmptyLine(preface, 1);

            preface.add(new Paragraph("Bulevar Oslobodjenja 22, Novi Sad"));
            preface.add(new Paragraph("Ogranak Cika Necina 101, Kac"));

            // We add one empty line
            addEmptyLine(preface, 1);

            preface.add(new Paragraph("Poreski identifikacioni broj: 1112222333"));
            preface.add(new Paragraph("Maticni broj: 214234324234"));
            preface.add(new Paragraph("ZR: " + faktura.getKlijent().getZiroRacun()));

            // We add one empty line
            addEmptyLine(preface, 1);

            preface.add(new Paragraph("Klijent: " + faktura.getKlijent()));
            preface.add(new Paragraph("Poreski identifikacioni broj: " + faktura.getKlijent().getPoreskiIdentifikacioniBroj()));
            preface.add(new Paragraph("Maticni broj: " + faktura.getKlijent().getMaticniBroj()));
            preface.add(new Paragraph("Adresa: " + faktura.getKlijent().getAdresa()));
            preface.add(new Paragraph("Broj fakture: " + faktura.getInterniBroj()));
            preface.add(new Paragraph("Datum fakture: " + faktura.getDatum().toString().replaceAll("T", " ").replaceAll("Z", "")));
            preface.add(new Paragraph("Napomena: " + faktura.getNapomena()));

            // We add one empty line
            addEmptyLine(preface, 1);

            PdfPTable table = new PdfPTable(7);
            table.setWidthPercentage(100);
            table.setWidths(new int[] { 1, 3, 3, 4, 5, 6, 7 });

            Font headFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD);

            PdfPCell hcell;
            hcell = new PdfPCell(new Phrase("Id", headFont));
            hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(hcell);

            hcell = new PdfPCell(new Phrase("Vrsta robe ili usluge", headFont));
            hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(hcell);

            hcell = new PdfPCell(new Phrase("Kolicina", headFont));
            hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(hcell);

            hcell = new PdfPCell(new Phrase("Cena", headFont));
            hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(hcell);

            hcell = new PdfPCell(new Phrase("PDV", headFont));
            hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(hcell);

            hcell = new PdfPCell(new Phrase("Cena + PDV", headFont));
            hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(hcell);

            hcell = new PdfPCell(new Phrase("Vrednost RSD", headFont));
            hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(hcell);

            double ukupnaCena = 0.0;
            for (Stavka stavka : faktura.getStavkas()) {
                ukupnaCena += stavka.getVrednostRSD();

                PdfPCell cell;

                cell = new PdfPCell(new Phrase(stavka.getId().toString()));
                cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                table.addCell(cell);

                cell = new PdfPCell(new Phrase(stavka.getVrstaRobeIliUsluge() + " " + stavka.getUsluga().getNaziv()));
                cell.setPaddingLeft(5);
                cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                cell.setHorizontalAlignment(Element.ALIGN_LEFT);
                table.addCell(cell);

                cell = new PdfPCell(new Phrase(stavka.getKolicina().toString()));
                cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
                cell.setPaddingRight(5);
                table.addCell(cell);

                cell = new PdfPCell(new Phrase(stavka.getCena().toString()));
                cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
                cell.setPaddingRight(5);
                table.addCell(cell);

                cell = new PdfPCell(new Phrase(stavka.getPdv().toString()));
                cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
                cell.setPaddingRight(5);
                table.addCell(cell);

                cell = new PdfPCell(new Phrase(stavka.getCenaPlusPDV().toString()));
                cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
                cell.setPaddingRight(5);
                table.addCell(cell);

                cell = new PdfPCell(new Phrase(stavka.getVrednostRSD().toString()));
                cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
                cell.setPaddingRight(5);
                table.addCell(cell);
            }

            //Next section
            Paragraph price = new Paragraph("Ukupna cena RSD: " + ukupnaCena);

            // Next section
            Anchor anchor = new Anchor("Potpis ____________________");

            Paragraph signature = new Paragraph(anchor);

            PdfWriter.getInstance(document, out);
            document.open();
            document.add(preface);
            document.add(table);
            document.add(price);
            document.add(signature);

            document.close();
        } catch (DocumentException ex) {
        }

        return new ByteArrayInputStream(out.toByteArray());
    }

    /**
     * Knjiga Izlaznih Faktura
     * @param fakturaList - fakture koje su prosle filtriranje
     * @return ByteArrayInputStream
     */
    public static ByteArrayInputStream downloadKIF(List<Faktura> fakturaList) {
        Document document = new Document();
        ByteArrayOutputStream out = new ByteArrayOutputStream();

        try {
            PdfWriter.getInstance(document, out);

            for (Faktura faktura : fakturaList) {
                Paragraph preface = new Paragraph();

                // We add one empty line
                addEmptyLine(preface, 1);

                // Lets write a big header
                preface.add(
                    new Paragraph(
                        "KARTON DOO ZA PROIZVODNJU, TRGOVINU I USLUGE NOVI SAD",
                        new Font(Font.FontFamily.TIMES_ROMAN, 18, Font.BOLD)
                    )
                );

                // We add one empty line
                addEmptyLine(preface, 1);

                preface.add(new Paragraph("Bulevar Oslobodjenja 22, Novi Sad"));
                preface.add(new Paragraph("Ogranak Cika Necina 101, Kac"));

                // We add one empty line
                addEmptyLine(preface, 1);

                preface.add(new Paragraph("Poreski identifikacioni broj: 1112222333"));
                preface.add(new Paragraph("Maticni broj: 214234324234"));
                preface.add(new Paragraph("ZR: " + faktura.getKlijent().getZiroRacun()));

                // We add one empty line
                addEmptyLine(preface, 1);

                preface.add(new Paragraph("Klijent: " + faktura.getKlijent()));
                preface.add(new Paragraph("Poreski identifikacioni broj: " + faktura.getKlijent().getPoreskiIdentifikacioniBroj()));
                preface.add(new Paragraph("Maticni broj: " + faktura.getKlijent().getMaticniBroj()));
                preface.add(new Paragraph("Adresa: " + faktura.getKlijent().getAdresa()));
                preface.add(new Paragraph("Broj fakture: " + faktura.getInterniBroj()));
                preface.add(new Paragraph("Datum fakture: " + faktura.getDatum().toString().replaceAll("T", " ").replaceAll("Z", "")));
                preface.add(new Paragraph("Napomena: " + faktura.getNapomena()));

                // We add one empty line
                addEmptyLine(preface, 1);

                PdfPTable table = new PdfPTable(7);
                table.setWidthPercentage(100);
                table.setWidths(new int[] { 1, 3, 3, 4, 5, 6, 7 });

                Font headFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD);

                PdfPCell hcell;
                hcell = new PdfPCell(new Phrase("Id", headFont));
                hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
                table.addCell(hcell);

                hcell = new PdfPCell(new Phrase("Vrsta robe ili usluge", headFont));
                hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
                table.addCell(hcell);

                hcell = new PdfPCell(new Phrase("Kolicina", headFont));
                hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
                table.addCell(hcell);

                hcell = new PdfPCell(new Phrase("Cena", headFont));
                hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
                table.addCell(hcell);

                hcell = new PdfPCell(new Phrase("PDV", headFont));
                hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
                table.addCell(hcell);

                hcell = new PdfPCell(new Phrase("Cena + PDV", headFont));
                hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
                table.addCell(hcell);

                hcell = new PdfPCell(new Phrase("Vrednost RSD", headFont));
                hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
                table.addCell(hcell);

                double ukupnaCena = 0.0;
                for (Stavka stavka : faktura.getStavkas()) {
                    ukupnaCena += stavka.getVrednostRSD();

                    PdfPCell cell;

                    cell = new PdfPCell(new Phrase(stavka.getId().toString()));
                    cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                    cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                    table.addCell(cell);

                    cell = new PdfPCell(new Phrase(stavka.getVrstaRobeIliUsluge() + " " + stavka.getUsluga().getNaziv()));
                    cell.setPaddingLeft(5);
                    cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                    cell.setHorizontalAlignment(Element.ALIGN_LEFT);
                    table.addCell(cell);

                    cell = new PdfPCell(new Phrase(stavka.getKolicina().toString()));
                    cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                    cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
                    cell.setPaddingRight(5);
                    table.addCell(cell);

                    cell = new PdfPCell(new Phrase(stavka.getCena().toString()));
                    cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                    cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
                    cell.setPaddingRight(5);
                    table.addCell(cell);

                    cell = new PdfPCell(new Phrase(stavka.getPdv().toString()));
                    cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                    cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
                    cell.setPaddingRight(5);
                    table.addCell(cell);

                    cell = new PdfPCell(new Phrase(stavka.getCenaPlusPDV().toString()));
                    cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                    cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
                    cell.setPaddingRight(5);
                    table.addCell(cell);

                    cell = new PdfPCell(new Phrase(stavka.getVrednostRSD().toString()));
                    cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                    cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
                    cell.setPaddingRight(5);
                    table.addCell(cell);
                }

                //Next section
                Paragraph price = new Paragraph("Ukupna cena RSD: " + ukupnaCena);
                // Next section
                Anchor anchor = new Anchor("Potpis ____________________");
                Paragraph signature = new Paragraph(anchor);

                document.open();
                document.add(preface);
                document.add(table);
                document.add(price);
                document.add(signature);
                document.newPage();
            }

            document.close();
        } catch (DocumentException ex) {
        }

        return new ByteArrayInputStream(out.toByteArray());
    }

    private static void addEmptyLine(Paragraph paragraph, int number) {
        for (int i = 0; i < number; i++) {
            paragraph.add(new Paragraph(" "));
        }
    }
}
