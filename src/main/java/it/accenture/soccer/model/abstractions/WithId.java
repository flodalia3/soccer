package it.accenture.soccer.model.abstractions;

public interface WithId<K> {

    public K getId();

    public void setId(K id);
}
