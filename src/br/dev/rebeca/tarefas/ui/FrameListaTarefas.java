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
import javax.swing.table.DefaultTableModel;

import br.dev.rebeca.tarefas.dao.*;
import br.dev.rebeca.tarefas.model.Tarefa;

public class FrameListaTarefas {

	private JLabel lblTitulo;
	private JTable tblTabela;
	DefaultTableModel modeloTabela;
	private JScrollPane scrollTabela;
	private JButton btnNovaTarefa, btnSair;

	private Font fontTitulo = new Font("Arial", Font.BOLD, 26);
	private Font fontBotao = new Font("Arial", Font.BOLD, 16);

	public FrameListaTarefas() {
		criarTela();
	}

	public void criarTela() {
		
		JFrame tela = new JFrame();
		tela.setTitle("Lista de Tarefas");
		tela.setSize(600, 600);
		tela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		tela.setResizable(false);
		tela.setLayout(null);
		tela.setLocationRelativeTo(null);
		
		Container painel = tela.getContentPane();
		
		lblTitulo = new JLabel("Lista de Tarefas");
		lblTitulo.setBounds(20, 40, 450, 20);
		lblTitulo.setFont(fontTitulo);
		
		String[] colunas = new String[3];
		colunas[0] = "Código";
		colunas[1] = "Titulo";
		colunas[2] = "Responsável";
		
		TarefaDAO dao = new TarefaDAO(null);

		List<Tarefa> tarefas = dao.showTask();
		Object[][] dados = new Object[tarefas.size()][3];
		
		int linha = 0;
		for(Tarefa t : tarefas) {
			dados[linha][0] = t.getCodigo();
			dados[linha][1] = t.getTitulo();
			dados[linha][2] = t.getResponsavel();
			linha++;
		}
		
		tblTabela = new JTable(dados, colunas);
		scrollTabela = new JScrollPane(tblTabela);
		scrollTabela.setBounds(20, 70, 500, 300);

		modeloTabela = new DefaultTableModel();
		
		btnNovaTarefa = new JButton("Nova Tarefa");
		btnNovaTarefa.setBounds(20, 400, 150, 40);
		btnNovaTarefa.setFont(fontBotao);
		btnNovaTarefa.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new FrameTarefa();
				
			}
		});
		
		btnSair = new JButton("Sair");
		btnSair.setBounds(180, 400, 150, 40);
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
		painel.add(scrollTabela);
		painel.add(btnNovaTarefa);
		painel.add(btnSair);
		
		tela.setVisible(true);
	}
}
