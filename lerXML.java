//Imports para manipular XML
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Element;

public class Main {

	public static void main(String[] args) throws Exception{	
		lerXML();		
	}
	
	private static void lerXML() throws Exception{
		File fXmlFile = new File("Agenda.xml");
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		Document doc = dBuilder.parse(fXmlFile);
		
		System.out.println("Root do elemento: " + doc.getDocumentElement().getNodeName());
		NodeList nList = doc.getElementsByTagName("guest");
		
		System.out.println("----------------------------");
		for (int temp = 0; temp < nList.getLength(); temp++) {
			Node nNode = nList.item(temp);
			//System.out.println("\nElemento corrente :" + nNode.getNodeName());
			if (nNode.getNodeType() == Node.ELEMENT_NODE) {
				Element eElement = (Element) nNode;
				System.out.println("Id : " + (temp+1));
				System.out.println("Primeiro nome.: " + eElement.getElementsByTagName("fname").item(0).getTextContent());
				System.out.println("Segundo nome..: " + eElement.getElementsByTagName("lname").item(0).getTextContent());
			}
		}
	}
}

/*
 XML usado no exemplo
 
<?xml version="1.0" encoding="UTF-8"?>
<guestbook>
	<guest>
		<fname>Fulano</fname>
		<lname>de Tal</lname>
	</guest>
	<guest>
		<fname>Cilano</fname>
		<lname>Qualquer</lname>
	</guest>
</guestbook>

*/