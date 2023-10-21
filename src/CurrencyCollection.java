import java.util.ArrayList;
import java.util.List;

public class CurrencyCollection implements CurrencyCollectionInterface {
    private List<CurrencyInterface> currencies;

    public CurrencyCollection() {
        currencies = new ArrayList<>();
    }
    public CurrencyInterface getCurrencyByCode(String code) throws CurrencyNotFoundException {
        for (CurrencyInterface currency : currencies) {
            if (currency.getCode().equals(code)) {
                return currency;
            }
        }
        throw new CurrencyNotFoundException("Currency with code " + code + " not found.");
    }
    public List<CurrencyInterface> getCurrencies() {
        return currencies;
    }
    public void setCurrencies(List<CurrencyInterface> currencies) {
        this.currencies = currencies;
    }
    public void addCurrency(CurrencyInterface currency) {
        currencies.add(currency);
    }
    public void removeCurrency(CurrencyInterface currency) {
        currencies.remove(currency);
    }
}
