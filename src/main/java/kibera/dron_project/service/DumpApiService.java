package kibera.dron_project.service;

import kibera.dron_project.domain.TrackerData;
import kibera.dron_project.repository.TrackerDataRepository;
import lombok.RequiredArgsConstructor;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.sql.Timestamp;

@Service
@Transactional
@RequiredArgsConstructor
public class DumpApiService {

    private final TrackerDataRepository trackerDataRepository;

    public void dumpCsvData(MultipartFile file) {
        String[] header;



        try (Reader reader = new InputStreamReader(file.getInputStream())) {

            header = getHeader(reader);

            for (String s : header) {
                System.out.println(s);
            }

        } catch (IOException e) {
            throw new RuntimeException("Error while reading file: " + e.getMessage());
        }

        try (Reader reader = new InputStreamReader(file.getInputStream())) {

            int i = 0;

            CSVParser newParser = createParser(reader, header);

            for (CSVRecord record : newParser) {

                System.out.println("Ha");

                if(i == 0) {
                    i++;
                    continue;
                }

                TrackerData tData = createNewObject(record);
                trackerDataRepository.save(tData);

            }
        } catch (IOException e) {
            throw new RuntimeException("Error while reading file: " + e.getMessage());
        }


    }

    private TrackerData createNewObject(CSVRecord record) {
        return new TrackerData()
                .altitude(StringUtils.hasText(record.get("altitude")) ? record.get("altitude") : null)
                .angle(StringUtils.hasText(record.get("angle")) ? record.get("angle") : null)
                .drone_id(StringUtils.hasText(record.get("drone_id")) ? record.get("drone_id") : null)
                .latitude(StringUtils.hasText(record.get("latitude")) ? record.get("latitude") : null)
                .length(StringUtils.hasText(record.get("length")) ? record.get("length") : null)
                .longitude(StringUtils.hasText(record.get("longitude")) ? record.get("longitude") : null)
                .priority(StringUtils.hasText(record.get("priority")) ? record.get("priority") : null)
                .record(StringUtils.hasText(record.get("record")) ? record.get("record") : null)
                .satellites(StringUtils.hasText(record.get("satellites")) ? record.get("satellites") : null)
                .speed(StringUtils.hasText(record.get("speed")) ? record.get("speed") : null)
                .timestamp(StringUtils.hasText(record.get("timestamp")) ? new Timestamp(Long.parseLong(record.get("timestamp"))) : null);
    }

    private CSVParser createParser(Reader reader, String[] header) throws IOException {
        return CSVFormat
                .newFormat(',')
                .builder()
                .setIgnoreEmptyLines(true)
                .setIgnoreSurroundingSpaces(true)
                .setHeader(header)
                .build()
                .parse(reader);
    }

    private CSVParser createParser(Reader reader) throws IOException {
        return CSVFormat
                .newFormat(',')
                .builder()
                .setIgnoreEmptyLines(true)
                .setIgnoreSurroundingSpaces(true)
                .build()
                .parse(reader);
    }

    private String[] getHeader(Reader reader) throws IOException {

        CSVParser parser = createParser(reader);

        return createHeader(parser.getRecords().get(0));

    }


    private String[] createHeader(CSVRecord record) {
        String[] header = new String[record.size()];
        for (int i = 0; i < record.size(); i++) {
            header[i] = record.get(i);
        }
        return header;
    }

}
