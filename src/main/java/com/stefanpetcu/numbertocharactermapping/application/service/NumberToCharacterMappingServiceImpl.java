package com.stefanpetcu.numbertocharactermapping.application.service;

import com.stefanpetcu.numbertocharactermapping.application.dto.DigitToCharactersRecord;

import java.util.ArrayList;
import java.util.List;

public class NumberToCharacterMappingServiceImpl implements NumberToCharacterMappingService {
    @Override
    public List<String> getCharacterCombinationsFor(List<DigitToCharactersRecord> digitToCharactersMap, Integer number) {
        /**
         * TODO: in the while loop filter below, handle digits that do not exist in the map
         *  (e.g., 0 for the map defined in {@link NumberToCharacterMappingServiceImplTest#getCharacterCombinationsFor_returns_combinations_of_letters_given_a_number}
         */
        var filteredDigitToCharactersMap = new ArrayList<DigitToCharactersRecord>();
        var result = new ArrayList<String>();


        while (number > 0) { // Filter the digit to characters map
            var digit = number % 10;
            number = number / 10;

            filteredDigitToCharactersMap
                    .add(digitToCharactersMap.stream().filter(record -> record.digit() == digit).findFirst().orElse(null));
        }
        return new ArrayList<>();
    }
}
