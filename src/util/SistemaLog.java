package util;

import java.io.IOException;
import java.util.logging.*;

public class SistemaLog {
    private static Logger logger = Logger.getLogger(SistemaLog.class.getName());

    static {
        try {
            FileHandler fileHandler = new FileHandler("sistema.log", true);
            fileHandler.setFormatter(new SimpleFormatter());
            logger.addHandler(fileHandler);
            logger.setLevel(Level.ALL);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void logarAtividade(String atividade) {
        logger.info(atividade);
    }

    public static void logarErro(String erro) {
        logger.severe(erro);
    }
}
