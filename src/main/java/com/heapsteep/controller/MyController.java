package com.heapsteep.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {

    @GetMapping("/")
    public String welcome() {
        return "Welcome to Heapsteep !!";
    }

    /** USER or ADMIN — shared “normal user” APIs. */
    @GetMapping("/api/user/dashboard")
    public String userDashboard() {
        return "Success — User dashboard page, accessible to USER and ADMIN.";
    }

    /** ADMIN only. */
    @GetMapping("/api/admin/reports")
    public String adminReports() {
        return "Success - You are seeing an Admin Reports page.";
    }
}
