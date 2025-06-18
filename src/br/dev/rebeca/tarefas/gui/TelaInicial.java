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
import br.dev.rebeca.tarefas.ui.FrameListaTarefas;

public class TelaInicial {
	
	private JButton btnFuncionarios;
	private JButton btnTarefas;
	
	private Font fontBotao = new Font("Arial", Font.BOLD, 16);
	
	public TelaInicial() {
		criarTela();
	}
	
	public void criarTela() {
		JFrame tela = new JFrame();
		tela.setTitle("Gerenciador de Tarefas");
		tela.setSize(400, 200);
		tela.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		tela.setResizable(false);
		tela.setLayout(null);
		tela.setLocationRelativeTo(null);
		
		Container painel = tela.getContentPane();
		
		btnFuncionarios = new JButton("Funcionários");
		btnFuncionarios.setBounds(40, 50, 150, 40);
		btnFuncionarios.setFont(fontBotao);
		btnFuncionarios.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new FrameListaFuncionario();
			}
		});
		
		btnTarefas = new JButton("Tarefas");
		btnTarefas.setBounds(200, 50, 150, 40);
		btnTarefas.setFont(fontBotao);
		btnTarefas.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new FrameListaTarefas();
				
			}
		});
		
		painel.add(btnFuncionarios);
		painel.add(btnTarefas);
		
		tela.setVisible(true);
	}
	

}
