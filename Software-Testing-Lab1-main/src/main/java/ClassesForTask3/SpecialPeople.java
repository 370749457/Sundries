package ClassesForTask3;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
public class SpecialPeople {
    public final String description = "This person is special from birth";

    private String name;
    private Integer age;
    private Gender gender;
    private String state;


    public SpecialPeople(String name,Gender gender, Integer age, String state) throws Exception {

        if (name == null) {
            throw new IllegalArgumentException("Name shouldn't be null.");
        }
        if (gender == null) {
            throw new IllegalArgumentException("gender shouldn't be null.");
        }
        if (state == null) {
            throw new IllegalArgumentException("state shouldn't be null");
        }
        if (age < 0) {
            throw new IllegalArgumentException("gender shouldn't be null.");
        }
        this.name = name;
        this.gender = gender;
        this.state = state;
        this.age = age;

    }


    public void setName(String name) throws Exception {
        if (name == null) {
            throw new IllegalArgumentException("Name shouldn't be null.");
        }
        this.name = name;
    }

    public void setGender(Gender gender) throws Exception {
        if (gender == null) {
            throw new IllegalArgumentException("Gender shouldn't be null.");
        }
        this.gender = gender;
    }

    public void setState(String state) throws Exception {
        if (state == null){
            throw new IllegalArgumentException("State shouldn't be null");
        }
        this.state = state;
    }

    public  void setAge(Integer age) throws Exception{
        if (age < 0){
            throw new IllegalArgumentException("Age should lager than 0");
        }
    }
     public String getState(){
        return this.state;
     }
}
