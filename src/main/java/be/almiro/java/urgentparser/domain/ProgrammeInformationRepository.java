package be.almiro.java.urgentparser.domain;

import java.util.Optional;

/**
 * @author Niko Strijbol
 */
public interface ProgrammeInformationRepository {

    /**
     * Get the current programme information.
     *
     * @return The information or nothing if there was an error.
     */
    Optional<ProgrammeInformation> getCurrent();
}