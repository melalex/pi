package com.room414.hospital.validators.impl;

import com.room414.hospital.forms.AccountForm;
import com.room414.hospital.services.UserService;
import lombok.AllArgsConstructor;

import java.util.List;

import static org.apache.commons.lang3.StringUtils.isBlank;
import static org.apache.commons.lang3.StringUtils.isNoneEmpty;

@AllArgsConstructor
public class AccountFormValidator extends ValidatorSupport<AccountForm> {
    private static final String USER_ALREADY_EXISTS = "errors.validation.userName.alreadyExists";
    private static final String USERNAME_IS_EMPTY = "errors.validation.userName.empty";

    private static final String PASSWORD_IS_EMPTY = "errors.validation.password.empty";
    private static final String PASSWORDS_DID_NOT_MATCHED = "errors.validation.password.passwordDidNotMatched";
    private static final String PASSWORD_TOO_SHORT = "errors.validation.password.tooShort";

    private static final String FIRST_NAME_IS_EMPTY = "errors.validation.firstName.empty";
    private static final String LAST_NAME_IS_EMPTY = "errors.validation.lastName.empty";
    private static final String SECESSION_IS_EMPTY = "errors.validation.secession.empty";

    private static final int PASSWORD_MIN_LENGTH = 4;

    private UserService userService;

    @Override
    protected void validate(AccountForm object, List<String> errorCodes) {
        if (userService.isUserExists(object.getUsername())) {
            errorCodes.add(USER_ALREADY_EXISTS);
        }

        if (isBlank(object.getUsername())) {
            errorCodes.add(USERNAME_IS_EMPTY);
        }

        if (isBlank(object.getPassword())) {
            errorCodes.add(PASSWORD_IS_EMPTY);
        } else if (!object.getPassword().equals(object.getRetryPassword())){
            errorCodes.add(PASSWORDS_DID_NOT_MATCHED);
        }

        if (isNoneEmpty(object.getPassword()) && object.getPassword().length() < PASSWORD_MIN_LENGTH) {
            errorCodes.add(PASSWORD_TOO_SHORT);
        }

        if (isBlank(object.getFirstName())) {
            errorCodes.add(FIRST_NAME_IS_EMPTY);
        }

        if (isBlank(object.getLastName())) {
            errorCodes.add(LAST_NAME_IS_EMPTY);
        }

        if (isBlank(object.getSecession())) {
            errorCodes.add(SECESSION_IS_EMPTY);
        }
    }
}
