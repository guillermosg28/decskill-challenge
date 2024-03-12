package dev.guillermosg.decskillchallenge.infrastructure.adapters.input.rest.errorhandlers;

import dev.guillermosg.decskillchallenge.application.ports.dto.ErrorDTO;
import dev.guillermosg.decskillchallenge.domain.exception.PriceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Locale;

/**
 * The type Global exception handler.
 */

@ControllerAdvice
public class GlobalExceptionHandler {

    @Autowired
    private MessageSource messageSource;

    /**
     * Handle unavailable balance exception response entity.
     *
     * @param locale the locale
     * @return the response entity
     */
    @ExceptionHandler(PriceNotFoundException.class)
    public ResponseEntity<Object> handlePriceNotFoundException(Locale locale) {
        String errorMessage = messageSource.getMessage("message.exception.pricenotfound", null, locale);
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(ErrorDTO.builder().codResponse(PriceNotFoundException.ERROR_CODE)
                        .desResponse(errorMessage).build());
    }


    /**
     * Handle method argument not valid response entity.
     *
     * @return the response entity
     */
    @ExceptionHandler(MissingServletRequestParameterException.class)
    public ResponseEntity<Object> handleMissingServletRequestParameterException(Locale locale) {
        String errorMessage = messageSource.getMessage("message.exception.missingparameter", null, locale);
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(ErrorDTO.builder().codResponse("400")
                        .desResponse(errorMessage).build());
    }

}
