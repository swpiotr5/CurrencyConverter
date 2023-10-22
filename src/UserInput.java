public class UserInput implements UserInputInterface {
    private String sourceCurrencyCode;
    private String targetCurrencyCode;
    private double amountToConvert;

    public UserInput(String sourceCurrencyCode, String targetCurrencyCode, double amountToConvert) {
        this.sourceCurrencyCode = sourceCurrencyCode;
        this.targetCurrencyCode = targetCurrencyCode;
        this.amountToConvert = amountToConvert;
    }

    @Override
    public String getSourceCurrencyCode() {
        return sourceCurrencyCode;
    }

    @Override
    public void setSourceCurrencyCode(String sourceCurrencyCode) {
        this.sourceCurrencyCode = sourceCurrencyCode;
    }

    @Override
    public String getTargetCurrencyCode() {
        return targetCurrencyCode;
    }

    @Override
    public void setTargetCurrencyCode(String targetCurrencyCode) {
        this.targetCurrencyCode = targetCurrencyCode;
    }

    @Override
    public double getAmountToConvert() {
        return amountToConvert;
    }

    @Override
    public void setAmountToConvert(double amountToConvert) {
        this.amountToConvert = amountToConvert;
    }
}