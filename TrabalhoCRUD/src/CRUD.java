import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import bd.dao.Clinicas;
import bd.dbo.Clinica;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.FlowLayout;
import javax.swing.JButton;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.io.IOException;

public class CRUD extends JFrame {

	private JPanel contentPane;
	private JTextPane txtCod;
	private JTextPane txtNome;
	private JTextPane txtCEP;
	private JTextPane txtNumero;
	private JTextPane txtComplemento;
	
	private JTextPane txtEndereco;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CRUD frame = new CRUD();
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
	public CRUD() {
		setTitle("CRUD");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 510, 308);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JLabel label = new JLabel("CRUD - CLIN\u00CDCAS");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Gungsuh", Font.BOLD, 32));
		label.setBackground(Color.DARK_GRAY);
		contentPane.add(label, BorderLayout.NORTH);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.DARK_GRAY);
		contentPane.add(panel, BorderLayout.SOUTH);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JPanel panel_1 = new JPanel();
		panel_1.setForeground(Color.WHITE);
		panel_1.setBackground(Color.DARK_GRAY);
		contentPane.add(panel_1, BorderLayout.CENTER);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[]{69, 350, 0};
		gbl_panel_1.rowHeights = new int[]{32, 32, 32, 32, 32, 0, 0};
		gbl_panel_1.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_panel_1.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		panel_1.setLayout(gbl_panel_1);
		
		JLabel label_1 = new JLabel("C\u00F3digo:");
		label_1.setForeground(Color.WHITE);
		GridBagConstraints gbc_label_1 = new GridBagConstraints();
		gbc_label_1.insets = new Insets(0, 0, 5, 5);
		gbc_label_1.gridx = 0;
		gbc_label_1.gridy = 0;
		panel_1.add(label_1, gbc_label_1);
		
		txtCod = new JTextPane();
		GridBagConstraints gbc_txtCod = new GridBagConstraints();
		gbc_txtCod.fill = GridBagConstraints.BOTH;
		gbc_txtCod.insets = new Insets(0, 0, 5, 0);
		gbc_txtCod.gridx = 1;
		gbc_txtCod.gridy = 0;
		panel_1.add(txtCod, gbc_txtCod);
		
		JLabel label_2 = new JLabel("Nome:");
		label_2.setForeground(Color.WHITE);
		GridBagConstraints gbc_label_2 = new GridBagConstraints();
		gbc_label_2.insets = new Insets(0, 0, 5, 5);
		gbc_label_2.gridx = 0;
		gbc_label_2.gridy = 1;
		panel_1.add(label_2, gbc_label_2);
		
		txtNome = new JTextPane();
		GridBagConstraints gbc_txtNome = new GridBagConstraints();
		gbc_txtNome.fill = GridBagConstraints.BOTH;
		gbc_txtNome.insets = new Insets(0, 0, 5, 0);
		gbc_txtNome.gridx = 1;
		gbc_txtNome.gridy = 1;
		panel_1.add(txtNome, gbc_txtNome);
		
		JLabel label_3 = new JLabel("CEP:");
		label_3.setForeground(Color.WHITE);
		GridBagConstraints gbc_label_3 = new GridBagConstraints();
		gbc_label_3.insets = new Insets(0, 0, 5, 5);
		gbc_label_3.gridx = 0;
		gbc_label_3.gridy = 2;
		panel_1.add(label_3, gbc_label_3);
		
		txtCEP = new JTextPane();
		txtCEP.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent arg0)  {
				try
				{
					if(!txtCEP.getText().equals(""))
					{
						exibirEndereco();
					}
				}
				catch(Exception erro)
				{
					JOptionPane.showMessageDialog(null, "CEP inválido!", "ERRO",JOptionPane.ERROR_MESSAGE);
					txtCEP.setText("");
					txtCEP.requestFocus();
				}
			}
		});
		GridBagConstraints gbc_txtCEP = new GridBagConstraints();
		gbc_txtCEP.fill = GridBagConstraints.BOTH;
		gbc_txtCEP.insets = new Insets(0, 0, 5, 0);
		gbc_txtCEP.gridx = 1;
		gbc_txtCEP.gridy = 2;
		panel_1.add(txtCEP, gbc_txtCEP);
		
		JLabel label_4 = new JLabel("N\u00FAmero:");
		label_4.setForeground(Color.WHITE);
		GridBagConstraints gbc_label_4 = new GridBagConstraints();
		gbc_label_4.insets = new Insets(0, 0, 5, 5);
		gbc_label_4.gridx = 0;
		gbc_label_4.gridy = 3;
		panel_1.add(label_4, gbc_label_4);
		
		txtNumero = new JTextPane();
		GridBagConstraints gbc_txtNumero = new GridBagConstraints();
		gbc_txtNumero.fill = GridBagConstraints.BOTH;
		gbc_txtNumero.insets = new Insets(0, 0, 5, 0);
		gbc_txtNumero.gridx = 1;
		gbc_txtNumero.gridy = 3;
		panel_1.add(txtNumero, gbc_txtNumero);
		
		JLabel label_5 = new JLabel("Complemento:");
		label_5.setForeground(Color.WHITE);
		GridBagConstraints gbc_label_5 = new GridBagConstraints();
		gbc_label_5.insets = new Insets(0, 0, 5, 5);
		gbc_label_5.gridx = 0;
		gbc_label_5.gridy = 4;
		panel_1.add(label_5, gbc_label_5);
		
		txtComplemento = new JTextPane();
		GridBagConstraints gbc_txtComplemento = new GridBagConstraints();
		gbc_txtComplemento.insets = new Insets(0, 0, 5, 0);
		gbc_txtComplemento.fill = GridBagConstraints.BOTH;
		gbc_txtComplemento.gridx = 1;
		gbc_txtComplemento.gridy = 4;
		panel_1.add(txtComplemento, gbc_txtComplemento);
		
		JLabel lblNewLabel = new JLabel("Endere\u00E7o:");
		lblNewLabel.setForeground(Color.WHITE);
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 5;
		panel_1.add(lblNewLabel, gbc_lblNewLabel);
		
		txtEndereco = new JTextPane();
		txtEndereco.setBackground(Color.LIGHT_GRAY);
		txtEndereco.setEditable(false);
		GridBagConstraints gbc_txtEndereco = new GridBagConstraints();
		gbc_txtEndereco.fill = GridBagConstraints.BOTH;
		gbc_txtEndereco.gridx = 1;
		gbc_txtEndereco.gridy = 5;
		
		panel_1.add(txtEndereco, gbc_txtEndereco);
		JButton btnLimparCampos = new JButton("Limpar");
		btnLimparCampos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				txtCod.setText("");
				txtNumero.setText("");
				txtEndereco.setText("");
				txtNome.setText("");
				txtCod.setText("");
				txtCEP.setText("");
				txtComplemento.setText("");
			}
		});
		panel.add(btnLimparCampos);
		
		JButton btnInserir = new JButton("Inserir");
		btnInserir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					if(txtCod.getText().equals("") || txtNome.getText().equals("") || txtNumero.getText().equals("")||txtCEP.getText().equals(""))
						JOptionPane.showMessageDialog(null, "Insira todos os dados corretamente", "Dados incompletos",JOptionPane.INFORMATION_MESSAGE);
					if(Clinicas.cadastrado(Integer.parseInt(txtCod.getText())))
						JOptionPane.showMessageDialog(null, "Não foi possível adicionar clínica, pois ela já existe", "Clinica existente",JOptionPane.INFORMATION_MESSAGE);
					else
						Clinicas.incluir(new Clinica(Integer.parseInt(txtCod.getText()), txtNome.getText(), Integer.parseInt(txtCEP.getText()), Integer.parseInt(txtNumero.getText()), txtComplemento.getText()));
						
						
				}
				catch(Exception erro)
				{
					erro.getMessage();
				}
			}
		});
		panel.add(btnInserir);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if(txtCod.getText().equals(""))
						JOptionPane.showMessageDialog(null, "Insira o código da clínica!", "Dados incompletos",JOptionPane.INFORMATION_MESSAGE);
					if(!Clinicas.cadastrado(Integer.parseInt(txtCod.getText())))
						JOptionPane.showMessageDialog(null, "Não foi possível encontrar encontrar clínica", "Clínica não existente", JOptionPane.WARNING_MESSAGE);
					else
					{ 
						 Clinica cli = Clinicas.getClinica(Integer.parseInt(txtCod.getText()));
						 btnLimparCampos.doClick();
						
						 txtCod.setText(cli.getCodClinica() + "");
						 txtCEP.setText(cli.getCEP() + "");
						 txtComplemento.setText(cli.getComplemento());
						 txtNome.setText(cli.getNome());
						 txtNumero.setText(cli.getNumero() + "");
						 exibirEndereco();
					}
						
					
				}
				catch(Exception erro)
				{
					erro.getMessage();
				}
				
			}
		});
		panel.add(btnBuscar);
		
		JButton btnAtualizar = new JButton("Atualizar");
		btnAtualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if(txtCod.getText().equals("") || txtNome.getText().equals("") || txtNumero.getText().equals("")||txtCEP.getText().equals(""))
						JOptionPane.showMessageDialog(null, "Insira todos os dados corretamente", "Dados incompletos",JOptionPane.INFORMATION_MESSAGE);
					else if(!Clinicas.cadastrado(Integer.parseInt(txtCod.getText())))
						JOptionPane.showMessageDialog(null, "Não foi possível atualizar clínica, pois ela não existe", "Clinica não existente",JOptionPane.INFORMATION_MESSAGE);
					else
						Clinicas.alterar(new Clinica(Integer.parseInt(txtCod.getText()), txtNome.getText(), Integer.parseInt(txtCEP.getText()), Integer.parseInt(txtNumero.getText()), txtComplemento.getText()));
				
					
						
				}
				catch(Exception erro)
				{
					erro.getMessage();
				}
			}
		});
		panel.add(btnAtualizar);
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if(txtCod.getText().equals(""))
						JOptionPane.showMessageDialog(null, "Insira o código da clínica!", "Dados incompletos",JOptionPane.INFORMATION_MESSAGE);
					if(!Clinicas.cadastrado(Integer.parseInt(txtCod.getText())))
							JOptionPane.showMessageDialog(null, "Não foi possível excluir a clínica, pois ela não existe", "Clinica não existente",JOptionPane.INFORMATION_MESSAGE);
					else
					{
						Clinicas.excluir(Integer.parseInt(txtCod.getText()));
						btnLimparCampos.doClick();
					}
						
					
						
				} 
				catch (Exception err) {
					err.getMessage();
				}
			}
		});
		panel.add(btnExcluir);
		
		
	}
	
	private void exibirEndereco()
	{
		Logradouro logradouro = (Logradouro)ClienteWS.getObjeto(Logradouro.class, "http://api.postmon.com.br/v1/cep/" + txtCEP.getText());
		txtEndereco.setText(logradouro.getLogradouro()+((logradouro.getComplemento() == null)? "": ", " + logradouro.getComplemento()) +", " + logradouro.getBairro() + " - " + logradouro.getCidade() + ", " + logradouro.getEstado());
	}
	

}
