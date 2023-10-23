public class CurrencyConverter implements CurrencyConverterInterface {
    @Override
    public double convertCurrency(double amount, CurrencyCollectionInterface currencyCollection, String sourceCurrencyCode, String targetCurrencyCode) {

        CurrencyInterface sourceCurrency = currencyCollection.getCurrencyByCode(sourceCurrencyCode);
        CurrencyInterface targetCurrency = currencyCollection.getCurrencyByCode(targetCurrencyCode);

        if (sourceCurrency == null || targetCurrency == null) {
            System.out.println("Nie znaleziono waluty źródłowej lub docelowej.");
            return -1.0;
        }

        double sourceConverter = sourceCurrency.getConverter();
        double targetConverter = targetCurrency.getConverter();
        double sourceExchangeRate = sourceCurrency.getExchangeRate();
        double targetExchangeRate = targetCurrency.getExchangeRate();

        double convertedAmount = amount * targetConverter/sourceConverter * (sourceExchangeRate / targetExchangeRate);
        return convertedAmount;
    }
}
