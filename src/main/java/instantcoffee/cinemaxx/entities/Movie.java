package instantcoffee.cinemaxx.entities;

import jdk.jfr.Timespan;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.sql.Time;
import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@Table(name = "movies")
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "movie_Id")
    private int movieId;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "age_restriction")
    private int ageRestriction;

    @Column(name = "start_date")
    private LocalDate startDate;

    @Column(name = "end_date")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate endDate;

    @Column(name = "rating")
    private int rating;


}
