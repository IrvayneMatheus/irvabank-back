package br.com.irvabank.util;

import java.sql.Timestamp;
import java.time.Duration;
import java.time.LocalDateTime;

public class TaxaUtil {

    public static Double calcularValorTaxa(double valor, Timestamp dataTransferencia, Timestamp dataAgendamento) {
        LocalDateTime dtTransferencia = dataTransferencia.toLocalDateTime();
        LocalDateTime dtAgendamento = dataAgendamento.toLocalDateTime();

        long diferencaDias = Duration.between(dtAgendamento, dtTransferencia).toDays();

        if (diferencaDias == 0) {
            return 3 + (0.025 * valor);
        } else if (diferencaDias >= 1 && diferencaDias <= 10) {
            return 12.0;
        } else if (diferencaDias >= 11 && diferencaDias <= 20) {
            return (0.082 * valor);
        } else if (diferencaDias >= 21 && diferencaDias <= 30) {
            return (0.069 * valor);
        } else if (diferencaDias >= 31 && diferencaDias <= 40) {
            return (0.047 * valor);
        } else if (diferencaDias >= 41 && diferencaDias <= 50) {
            return (0.017 * valor);
        } else {
            return null;
        }
    }
}
