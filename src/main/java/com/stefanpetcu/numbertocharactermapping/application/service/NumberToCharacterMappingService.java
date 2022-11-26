package com.stefanpetcu.numbertocharactermapping.application.service;

import com.stefanpetcu.numbertocharactermapping.application.dto.DigitToCharactersRecord;

import java.util.List;

public interface NumberToCharacterMappingService {
    List<String> getCharacterCombinationsFor(List<DigitToCharactersRecord> digitToCharactersMap, Integer number);
}
