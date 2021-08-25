package com.example.service;

import javax.validation.GroupSequence;

@GroupSequence({FirstValidationService.class, SecondValidationService.class})
public interface ValidationGroupOrderService {
}
