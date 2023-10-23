import java.util.List;

public class Main {
    public static void main(String[] args) {
        String url = "https://www.nbp.pl/kursy/xml/lasta.xml";

        DownloadData downloadData = DownloadData.getInstance();
        String xmlData = downloadData.downloadXML(url);

        ParseData parser = ParseData.getInstance();
        List<CurrencyInterface> currencyList = parser.parseXML(xmlData);

        CurrencyCollectionInterface currencyCollection = new CurrencyCollection(currencyList);

        UserInputInterface user = new UserInput();
        user.inputUserValues();

        CurrencyConverterInterface currencyConverter = new CurrencyConverter();
        double convertedAmount = currencyConverter.convertCurrency(user.getAmountToConvert(), currencyCollection, user.getSourceCurrencyCode(), user.getTargetCurrencyCode());
        if (convertedAmount != -1){
        System.out.println(
                user.getAmountToConvert() + " " + user.getSourceCurrencyCode() + " is equivalent to " +
                        convertedAmount + " " + user.getTargetCurrencyCode()
        );
        };
    }
}