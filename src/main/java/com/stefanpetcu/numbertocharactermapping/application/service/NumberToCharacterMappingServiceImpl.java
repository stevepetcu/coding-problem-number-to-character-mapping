package com.stefanpetcu.numbertocharactermapping.application.service;

import com.stefanpetcu.numbertocharactermapping.application.dto.DigitToCharactersRecord;

import java.util.*;
import java.util.stream.Stream;

public class NumberToCharacterMappingServiceImpl implements NumberToCharacterMappingService {
    @Override
    public List<String> getCharacterCombinationsFor(List<DigitToCharactersRecord> digitToCharactersMap, Integer number) {
        // 1. Create an array of the desired size, filled with empty strings.
        // 1.1 Assuming all digits are mapped to the same number of possible characters.
        var numberOfCharsPerDigit = digitToCharactersMap.get(0).characters().length;

        // 1.2 Filter the relevant map records:
        var digitsToFilterBy = number.toString().chars().mapToObj(c -> (char) c)
                .map(c -> Integer.valueOf(String.valueOf(c))).toList();

        List<DigitToCharactersRecord> filteredDigitToCharMapRecords = new ArrayList<>();

        for (Integer d : digitsToFilterBy) { // This could have been simpler if we didn't want to keep duplicates.
            digitToCharactersMap.stream().filter(r -> Objects.equals(r.digit(), d)).findFirst().ifPresent(filteredDigitToCharMapRecords::add);
        }

        // 1.3 If no digits match, return an empty list.
        if (filteredDigitToCharMapRecords.isEmpty()) {
            return List.of();
        } else {
            // 1.4 Reverse the array for the logic at point 2 to work.
            Collections.reverse(filteredDigitToCharMapRecords);
        }

        // 1.5 Create an array filled with distinct instances of StringBuilder.
        // The size of the array depends on the number of relevant digits.
        var result = Stream.generate(StringBuilder::new)
                .limit((int) Math.pow(numberOfCharsPerDigit, filteredDigitToCharMapRecords.size())).toArray(StringBuilder[]::new);
        // 1.6 Keep track of iterations to know how many times we must repeat a character.
        var iterationNumber = 0;

        // 2. Add the actual strings to the previously created array.
        for (DigitToCharactersRecord record : filteredDigitToCharMapRecords) {
            var repeatEachCharacter = (int) Math.pow(numberOfCharsPerDigit, iterationNumber);

            // 2.1 Build the final result.
            var i = 0;
            var repeated = 0;
            for (StringBuilder stringBuilder : result) {
                stringBuilder.insert(0, record.characters()[i]);
                repeated++;

                if (repeated == repeatEachCharacter) {
                    i++;
                    repeated = 0;
                }

                if (i == numberOfCharsPerDigit) {
                    i = 0;
                }
            }
            iterationNumber++;
        }

        return Arrays.stream(result).map(StringBuilder::toString).toList();
    }
}
