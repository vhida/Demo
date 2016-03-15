package Sample;

import java.io.Serializable;

/**
 * Created by Liu Hao on 6/3/16.
 */
public class UserPK implements Serializable{
    String lastName;
    String firstName;
    public UserPK(){}
    public UserPK(String firstName, String lastName){
        this.firstName = firstName;
        this.lastName = lastName;
    }
}
