package it.accenture.soccer.services.implementations;

import it.accenture.soccer.exceptions.EntityNotFoundException;
import it.accenture.soccer.model.abstractions.WithId;
import it.accenture.soccer.services.AbstractCrudService;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

import static it.accenture.soccer.exceptions.EntityNotFoundException.ERROR_NOT_FOUND;

public class CrudService <T extends WithId<K>, K, R extends JpaRepository<T, K>> implements AbstractCrudService<T, K>  {
    protected final R repo;
    protected Class<?> entityClass;

    public CrudService(R repo, Class<?> entityClass){
        this.repo = repo;
        this.entityClass = entityClass;
    }
    @Override
    public Iterable<T> getAll() {
        return repo.findAll();
    }

    @Override
    public Optional<T> findById(K k) {
        return repo.findById(k);
    }

    @Override
    public void deleteById(K k) throws EntityNotFoundException {
        if (exists(k)) {
            repo.deleteById(k);
        } else {
            throw new EntityNotFoundException(ERROR_NOT_FOUND, entityClass, (long) k);
        }
    }

    @Override
    public T saveOrUpdate(T t) throws EntityNotFoundException {
        if (t.getId()!=null && !t.getId().equals(0) && !exists(t.getId())) {
            throw new EntityNotFoundException(ERROR_NOT_FOUND, entityClass, (long) t.getId());
        }
        return repo.save(t);
    }

    @Override
    public boolean exists(K id) {
        return findById(id).isPresent();
    }
}
