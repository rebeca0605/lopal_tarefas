package br.dev.rebeca.tarefas.ui;

import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import br.dev.rebeca.tarefas.dao.FuncionarioDAO;
import br.dev.rebeca.tarefas.model.Funcionario;

public class FrameListaFuncionario {

	private JLabel lblTitulo;
	private JTable tableFuncionarios;
	private JScrollPane scrollFuncionarios;
	private JButton btnNovo;
	private JButton btnSair;

	private Font fontTitulo = new Font("Arial", Font.BOLD, 26);
	private Font fontBotao = new Font("Arial", Font.BOLD, 16);

	public FrameListaFuncionario() {
		criarTela();
	}

	private void criarTela() {

		JFrame tela = new JFrame();
		tela.setTitle("Lista de Funcionários");
		tela.setSize(600, 600);
		tela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		tela.setResizable(false);
		tela.setLayout(null);
		tela.setLocationRelativeTo(null);

		Container painel = tela.getContentPane();

		lblTitulo = new JLabel("Lista de Funcionários");
		lblTitulo.setBounds(10, 20, 500, 30);
		lblTitulo.setFont(fontTitulo);

		// Criação da Tabela
		String[] colunas = new String[3];
		colunas[0] = "Código";
		colunas[1] = "Nome";
		colunas[2] = "E-mail";

		// Obter lista de funcionarios
		FuncionarioDAO dao = new FuncionarioDAO(null);

		List<Funcionario> funcionarios = dao.showEmployees();

		Object[][] dados = new Object[funcionarios.size()][3];

		int linha = 0;
		for (Funcionario f : funcionarios) {
			dados[linha][0] = f.getCodigo();
			dados[linha][1] = f.getNome();
			dados[linha][2] = f.getEmail();
			linha++;
		}

		tableFuncionarios = new JTable(dados, colunas);

		scrollFuncionarios = new JScrollPane(tableFuncionarios);
		scrollFuncionarios.setBounds(10, 70, 500, 300);

		btnNovo = new JButton("Cadastrar");
		btnNovo.setBounds(10, 380, 150, 40);
		btnNovo.setFont(fontBotao);
		btnNovo.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new FrameFuncionario(tela);

			}
		});
		
		btnSair = new JButton("Sair");
		btnSair.setBounds(170, 380, 150, 40);
		btnSair.setFont(fontBotao);
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
		painel.add(scrollFuncionarios);
		painel.add(btnNovo);
		painel.add(btnSair);

		tela.setVisible(true);
	}
}
