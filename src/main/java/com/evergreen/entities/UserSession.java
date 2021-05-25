package com.evergreen.entities;

import lombok.Data;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

@Data
@Component
@Scope(value="session", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class UserSession {
    private Long id;
    private String role;

    public boolean isConnected() {
        return id!= null;
    }

    public boolean isAdministrator() {
        return this.role.equals("Administrateur");
    }

}
