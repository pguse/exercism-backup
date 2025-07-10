#[derive(Debug, Clone)]
pub enum CalculatorInput {
    Add,
    Subtract,
    Multiply,
    Divide,
    Value(i32),
}

pub fn evaluate(inputs: &[CalculatorInput]) -> Option<i32> {
    let mut stack = Vec::new();
    for item in inputs {
        match item {
            CalculatorInput::Value(n) => stack.push(n.clone()),
            op =>   {let result = match (stack.pop(), stack.pop()) {
                                    (Some(a), Some(b)) => match op {
                                                CalculatorInput::Add => Some(b + a),
                                                CalculatorInput::Subtract => Some(b - a),
                                                CalculatorInput::Multiply => Some(b * a),
                                                CalculatorInput::Divide => Some(b / a),
                                                CalculatorInput::Value(_) => None
                                                        },
                                    (_,_) => None
                                };
                        match result {
                            Some(n) => stack.push(n.clone()),
                            None => break
                        }
                    }
        }
    }
    // If one value n left in the stack, return Some(n).
    // Otherwise, return None
    match stack.len() {
        1 => stack.pop(),
        _ => None
    }
    
}
