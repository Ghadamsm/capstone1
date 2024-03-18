package com.example.capstone1.Service;

import com.example.capstone1.Model.MerchantStock;
import com.example.capstone1.Model.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@RequiredArgsConstructor
public class MerchantStockService {


    private final ProductService productService ;
    ArrayList<MerchantStock> merchantStocks = new ArrayList<>();


    public ArrayList<MerchantStock> getMerchantStock(){
        return merchantStocks;
    }


    public void addMerchantStock(MerchantStock merchantStock){

        merchantStocks.add(merchantStock);

    }

    public Boolean updateMerchantStock(int Id , MerchantStock merchantStock){

        for (int i = 0; i < merchantStocks.size(); i++) {
            if (merchantStocks.get(i).getID() == Id){
                merchantStocks.set(i , merchantStock);
                return true ;
            }

        }
        return false ;
    }



    public Boolean deleteMerchantStock(int Id){

        for (int i = 0; i < merchantStocks.size(); i++) {
            if (merchantStocks.get(i).getID() == Id){
                merchantStocks.remove(i);
                return true ;
            }
        }
        return null ;
    }



    public Boolean reStock(int IdPr , int IdP , int IdM , int newStock){
        if (productService.productId(IdPr) == true){
           for (MerchantStock merchantStock : merchantStocks){
               for (int i = 0; i < merchantStocks.size(); i++) {
                   if (merchantStocks.get(i).getProductID() == IdP && merchantStocks.get(i).getMerchantID() == IdM){
                       merchantStock.setStock(merchantStock.getStock() + newStock);
                       return true ;
                   }

               }
           }
        }
       return false ;
    }



    public Boolean MerchantSId(int IdMS ){
        for (int i = 0; i < merchantStocks.size(); i++) {
            if (merchantStocks.get(i).getID() == IdMS){
                return true ;
            }
        }

        return false ;
    }





}
