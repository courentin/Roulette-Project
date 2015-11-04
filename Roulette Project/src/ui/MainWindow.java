package ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

import logic.Game;
import logic.typeOfBets.TypeOfBet;

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
import java.awt.event.ActionEvent;

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
					String betSelected = String.valueOf(cbTypeOfBet.getSelectedItem());
					showBetOptions(betSelected);
				}
			});
			cbTypeOfBet.setModel(new DefaultComboBoxModel<TypeOfBet>(game.getBetsAvailable()));
			cbTypeOfBet.setBounds(26, 200, 106, 20);
		}
		return cbTypeOfBet;
	}
	protected void showBetOptions(String betSelected) {		
			showCbAux(betSelected);			
		
	}
	private void showCbAux(String betSelected) {
			if(betSelected.equals("Column")){
				String[]cbAuxColumnsArray={"Column 0","Column 1","Column 2"};
				cbAuxTypeOfBet.setModel(new DefaultComboBoxModel<String>(cbAuxColumnsArray));
				cbAuxTypeOfBet.setVisible(true);	
			}
			else if(betSelected.equals("CornerBet")){
				//thinking about it
				
			}
			else if(betSelected.equals("EvenOdd")){
				String[]cbAuxEvenOddArray={"Even","Odd"};
				cbAuxTypeOfBet.setModel(new DefaultComboBoxModel<String>(cbAuxEvenOddArray));
				cbAuxTypeOfBet.setVisible(true);				
			}
			else if(betSelected.equals("RedBlack")){
				//String cbAuxRedBlackArray={""
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
}
