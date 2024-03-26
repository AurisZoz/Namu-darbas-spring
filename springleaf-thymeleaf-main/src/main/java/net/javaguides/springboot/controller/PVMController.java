package net.javaguides.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PVMController {

    @GetMapping({"/" , "/Input"})
    public String showInput() {
        return "input";
    }

    @PostMapping("/result")
    public String calculatePrice(@RequestParam("price") double price,
                                 @RequestParam("quantity") int quantity, Model model) {
    	
        double unitPriceWithoutVat = price / 1.21;
        double VAT =price - unitPriceWithoutVat;
        double vatAmount = price;
        double totalPriceWithoutVat = (price * quantity) - (VAT * price);
        double totalVat = (vatAmount * quantity) / VAT;
        double totalPriceWithVat = price * quantity;

        model.addAttribute("unitPriceWithoutVat", unitPriceWithoutVat);
        model.addAttribute("VAT", VAT);
        model.addAttribute("vatAmount", vatAmount);
        model.addAttribute("totalPriceWithoutVat", totalPriceWithoutVat);
        model.addAttribute("totalVat", totalVat);
        model.addAttribute("totalPriceWithVat", totalPriceWithVat);

        return "result";
    }
}