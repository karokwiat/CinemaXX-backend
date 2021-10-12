package instantcoffee.cinemaxx.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Time;
import java.time.LocalDate;
import java.util.List;

@Entity
@Data
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Movie_Id")
    private int movieId;
    @Column(name = "Title")
    private String title;
    @Column(name = "Description")
    private String description;
    @Column(name = "Age_Restriction")
    private int ageRestriction;
    @Column(name = "Starting_Date")
    private LocalDate startDate;
    @Column(name = "Ending_Date")
    private LocalDate endDate;
    @Column(name = "Ratings")
    private int rating;

    @OneToMany(mappedBy = "movie")
    List<TimeSlot> timeSlots;
}
