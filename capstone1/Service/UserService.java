package com.example.capstone1.Service;


import com.example.capstone1.Model.MerchantStock;
import com.example.capstone1.Model.Product;
import com.example.capstone1.Model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;

@Service
@RequiredArgsConstructor
public class UserService {


    @DateTimeFormat
    private final ProductService productService ;
    private final MerchantService merchantService ;
    private final MerchantStockService merchantStockService ;
    ArrayList<User> users = new ArrayList<>();

    public ArrayList<User> getUser(){
        return users;
    }


    public void addUser(User user){

        users.add(user);

    }

    public Boolean updateUser(int Id , User user){

        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getID() == Id){
                users.set(i , user);
                return true ;
            }

        }
        return false ;
    }



    public Boolean deleteUser(int Id){

        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getID() == Id){
                users.remove(i);
                return true ;
            }
        }
        return null ;
    }






    public String buyProduct(int IdU , int IdP , int IdMS){
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getID() == IdU){
                if (productService.productId(IdP) == true){
                        if (merchantStockService.MerchantSId(IdMS) == true) {
                            for (MerchantStock merchantStock : merchantStockService.merchantStocks){
                                if (merchantStock.getStock() >= 1 ){
                                    for (User user : users){
                                        for (Product product : productService.products){
                                            if (user.getBalance() >= product.getPrice() ) {
                                                users.get(i).setBalance(users.get(i).getBalance() - product.getPrice());
                                                int i2 = merchantStock.getStock()-1;
                                                merchantStock.setStock(i2);
                                                return "thank you" ;
                                            }
                                        }
                                    }
                                }
                                return "out of stuck";
                            }
                        }
                }
            }
        }

        return "Invalid ID";
    }





    public String giftCard(int IdU ){
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getID() == IdU){
                if (users.get(i).getBalance() >= 100 ){
                    users.get(i).setBalance(users.get(i).getBalance() - 100);
                    return "your gift card : gift ";
                }
                return "check your balance";
            }
        }
        return "Invalid ID";
    }






    public Boolean deposit(int Id , int dep){
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getID() == Id){
                users.get(i).setBalance(users.get(i).getBalance() + dep);
                return true ;
            }
        }
        return false ;
    }

}
