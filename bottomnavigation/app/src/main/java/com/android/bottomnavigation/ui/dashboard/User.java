package com.android.bottomnavigation.ui.dashboard;

public class User {
    private String displayName;
    private String email;
    // Add other properties as needed

    public User() {
        // Default constructor required for Firebase
    }

    public User(String displayName, String email) {
        this.displayName = displayName;
        this.email = email;
        // Initialize other properties as needed
    }

    public String getDisplayName() {
        return displayName;
    }

    public String getEmail() {
        return email;
    }
    // Add getters and setters for other properties as needed
}
