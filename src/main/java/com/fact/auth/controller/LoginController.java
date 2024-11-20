package com.fact.auth.controller;

import com.fact.auth.service.EmailService;
import com.fact.auth.util.OTPUtil;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    @Autowired
    private EmailService emailService;

    @Autowired
    private HttpSession session;

    private String otp;
    private final int length = 6;

    // Show login page
    @GetMapping("/login")
    public String showLoginPage() {
        return "login";
    }

    @PostMapping("/login")
    public String sendOtp(@RequestParam("email") String userEmail, Model model) {
        otp = OTPUtil.generateOTP(length);
        session.setAttribute("otp", otp);
        boolean otpSent = emailService.sendOTP(userEmail, otp);

        if (otpSent) {
            model.addAttribute("message", "OTP has been sent to your email.");
            return "otp"; // Redirect to OTP verification page
        } else {
            model.addAttribute("error", "Failed to send OTP. Please try again.");
            return "login"; // Return to login page
        }
    }

    @PostMapping("/verify-otp")
    public String verifyOtp(@RequestParam("otp") String enteredOtp, Model model) {
        String storedOtp = (String) session.getAttribute("otp");
        if (storedOtp != null && storedOtp.equals(enteredOtp)) {
            return "redirect:/home";
        } else {
            model.addAttribute("error", "Invalid OTP. Please try again.");
            return "otp";
        }
    }

    @GetMapping("/home")
    public String home() {
        return "home";
    }
}
