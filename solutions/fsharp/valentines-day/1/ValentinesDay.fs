module ValentinesDay

type Approval =
    | Yes
    | No
    | Maybe

type Cuisine =
    | Korean
    | Turkish

type Genre =
    | Crime
    | Horror
    | Romance
    | Thriller

type Activity =
    | BoardGame
    | Chill
    | Movie of Genre
    | Restaurant of Cuisine
    | Walk of int

let rateActivity (activity: Activity): Approval = 
    match activity with
    | Activity.BoardGame -> Approval.No
    | Activity.Chill -> Approval.No
    | Activity.Movie g -> 
        match g with
        | Genre.Romance -> Approval.Yes
        | _ -> Approval.No
    | Activity.Restaurant c ->
        match c with
        | Cuisine.Korean -> Approval.Yes
        | Cuisine.Turkish -> Approval.Maybe
    | Activity.Walk distance -> 
        match distance with
        | d when d < 3 -> Approval.Yes
        | d when d < 5 -> Approval.Maybe
        | _ -> Approval.No
