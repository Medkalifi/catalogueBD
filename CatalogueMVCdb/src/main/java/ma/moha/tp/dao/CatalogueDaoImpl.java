package ma.moha.tp.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import ma.moha.tp.entities.Produit;

public class CatalogueDaoImpl  implements  ICatalogueDAO{

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public void addProduit(Produit p) {
		entityManager.persist(p);
		
	}

	@Override
	public List<Produit> listProduits() {
		Query req=entityManager.createQuery("select p from Produit p"); 
		 return req.getResultList();

	}

	@Override
	public void deleteProduit(Long idP) {
		Produit p=entityManager.find(Produit.class,idP);  
		entityManager.remove(p);

		
	}

	@Override
	public Produit editProduit(Long idP) {
		Produit p=entityManager.find(Produit.class,idP); 
		return p;

	}

	@Override
	public void updateProduit(Produit p) {
		entityManager.merge(p);
		
	}

	@Override
	public List<Produit> chercherProduits(String motCle) {
		Query req=entityManager.createQuery("select p from Produit p where p.nomProduit like :x");  req.setParameter("x", "%"+motCle+"%");
		return req.getResultList();

	}

}
