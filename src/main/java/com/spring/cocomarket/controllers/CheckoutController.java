package com.spring.cocomarket.controllers;

import com.spring.cocomarket.payement.ChargeRequest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class CheckoutController {

    @Value("${STRIPE_PUBLIC_KEY}")
    private String stripePublicKey;

    @RequestMapping("/checkout")
    public String checkout(Model model) {
        model.addAttribute("amount", 50 * 100); // in cents
        model.addAttribute("stripePublicKey", stripePublicKey);
        model.addAttribute("currency", ChargeRequest.Currency.EUR);
        /*
        model.addAttribute("stripePublicKey",stripePublicKey);
        model.addAttribute("amount",checkoutForm.getAmount());
        model.addAttribute("email", checkoutForm.getEmail());
        model.addAttribute("featureRequest", checkoutForm.getFeatureRequest());
        */
        return "checkout";
    }
}