package senai.atividade.sisfabricadecarros.servicesCsv;

import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import org.springframework.stereotype.Service;
import senai.atividade.sisfabricadecarros.entities.Automovel;
import senai.atividade.sisfabricadecarros.repositories.AutomovelRepository;

import java.io.FileReader;

@Service
public class AutomovelCsv {

    private final AutomovelRepository automovelRepository;

    public AutomovelCsv(AutomovelRepository automovelRepository) {
        this.automovelRepository = automovelRepository;
    }

    public void lerAutomovelCSV(String filePath) {
        try (CSVReader reader = new CSVReaderBuilder(new FileReader(filePath))
                .withCSVParser(new CSVParserBuilder().withSeparator(';').build())
                .build()) {

            String[] nextLine = reader.readNext();
            while ((nextLine = reader.readNext()) != null) {
                Long id = Long.parseLong(nextLine[0]);
                String modelo = nextLine[1];
                Float preco = Float.valueOf(nextLine[2]);

                Automovel automovel = new Automovel(id, modelo, preco);
                automovelRepository.save(automovel);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
