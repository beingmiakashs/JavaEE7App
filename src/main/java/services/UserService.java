package services;

import models.User;

import javax.ejb.Stateless;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Named
@Stateless
public class UserService {
    @PersistenceContext
    private EntityManager em;

    public List<User> getAll() {
        CriteriaQuery<User> query = em.getCriteriaBuilder().createQuery(User.class);
        Root<User> root = query.from(User.class);
        query.select(root);
        return em.createQuery(query).getResultList();
    }

    public User find(String name) {
        return em.find(User.class, name);
    }

    public User addUser(User user) {
        em.persist(user);
        return user;
    }

    public void deleteUser(String email) {
        User user = em.find(User.class, email);
        em.remove(user);
    }
}
