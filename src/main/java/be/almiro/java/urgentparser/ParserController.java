package be.almiro.java.urgentparser;

import be.almiro.java.urgentparser.domain.ProgrammeInformation;
import be.almiro.java.urgentparser.domain.ProgrammeInformationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Niko Strijbol
 */
@RestController
public class ParserController {

    private final ProgrammeInformationRepository repository;

    @Autowired
    public ParserController(ProgrammeInformationRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/current")
    public ProgrammeInformation current() throws RemoteServerException {
        return repository.getCurrent().orElseThrow(RemoteServerException::new);
    }
}