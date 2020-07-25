package dev.innov8.devboards.util;

import dev.innov8.devboards.exceptions.AuthenticationException;
import dev.innov8.devboards.exceptions.BadRequestException;
import dev.innov8.devboards.exceptions.ResourceNotFoundException;
import dev.innov8.devboards.exceptions.DevboardsException;
import dev.innov8.devboards.web.dtos.ErrorResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletResponse;

@Component
@RestControllerAdvice
public class ControllerAdvisor {

    // TODO break apart into separate exception handler methods
    @ExceptionHandler
    public ErrorResponse handleRevaboardsException(DevboardsException e, HttpServletResponse resp) {
        ErrorResponse err = new ErrorResponse(e);

        if (e instanceof ResourceNotFoundException) {
            resp.setStatus(404);
        } else if (e instanceof BadRequestException) {
            resp.setStatus(400);
        } else if (e instanceof AuthenticationException) {
            resp.setStatus(401);
        }

        return err;
    }

}
