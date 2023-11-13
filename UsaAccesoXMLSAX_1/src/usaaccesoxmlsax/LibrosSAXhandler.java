
package usaaccesoxmlsax;

import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.*;

public class LibrosSAXhandler extends DefaultHandler {
    private int contadorlibros=0;
    public LibrosSAXhandler() {
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes atts) throws SAXException {
            
        if (qName.equals("catalog")){
            System.out.println("Listado de libros:");
            System.out.println("-----------------------");
        }
        else if (qName.equals("book")) {
            contadorlibros++;
            System.out.println("Libro "+contadorlibros);
            //System.out.println("Publicado en: " + atts.getValue(atts.getQName(0)));//extrae el primer atributo

        } else if (qName.equals("Titulo")) {
            System.out.print("\n " + "El titulo es: ");//aún no sabemos cúales el título, eso lo sabremos en el evento characters
        } 
        if (qName.equals("author")) {
            System.out.print( "\n " + "El autor es: ");
        }
        if (qName.equals("title")) {
            System.out.print( "\n " + "El titulo es: ");
        }
        if (qName.equals("genre")) {
            System.out.print( "\n " + "El genero es: ");
        }
        if (qName.equals("price")) {
            System.out.print( "\n " + "El precio es: ");
        }
        if (qName.equals("publish_date")) {
            System.out.print( "\n " + "La fecha de publicacion es: ");
        }
        if (qName.equals("description")) {
            System.out.print( "\n " + "La descripcion es: ");
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws
            SAXException {

        if (qName.equals("book")) {
            System.out.println("\n-----------------------");
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws
            SAXException {

        String car = new String(ch, start, length);
        car = car.replaceAll("\t", " ");//quita todos los tabuladores
        car = car.replaceAll("\n", " ");
        System.out.print(car);
    }
}
