module Accumulate

let accumulate (func: 'a -> 'b) (input: 'a list): 'b list = 
    let rec mapImp func acc = function
        | [] -> acc
        | h::t -> mapImp func (func h :: acc) t
    mapImp func [] input |> List.rev
    
