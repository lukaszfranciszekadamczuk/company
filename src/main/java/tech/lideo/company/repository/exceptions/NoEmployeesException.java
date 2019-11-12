package tech.lideo.company.repository.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NO_CONTENT)

public class NoEmployeesException extends RuntimeException {
}
