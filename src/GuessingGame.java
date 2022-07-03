import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GuessingGame extends JFrame {
	private JTextField txtGuess;
	private JLabel lblOutput;
	private int theNumber;
	public void checkGuess() {
		String guessText = txtGuess.getText();
		String message = "";
		try {
			int guess = Integer.parseInt(guessText);
			if (guess < theNumber)
				message = guess + " меньше загаданного числа. Попробуйте еще раз.";
			else if (guess > theNumber)
				message = guess + " больше загаданного числа. Попробуйте еще раз.";
			else {
				message = guess + " - это верно. Вы выиграли! Давай сыграем еще раз!";
				newGame();
			}
		} catch (Exception e) {
			message = "Введите целое число от 1 до 100.";
		} finally {
			lblOutput.setText(message);
			txtGuess.requestFocus();
			txtGuess.selectAll();
		}
	}
	public void newGame() {
		theNumber = (int) (Math.random() * 100 + 1);
	}
	public GuessingGame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("\u0418\u043B\u044C\u044F \u041A\u0443\u0440\u0431\u0430\u0442\u043E\u0432 \u0411\u043E\u043B\u044C\u0448\u0435-\u041C\u0435\u043D\u044C\u0448\u0435 \u0423\u0433\u0430\u0434\u0430\u0439 \u0447\u0438\u0441\u043B\u043E");
		getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("\u0418\u043B\u044C\u044F \u041A\u0443\u0440\u0431\u0430\u0442\u043E\u0432 \u0411\u043E\u043B\u044C\u0448\u0435-\u041C\u0435\u043D\u044C\u0448\u0435 \u0423\u0433\u0430\u0434\u0430\u0439 \u0447\u0438\u0441\u043B\u043E");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 37, 414, 19);
		getContentPane().add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("\u0412\u0432\u0435\u0434\u0438\u0442\u0435 \u0447\u0438\u0441\u043B\u043E \u043E\u0442 1 \u0434\u043E 100:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1.setBounds(20, 93, 228, 20);
		getContentPane().add(lblNewLabel_1);

		txtGuess = new JTextField();
		txtGuess.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				checkGuess();
			}
		});
		txtGuess.setHorizontalAlignment(SwingConstants.CENTER);
		txtGuess.setBounds(258, 94, 86, 20);
		getContentPane().add(txtGuess);
		txtGuess.setColumns(10);

		JButton btnGuess = new JButton("\u0423\u0433\u0430\u0434\u0430\u0442\u044C!");
		btnGuess.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				checkGuess();
			}
		});
		btnGuess.setBounds(172, 150, 89, 23);
		getContentPane().add(btnGuess);

		lblOutput = new JLabel("\u0412\u0432\u0435\u0434\u0438\u0442\u0435 \u0447\u0438\u0441\u043B\u043E \u0432\u044B\u0448\u0435 \u0438 \u043D\u0430\u0436\u043C\u0438\u0442\u0435 \u0423\u0433\u0430\u0434\u0430\u0442\u044C!");
		lblOutput.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblOutput.setHorizontalAlignment(SwingConstants.CENTER);
		lblOutput.setBounds(10, 210, 414, 14);
		getContentPane().add(lblOutput);
	}

	public static void main(String[] args) {
		GuessingGame theGame = new GuessingGame();
		theGame.newGame();
		theGame.setSize(new Dimension(450,300));
		theGame.setVisible(true);
	}
}
