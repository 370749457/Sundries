package ClassesForTask3;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class WitnessFuture {
    private SciencesAcademy academy;

    public void Witness() throws Exception {
        if (academy == null) {
            throw new RuntimeException("There must be two people in the SciencesAcademy. ");
        }

        checkAcademy();

        academy.changeState();

     // Make sure both of team have the same number of members.

        System.out.println("It is a special time,they find the answer and they are "+ academy.getState());
    }

    public void checkAcademy() {
        if (this.academy == null){
            throw new RuntimeException("Academy need two people");
        }

        int NUM = this.academy.getNum();

        if (this.academy.getA_name() == null){
            throw new RuntimeException("Name shouldn't be null.");
        }

        if (NUM == 0 ) {
            throw new RuntimeException("We need two people.");
        }

        if( NUM != 2) {
            throw new RuntimeException("It must be two people!");
        }

    }
    public void initAcademy(SciencesAcademy academy){
        this.academy = academy;
    }


}
