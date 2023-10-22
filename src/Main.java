import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Pobieranie danych
        String url = "https://www.nbp.pl/kursy/xml/lasta.xml"; // Zastąp odpowiednim adresem URL

        DownloadData downloadData = DownloadData.getInstance();
        String xmlData = downloadData.downloadXML(url);

        // Parsowanie danych
        ParseData parser = ParseData.getInstance();
        List<CurrencyInterface> currencyList = parser.parseXML(xmlData);

        // Tworzenie kolekcji
        CurrencyCollectionInterface currencyCollection = new CurrencyCollection(currencyList);

        // Utworzenie obiektu użytkownika
        Scanner scanner = new Scanner(System.in);
        System.out.print("Podaj kod waluty źródłowej: ");
        String sourceCurrencyCode = scanner.nextLine();
        System.out.print("Podaj kod waluty docelowej: ");
        String targetCurrencyCode = scanner.nextLine();
        System.out.print("Podaj kwotę do konwersji: ");
        double amountToConvert = scanner.nextDouble();

        UserInputInterface user = new UserInput(sourceCurrencyCode, targetCurrencyCode, amountToConvert);

        // Konwersja walut
        CurrencyConverterInterface currencyConverter = new CurrencyConverter(currencyCollection, user);
        double convertedAmount = currencyConverter.convertCurrency(user.getAmountToConvert());

        System.out.println(
                user.getAmountToConvert() + " " + user.getSourceCurrencyCode() + " is equivalent to " +
                        convertedAmount + " " + user.getTargetCurrencyCode()
        );
    }
}