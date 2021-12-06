# CinemaXX

KEA - AP Computer Science\
Third Semester\
Instant Coffee Group\
CinemaXX Project

**Authors:**

Andre Jeronimo Camargo Bittencourt | Juan Ignacio Nicolai | Karolina Barbara Kwiatkowska | Snorri Sigurjonsson | Veselin Plamenov Ivanov

### Links

frontend github repositories: 
* cinema customer https://github.com/andr01a0/CinemaXX-frontend
* admin https://github.com/andr01a0/CinemaXX-frontendAdmin

hosted:
* backend http://52.90.82.222:9090
* frontend - cinema customer http://52.90.82.222:5500/ 
* frontend - admin http://52.90.82.222:5501/

videos:
* cinema customer https://www.youtube.com/watch?v=e6-1wPW-9Nc&ab_channel=JuanNicolai
* admin https://www.youtube.com/watch?v=qP7Lm0_pwjg&ab_channel=JuanNicolai

### Swagger Documentation

http://localhost:9090/api/swagger

### Production Server : Amazon AWS EC2 instance

### Create booking

POST /api/booking/create takes in `theaterHallId`, `movieId`, `timeSlotId` and `seatId`

We query the database for a Theater Hall with the given `theaterHallId` and if
it exists we get the Movies that are shown in that Theater Hall. We filter out
the movies that do not match the given `movieId`. If there is a Movie left, we
take the available Time Slots and filter out the ones that do not match the
given `timeSlotId`. If there is a Time Slot left, we check if the seat with the
given `seatId` is taken by taking the bookings of the Time Slot and filtering
out the ones that do not match the `seatId`. If the Seat is not taken, we check
if the Theater Hall has that seat and if it does we create a new Booking.

## Security

Right now every endpoint requires authentication except:

* `/api/authenticate/signup`
* `/api/authenticate/login`
* `/api/swagger`
* `/api/api-docs`

There are no roles implemented at the moment, meaning if you are signed up, you
can perform all available operations.

### How to sign up

POST `/api/authenticate/signup` with `username` and `password`


### How to log in

POST `/api/authenticate/login` with `username` and `password`

You will get a token back.

There is OpenAPI specification for the two endpoints mentioned above.

### Authenticate

Whenever you make a request add the token to the Authorization header as a Bearer token.


### How to get the User inside a controller

```
@GetMapping
public String hello(@AuthenticationPrincipal User user) {
  System.out.println("HELLO");
  System.out.println(user);
  return "hello";
}
```

### Individual contribution

Andre : andr01a0
- User Story: delete movies.
- User Story: edit movies.
- User Story: cancel bookings.
- User Story: edit bookings.
- AMAZON AWS EC2 instance server with DevOps - CI/CD with jenkins building from GitHub into docker containers using environment variables.
- Pair-programming with team mates to solve problems encountered.

Juani : juaninicolai
- I performed as Scrum Master and directed all the Daily meetings.
- Built our Kanban board to follow the team progress.
- I built the “create movie” endpoint. Andre helped me to test de validation of it (pair programming).
- I built the “get free / booked seat list” with Andre’s guidance (pair programming).
- I participated in the overall testing of the endpoints before submitting to the PO.

Karolina : karokwiat
- the DDL and DML.
- get-movie-info endpoint.
- I did the pair programming working on the endpoint where all movie-titles, schedule-times, age requirements for all cinema halls in the movie theatre in question are returned for a given start- and end date.
- I participated in creating the create-booking endpoint.

Snorri : SnorriSig
- Endpoint where all movie-titles, schedule-times, age requirements for all cinema halls in the movie theater in question are returned for a given start- and end date, typically a week. Karolina assisted me with MYSQL logic and Veselin with DTO.
- Add Link to image(s) + trailer(s) and poster(s) to "Get movie info".
- Worked on entity relations with others.

Veselin : v3s1e
- Implemented Authentication with Spring Security.
- Participated in the creation of the endpoint to book a seat for a movie.
- Helped the team with problems we encountered during the sprint.
