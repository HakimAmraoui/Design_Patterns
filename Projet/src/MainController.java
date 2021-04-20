import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.stage.FileChooser;

import java.io.File;

public class MainController {
    public Label HelloWorld;

    public void sayHelloWorld(ActionEvent actionEvent) {


        FileChooser fileChooser = new FileChooser();
        File selectedFile = fileChooser.showOpenDialog(null);

        // process the file, and limit periods to given time interval
        var teamsProcessor = new TEAMSProcessor(selectedFile,"19/01/2021 à 10:15:00", "19/01/2021 à 11:45:00", new DurationSorter());
        teamsProcessor.setDisplayer(new DisplayerHTML());
        teamsProcessor.setSorter(new IdSorter());
        teamsProcessor.sort();
/*
        var allpeople = teamsProcessor.get_allpeople();
        for (People people : allpeople) {
            System.out.println( people );
        }
*/

        System.out.println( teamsProcessor.display() );

    }
}
