package pl.skoltun.SpringBoot.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.TypedQuery;

@Repository
public class UserDetailsRepository implements org.springframework.security.core.userdetails.UserDetailsService {
    @Autowired
    protected EntityManager em;

    @Transactional
    public void create(User user) {
        em.persist(user);
    }

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        try {
            TypedQuery<User> query = em.createQuery(
                    "SELECT u FROM User u JOIN FETCH u.authorities WHERE u.username=:name", User.class);
            query.setParameter("name", s);
            return query.getSingleResult();
        } catch (EntityNotFoundException e) {
            throw new UsernameNotFoundException(s);
        }
    }
}
