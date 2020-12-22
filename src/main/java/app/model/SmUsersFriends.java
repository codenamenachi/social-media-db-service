package app.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
@Table(name = "SM-USERS-FRIENDS")
public class SmUsersFriends {

    @Id
    private int userId;
    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "userId")
    private Set<SmUsers> users;
}
