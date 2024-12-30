package ticketreservation.service;

import java.util.List;

import ticketreservation.model.CategoryModel;
import ticketreservation.repository.*;

public class CategoryServiceImpl implements CategoryService
{

	CategoryRepository ctrepo=new CategoryRepositoryImpl();
	
	public boolean isAddNewCategory(CategoryModel cmodel) 
	{
		return ctrepo.isAddNewCategory(cmodel);
	}

	
	public List<CategoryModel> getAllCategoriesList() 
	{
		
		return ctrepo.getAllCategoriesList();
	}


	@Override
	public boolean isDeleteCategory(int cid) {
		return ctrepo.isDeleteCategory(cid);
	}


	@Override
	public int getIdByName(String cname) {
		return ctrepo.getIdByName(cname);
	}


	@Override
	public boolean isAssociatedCatEvent(int cid, int eid) {
		return ctrepo.isAssociatedCatEvent(cid, eid);
	}

}