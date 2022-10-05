import java.util.Objects;

public class Lista<T> implements Comparable {

    private String name;
    private String capital;

    private double population;
    private int area;

    public Lista(String name, String capital, double population, int area) {
        this.name = name;
        this.capital = capital;
        this.population = population;
        this.area = area;
    }

    public String getName() {
        return name;
    }

    public String getCapital() {
        return capital;
    }

    public double getPopulation() {
        return population;
    }

    public int getArea() {
        return area;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lista<?> lista = (Lista<?>) o;
        return Double.compare(lista.population, population) == 0 && area == lista.area && Objects.equals(name, lista.name) && Objects.equals(capital, lista.capital);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, capital, population, area);
    }

    @Override
    public String toString() {
        return "Lista{" +
                "name='" + name + '\'' +
                ", capital='" + capital + '\'' +
                ", population=" + population +
                ", area=" + area +
                '}';
    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }
}
