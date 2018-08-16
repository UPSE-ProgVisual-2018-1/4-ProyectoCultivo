package controllers;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;

public class NuevoListenerCambiosRendimiento extends ControllerCosecha implements ChangeListener<Boolean> {

	@Override 
	public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
		if(!newValue)
		{
			if(!txtProduccionTotalTM.getText().isEmpty() 
					&& !spnHectareasCosechadas.getValue().equals(0)
					&& txtProduccionTotalTM.getText().matches("\\d+"))
			{
				float rendimientoPromedioTemp = calculoMatematimaticoRendimientoPromedio();
				txtRendimientoHectareaPromedio.setText(String.valueOf(rendimientoPromedioTemp));
			}else {
				txtRendimientoHectareaPromedio.setText(null);
			}
		}	
		
	}

}
