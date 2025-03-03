package domain;

import java.util.Objects;

public class Client extends Entity<Long> {
    private String nume;
    private String email;

    public Client(Long id,String nume, String email) {
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
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Client client = (Client) o;
        return Objects.equals(nume, client.nume) && Objects.equals(email, client.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), nume, email);
    }

    @Override
    public String toString() {
        return "Client{" +
                "nume='" + nume + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
