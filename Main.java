import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.awt.Container;
public class Main {
    public static void main(String[] args) {
        JFrame window = new JFrame("Tic-Tac-Toe");        
        TurnBoard tb = new TurnBoard();
        TicTacToe main = new TicTacToe(tb);
        Container container = window.getContentPane();
        container.setLayout(new BorderLayout());// creating container for catching turnboard and gameboard
        container.add(tb, BorderLayout.NORTH);
        container.add(main, BorderLayout.CENTER);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //insert adding here
        
        window.setBounds(600,600,600,600);
        window.setVisible(true);
    }
}