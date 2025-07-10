pub fn actions(n: u8) -> Vec<&'static str> {
    let mut handshake: Vec<&str> = Vec::new();
    let actions = ["wink", "double blink", "close your eyes", "jump"];
    for (i, bit) in (0..5).map(|x| (n >> x) & 1).enumerate() {
        if bit == 1 && i < 4 { 
            handshake.push(actions[i]);
        } else if bit == 1 && i == 4 {
            handshake.reverse();
        }
    }
    handshake
}
