package domain2;

import domain.Entity;

public abstract class Persoana extends Entity<Long> {
    private String nume;
    private String email;

    public Persoana(Long id, String nume, String email) {
        setId(id);
        this.nume = nume;
        this.email = email;
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

    @Override
    public String toString() {
        return "Persoana{" +
                "nume='" + nume + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
