package com.pristonit.cleanarchetecture.infra.gateways.http.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class BaseResponse<T> {

  @JsonProperty("data")
  public T data;
  @JsonProperty("message")
  public String message;
  @JsonProperty("errors")
  public List<Error> errors;
  @JsonProperty("status")
  public boolean status;

  public BaseResponse(String message, T data, boolean status) {
    this.message = message;
    this.data = data;
    this.status = status;
  }

  public BaseResponse(T data, String message, List<Error> errors, boolean status) {
    this.data = data;
    this.message = message;
    this.errors = errors;
    this.status = status;
  }

  public static <T> BaseResponse<T> success(String message, T data) {
    return new BaseResponse<>(message, data, true);
  }

  public static <T> BaseResponse<T> success(String message) {
    return new BaseResponse<>(message, null, true);
  }

  public static <T> BaseResponse<T> fail(String reason) {
    return new BaseResponse<>(reason, null, false);
  }
}
