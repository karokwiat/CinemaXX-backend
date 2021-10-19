# CinemaXX

KEA - AP Computer Science
Third Semester
Instant Coffee Group
CinemaXX Project

**Authors:**

* Names here


## Security

Right now every endpoint requires authentication except:

* `/api/authenticate/signup`
* `/api/authenticate/login`
* `/api/swagger`
* `/api/api-docs`


### How to sign up

POST `/api/authenticate/signup` with `username` and `password`


### How to log in

POST `/api/authenticate/login` with `username` and `password`

You will get a token back.


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
