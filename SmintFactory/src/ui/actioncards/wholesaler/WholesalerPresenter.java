package ui.actioncards.wholesaler;

import java.net.URL;
import java.util.ResourceBundle;

import javax.inject.Inject;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import model.Action;
import model.Model;

/**
 * Presenter class for bottom screen.
 */
public class WholesalerPresenter implements Initializable {
	// Automatically use the same model for each .fxml using inject (also instantiates automatically).
	@Inject
	Model model;
	
	@FXML Button wholesaleButton1;
	@FXML TextField wholesaleText;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		model.getIsWholesalerButtonUsed().addListener(new ChangeListener<Boolean>(){
			@Override
			public void changed(ObservableValue<? extends Boolean> arg0, Boolean arg1, Boolean arg2) {
				wholesaleButton1.setDisable(model.getIsWholesalerButtonUsed().getValue());
			}
		});
	}
	
	@FXML    
	private void actionWholesale(ActionEvent event){
		model.doAction(Action.WHOLESALER, false);
    }
	
	
	
}
