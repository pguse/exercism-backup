module Bob

let containsLetters (input : string) =
    input
    |> Seq.exists System.Char.IsLetter

let response (input: string): string = 
    if System.String.IsNullOrWhiteSpace input then "Fine. Be that way!"
    elif input = input.ToUpper() && input.Trim().[input.Length-1] = '?' && (containsLetters input) then "Calm down, I know what I'm doing!"
    elif input = input.ToUpper() && (containsLetters input) then "Whoa, chill out!"
    elif input.Trim().EndsWith '?' then "Sure."
    else "Whatever."