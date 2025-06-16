package br.dev.rebeca.tarefas.ui;

import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import br.dev.rebeca.tarefas.dao.FuncionarioDAO;
import br.dev.rebeca.tarefas.model.Funcionario;

public class FrameTarefa {

	JLabel lblTitulo;
	JTextField txtTitulo;
	JLabel lblDescricao;
	JTextField txtDescricao;
	JLabel lblDataInicial;
	JTextField txtDataInicial;
	JLabel lblPrazo;
	JTextField txtPrazo;
	JLabel lblConclusao;
	JTextField txtConclusao;
	JLabel lblStatus;
	JComboBox<String> boxStatus;
	JLabel lblFuncionario;
	JComboBox<String> boxFuncionario;
	JButton btnSalvar;
	JButton btnSair;

	private Font fontTitulo = new Font("Arial", Font.BOLD, 14);

	public FrameTarefa() {
		criarTela();
	}

	private void criarTela() {
		JFrame tela = new JFrame();
		tela.setTitle("Cadastro de Tarefas");
		tela.setSize(400, 600);
		tela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		tela.setResizable(false);
		tela.setLayout(null);
		tela.setLocationRelativeTo(null);

		Container painel = tela.getContentPane();

		lblTitulo = new JLabel("Título:");
		lblTitulo.setBounds(20, 10, 50, 50);
		txtTitulo = new JTextField();
		txtTitulo.setBounds(20, 50, 250, 35);

		lblDescricao = new JLabel("Descrição:");
		lblDescricao.setBounds(20, 80, 150, 50);
		txtDescricao = new JTextField();
		txtDescricao.setBounds(20, 120, 250, 35);

		lblDataInicial = new JLabel("Data Inicial:");
		lblDataInicial.setBounds(20, 150, 150, 50);
		txtDataInicial = new JTextField();
		txtDataInicial.setBounds(20, 190, 250, 35);

		lblPrazo = new JLabel("Prazo:");
		lblPrazo.setBounds(20, 220, 150, 50);
		txtPrazo = new JTextField();
		txtPrazo.setBounds(20, 260, 250, 35);

		lblConclusao = new JLabel("Data Conclusão:");
		lblConclusao.setBounds(20, 290, 150, 50);
		txtConclusao = new JTextField();
		txtConclusao.setBounds(20, 330, 250, 35);

		lblStatus = new JLabel("Status:");
		lblStatus.setBounds(20, 360, 150, 50);
		boxStatus = new JComboBox<String>();
		boxStatus.setBounds(20, 400, 150, 30);
		boxStatus.addItem("NÃO_INICIADA");
		boxStatus.addItem("EM_ANDAMENTO");
		boxStatus.addItem("FINALIZADA");
		boxStatus.addItem("EM_ATRASO");

		lblFuncionario = new JLabel("Responsável:");
		lblFuncionario.setBounds(180, 360, 150, 50);
		boxFuncionario = new JComboBox<String>();
		boxFuncionario.setBounds(180, 400, 150, 30);
		FuncionarioDAO dao = new FuncionarioDAO(null);
		List<Funcionario> funcionarios = dao.showEmployees();
		for (Funcionario f : funcionarios) {
			boxFuncionario.addItem(f.getNome());
		}

		btnSalvar = new JButton("Salvar");
		btnSalvar.setBounds(20, 470, 130, 35);
		
		btnSair = new JButton("Sair");
		btnSair.setBounds(160, 470, 130, 35);
		btnSair.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int resposta = JOptionPane.showConfirmDialog(tela, "Confirma a saída do sistema?", "Sair do Sistema",
						JOptionPane.YES_NO_OPTION);

				if (resposta == 0) {
					tela.dispose();
				}
			}
		});

		painel.add(lblTitulo);
		painel.add(txtTitulo);
		painel.add(lblDescricao);
		painel.add(txtDescricao);
		painel.add(lblDataInicial);
		painel.add(txtDataInicial);
		painel.add(lblPrazo);
		painel.add(txtPrazo);
		painel.add(lblConclusao);
		painel.add(txtConclusao);
		painel.add(lblStatus);
		painel.add(boxStatus);
		painel.add(lblFuncionario);
		painel.add(boxFuncionario);
		painel.add(btnSalvar);
		painel.add(btnSair);

		tela.setVisible(true);
	}

}
