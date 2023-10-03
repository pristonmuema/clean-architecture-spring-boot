package com.pristonit.cleanarchetecture.infra.gateways.http.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

public class PageResponse<T> extends BaseResponse<List<T>> {

	@JsonProperty("pagination")
	PageInfo pagination;

	public PageResponse(String message) {
		super(message, null, false);
	}

	public PageResponse(String message, List<T> data, PageInfo pagination) {
		super(message, data, true);
		this.pagination = pagination;
	}

	public PageResponse(List<T> data, String message, List<java.lang.Error> errors,
	                    PageInfo pagination) {
		super(data, message, errors, false);
		this.pagination = pagination;
	}

	public static <R> PageResponse<R> success(List<R> data, PageInfo pageInfo) {
		return new PageResponse<>("success", data, pageInfo);
	}
}
