import java.util.List;

public class CurrencyCollection implements CurrencyCollectionInterface {
    private List<CurrencyInterface> currencies;

    public CurrencyCollection(List<CurrencyInterface> currencies) {
        this.currencies = currencies;
    }
    @Override
    public CurrencyInterface getCurrencyByCode(String code)  {
        for (CurrencyInterface currency : currencies) {
            if (currency.getCode().equals(code)) {
                return currency;
            }
        }
        return null;
    }
    @Override
    public List<CurrencyInterface> getCurrencies() {
        return currencies;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
    @Override
    public void setCurrencies(List<CurrencyInterface> currencies) {
        this.currencies = currencies;
    }
    @Override
    public void addCurrency(CurrencyInterface currency) {
        currencies.add(currency);
    }
    @Override
    public void removeCurrency(CurrencyInterface currency) {
        currencies.remove(currency);
    }
}

