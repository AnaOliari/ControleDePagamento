package util;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Serializacao {

    // Método estático genérico para salvar dados de uma lista em um arquivo.
    public static <T> void salvarDados(List<T> lista, String filename) {
        // Utiliza um bloco try-with-resources para garantir que o BufferedWriter será fechado após o uso.
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            // Itera sobre cada item na lista.
            for (T item : lista) {
                // Escreve a representação em string do item no arquivo.
                writer.write(item.toString());
                // Adiciona uma nova linha após cada item.
                writer.newLine();
            }
            // Loga a atividade de salvamento com sucesso.
            SistemaLog.logarAtividade("Dados salvos com sucesso no arquivo: " + filename);
        } catch (IOException e) {
            // Loga um erro em caso de falha ao salvar os dados.
            SistemaLog.logarErro("Erro ao salvar dados no arquivo: " + filename + " - " + e.getMessage());
            e.printStackTrace();
        }
    }

    // Método estático para carregar dados de um arquivo e retorná-los como uma lista de strings.
    public static List<String> carregarDados(String filename) {
        // Cria uma lista para armazenar as linhas lidas do arquivo.
        List<String> lista = new ArrayList<>();
        // Utiliza um bloco try-with-resources para garantir que o BufferedReader será fechado após o uso.
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String linha;
            // Lê cada linha do arquivo até o final.
            while ((linha = reader.readLine()) != null) {
                // Adiciona a linha lida à lista.
                lista.add(linha);
            }
            // Loga a atividade de carregamento com sucesso.
            SistemaLog.logarAtividade("Dados carregados com sucesso do arquivo: " + filename);
        } catch (FileNotFoundException e) {
            // Loga um erro em caso de o arquivo não ser encontrado.
            SistemaLog.logarErro("Erro ao carregar dados do arquivo: " + filename + " - Arquivo não encontrado.");
        } catch (IOException e) {
            // Loga um erro em caso de falha ao ler os dados.
            SistemaLog.logarErro("Erro ao carregar dados do arquivo: " + filename + " - " + e.getMessage());
            e.printStackTrace();
        }
        // Retorna a lista de linhas lidas do arquivo.
        return lista;
    }
}
