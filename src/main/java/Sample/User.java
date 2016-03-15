package Sample;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.validation.constraints.Size;

/**
 * Created by Liu Hao on 5/3/16.
 */
@Entity@IdClass(UserPK.class)
public class User {

    @Id
    @Size(max = 64)
    @Column(name = "firstName", nullable = false)
    private String firstName;

    @Id
    @Size(max = 64)
    @Column(name = "lastName", nullable = false)
    private String lastName;

    public String getFirstName(){
        return this.firstName;
    }

    public void setFirstName(String firstName){
        this.firstName = firstName;
    }

    public String getLastName(){
        return this.lastName;
    }

    public void setLastName(String lastName){
        this.lastName = lastName;
    }

}
