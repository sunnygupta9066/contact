package com.gl.mycontacts.model;

import com.gl.mycontacts.util.Validator;

public class PhoneNumber {
    private String label;
    private String phoneNumber;

    public PhoneNumber(String label, String phoneNumber) throws Exception {
        if(label == null || label.isBlank() || label.length()> 255 || Validator.containsNumber(label)){
            throw new RuntimeException();
        }if(phoneNumber== null || phoneNumber.isBlank() || Validator.containsAlphabate(phoneNumber) || (phoneNumber.length() != 10 && phoneNumber.length() != 6)){
            throw new RuntimeException();
        }
        this.label = label;
        this.phoneNumber = phoneNumber;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
