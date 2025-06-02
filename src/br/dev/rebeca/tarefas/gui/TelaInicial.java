package br.dev.rebeca.tarefas.gui;

import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import br.dev.rebeca.tarefas.ui.FrameListaFuncionario;

public class TelaInicial {
	
	private JButton btnFuncionarios;
	private JButton btnTarefas;
	private JButton btnSair;
	private JLabel lblTitulo;
	
	private Font fontTitulo = new Font("Arial", Font.BOLD, 18);
	
	public TelaInicial() {
		criarTela();
	}
	
	public void criarTela() {
		JFrame tela = new JFrame();
		tela.setTitle("Menu Principal");
		tela.setSize(400, 200);
		tela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		tela.setResizable(false);
		tela.setLayout(null);
		tela.setLocationRelativeTo(null);
		
		Container painel = tela.getContentPane();
		
		lblTitulo = new JLabel("Escolha uma opção:");
		lblTitulo.setBounds(100, 15, 250, 30);
		lblTitulo.setFont(fontTitulo);
		
		btnFuncionarios = new JButton("Funcionários");
		btnFuncionarios.setBounds(40, 50, 150, 40);
		
		btnFuncionarios.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new FrameListaFuncionario();
			}
		});
		
		btnTarefas = new JButton("Tarefas");
		btnTarefas.setBounds(200, 50, 150, 40);
		
		btnSair = new JButton("Sair");
		btnSair.setBounds(125, 100, 150, 40);
		
		// Adicionar os ouvintes de ação dos botões (Action Listener)
		btnSair.addActionListener(new ActionListener() {
			
			//Botão de Saída do Sistema
			@Override
			public void actionPerformed(ActionEvent e) {
				int resposta = JOptionPane.showConfirmDialog(
						tela, 
						"Confirma a saída do sistema?", 
						"Sair do Sistema",
						JOptionPane.YES_NO_OPTION)
					;

				if (resposta == 0) {
					tela.dispose();
				}
			}
		});
		
		painel.add(lblTitulo);
		painel.add(btnFuncionarios);
		painel.add(btnTarefas);
		painel.add(btnSair);
		
		tela.setVisible(true);
	}
	

}
