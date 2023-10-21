import java.util.List;

public interface ParseDataInterface {
    List<CurrencyInterface> parseXML(String xml);
    double parseExchangeRate(String exchangeRate);
}