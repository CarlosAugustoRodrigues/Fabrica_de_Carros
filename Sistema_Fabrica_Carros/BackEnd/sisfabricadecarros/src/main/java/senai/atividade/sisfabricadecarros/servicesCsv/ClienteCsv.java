package senai.atividade.sisfabricadecarros.servicesCsv;

import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import org.springframework.stereotype.Service;
import senai.atividade.sisfabricadecarros.entities.Cliente;
import senai.atividade.sisfabricadecarros.repositories.ClienteRepository;

import java.io.FileReader;

@Service
public class ClienteCsv {

    private final ClienteRepository clienteRepository;

    public ClienteCsv(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public void lerClientesCSV(String filePath) {
        try (CSVReader reader = new CSVReaderBuilder(new FileReader(filePath))
                .withCSVParser(new CSVParserBuilder().withSeparator(';').build())
                .build()) {

            String[] nextLine = reader.readNext();
            while ((nextLine = reader.readNext()) != null) {
                Long id = Long.parseLong(nextLine[0]);
                String nome = nextLine[1];

                Cliente cliente = new Cliente(id, nome);
                clienteRepository.save(cliente);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
