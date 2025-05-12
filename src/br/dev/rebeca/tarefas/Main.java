package br.dev.rebeca.tarefas;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import br.dev.rebeca.tarefas.model.Funcionario;
import br.dev.rebeca.tarefas.model.Tarefa;

public class Main {

	private static String path = "C:\\Users\\25132910\\tarefa\\tarefas.txt";

	public static void main(String[] args) {
		
		Funcionario f = new Funcionario();
		Tarefa t = new Tarefa();
		gravarArquivo();
		lerArquivo();

	}

	private static void gravarArquivo() {

		FileWriter arquivo = null;
		BufferedWriter escritor = null;  

		try {

			arquivo = new FileWriter(path, true);
			escritor = new BufferedWriter(arquivo);

			escritor.write("Essa é uma outra mais uma nova linha!!!!, por enquanto\n");
			escritor.flush();

		} catch (Exception erro) {
			System.out.println(erro.getMessage());
		}

	}

	private static void lerArquivo() {

		// Abrir o arquivo para leitura
		FileReader file = null;
		BufferedReader buffer = null;
		try {
			file = new FileReader(path);
			buffer = new BufferedReader(file);

			String linha = buffer.readLine();

			while (linha != null) {
				linha = buffer.readLine();
				if (linha != null) {
					System.out.println(linha);
				}

			}

		} catch (FileNotFoundException erro) {
			System.out.println("Arquivo não achado!");
			System.out.println(erro.getMessage());
		} catch (IOException erro) {
			System.out.println("Você não pode ver o arquivo!");
			System.out.println(erro.getMessage());
		} catch (Exception erro) {
			System.out.println("Erro genérico!");
			System.out.println(erro.getMessage());
		}
	}

}
