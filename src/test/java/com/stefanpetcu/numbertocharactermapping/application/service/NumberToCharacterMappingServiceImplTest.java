package com.stefanpetcu.numbertocharactermapping.application.service;

import com.stefanpetcu.numbertocharactermapping.application.dto.DigitToCharactersRecord;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class NumberToCharacterMappingServiceImplTest {
    private final NumberToCharacterMappingService service = new NumberToCharacterMappingServiceImpl();

    static private Stream<Arguments> inputsAndOutputsProvider() {
        return Stream.of(
                arguments(1, List.of("a", "b", "c")),
                arguments(12, List.of("ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf")),
                arguments(List.of(234),
                        List.of("dgj", "dgk", "dgl", "dhj", "dhk", "dhl", "dij", "dik", "dil",
                                "egj", "egk", "egl", "ehj", "ehk", "ehl", "eij", "eik", "eil",
                                "fgj", "fgk", "fgl", "fhj", "fhk", "fhl", "fij", "fik", "fil"
                        )),
                arguments(List.of(13579),
                        List.of("agmsy", "agmsz", "agms*", "agmty", "agmtz", "agmt*", "agmuy", "agmuz", "agmu*",
                                "agnsy", "agnsz", "agns*", "agnty", "agntz", "agnt*", "agnuy", "agnuz", "agnu*",
                                "agosy", "agosz", "agos*", "agoty", "agotz", "agot*", "agouy", "agouz", "agou*",
                                "ahmsy", "ahmsz", "ahms*", "ahmty", "ahmtz", "ahmt*", "ahmuy", "ahmuz", "ahmu*",
                                "ahnsy", "ahnsz", "ahns*", "ahnty", "ahntz", "ahnt*", "ahnuy", "ahnuz", "ahnu*",
                                "ahosy", "ahosz", "ahos*", "ahoty", "ahotz", "ahot*", "ahouy", "ahouz", "ahou*",
                                "aimsy", "aimsz", "aims*", "aimty", "aimtz", "aimt*", "aimuy", "aimuz", "aimu*",
                                "ainsy", "ainsz", "ains*", "ainty", "aintz", "aint*", "ainuy", "ainuz", "ainu*",
                                "aiosy", "aiosz", "aios*", "aioty", "aiotz", "aiot*", "aiouy", "aiouz", "aiou*",
                                "bgmsy", "bgmsz", "bgms*", "bgmty", "bgmtz", "bgmt*", "bgmuy", "bgmuz", "bgmu*",
                                "bgnsy", "bgnsz", "bgns*", "bgnty", "bgntz", "bgnt*", "bgnuy", "bgnuz", "bgnu*",
                                "bgosy", "bgosz", "bgos*", "bgoty", "bgotz", "bgot*", "bgouy", "bgouz", "bgou*",
                                "bhmsy", "bhmsz", "bhms*", "bhmty", "bhmtz", "bhmt*", "bhmuy", "bhmuz", "bhmu*",
                                "bhnsy", "bhnsz", "bhns*", "bhnty", "bhntz", "bhnt*", "bhnuy", "bhnuz", "bhnu*",
                                "bhosy", "bhosz", "bhos*", "bhoty", "bhotz", "bhot*", "bhouy", "bhouz", "bhou*",
                                "bimsy", "bimsz", "bims*", "bimty", "bimtz", "bimt*", "bimuy", "bimuz", "bimu*",
                                "binsy", "binsz", "bins*", "binty", "bintz", "bint*", "binuy", "binuz", "binu*",
                                "biosy", "biosz", "bios*", "bioty", "biotz", "biot*", "biouy", "biouz", "biou*",
                                "cgmsy", "cgmsz", "cgms*", "cgmty", "cgmtz", "cgmt*", "cgmuy", "cgmuz", "cgmu*",
                                "cgnsy", "cgnsz", "cgns*", "cgnty", "cgntz", "cgnt*", "cgnuy", "cgnuz", "cgnu*",
                                "cgosy", "cgosz", "cgos*", "cgoty", "cgotz", "cgot*", "cgouy", "cgouz", "cgou*",
                                "chmsy", "chmsz", "chms*", "chmty", "chmtz", "chmt*", "chmuy", "chmuz", "chmu*",
                                "chnsy", "chnsz", "chns*", "chnty", "chntz", "chnt*", "chnuy", "chnuz", "chnu*",
                                "chosy", "chosz", "chos*", "choty", "chotz", "chot*", "chouy", "chouz", "chou*",
                                "cimsy", "cimsz", "cims*", "cimty", "cimtz", "cimt*", "cimuy", "cimuz", "cimu*",
                                "cinsy", "cinsz", "cins*", "cinty", "cintz", "cint*", "cinuy", "cinuz", "cinu*",
                                "ciosy", "ciosz", "cios*", "cioty", "ciotz", "ciot*", "ciouy", "ciouz", "ciou*"
                        ))
        );
    }

    @ParameterizedTest
    @MethodSource("inputsAndOutputsProvider")
    void getCharacterCombinationsFor_returns_combinations_of_letters_given_a_number(Integer inputNumber, List<String> expectedOutput) {
        var digitToCharactersMap = List.of(
                new DigitToCharactersRecord(1, 'a', 'b', 'c'),
                new DigitToCharactersRecord(2, 'd', 'e', 'f'),
                new DigitToCharactersRecord(3, 'g', 'h', 'i'),
                new DigitToCharactersRecord(4, 'j', 'k', 'l'),
                new DigitToCharactersRecord(5, 'm', 'n', 'o'),
                new DigitToCharactersRecord(6, 'p', 'q', 'r'),
                new DigitToCharactersRecord(7, 's', 't', 'u'),
                new DigitToCharactersRecord(8, 'v', 'w', 'x'),
                new DigitToCharactersRecord(9, 'y', 'z', '*')
        );

        assertEquals(expectedOutput, service.getCharacterCombinationsFor(digitToCharactersMap, inputNumber));
    }
}
