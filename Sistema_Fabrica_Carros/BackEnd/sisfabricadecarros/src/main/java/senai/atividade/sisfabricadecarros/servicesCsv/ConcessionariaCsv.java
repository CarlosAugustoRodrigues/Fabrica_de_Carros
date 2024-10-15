package senai.atividade.sisfabricadecarros.servicesCsv;

import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import org.springframework.stereotype.Service;
import senai.atividade.sisfabricadecarros.entities.Concessionaria;
import senai.atividade.sisfabricadecarros.repositories.ConcessionariaRepository;

import java.io.FileReader;

@Service
public class ConcessionariaCsv {

    private final ConcessionariaRepository concessionariaRepository;

    public ConcessionariaCsv(ConcessionariaRepository concessionariaRepository) {
        this.concessionariaRepository = concessionariaRepository;
    }

    public void lerConcessionariasCSV(String filePath) {
        try (CSVReader reader = new CSVReaderBuilder(new FileReader(filePath))
                .withCSVParser(new CSVParserBuilder().withSeparator(';').build())
                .build()) {

            String[] nextLine = reader.readNext();
            while ((nextLine = reader.readNext()) != null) {
                Long id = Long.parseLong(nextLine[0]);
                String nome = nextLine[1];

                Concessionaria concessionaria = new Concessionaria(id, nome);
                concessionariaRepository.save(concessionaria);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
