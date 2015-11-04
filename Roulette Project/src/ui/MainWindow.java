package ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

import logic.Game;
import logic.typeOfBets.*;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JTextPane;
import javax.swing.JScrollBar;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JSpinner;
import javax.swing.SpinnerListModel;

public class MainWindow extends JFrame {

	private JPanel contentPane;
	private JMenuBar menuBar;
	private JMenu mnRoulette;
	private JMenuItem mntmNewGame;
	private JMenuItem mntmNewPlayer;
	private JMenuItem mntmExit;
	private JMenu mnHelp;
	private JMenuItem mntmAbout;
	private JTextField tfMoney;
	private JLabel lblPlayerName;
	private Game game;
	private JTextPane textPane;
	private JComboBox cbTypeOfBet;
	private JComboBox cbAuxTypeOfBet;
	private JTextField jtStraightUp;
	private JButton btnBet;
	private JSpinner spAmount;
	private JButton btnNoMoreBets;
	private logic.Number number;
	private JTextField tfNumber;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow frame = new MainWindow();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MainWindow() {
		game=new Game("DefaultPlayer", Color.BLUE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 676, 437);
		setJMenuBar(getMenuBar_1());
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getTfMoney());
		contentPane.add(getLblPlayerName());
		contentPane.add(getTextPane());
		contentPane.add(getCbTypeOfBet());
		contentPane.add(getCbAuxTypeOfBet());
		contentPane.add(getBtnBet());
		contentPane.add(getSpAmount());
		contentPane.add(getBtnNoMoreBets());
		contentPane.add(getTfNumber());

		representStatus();
	}

	private void representStatus() {
		representMoney();
		if(this.game.getPlayer().getMoney()<=0){
			JOptionPane.showMessageDialog(null,"Game Over");
		}


	}

	private void representMoney() {
		double money = game.getPlayer().getMoney();
		this.tfMoney.setText(String.valueOf(money));

	}

	private void playGame(){

	}

	private JMenuBar getMenuBar_1() {
		if (menuBar == null) {
			menuBar = new JMenuBar();
			menuBar.add(getMnRoulette());
			menuBar.add(getMnHelp());
		}
		return menuBar;
	}
	private JMenu getMnRoulette() {
		if (mnRoulette == null) {
			mnRoulette = new JMenu("Roulette");
			mnRoulette.setSelectedIcon(new ImageIcon(MainWindow.class.getResource("/img/icon175x175.png")));
			mnRoulette.add(getMntmNewGame());
			mnRoulette.add(getMntmNewPlayer());
			mnRoulette.add(getMntmExit());
		}
		return mnRoulette;
	}
	private JMenuItem getMntmNewGame() {
		if (mntmNewGame == null) {
			mntmNewGame = new JMenuItem("New Game");
		}
		return mntmNewGame;
	}
	private JMenuItem getMntmNewPlayer() {
		if (mntmNewPlayer == null) {
			mntmNewPlayer = new JMenuItem("New Player");
			mntmNewPlayer.setEnabled(false);
		}
		return mntmNewPlayer;
	}
	private JMenuItem getMntmExit() {
		if (mntmExit == null) {
			mntmExit = new JMenuItem("Exit");
		}
		return mntmExit;
	}
	private JMenu getMnHelp() {
		if (mnHelp == null) {
			mnHelp = new JMenu("Help");
			mnHelp.add(getMntmAbout());
		}
		return mnHelp;
	}
	private JMenuItem getMntmAbout() {
		if (mntmAbout == null) {
			mntmAbout = new JMenuItem("About");
		}
		return mntmAbout;
	}
	private JTextField getTfMoney() {
		if (tfMoney == null) {
			tfMoney = new JTextField();
			tfMoney.setEditable(false);
			tfMoney.setHorizontalAlignment(SwingConstants.CENTER);
			tfMoney.setBounds(561, 37, 86, 20);
			tfMoney.setColumns(10);
		}
		return tfMoney;
	}
	private JLabel getLblPlayerName() {
		if (lblPlayerName == null) {
			lblPlayerName = new JLabel(game.getPlayer().getName());
			lblPlayerName.setHorizontalAlignment(SwingConstants.CENTER);
			lblPlayerName.setForeground(game.getPlayer().getColor());
			lblPlayerName.setBounds(566, 12, 81, 14);
		}
		return lblPlayerName;
	}
	private JTextPane getTextPane() {
		if (textPane == null) {
			textPane = new JTextPane();
			textPane.setBounds(431, 163, 199, 121);
		}
		return textPane;
	}
	private JComboBox getCbTypeOfBet() {
		if (cbTypeOfBet == null) {
			cbTypeOfBet = new JComboBox<TypeOfBet>();
			cbTypeOfBet.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					TypeOfBet betSelected = (TypeOfBet) cbTypeOfBet.getSelectedItem();
					//String betSelected = String.valueOf(cbTypeOfBet.getSelectedItem());
					showBetOptions(betSelected);
				}
			});
			cbTypeOfBet.setModel(new DefaultComboBoxModel<TypeOfBet>(game.getBetsAvailable()));
			cbTypeOfBet.setBounds(26, 200, 106, 20);
		}
		return cbTypeOfBet;
	}
	protected void showBetOptions(TypeOfBet betSelected) {		
		showCbAux(betSelected);			

	}
	private void showCbAux(TypeOfBet betSelected) {
		if(betSelected instanceof Column){
			String[]cbAuxColumnsArray={"Column 0","Column 1","Column 2"};
			cbAuxTypeOfBet.setModel(new DefaultComboBoxModel<String>(cbAuxColumnsArray));
			cbAuxTypeOfBet.setVisible(true);	
		}
		else if(betSelected instanceof CornerBet){
			//thinking about it
		}
		else if(betSelected instanceof EvenOdd){
			String[]cbAuxEvenOddArray={"Even","Odd"};
			cbAuxTypeOfBet.setModel(new DefaultComboBoxModel<String>(cbAuxEvenOddArray));
			cbAuxTypeOfBet.setVisible(true);				
		}
		else if(betSelected instanceof RedBlack){
			String[] cbAuxRedBlackArray={"Red","Black"};
			cbAuxTypeOfBet.setModel(new DefaultComboBoxModel<String>(cbAuxRedBlackArray));
			cbAuxTypeOfBet.setVisible(true);
		}
		else if(betSelected instanceof StraightUp){
			cbAuxTypeOfBet.setVisible(false);
		}


	}

	private JComboBox getCbAuxTypeOfBet() {
		if (cbAuxTypeOfBet == null) {
			String[]cbAuxColumns={"Column 0","Column 1","Column 2"};
			cbAuxTypeOfBet = new JComboBox(cbAuxColumns);
			cbAuxTypeOfBet.setVisible(false);
			cbAuxTypeOfBet.setBounds(167, 200, 114, 20);
		}
		return cbAuxTypeOfBet;
	}
	private JTextField getJtStraightUp() {
		if (jtStraightUp == null) {
			jtStraightUp = new JTextField();
			jtStraightUp.setVisible(false);
			jtStraightUp.addKeyListener(new KeyAdapter() {
				public void keyTyped(KeyEvent e) {
					char c = e.getKeyChar();
					if (!((c >= '0') && (c <= '9') ||
							(c == KeyEvent.VK_BACK_SPACE) ||
							(c == KeyEvent.VK_DELETE))) {
						getToolkit().beep();
						e.consume();
					}
				}
			});
			jtStraightUp.setBounds(167, 200, 114, 20);
			jtStraightUp.setColumns(10);
		}
		return jtStraightUp;
	}
	private JButton getBtnBet() {
		if (btnBet == null) {
			btnBet = new JButton("Bet");
			btnBet.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					TypeOfBet betSelected = (TypeOfBet) cbTypeOfBet.getSelectedItem();
					int amount = Integer.parseInt((String) spAmount.getValue());
					if(betSelected instanceof Column){
						((Column) betSelected).setColomnBeted(cbAuxTypeOfBet.getSelectedIndex());

					}
					else if (betSelected instanceof CornerBet){

					}
					else if(betSelected instanceof EvenOdd){
						((EvenOdd)betSelected).setType(cbAuxTypeOfBet.getSelectedIndex());
					}
					else if(betSelected instanceof RedBlack){
						String color=(String) cbAuxTypeOfBet.getSelectedItem();
						if(color.equals("Red")){
							((RedBlack)betSelected).setColor(Color.RED);
						}
						else if (color.equals("Black")){
							((RedBlack)betSelected).setColor(Color.BLACK);
						}
					}
					else if(betSelected instanceof StraightUp){
						((StraightUp)betSelected).setNumber((int) cbAuxTypeOfBet.getSelectedItem());
					}

					if(!game.getPlayer().doABet(amount, betSelected))JOptionPane.showMessageDialog(null, "You don`t have money");;
					representMoney();
					btnNoMoreBets.setEnabled(true);
					
				}
			});
			btnBet.setBounds(63, 291, 89, 23);
		}
		return btnBet;
	}
	private JSpinner getSpAmount() {
		if (spAmount == null) {
			spAmount = new JSpinner();
			spAmount.setModel(new SpinnerListModel(new String[] {"5", "10", "50", "100", "500", "1000"}));
			spAmount.setBounds(118, 264, 69, 20);
		}
		return spAmount;
	}
	
	private JButton getBtnNoMoreBets() {
		if (btnNoMoreBets == null) {
			btnNoMoreBets = new JButton("No more bets!");
			btnNoMoreBets.setEnabled(false);
			btnNoMoreBets.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					number=game.turnTheWheel();
					tfNumber.setText(String.valueOf(number.getValue()));
					tfNumber.setForeground(number.getColor());
					
					
					
					btnNoMoreBets.setEnabled(false);
					representMoney();
					
				}
			});
			btnNoMoreBets.setBounds(208, 291, 123, 23);
		}
		return btnNoMoreBets;
	}
	private JTextField getTfNumber() {
		if (tfNumber == null) {
			tfNumber = new JTextField();
			tfNumber.setEditable(false);
			tfNumber.setBounds(404, 37, 86, 20);
			tfNumber.setColumns(10);
		}
		return tfNumber;
	}
}
