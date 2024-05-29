package util;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Serializacao {

    public static <T> void salvarDados(List<T> lista, String filename) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            for (T item : lista) {
                writer.write(item.toString());
                writer.newLine();
            }
            SistemaLog.logarAtividade("Dados salvos com sucesso no arquivo: " + filename);
        } catch (IOException e) {
            SistemaLog.logarErro("Erro ao salvar dados no arquivo: " + filename + " - " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static List<String> carregarDados(String filename) {
        List<String> lista = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                lista.add(linha);
            }
            SistemaLog.logarAtividade("Dados carregados com sucesso do arquivo: " + filename);
        } catch (IOException e) {
            SistemaLog.logarErro("Erro ao carregar dados do arquivo: " + filename + " - " + e.getMessage());
            e.printStackTrace();
        }
        return lista;
    }
}
