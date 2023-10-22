import java.util.List;

public interface CurrencyCollectionInterface {
    public CurrencyInterface getCurrencyByCode(String code);

    public List<CurrencyInterface> getCurrencies();

    public void setCurrencies(List<CurrencyInterface> currencies);
    public void addCurrency(CurrencyInterface currency);

    public void removeCurrency(CurrencyInterface currency);
}