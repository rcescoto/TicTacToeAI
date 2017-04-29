import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.io.IOException;
import java.awt.Color;

public class TurnBoard extends JPanel {
	JLabel ex = new JLabel("X", SwingConstants.CENTER);
	JLabel ow = new JLabel("O", SwingConstants.CENTER);
	public TurnBoard() {
      this.setLayout(new GridLayout(1,3));
      this.addLabels(this.ex, this.ow);
    }
    public void addLabels(JLabel ex, JLabel ow){
    	ex.setBorder(BorderFactory.createMatteBorder(1, 5, 1, 1, Color.red));
    	this.add(ex);
    	this.add(ow);
    }
    public void turnSet(int turn){
    	if(turn % 2 == 0){
    		ow.setBorder(null);
            ex.setBorder(BorderFactory.createMatteBorder(1, 5, 1, 1, Color.red));
    	}
    	else{
            ex.setBorder(null);
            ow.setBorder(BorderFactory.createMatteBorder(1, 5, 1, 1, Color.red));
    	}
    }

}