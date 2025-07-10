module GradeSchool

type School = Map<int, string list>

let empty: School = 
    Map.empty

let add (student: string) (grade: int) (school: School): School = 
    match school.TryFind grade with
    | Some students  -> Map.add grade (student :: students) school
    | None -> Map.add grade [student] school

let roster (school: School): string list = 
    school
    |> Map.toList
    |> List.collect (fun ( _ , value) -> List.sort value)

let grade (number: int) (school: School): string list = 
    match school.TryFind number with
    | Some students -> List.sort students
    | None -> []
