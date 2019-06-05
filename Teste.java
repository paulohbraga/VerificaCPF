package VerificaCPF;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.Color;

public class Teste extends JFrame {

	private JPanel contentPane;
	private JTextField txtDigiteOCpf;
	private JLabel lblVerificadorDeCpf;
	private JLabel lblIsvalid;
	private JTextField lblCPF;
	private JButton btnLimpar;
	private VerificaCPF verificaCPF = new VerificaCPF();
	private GeradorCPF geradorCPF = new GeradorCPF();
	
	/*
	 * My method actions
	 */
	private void checacpf(String cpf) {
		if (cpf.equals("")) {
			System.out.println(cpf.length());
			this.lblIsvalid.setText("Digite um CPF!");
		}else if (cpf.length() < 10) {
			this.lblIsvalid.setText("CPF incompleto");
		} 
		verificaCPF.setCpf(cpf);
		if (verificaCPF.cpfIsValid()){
			this.lblIsvalid.setText("Válido");			
		}else {
			this.lblIsvalid.setText("Inválido");
		}
		
	}
	
	private void gerarcpf() {
		String newCPF = geradorCPF.gerarcpf();
		this.lblCPF.setText(newCPF);
	}
	
	private void limpar() {
		this.txtDigiteOCpf.setText("");
		this.lblIsvalid.setText("");			

	}
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Teste frame = new Teste();
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
	public Teste() {
		setResizable(false);
		setTitle("Verificador de CPF");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 528, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		txtDigiteOCpf = new JTextField();
		txtDigiteOCpf.setForeground(Color.BLUE);
		txtDigiteOCpf.setHorizontalAlignment(SwingConstants.CENTER);
		txtDigiteOCpf.setBounds(166, 52, 177, 26);
		panel.add(txtDigiteOCpf);
		txtDigiteOCpf.setColumns(10);
		
		
		JButton btnNewButton = new JButton("Verificar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String cpf = txtDigiteOCpf.getText();
				checacpf(cpf);
			}


		});
		
		btnNewButton.setBounds(138, 104, 117, 29);
		panel.add(btnNewButton);
		
		lblVerificadorDeCpf = new JLabel("Verificador de CPF");
		lblVerificadorDeCpf.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		lblVerificadorDeCpf.setBounds(180, 6, 144, 20);
		panel.add(lblVerificadorDeCpf);
		
		lblIsvalid = new JLabel("");
		lblIsvalid.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
		lblIsvalid.setForeground(new Color(0, 0, 139));
		lblIsvalid.setHorizontalAlignment(SwingConstants.CENTER);
		lblIsvalid.setBounds(355, 52, 132, 16);
		panel.add(lblIsvalid);
		
		JButton btnGerarCpf = new JButton("Gerar CPF");
		btnGerarCpf.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gerarcpf();
			}
		});
		btnGerarCpf.setBounds(282, 175, 117, 29);
		panel.add(btnGerarCpf);
		
		lblCPF = new JTextField("CPF");
		lblCPF.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
		lblCPF.setForeground(Color.RED);
		lblCPF.setHorizontalAlignment(SwingConstants.CENTER);
		lblCPF.setBounds(93, 180, 177, 20);
		
		
		panel.add(lblCPF);
		
		btnLimpar = new JButton("Limpar");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpar();
			}
		});
		btnLimpar.setBounds(256, 104, 117, 29);
		panel.add(btnLimpar);
	}
}
