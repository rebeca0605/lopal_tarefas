package br.dev.rebeca.tarefas.dao;

import java.io.BufferedWriter;
import java.io.IOException;

import br.dev.rebeca.tarefas.factory.FileFactory;
import br.dev.rebeca.tarefas.model.Funcionario;

public class FuncionarioDAO {
	
	private Funcionario funcionario;
	
	//Método Construtor
	public FuncionarioDAO(Funcionario funcionario) {
		this.funcionario = funcionario;
	}
	
	public void gravar() {
		
		FileFactory ff = new FileFactory();
		
		try {
			
			BufferedWriter bw =ff.getBuferredWriter();
			
			bw.write(funcionario.toString());
			bw.flush();
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		
	}
	
	public void showEmployees() {
		
	}

}
