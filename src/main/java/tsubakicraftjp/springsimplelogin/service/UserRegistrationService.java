package tsubakicraftjp.springsimplelogin.service;

import tsubakicraftjp.springsimplelogin.form.RegistrationFormData;

public interface UserRegistrationService {

    public void register(RegistrationFormData data) throws Exception;
}