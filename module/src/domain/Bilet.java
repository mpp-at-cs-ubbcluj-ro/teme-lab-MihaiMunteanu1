package domain;

import java.util.Objects;

public class Bilet extends Entity<Long>{
    private Long idMeci;
    private Long idClient;
    private int nr_locuri;

    public Bilet(Long id, Long idMeci, Long idClient, int nr_locuri) {
        setId(id);
        this.idMeci = idMeci;
        this.idClient = idClient;
        this.nr_locuri = nr_locuri;
    }

    public Long getIdMeci() {
        return idMeci;
    }

    public void setIdMeci(Long idMeci) {
        this.idMeci = idMeci;
    }

    public Long getIdClient() {
        return idClient;
    }

    public void setIdClient(Long idClient) {
        this.idClient = idClient;
    }

    public int getNr_locuri() {
        return nr_locuri;
    }

    public void setNr_locuri(int nr_locuri) {
        this.nr_locuri = nr_locuri;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Bilet bilet = (Bilet) o;
        return nr_locuri == bilet.nr_locuri && Objects.equals(idMeci, bilet.idMeci) && Objects.equals(idClient, bilet.idClient);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), idMeci, idClient, nr_locuri);
    }

    @Override
    public String toString() {
        return "Bilet{" +
                "idMeci=" + idMeci +
                ", idClient=" + idClient +
                ", nr_locuri=" + nr_locuri +
                '}';
    }
}
