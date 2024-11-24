package org.NAK.Citronix.Controller;

import jakarta.validation.Valid;
import org.NAK.Citronix.DTO.Sale.CreateSaleDTO;
import org.NAK.Citronix.DTO.Sale.ResponseSaleDTO;
import org.NAK.Citronix.DTO.Sale.ResponseSaleSharedDTO;
import org.NAK.Citronix.DTO.Sale.UpdateSaleDTO;
import org.NAK.Citronix.Entity.Sale;
import org.NAK.Citronix.Service.Contract.SaleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/sales")
public class SaleController {

    private final SaleService saleService;

    public SaleController(SaleService saleService) {
        this.saleService = saleService;
    }


    @GetMapping("/{id}")
    public ResponseEntity<ResponseSaleDTO> getSale(@PathVariable Long id) {
        ResponseSaleDTO sale = saleService.getSale(id);
        return new ResponseEntity<>(sale, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<ResponseSaleDTO>> getSales() {
        List<ResponseSaleDTO> sales = saleService.getSales();
        return new ResponseEntity<>(sales, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ResponseSaleSharedDTO> createSale(@Valid @RequestBody CreateSaleDTO createSaleDTO) {
        ResponseSaleSharedDTO sale = saleService.createSale(createSaleDTO);
        return new ResponseEntity<>(sale, HttpStatus.CREATED);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<ResponseSaleDTO> updateSale(@PathVariable Long id,  @RequestBody UpdateSaleDTO updateSaleDTO) {

        ResponseSaleDTO sale = saleService.updateSale(id, updateSaleDTO);
        return new ResponseEntity<>(sale, HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseSaleDTO> deleteSale(@PathVariable Long id) {
        saleService.deleteSale(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
