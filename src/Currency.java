
public class Currency implements CurrencyInterface {
    private String name;
    private String code;
    private double exchangeRate;
    private int converter;

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getCode() {
        return this.code;
    }

    @Override
    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public double getExchangeRate() {
        return this.exchangeRate;
    }

    @Override
    public void setExchangeRate(double exchangeRate) {
        this.exchangeRate = exchangeRate;
    }

    @Override
    public int getConverter() {
        return this.converter;
    }

    @Override
    public void setConverter(int converter) {
        this.converter = converter;
    }
}

