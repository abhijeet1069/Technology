package swing.javaBook.eventHandling.otherClass;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Other implements ActionListener{
	GFG gfg;
	
	Other(GFG gfg){
		this.gfg = gfg;
	}

	@Override
	public void actionPerformed(ActionEvent e) { // process the event
		gfg.textField.setText("Different classes");
		
	}
}
