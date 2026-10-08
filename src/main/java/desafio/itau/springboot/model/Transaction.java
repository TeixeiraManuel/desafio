package desafio.itau.springboot.model;

import java.time.OffsetDateTime;

public class Transaction {
    private double Valor;
    private OffsetDateTime dataHora;

    public Transaction(final OffsetDateTime dataHora, final double Valor)
    {
        this.Valor = Valor;
        this.dataHora = dataHora;
    }


    public double getValor()
    {
        return Valor;
    }

    public OffsetDateTime getDataHora() {
        return dataHora;
    }
}
