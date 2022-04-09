package ClassesForTask3;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Random;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class SciencesAcademy {

    private String a_name;
    private ArrayList<SpecialPeople> members;
    private Integer num = 0;

    public void setName(String name){
        if (name == null) {
            throw new IllegalArgumentException("Name shouldn't be null.");
        }
        this.a_name = name;
    }


    public void addMember(SpecialPeople sp){
        if (members == null) {
            members = new ArrayList<>();
        }
        members.add(sp);
        num++;
    }

    public void deleteMember(SpecialPeople sp){
        if (num > 0){
            members.remove(sp);
            num --;
        }else{
            throw new IllegalArgumentException("There are no people to delete");
        }

    }

    public Integer getNum(){
        return num;
    }

    public void changeState() throws Exception {
        members.get(0).setState("excited");
        members.get(1).setState("excited");
    }

    public String getState(){
        return members.get(0).getState();
    }




}
