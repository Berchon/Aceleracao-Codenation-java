package br.com.codenation.paymentmethods;

public class Cash implements PriceStrategy{

    private final double OFF = 0.9;
    @Override
    public Double calculate(Double price) {
        return price * OFF;
    }
}
