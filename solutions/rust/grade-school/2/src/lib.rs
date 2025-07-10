use std::collections::HashMap;

pub struct School { 
    students: HashMap<u32, Vec<String>>,
}

impl School {
    pub fn new() -> School {
        School{students: HashMap::new()}
    }

    pub fn add(&mut self, grade: u32, student: &str) {
        self.students
        .entry(grade)
        .or_insert(Vec::new())
        .push(student.to_owned())
    }

    pub fn grades(&self) -> Vec<u32> {
        let mut grades: Vec<u32> = self.students.keys().cloned().collect();
        grades.sort();
        grades
    }

    pub fn grade(&self, grade: u32) -> Vec<String> {
        let mut students_in_grade = 
            match self.students.get(&grade) {
                Some(students) => students.to_vec(),
                None => vec![],
            };
        // Sort the students in a particular grade
        students_in_grade.sort();
        students_in_grade
    }
}