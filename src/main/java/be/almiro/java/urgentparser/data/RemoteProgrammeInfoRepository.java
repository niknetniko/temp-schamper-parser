package be.almiro.java.urgentparser.data;

import be.almiro.java.urgentparser.domain.ProgrammeInformation;
import be.almiro.java.urgentparser.domain.ProgrammeInformationRepository;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Optional;

/**
 * Get the information from the website.
 *
 * @author Niko Strijbol
 */
@Repository
public class RemoteProgrammeInfoRepository implements ProgrammeInformationRepository {

    private static final String URL = "http://urgent.fm/";
    private static final String SELECTOR = "#header-text > a:nth-child(3)";

    @Override
    public Optional<ProgrammeInformation> getCurrent() {
        try {
            // Get the title
            String title = getTitle();
            // Get the expiration date
            Instant instant = Instant.now()
                    .plus(1, ChronoUnit.HOURS)
                    .truncatedTo(ChronoUnit.HOURS);

            return Optional.of(new ProgrammeInformation(title, instant));

        } catch (IOException e) {
            return Optional.empty();
        }
    }

    private String getTitle() throws IOException {
        Document doc = Jsoup.connect(URL).get();
        Element element = doc.select(SELECTOR).first();
        return element.text();
    }
}
