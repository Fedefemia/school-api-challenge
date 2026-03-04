package com.scuola.apichallenge.rest;
import com.scuola.apichallenge.model.Film;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
@RestController
@RequestMapping("/films")
public class FilmRestController {
    private final List<Film> films = new ArrayList<>();
    public FilmRestController() {
        films.add(new Film("1", "Il Padrino", 1972, "Francis Ford Coppola"));
        films.add(new Film("2", "Pulp Fiction", 1994, "Quentin Tarantino"));
    }
    @GetMapping
    public List<Film> getFilms() { return films; }
    @PostMapping
    public Film addFilm(@RequestBody Film film) {
        if (film.getId() == null) film.setId(UUID.randomUUID().toString());
        films.add(film);
        return film;
    }
}
