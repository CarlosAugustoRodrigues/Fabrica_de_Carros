package senai.atividade.sisfabricadecarros.runtime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import senai.atividade.sisfabricadecarros.servicesCsv.AlocacaoCsv;
import senai.atividade.sisfabricadecarros.servicesCsv.AutomovelCsv;
import senai.atividade.sisfabricadecarros.servicesCsv.ClienteCsv;
import senai.atividade.sisfabricadecarros.servicesCsv.ConcessionariaCsv;

@Component
public class CarregarDadosCsv implements CommandLineRunner {

    private final ClienteCsv clienteCsv;
    private final ConcessionariaCsv concessionariaCsv;
    private final AutomovelCsv automovelCsv;
    private final AlocacaoCsv alocacaoCsv;

    public CarregarDadosCsv(ClienteCsv clienteCsv,
                            ConcessionariaCsv concessionariaCsv,
                            AutomovelCsv automovelCsv,
                            AlocacaoCsv alocacaoCsv) {
        this.clienteCsv = clienteCsv;
        this.concessionariaCsv = concessionariaCsv;
        this.automovelCsv = automovelCsv;
        this.alocacaoCsv = alocacaoCsv;
    }

    private String clientes =
            "src/main/resources/csv/clientes.csv";

    private String concessionarias =
            "src/main/resources/csv/concessionarias.csv";

    private String automovel =
            "src/main/resources/csv/automoveis.csv";

    private String alocacao =
            "src/main/resources/csv/alocacao.csv";

    @Override
    public void run(String... args) throws Exception {
        clienteCsv.lerClientesCSV(clientes);
        concessionariaCsv.lerConcessionariasCSV(concessionarias);
        automovelCsv.lerAutomovelCSV(automovel);
        alocacaoCsv.lerAlocacoesCSV(alocacao);
    }
}

