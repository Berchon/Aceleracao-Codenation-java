package challenge;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Carro {

    private final Motorista motorista;

    private final String placa;

    private final Cor cor;

    public Carro(Motorista motorista, String placa, Cor cor) {
        this.motorista = motorista;
        this.placa = placa;
        this.cor = cor;
    }

    public Motorista getMotorista() {
        return motorista;
    }

    public String getPlaca() {
        return placa;
    }

    public Cor getCor() {
        return cor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Carro carro = (Carro) o;
        return Objects.equals(motorista, carro.motorista) &&
                Objects.equals(placa, carro.placa) &&
                cor == carro.cor;
    }

    @Override
    public int hashCode() {
        return Objects.hash(motorista, placa, cor);
    }

    @Override
    public String toString() {
        return "Carro{" +
                "motorista=" + motorista +
                ", placa='" + placa + '\'' +
                ", cor=" + cor +
                '}';
    }

    public static CarroBuilder builder() {
        return new CarroBuilder();
    }


    public static class CarroBuilder {

        private Motorista motorista;

        private String placa;

        private Cor cor;

        private static boolean validaPlaca(String placa) {
            return placa != null && !placa.isEmpty();
        }

        private static boolean validaCor(Cor cor) {
            List choices = Arrays.asList(Cor.values());
             return choices.toString().contains(cor.toString());
        }

        private CarroBuilder() {
        }

        public CarroBuilder withMotorista(Motorista motorista) {
            this.motorista = motorista;
            return this;
        }

        public CarroBuilder withPlaca(String placa) {
            if (!validaPlaca(placa)) {
                throw new NullPointerException("Uma Placa deve ser informada");
            }
            this.placa = placa;
            return this;
        }

        public CarroBuilder withCor(Cor cor) {
            if (!validaCor(cor)) {
                throw new NullPointerException("A cor do carro deve ser informada");
            }
            this.cor = cor;
            return this;
        }

        public Carro build() {
            if (!validaPlaca(placa)) {
                throw new NullPointerException("Uma Placa deve ser informada");
            }
            if (!validaCor(cor)) {
                throw new NullPointerException("A cor do carro deve ser informada");
            }
            return new Carro(motorista, placa, cor);
        }
    }
}