package instantcoffee.cinemaxx.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Movie ID")
    private int movieId;
    @Column(name = "Title")
    private String title;
    @Column(name = "Description")
    private String description;
    @Column(name = "Age Restriction")
    private int ageRestriction;
    @Column(name = "Starting Date")
    private LocalDate startDate;
    @Column(name = "Ending Date")
    private LocalDate endDate;
    @Column(name = "Ratings")
    private int rating;


}
