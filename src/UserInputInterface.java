public interface UserInputInterface {
    String getSourceCurrencyCode();
    void setSourceCurrencyCode(String sourceCurrencyCode);

    String getTargetCurrencyCode();
    void setTargetCurrencyCode(String targetCurrencyCode);

    double getAmountToConvert();
    void setAmountToConvert(double amountToConvert);
}
