package com.tp.tpunla.data;

import android.os.Build;

import androidx.annotation.RequiresApi;

import com.tp.tpunla.models.Film;
import com.tp.tpunla.models.FilmDetail;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * Clase que contiene los datos harcodeados.
 */
public abstract class Data {
    private static final List<Film> films = Arrays.asList(
            new Film(1, "Castle in the Sky", "https://image.tmdb.org/t/p/w600_and_h900_bestv2/npOnzAbLh6VOIu3naU5QaEcTepo.jpg", "Hayao Miyazaki", 1986, 95),
            new Film(2, "Grave of the Fireflies", "https://image.tmdb.org/t/p/w600_and_h900_bestv2/qG3RYlIVpTYclR9TYIsy8p7m7AT.jpg", "Isao Takahata", 1988, 97),
            new Film(3, "My Neighbor Totoro", "https://image.tmdb.org/t/p/w600_and_h900_bestv2/rtGDOeG9LzoerkDGZF9dnVeLppL.jpg", "Hayao Miyazaki", 1986, 93),
            new Film(4, "Kiki's Delivery Service", "https://image.tmdb.org/t/p/w600_and_h900_bestv2/7nO5DUMnGUuXrA4r2h6ESOKQRrx.jpg", "Hayao Miyazaki", 1989, 96),
            new Film(5, "Only Yesterday", "https://image.tmdb.org/t/p/w600_and_h900_bestv2/xjJU6rwzLX7Jk8HFQfVW6H5guMC.jpg", "Isao Takahata", 1991, 100),
            new Film(6, "Porco Rosso", "https://image.tmdb.org/t/p/w600_and_h900_bestv2/byKAndF6KQSDpGxp1mTr23jPbYp.jpg", "Hayao Miyazaki", 1992, 94),
            new Film(7, "Pom Poko", "https://image.tmdb.org/t/p/w600_and_h900_bestv2/kowo9E1e1JcWLXj9cCvAOFZcy5n.jpg", "Isao Takahata", 1994, 78),
            new Film(8, "Whisper of the Heart", "https://image.tmdb.org/t/p/w600_and_h900_bestv2/5E3Hvbu0bg38ouYf6chGftVGqZ7.jpg", "Yoshifumi Kondō", 1995, 91),
            new Film(9, "Princess Mononoke", "https://image.tmdb.org/t/p/w600_and_h900_bestv2/jHWmNr7m544fJ8eItsfNk8fs2Ed.jpg", "Hayao Miyazaki", 1997, 92),
            new Film(10, "My Neighbors the Yamadas", "https://image.tmdb.org/t/p/w600_and_h900_bestv2/wTGuHmMIBBgKakY80J1D52VvQKI.jpg", "Isao Takahata", 1999, 75)
    );

    private static final List<FilmDetail> filmsDetails = Arrays.asList(
            new FilmDetail(1, "Castle in the Sky", "https://image.tmdb.org/t/p/w600_and_h900_bestv2/npOnzAbLh6VOIu3naU5QaEcTepo.jpg",
                    "Hayao Miyazaki", 1986, 95, "Hōhokekyo tonari",
                    "The Yamadas are a typical middle class Japanese family in urban Tokyo and this film shows us a variety of episodes of their lives. With tales that range from the humourous to the heartbreaking, we see this family cope with life's little conflicts, problems and joys in their own way.",
                    "https://image.tmdb.org/t/p/w533_and_h300_bestv2/3cyjYtLWCBE1uvWINHFsFnE8LUK.jpg", 120),
            new FilmDetail(2, "Grave of the Fireflies", "https://image.tmdb.org/t/p/w600_and_h900_bestv2/qG3RYlIVpTYclR9TYIsy8p7m7AT.jpg",
                    "Isao Takahata", 1988, 97, "Hōhokekyo tonari",
                    "The orphan Sheeta inherited a mysterious crystal that links her to the mythical sky-kingdom of Laputa. With the help of resourceful Pazu and a rollicking band of sky pirates, she makes her way to the ruins of the once-great civilization. Sheeta and Pazu must outwit the evil Muska, who plans to use Laputa's science to make himself ruler of the world.",
                    "https://image.tmdb.org/t/p/original/vkZSd0Lp8iCVBGpFH9L7LzLusjS.jpg", 130),
            new FilmDetail(3, "My Neighbor Totoro", "https://image.tmdb.org/t/p/w600_and_h900_bestv2/rtGDOeG9LzoerkDGZF9dnVeLppL.jpg",
                    "Hayao Miyazaki", 1986, 93, "Hōhokekyo tonari",
                    "In the latter part of World War II, a boy and his sister, orphaned when their mother is killed in the firebombing of Tokyo, are left to survive on their own in what remains of civilian life in Japan. The plot follows this boy and his sister as they do their best to survive in the Japanese countryside, battling hunger, prejudice, and pride in their own quiet, personal battle.",
                    "https://image.tmdb.org/t/p/original/etqr6fOOCXQOgwrQXaKwenTSuzx.jpg", 95),
            new FilmDetail(4, "Kiki's Delivery Service", "https://image.tmdb.org/t/p/w600_and_h900_bestv2/7nO5DUMnGUuXrA4r2h6ESOKQRrx.jpg",
                    "Hayao Miyazaki", 1989, 96, "Hōhokekyo tonari",
                    "Two sisters move to the country with their father in order to be closer to their hospitalized mother, and discover the surrounding trees are inhabited by Totoros, magical spirits of the forest. When the youngest runs away from home, the older sister seeks help from the spirits to find her.",
                    "https://image.tmdb.org/t/p/original/h5pAEVma835u8xoE60kmLVopLct.jpg", 120),
            new FilmDetail(5, "Only Yesterday", "https://image.tmdb.org/t/p/w600_and_h900_bestv2/xjJU6rwzLX7Jk8HFQfVW6H5guMC.jpg",
                    "Isao Takahata", 1991, 100, "Hōhokekyo tonari", "The Yamadas are a typical middle class Japanese family in urban Tokyo and this film shows us a variety of episodes of their lives. With tales that range from the humourous to the heartbreaking, we see this family cope with life's little conflicts, problems and joys in their own way.",
                    "https://image.tmdb.org/t/p/w533_and_h300_bestv2/3cyjYtLWCBE1uvWINHFsFnE8LUK.jpg", 120),
            new FilmDetail(6, "Porco Rosso", "https://image.tmdb.org/t/p/w600_and_h900_bestv2/byKAndF6KQSDpGxp1mTr23jPbYp.jpg",
                    "Hayao Miyazaki", 1992, 94, "Hōhokekyo tonari", "The Yamadas are a typical middle class Japanese family in urban Tokyo and this film shows us a variety of episodes of their lives. With tales that range from the humourous to the heartbreaking, we see this family cope with life's little conflicts, problems and joys in their own way.",
                    "https://image.tmdb.org/t/p/w533_and_h300_bestv2/isCrlWWI4JrdLKAUAwFb5cjAsH4.jpg", 110),
            new FilmDetail(7, "Pom Poko", "https://image.tmdb.org/t/p/w600_and_h900_bestv2/kowo9E1e1JcWLXj9cCvAOFZcy5n.jpg",
                    "Isao Takahata", 1994, 78, "Hōhokekyo tonari",  "The Yamadas are a typical middle class Japanese family in urban Tokyo and this film shows us a variety of episodes of their lives. With tales that range from the humourous to the heartbreaking, we see this family cope with life's little conflicts, problems and joys in their own way.",
                    "https://image.tmdb.org/t/p/w533_and_h300_bestv2/3cyjYtLWCBE1uvWINHFsFnE8LUK.jpg", 120),
            new FilmDetail(8, "Whisper of the Heart", "https://image.tmdb.org/t/p/w600_and_h900_bestv2/5E3Hvbu0bg38ouYf6chGftVGqZ7.jpg", "" +
                    "Yoshifumi Kondō", 1995, 91, "Hōhokekyo tonari", "The Yamadas are a typical middle class Japanese family in urban Tokyo and this film shows us a variety of episodes of their lives. With tales that range from the humourous to the heartbreaking, we see this family cope with life's little conflicts, problems and joys in their own way.",
                    "https://image.tmdb.org/t/p/original/nAeCzilMRXvGaxiCpv63ZRVRVgh.jpg", 90),
            new FilmDetail(9, "Princess Mononoke", "https://image.tmdb.org/t/p/w600_and_h900_bestv2/jHWmNr7m544fJ8eItsfNk8fs2Ed.jpg",
                    "Hayao Miyazaki", 1997, 92, "Hōhokekyo tonari", "The Yamadas are a typical middle class Japanese family in urban Tokyo and this film shows us a variety of episodes of their lives. With tales that range from the humourous to the heartbreaking, we see this family cope with life's little conflicts, problems and joys in their own way.",
                    "https://image.tmdb.org/t/p/original/jScPd0u0jeo66l8gwDl7W9hDUnM.jpg", 101),
            new FilmDetail(10, "My Neighbors the Yamadas", "https://image.tmdb.org/t/p/w600_and_h900_bestv2/wTGuHmMIBBgKakY80J1D52VvQKI.jpg",
                    "Isao Takahata", 1999, 75, "Hōhokekyo tonari",  "The Yamadas are a typical middle class Japanese family in urban Tokyo and this film shows us a variety of episodes of their lives. With tales that range from the humourous to the heartbreaking, we see this family cope with life's little conflicts, problems and joys in their own way.",
                    "https://image.tmdb.org/t/p/original/nDOsicEg4RHDq0t23JKGSb58z6u.jpg", 105)
    );

    public static List<Film> getFilms(int cantidad) {
        return films.subList(0, cantidad);
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public static FilmDetail getFilmDetails(Integer id) {
        return filmsDetails.stream().filter(film -> Objects.equals(film.getId(), id))
                .collect(Collectors.toList()).get(0);
    }
}
