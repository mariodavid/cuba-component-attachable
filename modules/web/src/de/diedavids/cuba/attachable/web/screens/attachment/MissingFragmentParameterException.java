package de.diedavids.cuba.attachable.web.screens.attachment;

import com.haulmont.cuba.core.global.DevelopmentException;

public class MissingFragmentParameterException extends DevelopmentException {

    public MissingFragmentParameterException(String message) {
        super(message);
    }
}
