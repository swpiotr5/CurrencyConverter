import java.util.Scanner;

public class UserInput implements UserInputInterface {
    private String sourceCurrencyCode;
    private String targetCurrencyCode;
    private double amountToConvert;

    public UserInput() {
        this.amountToConvert = 0;
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

    public void inputUserValues() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Podaj kod waluty źródłowej: ");
        sourceCurrencyCode = scanner.nextLine();

        System.out.print("Podaj kod waluty docelowej: ");
        targetCurrencyCode = scanner.nextLine();

        while (amountToConvert <= 0) {
            System.out.print("Podaj kwotę do konwersji: ");
            if (scanner.hasNextDouble()) {
                amountToConvert = scanner.nextDouble();
                if (amountToConvert <= 0) {
                    System.out.println("Kwota musi być większa od zera.");
                }
            } else {
                System.out.println("Nieprawidłowa kwota. Podaj liczbę.");
                scanner.next();
            }
        }
    }
}