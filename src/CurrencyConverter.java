public class CurrencyConverter implements CurrencyConverterInterface {
    private CurrencyCollectionInterface currencyCollection;
    private UserInputInterface user;

    public CurrencyConverter(CurrencyCollectionInterface currencyCollection, UserInputInterface user) {
        this.currencyCollection = currencyCollection;
        this.user = user;
    }
    @Override
    public double convertCurrency(double amount) {
        // Pobierz kody walut źródłowej i docelowej od użytkownika
        String sourceCurrencyCode = user.getSourceCurrencyCode();
        String targetCurrencyCode = user.getTargetCurrencyCode();

        // Pobierz waluty źródłową i docelową z kolekcji na podstawie kodów
        CurrencyInterface sourceCurrency = currencyCollection.getCurrencyByCode(sourceCurrencyCode);
        CurrencyInterface targetCurrency = currencyCollection.getCurrencyByCode(targetCurrencyCode);

        if (sourceCurrency == null || targetCurrency == null) {
            System.out.println("Nie znaleziono waluty źródłowej lub docelowej.");
            return -1.0; // Wartość oznaczająca błąd
        }

        // Pobierz przeliczniki z obiektów Currency
        double sourceConverter = sourceCurrency.getConverter();
        double targetConverter = targetCurrency.getConverter();
        double sourceExchangeRate = sourceCurrency.getExchangeRate();
        double targetExchangeRate = targetCurrency.getExchangeRate();
        // Wykonaj konwersję
        double convertedAmount = amount * targetConverter/sourceConverter * (sourceExchangeRate / targetExchangeRate);
        System.out.println(convertedAmount + " " + amount + " " + targetConverter + " " + sourceConverter+ " " +sourceExchangeRate + " " + targetConverter);
        return convertedAmount;
    }
}
