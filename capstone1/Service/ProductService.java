package com.example.capstone1.Service;

import com.example.capstone1.Model.Product;
import com.example.capstone1.Model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@RequiredArgsConstructor
public class ProductService {


    ArrayList<Product> products = new ArrayList<>();


    public ArrayList<Product> getProducts(){
        return products;
    }


    public void addProduct(Product product){

        products.add(product);

    }

    public Boolean updateProduct(int Id , Product product){

        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getID() == Id){
                products.set(i , product);
                return true ;
            }

        }
        return false ;
    }



    public Boolean deleteProduct(int Id){

        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getID() == Id){
                products.remove(i);
                return true ;
            }
        }
        return null ;
    }



    public Boolean productId(int IdPr){
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getID() == IdPr){
                return true ;
            }
        }

        return false ;
    }


    public Boolean discounts(int IdP , int des) {
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getID() == IdP){
                products.get(i).setPrice(products.get(i).getPrice() - (products.get(i).getPrice() * des / 100));
                return true;
            }
        }
        return false ;
    }



    public Boolean giftCard(String giftCard){
        if (giftCard.equalsIgnoreCase("gift")){
            for (Product product : products){
                product.setPrice(product.getPrice() - 100);
                return true;
            }
        }
        return false ;
    }


}
