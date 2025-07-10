module CollatzConjecture

let steps (number: int): int option = 
    match number with
    | n when n <=0 -> None
    | _ ->  let rec steps (n: int): int =
                if n = 1 then
                    0
                elif n % 2 = 0 then
                    1 + steps(n/2)
                else
                    1 + steps(3*n+1)
            Some( steps(number) )