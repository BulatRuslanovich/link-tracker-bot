package com.bipbup.controller;

import com.bipbup.controller.dto.request.LinkUpdateRequest;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/updates")
public class UpdateController {

    @PostMapping
    public void postUpdates(@Validated @RequestBody LinkUpdateRequest linkUpdateRequest) {
        // TODO document why this method is empty
    }
}
