import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;

public class Apresentacao {

	private JFrame frame;
	private JTextField textField;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Apresentacao window = new Apresentacao();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Apresentacao() {
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Digite uma frase:");
		lblNewLabel.setBounds(10, 31, 110, 14);
		frame.getContentPane().add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(130, 28, 261, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 94, 381, 138);
		frame.getContentPane().add(scrollPane);
		
		JTextArea textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		textArea.setEditable(false);
		
		JButton btnSeparar = new JButton("Separar");
		btnSeparar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Frase f = new Frase(textField.getText());
				String[] vetorStr = f.separar();
				String palavra;
				textArea.setText("Frase a ser separada: "+f.getTexto());
				for (int i=0; i < vetorStr.length; i++) {
					palavra = vetorStr[i];
					textArea.append("\n"+palavra+" - "+palavra.length());
				}
			}
		});
		btnSeparar.setBounds(302, 59, 89, 23);
		frame.getContentPane().add(btnSeparar);
		

	}
}