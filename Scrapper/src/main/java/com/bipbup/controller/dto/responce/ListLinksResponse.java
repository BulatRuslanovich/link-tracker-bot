package com.bipbup.controller.dto.responce;

import java.util.List;

public record ListLinksResponse(List<LinkResponse> links, int size) {
}
