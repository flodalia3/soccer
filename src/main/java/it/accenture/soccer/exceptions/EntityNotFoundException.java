package it.accenture.soccer.exceptions;

public class EntityNotFoundException extends Exception{
    public static final String ERROR_NOT_FOUND = "L'entità %s con id %d non esiste";
    public EntityNotFoundException(String message, Class<?> entity, long id) {
        super(String.format(message, entity.getSimpleName(), id));
    }
}
