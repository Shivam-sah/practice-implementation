package com.practise.project.builder;

public class ResponseConstant {
	public static final String SUCCESS = "success";
    public static final String ERROR = "error";
    public static final ResponseMessage SUCCESS_OK_200 = build(1, "success", "success.ok.200", "success", 200, "200");
    public static final ResponseMessage SUCCESS_CREATED_201 = build(2, "success", "success.created.201", "Resource created successfully", 201, "201");
    public static final ResponseMessage SUCCESS_NO_CONTENT_204 = build(3, "success", "success.no.content.204", "Request processed successfully", 204, "204");
    public static final ResponseMessage SUCCESS_UPDATED_200 = build(4, "success", "success.updated.200", "Resource updated successfully", 200, "200");
    public static final ResponseMessage SUCCESS_DELETED_200 = build(5, "success", "success.deleted.200", "Resource deleted successfully", 200, "200");
    public static final ResponseMessage ERROR_BAD_REQUEST_400 = build(6, "error", "error.bad.request.400", "Bad Request", 400, "400");
    public static final ResponseMessage ERROR_UNAUTHORIZED_401 = build(7, "error", "error.unauthorized.401", "Unauthorized", 401, "401");
    public static final ResponseMessage ERROR_FORBIDDEN_403 = build(8, "error", "error.forbidden.403", "Forbidden", 403, "403");
    public static final ResponseMessage ERROR_NOT_FOUND_404 = build(9, "error", "error.not.found.404", "Resource not found", 404, "404");
    public static final ResponseMessage ERROR_UNPROCESSABLE_ENTITY_422 = build(10, "error", "error.unprocessable.entity.422", "Unprocessable entity", 422, "422");
    public static final ResponseMessage ERROR_INTERNAL_SERVER_ERROR_500 = build(11, "error", "error.internal.server.error.500", "We're sorry, but something went wrong on our end. Our team has been notified, and we are working to resolve the issue. Please try again later.\nIf the problem persists, you may contact support.\n", 500, "500");
    public static final ResponseMessage ERROR_BAD_GATEWAY_502 = build(12, "error", "error.bad.gateway.502", "Bad Gateway", 502, "502");
    public static final ResponseMessage ERROR_SERVICE_UNAVAILABLE_503 = build(13, "error", "error.service.unavailable.503", "Service Unavailable", 503, "503");
    public static final ResponseMessage ERROR_GATEWAY_TIMEOUT_504 = build(14, "error", "error.gateway.timeout.504", "Gateway Timeout", 504, "504");
    public static final ResponseMessage ERROR_TOO_MANY_REQUESTS_429 = build(15, "error", "error.too.many.requests.429", "Too many requests - please try again later", 429, "429");
    public static final ResponseMessage ERROR_TOKEN_VALIDATION_ERROR_500_4026 = build(33, "error", "error.token.validation.error.500.4026", "An error occurred during validating the token", 500, "4026");
    public static final ResponseMessage ERROR_MALFORMED_TOKEN_400_4020 = build(27, "error", "error.malformed.token.400.4020", "Malformed token", 400, "4020");
    public static final ResponseMessage ERROR_TOKEN_EXPIRED_401_4018 = build(25, "error", "error.token.expired.401.4018", "Token has expired", 401, "4018");
    public static final ResponseMessage ERROR_UNSUPPORTED_TOKEN_401_4019 = build(26, "error", "error.unsupported.token.401.4019", "Unsupported token", 401, "4019");
    public static final ResponseMessage ERROR_EMPTY_TOKEN_400_4023 = build(30, "error", "error.empty.token.400.4023", "Token is empty", 400, "4023");
    public static final ResponseMessage ERROR_INVALID_KEY_401_4029 = build(37, "error", "error.invalid.key.400.4029", "Authentication failed. Secret key not found or is invalid.", 401, "4029");
    public static final ResponseMessage ERROR_INVALID_FILE_400_4031 = build(38, "error", "error.invalid.file.400.4031", "Unsupported file. Please upload a valid document or image in one of these formats: PNG, JPG, JPEG, PDF, CSV, DOC, DOCX, XLS, XLSX, and ensure the file size is less than 10 MB.", 400, "4031");
    public static final ResponseMessage ERROR_UNAUTHORIZED_ACCESS_403_4030 = build(40, "error", "error.unauthorized.access.403.4030", "Access denied. You don’t have permission to perform this action.", 403, "4030");
    public static final ResponseMessage ERROR_UNAUTHORIZED_SESSION_KEY_401_4044 = build(55, "error", "error.unauthorized.session.key.401.4044", "Session key not found. Please re-authenticate.", 401, "4044");

    private ResponseConstant() {
    }

    private static ResponseMessage build(Integer id, String type, String messageKey, String defaultMessage, Integer httpStatusCode, String customStatusCode) {
        return ResponseMessage.builder().id(id).type(type).messageKey(messageKey).defaultMessage(defaultMessage).httpStatusCode(httpStatusCode).customStatusCode(customStatusCode).build();
    }

}
