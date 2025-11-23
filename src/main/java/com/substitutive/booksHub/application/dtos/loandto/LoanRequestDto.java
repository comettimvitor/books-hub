package com.substitutive.booksHub.application.dtos.loandto;

import java.util.List;

public record LoanRequestDto(
        List<Long> bookIds,
        Long userId
) {}
