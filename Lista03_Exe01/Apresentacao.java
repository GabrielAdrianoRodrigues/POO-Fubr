import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.awt.event.ActionEvent;

public class Apresentacao {

	private JFrame frame;
	private JTextField tfNome;
	private JTextField tfCPF;
	private JTextField tfUF;
	private JTextField tfRendaAnual;
	private JTextField tfValor;
	private HashMap<String, Contribuinte> contribs = new HashMap<>();
	private int indice;
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

		tfNome = new JTextField();
		tfNome.setBounds(135, 8, 243, 20);
		frame.getContentPane().add(tfNome);
		tfNome.setColumns(10);

		JLabel lblNewLabel = new JLabel("Nome do contribuinte:");
		lblNewLabel.setBounds(10, 11, 127, 14);
		frame.getContentPane().add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("CPF:");
		lblNewLabel_1.setBounds(10, 36, 48, 14);
		frame.getContentPane().add(lblNewLabel_1);

		tfCPF = new JTextField();
		tfCPF.setBounds(135, 33, 96, 20);
		frame.getContentPane().add(tfCPF);
		tfCPF.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("Estado (UF):");
		lblNewLabel_2.setBounds(10, 64, 85, 14);
		frame.getContentPane().add(lblNewLabel_2);

		tfUF = new JTextField();
		tfUF.setBounds(135, 61, 36, 20);
		frame.getContentPane().add(tfUF);
		tfUF.setColumns(10);

		JLabel lblNewLabel_3 = new JLabel("Renda anual: R$");
		lblNewLabel_3.setBounds(10, 95, 110, 14);
		frame.getContentPane().add(lblNewLabel_3);

		tfRendaAnual = new JTextField();
		tfRendaAnual.setBounds(135, 92, 96, 20);
		frame.getContentPane().add(tfRendaAnual);
		tfRendaAnual.setColumns(10);

		JButton btnCalcular = new JButton("Calcular");
		btnCalcular.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (contribs.containsKey(tfCPF.getText())) {
					JOptionPane.showMessageDialog(null, "CPF já existente");
				} else {
					Contribuinte c = new Contribuinte();
					c.setNome(tfNome.getText());
					c.setCpf(tfCPF.getText());
					c.setUf(tfUF.getText());
					c.setRendaAnual(Double.parseDouble(tfRendaAnual.getText()));
					double imposto = c.getImpostoAPagar();
					JOptionPane.showMessageDialog(null, "Contribuinte pagará R$" + imposto);
					contribs.put(c.getCpf(), c);
				}
			}
		});
		btnCalcular.setBounds(289, 91, 89, 23);
		frame.getContentPane().add(btnCalcular);

		JLabel lblNewLabel_4 = new JLabel("Valor do imposto a consultar: R$");
		lblNewLabel_4.setBounds(10, 215, 179, 14);
		frame.getContentPane().add(lblNewLabel_4);

		tfValor = new JTextField();
		tfValor.setBounds(176, 212, 96, 20);
		frame.getContentPane().add(tfValor);
		tfValor.setColumns(10);

		JButton btnConsultar = new JButton("Consultar");
		btnConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double valor = Double.parseDouble(tfValor.getText());
				for (Contribuinte c:contribs.values()) {
					if (valor <= c.getImpostoAPagar()) {
						String msg = "Contribuinte " + c.getNome() + "\nCPF:" + c.getCpf() + "\nUF:" + c.getUf()
								+ "\nRenda anual:" + c.getRendaAnual() + "\nImposto a pagar:" + c.getImpostoAPagar();
						JOptionPane.showMessageDialog(null, msg);
					}
				}
			}
		});
		btnConsultar.setBounds(289, 211, 89, 23);
		frame.getContentPane().add(btnConsultar);

		JLabel lblNewLabel_5 = new JLabel("CPF a consultar:");
		lblNewLabel_5.setBounds(10, 240, 110, 14);
		frame.getContentPane().add(lblNewLabel_5);

		textField = new JTextField();
		textField.setBounds(130, 237, 96, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);

		JButton btnNewButton = new JButton("Consultar CPF");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String msg;
				String cpfConsultado = textField.getText();
				Contribuinte c = contribs.get(cpfConsultado);
				if (c != null) {
					msg = "Contribuinte " + c.getNome() + "\nCPF:" + c.getCpf() + "\nUF:" + c.getUf()
							+ "\nRenda anual:" + c.getRendaAnual() + "\nImposto a pagar:" + c.getImpostoAPagar();
				}
				else {
					msg = "CPF não localizado:"+cpfConsultado;
				}
				JOptionPane.showMessageDialog(null, msg);
			}
		});
		btnNewButton.setBounds(239, 236, 121, 23);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnEstados = new JButton("% dos estados");
		btnEstados.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double totalSC, totalRS, totalPR, totalGeral;
				totalSC = totalRS = totalPR = totalGeral = 0;
				for (Contribuinte c: contribs.values()) {
					double imposto = c.getImpostoAPagar();
					totalGeral += imposto;
					if (c.getUf().equals("SC")) {
						totalSC += imposto;
					}
					else if(c.getUf().equals("RS")) {
						totalRS += imposto;
					}
					else if(c.getUf().equals("PR")) {
						totalPR += imposto;
					}
				}
				String msg = "Participação percentual de cada estado\n";
				msg += "\nSC = "+totalSC+" = "+(totalSC/totalGeral*100)+" %";
				msg += "\nPR = "+totalPR+" = "+(totalPR/totalGeral*100)+" %";
				msg += "\nRS = "+totalRS+" = "+(totalRS/totalGeral*100)+" %";
				msg += "\n Total Geral = "+totalGeral;
				JOptionPane.showMessageDialog(null,msg);
			}
		});
		btnEstados.setBounds(257, 148, 121, 23);
		frame.getContentPane().add(btnEstados);
	}
}