package util;

public class Serializacao {
  public static void salvarObjeto(Object obj, String caminho) {
      try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(caminho))) {
          oos.writeObject(obj);
      } catch (IOException e) {
          e.printStackTrace();
      }
  }
