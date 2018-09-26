package ma.moha.tp.metier;

import ma.moha.tp.entities.Produit;
import java.util.List;
public interface ICatalogueMetier {
	public	void	addProduit(Produit p);  
	public	List<Produit>    listProduits(); 
	public	void	deleteProduit(Long idP);  
	public	Produit	editProduit(Long  idP);  
	public	void	updateProduit(Produit	p);
	public  List<Produit>	chercherProduits(String motCle);

}
