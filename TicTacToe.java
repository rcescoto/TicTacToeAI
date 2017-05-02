//NOTE: Aayusin yung JOptionPane na lalagyan ng reset game. Tapos magdadagdag ng JPanel sa taas
//for player turn
// Needs  way to access the states for making for the next move
//let user choose what to draw
//always let the holder of x be first to move??
//states is going to be implemented using arrays 
//since that is the prior used data structure
//terminal min and max are all states
//terminal states are the end results?
//
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.io.IOException;

public class TicTacToe extends JPanel {
    JButton buttons[] = new JButton[9]; // check if this buttons has the states
    int turn = 0;
    TurnBoard tb;
    public TicTacToe(TurnBoard tb) {
      this.setLayout(new GridLayout(3,3));// added this for readability
      this.initializebuttons(); 
      this.tb=tb;
    }
    
    public void initializebuttons() {
        for(int i = 0; i <= 8; i++) {
            buttons[i] = new JButton();
            buttons[i].setText("");
            buttons[i].setOpaque(false);
            buttons[i].setContentAreaFilled(false);
            
            buttons[i].addActionListener(new buttonListener());
            
            add(buttons[i]);//adds the button to the JPanel           
        }
    }
	
    public void resetButtons() {
        for(int i = 0; i <= 8; i++) {
            buttons[i].setText("");
        }
    }
    
    private class buttonListener implements ActionListener {//create another class for this
        
        public void actionPerformed(ActionEvent e) {
			Object[] options1 = { "Reset" };// what is this
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
                if(turn % 2 == 0){
                    int result = JOptionPane.showOptionDialog(null, "X Wins!", "Game Over!", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE,
                null, options1, null);
                    if (result == JOptionPane.YES_OPTION) {
                        try {
                            Runtime.getRuntime().exec("java Main");
                            System.exit(0);
                        } catch (IOException r) {

                        }
                    } else if (result == JOptionPane.NO_OPTION) {
                        
                    }
                }
                else{
                     int result = JOptionPane.showOptionDialog(null, "O wins!", "Game Over!", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE,
                null, options1, null);
                    if (result == JOptionPane.YES_OPTION) {
                        try {
                            Runtime.getRuntime().exec("java Main");
                            System.exit(0);
                        } catch (IOException r) {

                        }
                    } else if (result == JOptionPane.NO_OPTION) {
                        
                    }
                }
               
				//resetButtons();
				//buttonClicked.setEnabled(true);
            }
            else if(checkDraw(buttons)){
                           int result = JOptionPane.showOptionDialog(null, "Draw!", "Game Over!", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE,
                null, options1, null);
                if (result == JOptionPane.YES_OPTION) {
                    try {
                        Runtime.getRuntime().exec("java Main");
                        System.exit(0);
                    } catch (IOException r) {

                    }
                } else if (result == JOptionPane.NO_OPTION) {
                    
                } 
            } turn++;
            tb.turnSet(turn);
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
        
        public boolean checkAdjacent(int a, int b) {// can it access the real values
            if ( buttons[a].getText().equals(buttons[b].getText()) && !buttons[a].getText().equals("") ) return true;
            else return false;
        }
        public boolean checkDraw(JButton j[]){
            int i;
            for(i=0; i<=8; i++){
                if(j[i].getText().equals("")){
                    return false;
                }
            }
            return true;
        }
	   //public int min_value(JButton j[]) {

        
       //}
       public void setStates(JButton j[]){

       } 
    }
}
