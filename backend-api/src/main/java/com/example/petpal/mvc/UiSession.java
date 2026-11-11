package com.example.petpal.mvc;

import com.example.petpal.service.BadRequestException;
import jakarta.servlet.http.HttpSession;

public class UiSession {
    private UiSession() {

    }

    static Long requireId(HttpSession session, String role) {
        Object id = session.getAttribute("userId");
        Object currentRole = session.getAttribute("userRole");
        
        if (!(id instanceof Long userId) || !role.equals(currentRole)) {
            throw new BadRequestException("Please log in to continue.");
        }

        return userId;
    }
}
