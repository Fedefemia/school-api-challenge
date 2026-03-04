package com.scuola.apichallenge.graphql;

import com.scuola.apichallenge.model.Film;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import java.util.List;

@Controller
public class FilmGraphqlController {
    private final List<Film> films = List.of(
            new Film("1", "Il Padrino", 1972, "Francis Ford Coppola"),
            new Film("2", "Pulp Fiction", 1994, "Quentin Tarantino"));

    @QueryMapping
    public List<Film> films() {
        return films;
    }
}
