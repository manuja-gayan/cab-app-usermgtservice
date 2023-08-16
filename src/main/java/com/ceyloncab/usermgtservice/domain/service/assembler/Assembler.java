package com.ceyloncab.usermgtservice.domain.service.assembler;

import java.util.List;

/**
 * Assembles DTO to Entity objects.
 *
 */
public interface Assembler< A, B > {

    A fromDto(B dto);

    B toDto(A model);

    B toDto(A model, Object object);
}

