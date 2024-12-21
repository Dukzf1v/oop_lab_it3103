package hust.soict.dsai.javafx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class PainterController {
    @FXML
    private Pane drawingAreaPane;
    private boolean drawingMode = true;

    @FXML
    void clearButtonPressed(ActionEvent event) {
    	drawingAreaPane.getChildren().clear();
    }

    @FXML
    void drawingAreaMouseDragged(MouseEvent event) {
    	Circle newCircle = new Circle(event.getX(), event.getY(), 4);
    	if (drawingMode) {
    		newCircle.setFill(Color.BLACK);
    	} else {
    		newCircle.setFill(Color.WHITE);
    	}
    	drawingAreaPane.getChildren().add(newCircle);
    }
    
    @FXML
    void togglePen() {
    	drawingMode = true;
    }
    
    @FXML
    void toggleEraser() {
    	drawingMode = false;
    }
}