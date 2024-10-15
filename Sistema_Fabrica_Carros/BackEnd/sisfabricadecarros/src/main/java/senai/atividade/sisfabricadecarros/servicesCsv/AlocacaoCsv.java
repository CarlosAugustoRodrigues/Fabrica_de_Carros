package senai.atividade.sisfabricadecarros.servicesCsv;

import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import org.springframework.stereotype.Service;
import senai.atividade.sisfabricadecarros.entities.Alocacao;
import senai.atividade.sisfabricadecarros.repositories.AlocacaoRepository;
import senai.atividade.sisfabricadecarros.repositories.AutomovelRepository;
import senai.atividade.sisfabricadecarros.repositories.ConcessionariaRepository;

import java.io.FileReader;

@Service
public class AlocacaoCsv {

    private final AlocacaoRepository alocacaoRepository;
    private final AutomovelRepository automovelRepository;
    private final ConcessionariaRepository concessionariaRepository;

    public AlocacaoCsv(AlocacaoRepository alocacaoRepository,
                       AutomovelRepository automovelRepository,
                       ConcessionariaRepository concessionariaRepository) {
        this.alocacaoRepository = alocacaoRepository;
        this.automovelRepository = automovelRepository;
        this.concessionariaRepository = concessionariaRepository;
    }

    public void lerAlocacoesCSV(String filePath) {
        try (CSVReader reader = new CSVReaderBuilder(new FileReader(filePath))
                .withCSVParser(new CSVParserBuilder().withSeparator(';').build())
                .build()) {

            String[] nextLine = reader.readNext();
            while ((nextLine = reader.readNext()) != null) {
                Long id = Long.parseLong(nextLine[0]);
                Long area = Long.parseLong(nextLine[1]);
                var automovel0 = automovelRepository
                        .findById(Long.parseLong(nextLine[2]));
                var concessionaria0 = concessionariaRepository
                        .findById(Long.parseLong(nextLine[3]));
                Long qtd = Long.parseLong(nextLine[4]);

                Alocacao alocacao = new Alocacao(id, area, automovel0.get(), concessionaria0.get(), qtd);
                alocacaoRepository.save(alocacao);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
