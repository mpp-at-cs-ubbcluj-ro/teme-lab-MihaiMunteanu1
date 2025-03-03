package domain;

public class ClientDTO {
    private String nume;
    private String email;
    private String meci;
    private int nr_locuri;

    public ClientDTO(String nume, String email, String meci, int nr_locuri) {
        this.nume = nume;
        this.email = email;
        this.meci = meci;
        this.nr_locuri = nr_locuri;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMeci() {
        return meci;
    }

    public void setMeci(String meci) {
        this.meci = meci;
    }

    public int getNr_locuri() {
        return nr_locuri;
    }

    public void setNr_locuri(int nr_locuri) {
        this.nr_locuri = nr_locuri;
    }
}
