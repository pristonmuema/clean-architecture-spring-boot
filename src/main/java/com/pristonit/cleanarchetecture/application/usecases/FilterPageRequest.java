package com.pristonit.cleanarchetecture.application.usecases;

public record FilterPageRequest(int page, int size) {

	public FilterPageRequest normalise() {
		int pg = Math.max(page, 0);
		int sze = size < 10 ? 20 : size;
		return new FilterPageRequest(pg, sze);
	}
}
