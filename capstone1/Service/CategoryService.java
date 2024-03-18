package com.example.capstone1.Service;

import com.example.capstone1.Model.Category;
import com.example.capstone1.Model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class CategoryService {

    ArrayList<Category> categories = new ArrayList<>();
    public ArrayList<Category> getCategory(){
        return categories;
    }


    public void addCategory(Category category){

        categories.add(category);

    }

    public Boolean updateCategory(int Id , Category category){

        for (int i = 0; i < categories.size(); i++) {
            if (categories.get(i).getID() == Id){
                categories.set(i , category);
                return true ;
            }

        }
        return false ;
    }



    public Boolean deleteCategory(int Id){

        for (int i = 0; i < categories.size(); i++) {
            if (categories.get(i).getID() == Id){
                categories.remove(i);
                return true ;
            }
        }
        return null ;
    }

}
