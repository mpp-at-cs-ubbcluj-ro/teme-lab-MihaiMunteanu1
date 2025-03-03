package domain;

public class Casier extends Entity<Long>{
    private String name;

    public Casier(Long id, String name) {
        setId(id);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Casier{" +
                "name='" + name + '\'' +
                '}';
    }
}
