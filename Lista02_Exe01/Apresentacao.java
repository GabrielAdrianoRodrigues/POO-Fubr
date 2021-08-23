import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class Apresentacao {

	private JFrame frame;
	private JTextField tfNome;
	private JTextField tfCPF;
	private JTextField tfUf;
	private JTextField tfRendaAnual;
	private JTextField tfValor;
	private Contribuinte[] contribs = new Contribuinte[100];
	private int indice;
	

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
		frame.setBounds(100, 100, 575, 396);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		tfNome = new JTextField();
		tfNome.setBounds(197, 37, 302, 20);
		frame.getContentPane().add(tfNome);
		tfNome.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Nome do contribuente:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(25, 31, 162, 28);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("CPF:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(25, 70, 40, 28);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Estado (UF):");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(25, 109, 113, 28);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Renda Anual: R$");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_3.setBounds(25, 148, 120, 28);
		frame.getContentPane().add(lblNewLabel_3);
		
		tfCPF = new JTextField();
		tfCPF.setBounds(197, 76, 302, 20);
		frame.getContentPane().add(tfCPF);
		tfCPF.setColumns(10);
		
		tfUf = new JTextField();
		tfUf.setBounds(197, 115, 302, 20);
		frame.getContentPane().add(tfUf);
		tfUf.setColumns(10);
		
		tfRendaAnual = new JTextField();
		tfRendaAnual.setBounds(197, 154, 302, 20);
		frame.getContentPane().add(tfRendaAnual);
		tfRendaAnual.setColumns(10);
		
		JButton btnCalcular = new JButton("Calcular");
		btnCalcular.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnCalcular.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Contribuinte c = new Contribuinte();
				c.setNome(tfNome.getText());
				c.setCpf(tfCPF.getText());
				c.setUf(tfUf.getText());
				c.setRendaAnual(Double.parseDouble(tfRendaAnual.getText()));
				double imposto = c.getImpostoAPagar();
				JOptionPane.showMessageDialog(null, "Contribuente pagará R$ "+imposto);
				contribs[indice] = c;
				indice++;
			}
		});
		btnCalcular.setBounds(364, 185, 135, 34);
		frame.getContentPane().add(btnCalcular);
		
		JLabel lbValorConsulta = new JLabel("Valor do imposto \u00E0 consultar R$:");
		lbValorConsulta.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbValorConsulta.setBounds(25, 239, 227, 28);
		frame.getContentPane().add(lbValorConsulta);
		
		JButton btnConsulta = new JButton("Consultar");
		btnConsulta.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnConsulta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double valor = Double.parseDouble(tfValor.getText());
				for (int i = 0; i < indice; i++) {
					Contribuinte c = contribs[i];
					if (valor <= c.getImpostoAPagar()) {
						String msg = "Contribuinte: " + c.getNome() 
									 + "\nCPF: " + c.getCpf() 
									 + "\nUF: " + c.getUf()
									 + "\nRenda Anual: " + c.getRendaAnual() 
									 +"\nImposto a pagar: " + c.getImpostoAPagar();
						JOptionPane.showMessageDialog(null, msg);
					}
				}
			}
		});
		
		btnConsulta.setBounds(364, 285, 135, 34);
		frame.getContentPane().add(btnConsulta);
		
		tfValor = new JTextField();
		tfValor.setBounds(251, 245, 248, 20);
		frame.getContentPane().add(tfValor);
		tfValor.setColumns(10);
	}
}
