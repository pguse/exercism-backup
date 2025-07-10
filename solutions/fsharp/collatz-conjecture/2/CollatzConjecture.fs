module CollatzConjecture

let steps (number: int): int option = 
    match number with
    | n when n <=0 -> None
    | _ ->  let rec steps (n: int): int =
                match n with
                | 1 -> 0
                | x when x % 2 = 0 -> 1 + steps(n/2)
                | _ -> 1 + steps(3*n+1)
            Some( steps(number) )