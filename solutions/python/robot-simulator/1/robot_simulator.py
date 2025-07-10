# Globals for the directions
EAST = 1
NORTH = 2
WEST = 3
SOUTH = 4

class Robot:
    def __init__(self, direction=NORTH, x_pos=0, y_pos=0):
        self.coordinates = (x_pos, y_pos)
        self.direction = direction

    def move(self, instructions):
        for instruction in instructions:
            if instruction == "A":
                self.advance()
            elif instruction == "L":
                self.turn_left()
            elif instruction == "R":
                self.turn_right()

    def advance(self):
        if self.direction == EAST:
            self.coordinates = (self.coordinates[0]+1, self.coordinates[1])
        elif self.direction == WEST:
            self.coordinates = (self.coordinates[0]-1, self.coordinates[1])
        elif self.direction == NORTH:
            self.coordinates = (self.coordinates[0], self.coordinates[1]+1)
        elif self.direction == SOUTH:
            self.coordinates = (self.coordinates[0], self.coordinates[1]-1)

    def turn_left(self):
        if self.direction == EAST:
            self.direction = NORTH
        elif self.direction == NORTH:
            self.direction = WEST
        elif self.direction == WEST:
            self.direction = SOUTH
        elif self.direction == SOUTH:
            self.direction = EAST

    def turn_right(self):
        if self.direction == EAST:
            self.direction = SOUTH
        elif self.direction == SOUTH:
            self.direction = WEST
        elif self.direction == WEST:
            self.direction = NORTH
        elif self.direction == NORTH:
            self.direction = EAST

            
