We finished what we had decleared.
1. Completed minor things missing from Sprint-1.
2. Added links to image + trailer + poster to "Get movie info".
3. Endpoint to let an authenticated administrator create a booking for seats for specific movie, cinema hall and start time.
4. Endpoint to let an authenticated user get a list of free/booked seats for a given cinema hall, date and time.
5. Endpoint to let an authenticated user cancel/edit a booking.
6. Description on how we plan to get the movie info: 

Another solution to manually update the database with movie information is to fetch it from an external API that is an expert in movie information. For example, the Internet Movie Database (IMDB), or other alternatives like the TMDb and OMDb.
We believe that in our backend controller it is possible to search for a movie title with movieId and send the movie title string to the foreign API through a DTO. Then receive a standard package including information about the movie which we will have to filter with DTO and forward to our Json package.

