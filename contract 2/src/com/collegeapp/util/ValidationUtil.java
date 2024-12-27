package com.collegeapp.util;

import java.awt.Color;
import java.util.regex.Pattern;
import javax.swing.JLabel;

/**
 *
 * @ Snehal subedi
 */

public class ValidationUtil {

    // Regular expressions for validation
    private static final Pattern NUMERIC_PATTERN = Pattern.compile("\\d+");
    private static final Pattern ALPHABET_PATTERN = Pattern.compile("^[a-zA-Z\\s]+$"); // Only alphabets and spaces

    // Regular expressions for new fields
    private static final Pattern DATE_PATTERN = Pattern.compile("\\d{2}-\\d{2}-\\d{4}"); // Date format: DD-MM-YYYY
    private static final Pattern DRAFT_BY_PATTERN = Pattern.compile("^[a-zA-Z]+( [a-zA-Z]+)?$"); // Max 2 words
    private static final Pattern CONTACT_PATTERN = Pattern.compile("^(98|97)\\d{8}$"); // Starts with 98 or 97, 10 digits

    /**
     * Checks if a string is null or empty.
     *
     * @param value the string to check
     * @return true if the string is null or empty, otherwise false
     */
    private static boolean isNullOrEmpty(String value) {
        return value == null || value.trim().isEmpty();
    }

    /**
     * Validates the Contract ID.
     * It should be numeric and exactly 5 digits.
     *
     * @param contractId the contract ID to validate
     * @param lblError the JLabel to show error messages
     * @return true if valid, false otherwise
     */
    public static boolean isValidContractId(String contractId, JLabel lblError) {
        if (isNullOrEmpty(contractId)) {
            lblError.setText("Contract ID cannot be empty.");
            lblError.setForeground(Color.RED);
            return false;
        }
        if (!contractId.matches("\\d{5}")) {
            lblError.setText("Contract ID must be exactly 5 digits and numeric.");
            lblError.setForeground(Color.RED);
            return false;
        }
        lblError.setText("");
        return true;
    }

    /**
     * Validates the Title.
     * It should consist of a maximum of 2 words and contain only alphabets.
     *
     * @param title the title to validate
     * @param lblError the JLabel to show error messages
     * @return true if valid, false otherwise
     */
    public static boolean isValidTitle(String title, JLabel lblError) {
        if (isNullOrEmpty(title)) {
            lblError.setText("Title cannot be empty.");
            lblError.setForeground(Color.RED);
            return false;
        }
        if (!title.matches("[a-zA-Z]+( [a-zA-Z]+)?")) {
            lblError.setText("Title must contain only alphabets and up to 2 words.");
            lblError.setForeground(Color.RED);
            return false;
        }
        lblError.setText("");
        return true;
    }

    /**
     * Validates the Type.
     * It should be a single word (alphabetical).
     *
     * @param type the type to validate
     * @param lblError the JLabel to show error messages
     * @return true if valid, false otherwise
     */
    public static boolean isValidType(String type, JLabel lblError) {
        if (isNullOrEmpty(type)) {
            lblError.setText("Type cannot be empty.");
            lblError.setForeground(Color.RED);
            return false;
        }
        if (!type.matches("[a-zA-Z]+")) {
            lblError.setText("Type must be a single word (alphabets only).");
            lblError.setForeground(Color.RED);
            return false;
        }
        lblError.setText("");
        return true;
    }

    /**
     * Validates the Term.
     * It should be a double and between 1 and 120.
     *
     * @param term the term to validate
     * @param lblError the JLabel to show error messages
     * @return true if valid, false otherwise
     */
    public static boolean isValidTerm(String term, JLabel lblError) {
        if (isNullOrEmpty(term)) {
            lblError.setText("Term cannot be empty.");
            lblError.setForeground(Color.RED);
            return false;
        }
        try {
            double termValue = Double.parseDouble(term);
            if (termValue < 1 || termValue > 120) {
                lblError.setText("Term must be a double between 1 and 120.");
                lblError.setForeground(Color.RED);
                return false;
            }
        } catch (NumberFormatException e) {
            lblError.setText("Term must be a valid number.");
            lblError.setForeground(Color.RED);
            return false;
        }
        lblError.setText("");
        return true;
    }

    /**
     * Validates the Status.
     * It should be a single word (alphabetical).
     *
     * @param status the status to validate
     * @param lblError the JLabel to show error messages
     * @return true if valid, false otherwise
     */
    public static boolean isValidStatus(String status, JLabel lblError) {
        if (isNullOrEmpty(status)) {
            lblError.setText("Status cannot be empty.");
            lblError.setForeground(Color.RED);
            return false;
        }
        if (!status.matches("[a-zA-Z]+")) {
            lblError.setText("Status must be a single word (alphabets only).");
            lblError.setForeground(Color.RED);
            return false;
        }
        lblError.setText("");
        return true;
    }

    // New Validations
    public static boolean isValidStartDate(String date, JLabel lblError) {
        if (!DATE_PATTERN.matcher(date).matches()) {
            lblError.setText("Start Date must be in DD-MM-YYYY format.");
            lblError.setForeground(Color.RED);
            return false;
        }
        lblError.setText("");
        return true;
    }

    public static boolean isValidDraftBy(String draftBy, JLabel lblError) {
        if (!DRAFT_BY_PATTERN.matcher(draftBy).matches()) {
            lblError.setText("Drafted By only alphabets and must be 1-2 words only.");
            lblError.setForeground(Color.RED);
            return false;
        }
        lblError.setText("");
        return true;
    }

    public static boolean isValidContactNo(String contactNo, JLabel lblError) {
        if (!CONTACT_PATTERN.matcher(contactNo).matches()) {
            lblError.setText("Contact No must start with 98 or 97 and have 10 digits.");
            lblError.setForeground(Color.RED);
            return false;
        }
        lblError.setText("");
        return true;
    }
}