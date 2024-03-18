package com.example.capstone1.Controller;


import com.example.capstone1.Model.Merchant;
import com.example.capstone1.Model.MerchantStock;
import com.example.capstone1.Service.MerchantStockService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/stock")
@RequiredArgsConstructor
public class MerchantStockController {


    private final MerchantStockService merchantStockService ;


    @GetMapping("/get")
    public ResponseEntity getMerchantStock(){
        return ResponseEntity.status(200).body(merchantStockService.getMerchantStock());
    }



    @PostMapping("/add")
    public ResponseEntity addMerchantStock(@RequestBody @Valid MerchantStock merchantStock , Errors errors){
        if (errors.hasErrors()){
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }

        merchantStockService.addMerchantStock(merchantStock);
        return ResponseEntity.status(200).body("added");

    }




    @PutMapping("/update/{Id}")
    public ResponseEntity updateMerchantStock(@PathVariable int Id , @RequestBody @Valid MerchantStock merchantStock , Errors errors ){

        if (errors.hasErrors()){
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }

        boolean isUpdate = merchantStockService.updateMerchantStock(Id , merchantStock);
        if (isUpdate){
            return ResponseEntity.status(200).body("updated");
        }

        return ResponseEntity.status(400).body("Invalid Id");
    }




    @DeleteMapping("/delete/{Id}")
    public ResponseEntity deleteMerchantStock(@PathVariable int Id ){


        if (merchantStockService.deleteMerchantStock(Id) == null){
            return ResponseEntity.status(400).body("Invalid Id");
        }

        return ResponseEntity.status(200).body("deleted");

    }



    @GetMapping("/restock/{IdPr}/{IdP}/{IdM}/{newStock}")
    public ResponseEntity reStock(@PathVariable int IdPr , @PathVariable int IdP , @PathVariable int IdM , @PathVariable int newStock){
        if (merchantStockService.reStock(IdPr ,IdP, IdM, newStock) == false){
            return ResponseEntity.status(400).body("Invalid ID");
        }

        return ResponseEntity.status(200).body("done");
    }


}
