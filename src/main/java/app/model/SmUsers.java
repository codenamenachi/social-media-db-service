package app.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
@Table(name = "SM-USERS")
public class SmUsers {

    @Id
    private int userId;
    private String firstName;
    private String lastName;
    private String avatar;

    @ManyToMany(fetch = FetchType.EAGER,mappedBy="users",cascade = CascadeType.ALL)
    @JoinColumn(name = "userId")
    private Set<SmUsers> friends;
}
