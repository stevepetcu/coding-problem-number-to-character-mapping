# Daily Coding Problem #639 [Easy]

Problem asked by Yelp.

## Problem Statement

Given a mapping of digits to letters (as in a phone number), and a digit string, 
return all possible letters the number could represent. You can assume each valid 
number in the mapping is a single digit.

For example if:
> {2: ["a", "b", "c"], 3: ["d", "e", "f"], …}`

then 
> 23 

should return

> ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"]

> <u>Marginalia</u>: It sort of looks like *as in a phone number* above should actually read
> *as for a phone keyboard* – the kind mobile phones, for example, used to have before all the
> fancy touchscreens came about.
>
> That said, the above also doesn't fully make sense given the example. As you may know if you've
> ever used one of those older mobile devices, in the example above `23` would always map to `ad`.
> `223` would map to `bd`, `2233` would map to `bf`, `2223` would map to `cd` etc.
> 
> So far this looks like a combinations problem with extra steps.
