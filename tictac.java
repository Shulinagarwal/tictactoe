import java.awt.*;
import javax.swing.*;
import java.util.*;
import java.awt.event.*;


public class tictac implements ActionListener{

    Random random=new Random();
    JFrame frame=new JFrame();
    JPanel title_panel=new JPanel();
    JPanel button_panel=new JPanel();
    JLabel textfield=new JLabel();
    JButton[] buttons=new JButton[9];
    boolean player1_turn;

    tictac(){
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 800);
        frame.getContentPane().setBackground(new Color(50,50,50));
        frame.setLayout(new BorderLayout());
        frame.setVisible(true);


        textfield.setBackground(new Color(25,25,25));
        textfield.setForeground(new Color(25,255,0));
        textfield.setFont(new Font("Ink Free",Font.BOLD,75));
        textfield.setHorizontalAlignment(JLabel.CENTER);
        textfield.setText("TicTacToe");
        textfield.setOpaque(true);

        title_panel.setLayout(new BorderLayout());
        title_panel.setBounds(0,0,800,100);


        button_panel.setLayout(new GridLayout(3,3));
        button_panel.setBackground(new Color(125,215,125));

        for(int i=0;i<9;i++){
            buttons[i]=new JButton();
            button_panel.add(buttons[i]);
            buttons[i].setFont(new Font("MV Boli",Font.BOLD,120));
            buttons[i].setFocusable(false);
            buttons[i].addActionListener(this);
        }

        title_panel.add(textfield);
        frame.add(title_panel,BorderLayout.NORTH);
        frame.add(button_panel);

        firstTurn();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for(int i=0;i<9;i++){
            if(e.getSource()==buttons[i]){
                if(player1_turn){
                    if(buttons[i].getText()==""){
                        buttons[i].setForeground(new Color(255,0,0));
                        buttons[i].setText("x");
                        player1_turn=false;
                        textfield.setText("o turn");
                        check();
                    }
                }
                else{
                    if(buttons[i].getText()==""){
                        buttons[i].setForeground(new Color(0,0,255));
                        buttons[i].setText("o");
                        player1_turn=true;
                        textfield.setText("x turn");
                        check();
                    }
                }
            }


        }
    }

    public void firstTurn(){

        try{
            Thread.sleep(2000);
        }
        catch(InterruptedException e){
            e.printStackTrace();
        }
        if(random.nextInt(2)==0){
            player1_turn=true;
            textfield.setText("X turn");

        }
        else{
            player1_turn=false;
            textfield.setText("o turn");
        }

    }

    public void check(){
        //check x wins

        if(
            (buttons[0].getText()=="x") &&
            (buttons[1].getText()=="x") &&
            (buttons[2].getText()=="x") 
            ){
                xwins(0, 1, 2);

        }
        if(
            (buttons[3].getText()=="x") &&
            (buttons[4].getText()=="x") &&
            (buttons[5].getText()=="x") 
            ){
                xwins(3, 4, 5);

        }
        if(
            (buttons[6].getText()=="x") &&
            (buttons[7].getText()=="x") &&
            (buttons[8].getText()=="x") 
            ){
                xwins(6, 7, 8);

        }
        if(
            (buttons[0].getText()=="x") &&
            (buttons[3].getText()=="x") &&
            (buttons[6].getText()=="x") 
            ){
                xwins(0, 3, 6);

        }
        if(
            (buttons[1].getText()=="x") &&
            (buttons[4].getText()=="x") &&
            (buttons[7].getText()=="x") 
            ){
                xwins(1, 4, 7);

        }
        if(
            (buttons[2].getText()=="x") &&
            (buttons[5].getText()=="x") &&
            (buttons[8].getText()=="x") 
            ){
                xwins(2, 5, 8);

        }
        if(
            (buttons[0].getText()=="x") &&
            (buttons[4].getText()=="x") &&
            (buttons[8].getText()=="x") 
            ){
                xwins(0, 4, 8);

        }
        if(
            (buttons[2].getText()=="x") &&
            (buttons[4].getText()=="x") &&
            (buttons[6].getText()=="x") 
            ){
                xwins(2, 4, 6);

        }

        // o wins checking

        if(
            (buttons[0].getText()=="o") &&
            (buttons[1].getText()=="o") &&
            (buttons[2].getText()=="o") 
            ){
                owins(0, 1, 2);

        }
        if(
            (buttons[3].getText()=="o") &&
            (buttons[4].getText()=="o") &&
            (buttons[5].getText()=="o") 
            ){
                owins(3, 4, 5);

        }
        if(
            (buttons[6].getText()=="o") &&
            (buttons[7].getText()=="o") &&
            (buttons[8].getText()=="o") 
            ){
                owins(6, 7, 8);

        }
        if(
            (buttons[0].getText()=="o") &&
            (buttons[3].getText()=="o") &&
            (buttons[6].getText()=="o") 
            ){
                owins(0, 3, 6);

        }
        if(
            (buttons[1].getText()=="o") &&
            (buttons[4].getText()=="o") &&
            (buttons[7].getText()=="o") 
            ){
                owins(1, 4, 7);

        }
        if(
            (buttons[2].getText()=="o") &&
            (buttons[5].getText()=="o") &&
            (buttons[8].getText()=="o") 
            ){
                owins(2, 5, 8);

        }
        if(
            (buttons[0].getText()=="o") &&
            (buttons[4].getText()=="o") &&
            (buttons[8].getText()=="o") 
            ){
                owins(0, 4, 8);

        }
        if(
            (buttons[2].getText()=="o") &&
            (buttons[4].getText()=="o") &&
            (buttons[6].getText()=="o") 
            ){
                owins(2, 4, 6);

        }
    }

    public void xwins(int a,int b,int c){
        buttons[a].setBackground(Color.yellow);
        buttons[b].setBackground(Color.yellow);
        buttons[c].setBackground(Color.yellow);

        for(int i=0;i<9;i++){
            buttons[i].setEnabled(false);
        }
        textfield.setText("X wins");
    }
    public void owins(int a,int b,int c){
        buttons[a].setBackground(Color.yellow);
        buttons[b].setBackground(Color.yellow);
        buttons[c].setBackground(Color.yellow);

        for(int i=0;i<9;i++){
            buttons[i].setEnabled(false);
        }
        textfield.setText("o wins");
    }

}
