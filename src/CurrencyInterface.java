public interface CurrencyInterface {
    String getName();
    void setName(String name);

    String getCode();
    void setCode(String code);

    double getExchangeRate();
    void setExchangeRate(double exchangeRate);

   int getConverter();
    void setConverter(int converter);
}