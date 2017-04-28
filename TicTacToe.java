//NOTE: Aayusin yung JOptionPane na lalagyan ng reset game. Tapos magdadagdag ng JPanel sa taas
//for player turn

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.io.IOException;

public class TicTacToe extends JPanel {
    JButton buttons[] = new JButton[9]; 
    int turn = 0;
    
    public TicTacToe() {
      setLayout(new GridLayout(3,3));
      initializebuttons(); 
    }
    
    public void initializebuttons() {
        for(int i = 0; i <= 8; i++) {
            buttons[i] = new JButton();
            buttons[i].setText("");
            buttons[i].addActionListener(new buttonListener());
            
            add(buttons[i]);           
        }
    }
	
    public void resetButtons() {
        for(int i = 0; i <= 8; i++) {
            buttons[i].setText("");
        }
    }
    
    private class buttonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
			Object[] options1 = { "Yes", "No" };
			int choice = 0;
            JButton buttonClicked = (JButton)e.getSource();
            if(turn % 2 == 0) {
				buttonClicked.setText("X");
				buttonClicked.setEnabled(false);
            } else {
				buttonClicked.setText("O");
				buttonClicked.setEnabled(false);
            }
			
            if(checkForWin() == true) {
                int result = JOptionPane.showOptionDialog(null, "Game Over! Reset?", "Game Over!", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE,
                null, options1, null);
                if (result == JOptionPane.YES_OPTION) {
                    try {
                        Runtime.getRuntime().exec("java Main");
                        System.exit(0);
                    } catch (IOException r) {

                    }
                } else if (result == JOptionPane.NO_OPTION) {
                    
                }
				//resetButtons();
				//buttonClicked.setEnabled(true);
            } turn++;
        }
        
        public boolean checkForWin()
        {
            //horizontal win check
            if( checkAdjacent(0,1) && checkAdjacent(1,2) )
                return true;
            else if( checkAdjacent(3,4) && checkAdjacent(4,5) )
                return true;
            else if ( checkAdjacent(6,7) && checkAdjacent(7,8))
                return true;
            
            //vertical win check
            else if ( checkAdjacent(0,3) && checkAdjacent(3,6))
                return true;  
            else if ( checkAdjacent(1,4) && checkAdjacent(4,7))
                return true;
            else if ( checkAdjacent(2,5) && checkAdjacent(5,8))
                return true;
            
            //diagonal win check
            else if ( checkAdjacent(0,4) && checkAdjacent(4,8))
                return true;  
            else if ( checkAdjacent(2,4) && checkAdjacent(4,6))
                return true;
            else 
                return false;
        }
        
        public boolean checkAdjacent(int a, int b) {
            if ( buttons[a].getText().equals(buttons[b].getText()) && !buttons[a].getText().equals("") ) return true;
            else return false;
        }  
    }
}