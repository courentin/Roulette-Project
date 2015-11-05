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
import javax.swing.JScrollPane;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JSpinner;
import javax.swing.SpinnerListModel;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import java.awt.Dimension;
import javax.swing.table.DefaultTableModel;
import java.awt.Rectangle;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Toolkit;

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
	private JComboBox cbTypeOfBet;
	private JComboBox cbAuxTypeOfBet;
	private JTextField jtStraightUp;
	private JButton btnBet;
	private JSpinner spAmount;
	private JButton btnNoMoreBets;
	private logic.Number number;
	private JTextField tfNumber;
	private JTextPane txEvenOdd;
	private JTextPane txRedBlack;
	private JScrollPane scrollPane;
	private JTable tbBets;
	//private JScrollPane scrollPane;


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
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(MainWindow.class.getResource("/img/icon175x175.png")));
		
		game=new Game("DefaultPlayer", Color.BLUE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 676, 437);
		setJMenuBar(getMenuBar_1());
		contentPane = new JPanel();
		contentPane.setBackground(new Color(51, 153, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getCbTypeOfBet());
		contentPane.add(getCbAuxTypeOfBet());
		contentPane.add(getSpAmount());
		contentPane.add(getBtnBet());
		contentPane.add(getBtnNoMoreBets());
		contentPane.add(getTxEvenOdd());
		contentPane.add(getTxRedBlack());
		contentPane.add(getLblPlayerName());
		contentPane.add(getTfNumber());
		contentPane.add(getTfMoney());
		contentPane.add(getScrollPane());
		//contentPane.add(getTbBet);
		//contentPane.add(getTbBets());

		representStatus();
	}

	private void newGame() {
		game=new Game("DefaultPlayer", Color.BLUE);
		representStatus();
		
	}

	private void representStatus() {
		representMoney();
		if(this.game.getPlayer().getMoney()<=0){
			JOptionPane.showMessageDialog(null,"Game Over");
		}
		representBets();


	}

	private void representBets() {
		System.err.println(game.getPlayer().getBetsTable().getRowCount());
		tbBets.setModel(game.getPlayer().getBetsTable());
	}

	private void representMoney() {
		double money = game.getPlayer().getMoney();
		this.tfMoney.setText(String.valueOf(money));

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
			mntmNewGame.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					newGame();
					
					
					
					
				}
			});
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
			tfMoney.setBounds(339, 37, 86, 20);
			tfMoney.setEditable(false);
			tfMoney.setHorizontalAlignment(SwingConstants.CENTER);
			tfMoney.setColumns(10);
		}
		return tfMoney;
	}
	private JLabel getLblPlayerName() {
		if (lblPlayerName == null) {
			lblPlayerName = new JLabel(game.getPlayer().getName());
			lblPlayerName.setBounds(344, 12, 81, 14);
			lblPlayerName.setHorizontalAlignment(SwingConstants.CENTER);
			lblPlayerName.setForeground(game.getPlayer().getColor());
		}
		return lblPlayerName;
	}
	private JComboBox getCbTypeOfBet() {
		if (cbTypeOfBet == null) {
			cbTypeOfBet = new JComboBox<TypeOfBet>();
			cbTypeOfBet.setBounds(58, 252, 106, 20);
			cbTypeOfBet.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					TypeOfBet betSelected = (TypeOfBet) cbTypeOfBet.getSelectedItem();
					//String betSelected = String.valueOf(cbTypeOfBet.getSelectedItem());
					showBetOptions(betSelected);
				}
			});
			cbTypeOfBet.setModel(new DefaultComboBoxModel<TypeOfBet>(game.getBetsAvailable()));
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
			String[]cbAuxStraightUpArray=new String[37];
			for(int i=0;i<=36;i++){
				cbAuxStraightUpArray[i]=String.valueOf(i);
			}
			cbAuxTypeOfBet.setModel(new DefaultComboBoxModel<String>(cbAuxStraightUpArray));
			cbAuxTypeOfBet.setVisible(true);
		}


	}

	private JComboBox getCbAuxTypeOfBet() {
		if (cbAuxTypeOfBet == null) {
			String[]cbAuxColumns={"Column 0","Column 1","Column 2"};
			cbAuxTypeOfBet = new JComboBox(cbAuxColumns);
			cbAuxTypeOfBet.setBounds(199, 252, 114, 20);
			cbAuxTypeOfBet.setVisible(false);
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
			btnBet.setBounds(58, 318, 89, 23);
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
						((StraightUp)betSelected).setNumber((int) Integer.parseInt((String) cbAuxTypeOfBet.getSelectedItem()));
						
					}

					if(!game.getPlayer().doABet(amount, betSelected))JOptionPane.showMessageDialog(null, "You don`t have money");;
					representMoney();
					representBets();
					btnNoMoreBets.setEnabled(true);
					
				}
			});
		}
		return btnBet;
	}
	private JSpinner getSpAmount() {
		if (spAmount == null) {
			spAmount = new JSpinner();
			spAmount.setBounds(113, 291, 69, 20);
			spAmount.setModel(new SpinnerListModel(new String[] {"5", "10", "50", "100", "500", "1000"}));
		}
		return spAmount;
	}
	
	private JButton getBtnNoMoreBets() {
		if (btnNoMoreBets == null) {
			btnNoMoreBets = new JButton("No more bets!");
			btnNoMoreBets.setBounds(203, 318, 123, 23);
			btnNoMoreBets.setEnabled(false);
			btnNoMoreBets.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					number=game.turnTheWheel();
					tfNumber.setText(String.valueOf(number.getValue()));
					tfNumber.setForeground(number.getColor());
					
					
					
					btnNoMoreBets.setEnabled(false);
					representMoney();
					txRedBlack.setText(game.getRedBlackStatistics().toString());
					txEvenOdd.setText(game.getEvenOddStatistics().toString());
					
				}
			});
		}
		return btnNoMoreBets;
	}
	private JTextField getTfNumber() {
		if (tfNumber == null) {
			tfNumber = new JTextField();
			tfNumber.setBounds(182, 37, 86, 20);
			tfNumber.setEditable(false);
			tfNumber.setColumns(10);
		}
		return tfNumber;
	}
	private JTextPane getTxEvenOdd() {
		if (txEvenOdd == null) {
			txEvenOdd = new JTextPane();
			txEvenOdd.setBounds(419, 278, 86, 48);
		}
		return txEvenOdd;
	}
	private JTextPane getTxRedBlack() {
		if (txRedBlack == null) {
			txRedBlack = new JTextPane();
			txRedBlack.setBounds(532, 278, 86, 48);
		}
		return txRedBlack;
	}
	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(297, 75, 280, 140);
			scrollPane.setViewportView(getTbBets());
		}
		return scrollPane;
	}
	private JTable getTbBets() {
		if (tbBets == null) {
			tbBets = new JTable(game.getPlayer().getBetsTable());
		}
		return tbBets;
	}
}
