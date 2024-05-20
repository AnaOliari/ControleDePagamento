// src/model/Entidade.java
package model;

public abstract class Entidade {
    private int id;

    public Entidade(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public abstract void display();
}
