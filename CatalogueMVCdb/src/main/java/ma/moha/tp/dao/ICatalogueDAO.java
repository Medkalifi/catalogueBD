package ma.moha.tp.dao;

import java.util.List;

import ma.moha.tp.entities.Produit;

public interface ICatalogueDAO {
	public	void	addProduit(Produit	p); 
	public	List<Produit>	listProduits(); 
	public	void	deleteProduit(Long	idP);  
	public	Produit	editProduit(Long	idP);  
	public	void	updateProduit(Produit	p);
	public List<Produit> chercherProduits(String	motCle);

}
