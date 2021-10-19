package instantcoffee.cinemaxx.dto;

import instantcoffee.cinemaxx.entities.Actor;
import instantcoffee.cinemaxx.entities.Movie;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.stream.Collectors;

@NoArgsConstructor
@Getter
@Setter
public class ActorDTO {

    private String firstName;
    private String lastName;
    private static ModelMapper modelMapper = new ModelMapper();

    public ActorDTO(Actor actor){
        this.firstName = actor.getFirstName();
        this.lastName = actor.getLastName();
    }

    public ActorDTO(String firstName, String lastName){
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public static ActorDTO entityToDTO(Actor actor) {
        ActorDTO actorDTO = modelMapper.map(actor, ActorDTO.class);
        return actorDTO;
    }

    public static List<ActorDTO> entityToDTO(List<Actor> actors) {
        return actors.stream().map(x -> entityToDTO(x)).collect(Collectors.toList());
    }

}
