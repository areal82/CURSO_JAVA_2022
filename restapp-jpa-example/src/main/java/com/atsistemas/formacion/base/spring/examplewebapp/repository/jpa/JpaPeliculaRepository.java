package com.atsistemas.formacion.base.spring.examplewebapp.repository.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.atsistemas.formacion.base.spring.examplewebapp.model.FiltrosPelicula;
import com.atsistemas.formacion.base.spring.examplewebapp.model.Pelicula;
import com.atsistemas.formacion.base.spring.examplewebapp.repository.PeliculaRepository;

@Repository
public class JpaPeliculaRepository implements PeliculaRepository {

	@PersistenceContext
	private EntityManager em;

	public JpaPeliculaRepository() {
	}

	public List<Pelicula> findAll() {
		return em.createQuery("FROM Pelicula", Pelicula.class).getResultList();
	}

	@Override
	public Pelicula findById(Integer id) {
		return em.find(Pelicula.class, id);
	}

	@Override
	public Pelicula insert(Pelicula pelicula) {
		em.persist(pelicula);
		return pelicula;
	}

	@Override
	public Pelicula update(Pelicula pelicula) {
		em.merge(pelicula);
		return pelicula;
	}

	@Override
	public void delete(Integer id) {
		em.createQuery("DELETE FROM Pelicula WHERE id = ?1").setParameter(1, id).executeUpdate();
	}

	@Override
	public List<Pelicula> findByGenero(String genero) {
		return em.createQuery("FROM Pelicula p WHERE p.genero = :genero", Pelicula.class).setParameter("genero", genero)
				.getResultList();
	}

	@Override
	public List<Pelicula> search(FiltrosPelicula filtrosPelicula) {
		CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
		CriteriaQuery<Pelicula> query = criteriaBuilder.createQuery(Pelicula.class);
		Root<Pelicula> root = query.from(Pelicula.class);
		Predicate predicate = criteriaBuilder.conjunction();

		if (filtrosPelicula.getTitulo() != null) {
			predicate = criteriaBuilder.and(predicate,
					criteriaBuilder.equal(root.get("titulo"), filtrosPelicula.getTitulo()));
		}

		if (filtrosPelicula.getDirector() != null) {
			predicate = criteriaBuilder.and(predicate,
					criteriaBuilder.like(root.get("director"), "%"+filtrosPelicula.getDirector()+"%"));
		}

		if (filtrosPelicula.getFechaEstreno() != null) {
			predicate = criteriaBuilder.and(predicate,
					criteriaBuilder.greaterThanOrEqualTo(root.get("fechaEstreno"), filtrosPelicula.getFechaEstreno()));
		}

		if (filtrosPelicula.getGenero() != null) {
			predicate = criteriaBuilder.and(predicate,
					criteriaBuilder.equal(root.get("genero"), filtrosPelicula.getGenero()));
		}

		query.where(predicate);

		return em.createQuery(query).getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Pelicula> findBy21Century() {
		return em.createNativeQuery("SELECT * FROM pelicula p WHERE p.fecha_estreno >= 2000", Pelicula.class)
				.getResultList();
	}

}
