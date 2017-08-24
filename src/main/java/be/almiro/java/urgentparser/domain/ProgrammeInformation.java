package be.almiro.java.urgentparser.domain;

import java.net.URL;
import java.time.Instant;
import java.util.Objects;

/**
 * Represents information about a track.
 *
 * @author Niko Strijbol
 */
public final class ProgrammeInformation {

    private final URL url;
    private final String name;
    private final Instant validUntil;

    public ProgrammeInformation(URL url, String name, Instant validUntil) {
        this.url = url;
        this.name = name;
        this.validUntil = validUntil;
    }

    public String getName() {
        return name;
    }

    public Instant getValidUntil() {
        return validUntil;
    }

    public URL getUrl() {
        return url;
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