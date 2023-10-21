import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
public class ParseData implements ParseDataInterface{
    private static ParseData instance;
    private ParseData() {}
    public static ParseData getInstance() {
        if (instance == null) {
            instance = new ParseData();
        }
        return instance;
    }
    @Override
    public List<CurrencyInterface> parseXML(String xml) {
        List<CurrencyInterface> currencyList = new ArrayList<>();

        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            InputStream inputStream = new ByteArrayInputStream(xml.getBytes("UTF-8"));
            Document document = builder.parse(inputStream);

            NodeList positions = document.getElementsByTagName("pozycja");

            for (int i = 0; i < positions.getLength(); i++) {
                Element position = (Element) positions.item(i);
                Element name = (Element) position.getElementsByTagName("nazwa_waluty").item(0);
                Element converter = (Element) position.getElementsByTagName("przelicznik").item(0);
                Element code = (Element) position.getElementsByTagName("kod_waluty").item(0);
                Element exchange_rate = (Element) position.getElementsByTagName("kurs_sredni").item(0);

                CurrencyInterface currency = new Currency();
                currency.setName(name.getTextContent());
                currency.setConverter(Integer.parseInt(converter.getTextContent()));
                currency.setCode(code.getTextContent());
                currency.setExchangeRate(parseExchangeRate(exchange_rate.getTextContent()));

                currencyList.add(currency);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return currencyList;
    }
    @Override
    public double parseExchangeRate(String exchangeRate) {
        try {
            exchangeRate = exchangeRate.replace(',', '.');
            return Double.parseDouble(exchangeRate);
        } catch (NumberFormatException e) {
            e.printStackTrace();
            return 0.0;
        }
    }
}