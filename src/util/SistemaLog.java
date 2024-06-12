package util;

import java.io.IOException;
import java.util.logging.*;

public class SistemaLog {
    // Cria um logger estático com o nome da classe SistemaLog.
    private static Logger logger = Logger.getLogger(SistemaLog.class.getName());

    // Bloco estático para configuração inicial do logger.
    static {
        try {
            // Cria um FileHandler para gravar logs no arquivo "sistema.log".
            // O segundo parâmetro true indica que os logs serão adicionados ao arquivo existente.
            FileHandler fileHandler = new FileHandler("sistema.log", true);
            // Define um formato simples para os logs.
            fileHandler.setFormatter(new SimpleFormatter());
            // Adiciona o FileHandler ao logger.
            logger.addHandler(fileHandler);
            // Define o nível de log para registrar todas as mensagens (de ALL a SEVERE).
            logger.setLevel(Level.ALL);
        } catch (IOException e) {
            // Em caso de falha ao configurar o FileHandler, imprime a stack trace do erro.
            e.printStackTrace();
        }
    }

    // Método estático para registrar uma mensagem de atividade informativa.
    public static void logarAtividade(String atividade) {
        // Registra a mensagem de atividade com o nível INFO.
        logger.info(atividade);
    }

    // Método estático para registrar uma mensagem de erro severo.
    public static void logarErro(String erro) {
        // Registra a mensagem de erro com o nível SEVERE.
        logger.severe(erro);
    }
}
