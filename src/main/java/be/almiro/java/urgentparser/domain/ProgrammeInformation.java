package be.almiro.java.urgentparser.domain;

import java.time.Instant;
import java.util.Objects;

/**
 * Represents information about a track.
 *
 * @author Niko Strijbol
 */
public final class ProgrammeInformation {

    private final String name;
    private final Instant validUntil;

    public ProgrammeInformation(String name, Instant validUntil) {
        this.name = name;
        this.validUntil = validUntil;
    }

    public String getName() {
        return name;
    }

    public Instant getValidUntil() {
        return validUntil;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProgrammeInformation that = (ProgrammeInformation) o;
        return Objects.equals(name, that.name) &&
                Objects.equals(validUntil, that.validUntil);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, validUntil);
    }
}