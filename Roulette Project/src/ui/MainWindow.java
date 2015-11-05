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
		
		game=new Game("DefaultPlayer", Color.BLUE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 676, 437);
		setJMenuBar(getMenuBar_1());
		contentPane = new JPanel();
		contentPane.setBackground(new Color(51, 153, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(21)
					.addComponent(getCbTypeOfBet(), GroupLayout.PREFERRED_SIZE, 106, GroupLayout.PREFERRED_SIZE)
					.addGap(35)
					.addComponent(getCbAuxTypeOfBet(), GroupLayout.PREFERRED_SIZE, 114, GroupLayout.PREFERRED_SIZE)
					.addGap(342))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(58)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(55)
							.addComponent(getSpAmount(), GroupLayout.PREFERRED_SIZE, 69, GroupLayout.PREFERRED_SIZE))
						.addComponent(getBtnBet(), GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE))
					.addGap(21)
					.addComponent(getBtnNoMoreBets(), GroupLayout.PREFERRED_SIZE, 123, GroupLayout.PREFERRED_SIZE)
					.addGap(93)
					.addComponent(getTxEvenOdd(), GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE)
					.addGap(27)
					.addComponent(getTxRedBlack(), GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(275)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(286)
							.addComponent(getLblPlayerName(), GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(124)
							.addComponent(getTfNumber(), GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(71)
							.addComponent(getTfMoney(), GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addContainerGap(360, Short.MAX_VALUE)
					.addComponent(getScrollPane(), GroupLayout.PREFERRED_SIZE, 280, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(7)
					.addComponent(getLblPlayerName())
					.addGap(11)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(getTfNumber(), GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(getTfMoney(), GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(88)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(107)
									.addComponent(getCbTypeOfBet(), GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(107)
									.addComponent(getCbAuxTypeOfBet(), GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(55)
							.addComponent(getScrollPane(), GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(13)
							.addComponent(getSpAmount(), GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(7)
							.addComponent(getBtnBet()))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(40)
							.addComponent(getBtnNoMoreBets()))
						.addComponent(getTxEvenOdd(), GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
						.addComponent(getTxRedBlack(), GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)))
		);
		contentPane.setLayout(gl_contentPane);
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
			tfMoney.setEditable(false);
			tfMoney.setHorizontalAlignment(SwingConstants.CENTER);
			tfMoney.setColumns(10);
		}
		return tfMoney;
	}
	private JLabel getLblPlayerName() {
		if (lblPlayerName == null) {
			lblPlayerName = new JLabel(game.getPlayer().getName());
			lblPlayerName.setHorizontalAlignment(SwingConstants.CENTER);
			lblPlayerName.setForeground(game.getPlayer().getColor());
		}
		return lblPlayerName;
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
			spAmount.setModel(new SpinnerListModel(new String[] {"5", "10", "50", "100", "500", "1000"}));
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
			tfNumber.setEditable(false);
			tfNumber.setColumns(10);
		}
		return tfNumber;
	}
	private JTextPane getTxEvenOdd() {
		if (txEvenOdd == null) {
			txEvenOdd = new JTextPane();
		}
		return txEvenOdd;
	}
	private JTextPane getTxRedBlack() {
		if (txRedBlack == null) {
			txRedBlack = new JTextPane();
		}
		return txRedBlack;
	}
	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
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
