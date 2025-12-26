package com.practise.project.exception;

import java.util.List;

import org.apache.commons.lang3.ObjectUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.practise.project.builder.ApiResponse;
import com.practise.project.builder.ApiResponseBuilder;
import com.practise.project.builder.FieldError;
import com.practise.project.builder.ResponseConstant;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler({ResourceNotFoundException.class})
    public ResponseEntity<ApiResponse> resourceNotFoundExceptionHandler(ResourceNotFoundException ex) {
        return ApiResponseBuilder.getErrorResponse(ex.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler({BadApiRequestException.class})
    public ResponseEntity<ApiResponse> handleBadApiRequestException(BadApiRequestException ex) {
        return ObjectUtils.isNotEmpty(ex.getResponseMessage()) ? ApiResponseBuilder.getErrorResponse(ex.getMessage(), ex.getResponseMessage().getCustomStatusCode(), ex.getResponseMessage().getHttpStatus()) : ApiResponseBuilder.getErrorResponse(ex.getMessage(), ResponseConstant.ERROR_BAD_REQUEST_400.getCustomStatusCode(), ResponseConstant.ERROR_BAD_REQUEST_400.getHttpStatus());
    }

    @ExceptionHandler({IllegalStateException.class})
    public ResponseEntity<ApiResponse> illegalStateExceptionHandler(IllegalStateException ex) {
        return ApiResponseBuilder.getErrorResponse(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

//    @ExceptionHandler({MethodArgumentNotValidException.class})
//    public ResponseEntity<ApiResponse> handlerMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
//        List<FieldError> fieldErrors = new ArrayList(5);
//        ex.getBindingResult().getAllErrors().forEach((error) -> {
//            String fieldName = ((org.springframework.validation.FieldError)error).getField();
//            String errorMessage = error.getDefaultMessage();
//            fieldErrors.add(new FieldError(fieldName, errorMessage));
//        });
//        return ApiResponseBuilder.getErrorResponse((Object)null, "Validation Failed", HttpStatus.BAD_REQUEST, fieldErrors);
//    }
//
//    @ExceptionHandler({ConstraintViolationException.class})
//    public ResponseEntity<ApiResponse> handlerConstraintViolationException(ConstraintViolationException ex) {
//        List<FieldError> fieldErrors = new ArrayList(5);
//        if (ex.getConstraintViolations() != null && !ex.getConstraintViolations().isEmpty()) {
//            ex.getConstraintViolations().forEach((violation) -> {
//                String fieldName = violation.getPropertyPath().toString();
//                String errorMessage = violation.getMessage();
//                fieldErrors.add(new FieldError(fieldName, errorMessage));
//            });
//        }
//
//        return ApiResponseBuilder.getErrorResponse((Object)null, "Validation Failed", HttpStatus.BAD_REQUEST, fieldErrors);
//    }

    @ExceptionHandler({IllegalArgumentException.class})
    public ResponseEntity<ApiResponse> handleIllegalArgumentException(IllegalArgumentException ex) {
        return ApiResponseBuilder.getErrorResponse(ex.getMessage(), HttpStatus.BAD_REQUEST);
    }

//    @ExceptionHandler({AccessDeniedException.class})
//    public ResponseEntity<ApiResponse> handleAccessDeniedException(AccessDeniedException ex) {
//        log.error(ex.getMessage(), ex);
//        return ApiResponseBuilder.getErrorResponse(ResponseConstant.ERROR_FORBIDDEN_403);
//    }
//
//    @ExceptionHandler({AuthJwtTokenException.class})
//    public ResponseEntity<ApiResponse> handleAuthJwtTokenException(AuthJwtTokenException ex) {
//        return ObjectUtils.isNotEmpty(ex.getResponseMessage()) ? ApiResponseBuilder.getErrorResponse(ex.getResponseMessage()) : ApiResponseBuilder.getErrorResponse(ResponseConstant.ERROR_UNAUTHORIZED_401);
//    }
//
//    @ExceptionHandler({UnauthorizedAccessException.class})
//    public ResponseEntity<ApiResponse> handleUnauthorizedAccessException(UnauthorizedAccessException ex) {
//        return ObjectUtils.isNotEmpty(ex.getResponseMessage()) ? ApiResponseBuilder.getErrorResponse(ex.getResponseMessage()) : ApiResponseBuilder.getErrorResponse(ResponseConstant.ERROR_UNAUTHORIZED_ACCESS_403_4030);
//    }
//
//    @ExceptionHandler({SessionKeyException.class})
//    public ResponseEntity<ApiResponse> handleSessionKeyException(SessionKeyException ex) {
//        return ObjectUtils.isNotEmpty(ex.getResponseMessage()) ? ApiResponseBuilder.getErrorResponse(ex.getResponseMessage()) : ApiResponseBuilder.getErrorResponse(ResponseConstant.ERROR_UNAUTHORIZED_SESSION_KEY_401_4044);
//    }
	
}
