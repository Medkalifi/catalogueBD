package ma.moha.tp.metier;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import ma.moha.tp.dao.ICatalogueDAO;
import ma.moha.tp.entities.Produit;

public class CatalogueMetierImpl implements ICatalogueMetier {
	private ICatalogueDAO	dao;
	public void setDao(ICatalogueDAO dao) {
		this.dao = dao;
	}
	@Override
	@Transactional
	public void addProduit(Produit p) {
		dao.addProduit(p);
		
	}

	@Override
	public List<Produit> listProduits() {
		return dao.listProduits();
	}

	@Override
	@Transactional
	public void deleteProduit(Long idP) {
		dao.deleteProduit(idP);
	}

	@Override
	public Produit editProduit(Long idP) {
		return dao.editProduit(idP);
	}

	@Override
	@Transactional
	public void updateProduit(Produit p) {
dao.updateProduit(p);		
	}

	@Override
	@Transactional
	public List<Produit> chercherProduits(String motCle) {
		return dao.chercherProduits(motCle);
	}

}
