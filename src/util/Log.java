package util;

public class Log {
  public static void salvarLog(String mensagem) {
      try (FileWriter writer = new FileWriter("log.txt", true)) {
          writer.write(LocalDateTime.now() + " - " + mensagem + "\n");
      } catch (IOException e) {
          e.printStackTrace();
      }
  }
}

  public static Object recuperarObjeto(String caminho) {
      try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(caminho))) {
          return ois.readObject();
      } catch (IOException | ClassNotFoundException e) {
          e.printStackTrace();
      }
      return null;
  }
}

