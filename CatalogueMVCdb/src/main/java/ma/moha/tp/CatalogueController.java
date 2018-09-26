package ma.moha.tp;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import ma.moha.tp.entities.Produit;
import ma.moha.tp.metier.ICatalogueMetier;

@Controller
public class CatalogueController {
	
	@Autowired
	private ICatalogueMetier	metier; 
	@RequestMapping(value="/index")  
	public  String index(Model model){
	model.addAttribute("produit",	new Produit());  
	model.addAttribute("produits",	metier.listProduits());  
	return "produits";
	}
	
	@RequestMapping(value="/saveProduit")
	public String saveProduit(@Valid Produit p,BindingResult  bindingResult,Model model){
	if(bindingResult.hasErrors()) return "produits";  if(p.getIdProduit()==null)  metier.addProduit(p);
	else metier.updateProduit(p);  model.addAttribute("produit", new Produit());  model.addAttribute("produits", metier.listProduits());  return "produits";
	}
	@RequestMapping(value="/deleteProduit")
	public String delete(@RequestParam(value="id")
	Long id, Model model){  metier.deleteProduit(id);
	model.addAttribute("produit", new Produit()); 
	model.addAttribute("produits", metier.listProduits()); 
	return "produits";
	}

	@RequestMapping(value="/editProduit/{id}")
	public  String	edit(@PathVariable(value="id")
	Long	id,  Model	model){  Produit p=metier.editProduit(id);
	model.addAttribute("produit",	p); 
	model.addAttribute("produits",		metier.listProduits());  return "produits";
	}
	@RequestMapping(value="/listProduits/{mc}")  
	@ResponseBody
	public  List<Produit>	listProduits(@PathVariable(value="mc")String	mc){  return metier.chercherProduits(mc);
	}

	
	
}
