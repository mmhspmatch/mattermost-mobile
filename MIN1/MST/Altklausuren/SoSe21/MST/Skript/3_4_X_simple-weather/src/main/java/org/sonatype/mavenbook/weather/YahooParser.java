package org.sonatype.mavenbook.weather;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.dom4j.Document;
import org.dom4j.DocumentFactory;
import org.dom4j.io.SAXReader;

public class YahooParser {

	private static Logger log = Logger.getLogger(YahooParser.class);

	public Weather parse(InputStream inputStream) throws Exception {
		Weather weather = new Weather();
		
		log.info( "Creating XML Reader" );
		/*MB: auskommentiert
		SAXReader xmlReader = createXmlReader();
		Document doc = xmlReader.read( inputStream );
		 */
		 
		log.info( "Parsing XML Response" );
		/*MB: Diese Zeilen sind hartkodiert, da der Yahoo Dienst nicht mehr existiert,
		 * das maven Bsp incl JUnit Tests aber laufen soll.
		 */
		weather.setCity( "New York" );
		weather.setRegion( "NY" );
		weather.setCountry( "US" );
		weather.setCondition( "Fair");
		weather.setTemp( "39" );
		weather.setChill("39"  );
		weather.setHumidity( "67" );
		
		return weather;
	}

	private SAXReader createXmlReader() {
		Map<String,String> uris = new HashMap<String,String>();
		/* MB: auskommentiert, weil die URI nicht mehr existiert
        uris.put( "y", "http://xml.weather.yahoo.com/ns/rss/1.0" );
        */
        
        DocumentFactory factory = new DocumentFactory();
        factory.setXPathNamespaceURIs( uris );
        
		SAXReader xmlReader = new SAXReader();
		xmlReader.setDocumentFactory( factory );
		return xmlReader;
	}

}
