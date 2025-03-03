package domain;

import java.util.Objects;

public class Meci extends Entity<Long>{
    private Long echipa1;
    private Long echipa2;
    private float pret;
    private int locuri;

    public Meci(Long id, Long echipa1, Long echipa2, float pret, int locuri) {
        setId(id);
        this.echipa1 = echipa1;
        this.echipa2 = echipa2;
        this.pret = pret;
        this.locuri = locuri;
    }

    public Long getEchipa1() {
        return echipa1;
    }

    public void setEchipa1(Long echipa1) {
        this.echipa1 = echipa1;
    }

    public Long getEchipa2() {
        return echipa2;
    }

    public void setEchipa2(Long echipa2) {
        this.echipa2 = echipa2;
    }

    public float getPret() {
        return pret;
    }

    public void setPret(float pret) {
        this.pret = pret;
    }

    public int getLocuri() {
        return locuri;
    }

    public void setLocuri(int locuri) {
        this.locuri = locuri;
    }

    @Override
    public String toString() {
        return "Meci{" +
                "echipa1=" + echipa1 +
                " vs echipa2=" + echipa2 +
                ", pret=" + pret +
                ", locuri=" + locuri +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Meci meci = (Meci) o;
        return Float.compare(pret, meci.pret) == 0 && locuri == meci.locuri && Objects.equals(echipa1, meci.echipa1) && Objects.equals(echipa2, meci.echipa2);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), echipa1, echipa2, pret, locuri);
    }
}
