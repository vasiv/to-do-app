package pl.tt;

/**
 * @author ciepluchs
 */
public class IdProvider {

    // Jak wprowadzimy interfejsy i pliki, to dodamy interfejs IdProvider. I dwie implementacje, jedna taka jak tutaj, druga, która czyta z pliku.

    static Long id = 0L;

    public static Long generateId() {
        return id++;
    }
}
