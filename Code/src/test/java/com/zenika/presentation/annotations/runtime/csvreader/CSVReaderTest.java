package com.zenika.presentation.annotations.runtime.csvreader;

import org.junit.Test;

import java.io.FileReader;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class CSVReaderTest {

    @Test
    public void testCSVReader() throws Exception {

        CSVReader<Client> csvReader = new CSVReader<Client>(Client.class) {
            @Override
            protected Client newContainer() {
                return new Client();
            }
        };

        String filePath = "/home/olivier/Zenika/Formation/Formations-Interne/trunk/Presentations/Annotations/Code/src/test/java/com/zenika/presentation/annotations/runtime/csvreader/clients.csv";
        List<Client> clients = csvReader.read(new FileReader(filePath));
        assertEquals(3, clients.size());
        for (Client client : clients) {
            System.out.println(client);
        }

    }

}
