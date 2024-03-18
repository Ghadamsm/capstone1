package com.example.capstone1.Service;


import com.example.capstone1.Model.Merchant;
import com.example.capstone1.Model.MerchantStock;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class MerchantService {

    ArrayList<Merchant> merchants = new ArrayList<>();

    public ArrayList<Merchant> getMerchant(){
        return merchants;
    }


    public void addMerchant(Merchant merchant){

        merchants.add(merchant);

    }

    public Boolean updateMerchant(int Id , Merchant merchant){

        for (int i = 0; i < merchants.size(); i++) {
            if (merchants.get(i).getID() == Id){
                merchants.set(i , merchant);
                return true ;
            }

        }
        return false ;
    }



    public Boolean deleteMerchant(int Id){

        for (int i = 0; i < merchants.size(); i++) {
            if (merchants.get(i).getID() == Id){
                merchants.remove(i);
                return true ;
            }
        }
        return null ;
    }




}
