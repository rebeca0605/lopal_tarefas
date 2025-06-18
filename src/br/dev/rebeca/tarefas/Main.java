package br.dev.rebeca.tarefas;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import br.dev.rebeca.tarefas.dao.FuncionarioDAO;
import br.dev.rebeca.tarefas.gui.TelaInicial;
import br.dev.rebeca.tarefas.model.Funcionario;
import br.dev.rebeca.tarefas.model.Tarefa;
import br.dev.rebeca.tarefas.ui.FrameFuncionario;
import br.dev.rebeca.tarefas.ui.FrameListaFuncionario;
import br.dev.rebeca.tarefas.ui.FrameListaTarefas;
import br.dev.rebeca.tarefas.ui.FrameTarefa;
import br.dev.rebeca.tarefas.utils.Utils;

public class Main {

	private static String path = "C:\\Users\\User\\tarefa\\tarefas.cvs";

	public static void main(String[] args) {

		new TelaInicial();

	}
	
}