public class CurrencyConverter {
    private CurrencyCollectionInterface currencyCollection;
    private UserInterface user;

    public CurrencyConverter(CurrencyCollectionInterface currencyCollection, UserInterface user) {
        this.currencyCollection = currencyCollection;
        this.user = user;
    }

    public double convertCurrency(double amount) {
        // Pobierz kody walut źródłowej i docelowej od użytkownika
        String sourceCurrencyCode = user.getSourceCurrencyCode();
        String targetCurrencyCode = user.getTargetCurrencyCode();

        // Pobierz waluty źródłową i docelową z kolekcji na podstawie kodów
        CurrencyInterface sourceCurrency = currencyCollection.getCurrencyByCode(sourceCurrencyCode);
        CurrencyInterface targetCurrency = currencyCollection.getCurrencyByCode(targetCurrencyCode);

        // Pobierz przeliczniki z obiektów Currency
        int sourceConverter = sourceCurrency.getConverter();
        int targetConverter = targetCurrency.getConverter();

        // Wykonaj konwersję
        double convertedAmount = (amount / sourceConverter) * targetConverter;

        return convertedAmount;
    }
}