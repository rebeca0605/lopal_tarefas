package br.dev.rebeca.tarefas.factory;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

public class FileFactory {
	
	public FileWriter fw;
	public BufferedWriter bw;
	
	private String pathFuncionarios =  "C:\\Users\\25132910\\tarefa\\funcionarios.csv";
	
	public BufferedWriter getBuferredWriter() throws FileNotFoundException, IOException {
		
			fw = new FileWriter(pathFuncionarios, true);
			bw = new BufferedWriter(fw);
			
			return bw;
	}

}
