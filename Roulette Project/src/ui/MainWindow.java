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
import javax.swing.JTabbedPane;
import java.awt.Font;
import javax.swing.KeyStroke;
import java.awt.event.InputEvent;

public class MainWindow extends JFrame {

	private JPanel contentPane;
	private JMenuBar menuBar;
	private JMenu mnRoulette;
	private JMenuItem mntmNewGame;
	private JMenuItem mntmNewPlayer;
	private JMenuItem mntmExit;
	private JMenu mnHelp;
	private JMenuItem mntmAbout;
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
	private JPanel panel;
	private JPanel panel_1;
	private JLabel lblMoney;
	private JLabel lblNewLabel;
	private JLabel lblTypeOfBet;
	private JLabel lblOption;
	private JLabel lblAmount;
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
		setTitle("Roulette");
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(MainWindow.class.getResource("/img/icon175x175.png")));

		game=new Game("DefaultPlayer", Color.BLUE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 795, 437);
		setJMenuBar(getMenuBar_1());
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 51, 153));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getLblPlayerName());
		contentPane.add(getTfNumber());
		contentPane.add(getScrollPane());
		contentPane.add(getPanel());
		contentPane.add(getPanel_1());
		contentPane.add(getLblMoney());
		contentPane.add(getLblNewLabel());
		//contentPane.add(getTbBet);
		//contentPane.add(getTbBets());

		representStatus();
	}

	private void newGame() {
		game=new Game("DefaultPlayer", Color.BLUE);
		txEvenOdd.setText("");
		txRedBlack.setText("");
		tfNumber.setText("");
		representStatus();
		cbTypeOfBet.setSelectedIndex(0);
		cbAuxTypeOfBet.setSelectedIndex(0);

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
		lblMoney.setText(String.valueOf(game.getPlayer().getMoney())+"\u20ac");

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
			mntmNewGame.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, InputEvent.CTRL_MASK));
			mntmNewGame.setMnemonic(KeyEvent.VK_N);
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
			mntmExit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F4, InputEvent.ALT_MASK));
			mntmExit.setMnemonic(KeyEvent.VK_E);
			mntmExit.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					System.exit(0);
				}
			});
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
			mntmAbout.setMnemonic(KeyEvent.VK_O);
			mntmAbout.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F1, 0));
			mntmAbout.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					JOptionPane.showMessageDialog(contentPane, "Collaboration Project EII Oviedo - Université de Valenciennes", "About Roulette",JOptionPane.INFORMATION_MESSAGE);

				}
			});
		}
		return mntmAbout;
	}
	private JLabel getLblPlayerName() {
		if (lblPlayerName == null) {
			lblPlayerName = new JLabel(game.getPlayer().getName());
			lblPlayerName.setFont(new Font("Tahoma", Font.PLAIN, 18));
			lblPlayerName.setIcon(new ImageIcon(MainWindow.class.getResource("/img/icon_gameMode_single.png")));
			lblPlayerName.setBounds(460, 11, 184, 51);
			lblPlayerName.setHorizontalAlignment(SwingConstants.CENTER);
			lblPlayerName.setForeground(game.getPlayer().getColor());
		}
		return lblPlayerName;
	}
	private JComboBox getCbTypeOfBet() {
		if (cbTypeOfBet == null) {
			cbTypeOfBet = new JComboBox<TypeOfBet>();
			cbTypeOfBet.setBounds(114, 12, 87, 20);
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
		else if(betSelected instanceof FailedPassed){
			String[]cbAuxFailedPassedArray={"Failed (1-18)","Passed (19-36)"};
			cbAuxTypeOfBet.setModel(new DefaultComboBoxModel<String>(cbAuxFailedPassedArray));
			cbAuxTypeOfBet.setVisible(true);
		}
		else if(betSelected instanceof TwoDozen){
			String[]cbAuxTwoDozenArray={"}"};///PENSAR COMO ELEGIR 2 COLUMNAS
		}

		else if(betSelected instanceof Dozen){
			//thinkaboutir

		}



	}

	private JComboBox getCbAuxTypeOfBet() {
		if (cbAuxTypeOfBet == null) {
			String[]cbAuxColumns={"Column 0","Column 1","Column 2"};
			cbAuxTypeOfBet = new JComboBox(cbAuxColumns);
			cbAuxTypeOfBet.setBounds(114, 54, 87, 20);
			cbAuxTypeOfBet.setVisible(true);
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
			btnBet.setMnemonic(KeyEvent.VK_B);
			btnBet.setBounds(33, 131, 89, 23);
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
					else if(betSelected instanceof FailedPassed){
						System.err.println("ERR");
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
			spAmount.setBounds(114, 100, 87, 20);
			spAmount.setModel(new SpinnerListModel(new String[] {"5", "10", "50", "100", "500", "1000"}));
		}
		return spAmount;
	}

	private JButton getBtnNoMoreBets() {
		if (btnNoMoreBets == null) {
			btnNoMoreBets = new JButton("No more bets!");
			btnNoMoreBets.setMnemonic(KeyEvent.VK_N);
			btnNoMoreBets.setBounds(132, 131, 123, 23);
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
			tfNumber.setHorizontalAlignment(SwingConstants.CENTER);
			tfNumber.setFont(new Font("Tahoma", Font.BOLD, 30));
			tfNumber.setBackground(new Color(153, 204, 255));
			tfNumber.setBounds(93, 49, 125, 71);
			tfNumber.setEditable(false);
			tfNumber.setColumns(10);
		}
		return tfNumber;
	}
	private JTextPane getTxEvenOdd() {
		if (txEvenOdd == null) {
			txEvenOdd = new JTextPane();
			txEvenOdd.setBounds(243, 50, 108, 63);
		}
		return txEvenOdd;
	}
	private JTextPane getTxRedBlack() {
		if (txRedBlack == null) {
			txRedBlack = new JTextPane();
			txRedBlack.setBounds(10, 50, 108, 63);
		}
		return txRedBlack;
	}
	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(349, 78, 375, 140);
			scrollPane.setViewportView(getTbBets());
		}
		return scrollPane;
	}
	private JTable getTbBets() {
		if (tbBets == null) {
			tbBets = new JTable(game.getPlayer().getBetsTable());
			tbBets.setEnabled(false);
			
		}
		return tbBets;
	}
	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setBackground(new Color(102, 153, 204));
			panel.setBounds(10, 200, 265, 165);
			panel.setLayout(null);
			panel.add(getCbTypeOfBet());
			panel.add(getBtnBet());
			panel.add(getBtnNoMoreBets());
			panel.add(getSpAmount());
			panel.add(getCbAuxTypeOfBet());
			panel.add(getLblTypeOfBet());
			panel.add(getLblOption());
			panel.add(getLblAmount());
		}
		return panel;
	}
	private JPanel getPanel_1() {
		if (panel_1 == null) {
			panel_1 = new JPanel();
			panel_1.setBounds(349, 229, 375, 136);
			panel_1.setLayout(null);
			panel_1.add(getTxRedBlack());
			panel_1.add(getTxEvenOdd());
		}
		return panel_1;
	}
	private JLabel getLblMoney() {
		if (lblMoney == null) {
			lblMoney = new JLabel("");
			lblMoney.setFont(new Font("Tahoma", Font.PLAIN, 18));
			lblMoney.setIcon(new ImageIcon(MainWindow.class.getResource("/img/image-2015-11-06 (1).png")));
			lblMoney.setBounds(349, 25, 120, 33);
		}
		return lblMoney;
	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("Winner Number");
			lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 25));
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel.setBounds(30, 12, 265, 27);
		}
		return lblNewLabel;
	}
	private JLabel getLblTypeOfBet() {
		if (lblTypeOfBet == null) {
			lblTypeOfBet = new JLabel("Type of Bet:");
			lblTypeOfBet.setLabelFor(getCbTypeOfBet());
			lblTypeOfBet.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblTypeOfBet.setDisplayedMnemonic('T');
			lblTypeOfBet.setDisplayedMnemonic(KeyEvent.VK_T);
			lblTypeOfBet.setBounds(10, 14, 94, 18);
		}
		return lblTypeOfBet;
	}
	private JLabel getLblOption() {
		if (lblOption == null) {
			lblOption = new JLabel("Option:");
			lblOption.setLabelFor(getCbAuxTypeOfBet());
			lblOption.setDisplayedMnemonic(KeyEvent.VK_O);
			lblOption.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblOption.setBounds(10, 55, 56, 19);
		}
		return lblOption;
	}
	private JLabel getLblAmount() {
		if (lblAmount == null) {
			lblAmount = new JLabel("Amount:");
			lblAmount.setLabelFor(getSpAmount());
			lblAmount.setDisplayedMnemonic('A');
			lblAmount.setDisplayedMnemonic(KeyEvent.VK_A);
			lblAmount.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblAmount.setBounds(10, 103, 78, 14);
		}
		return lblAmount;
	}
}
