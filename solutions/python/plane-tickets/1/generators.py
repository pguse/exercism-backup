"""Functions to automate Conda airlines ticketing system."""


def generate_seat_letters(number):
    """Generate a series of letters for airline seats.

    :param number: int - total number of seat letters to be generated.
    :return: generator - generator that yields seat letters.

    Seat letters are generated from A to D.
    After D it should start again with A.

    Example: A, B, C, D

    """

    letters = ["A", "B", "C", "D"]
    for i in range(number):
        yield letters[i % 4]


def generate_seats(number):
    """Generate a series of identifiers for airline seats.

    :param number: int - total number of seats to be generated.
    :return: generator - generator that yields seat numbers.

    A seat number consists of the row number and the seat letter.

    There is no row 13.
    Each row has 4 seats.

    Seats should be sorted from low to high.

    Example: 3C, 3D, 4A, 4B

    """

    seat_letter = generate_seat_letters(number)
    
    for i in range(number):
        row = i // 4 + 1
        if row > 12:
            row += 1
        yield f"{row}{next(seat_letter)}"

def assign_seats(passengers):
    """
    :param passengers: list[str] - a list of strings containing names of passengers.
    :return: dict - with the names of the passengers as keys and seat numbers as values.

    Example output: {"Adele": "1A", "Björk": "1B"}
    
    """
    
    assignments = {}
    seat = generate_seats(len(passengers))
    for person in passengers:
        assignments[person] = next(seat)
    return assignments

def generate_codes(seat_numbers, flight_id):
    """Generate codes for a ticket.

    :param seat_numbers: list[str] - list of seat numbers.
    :param flight_id: str - string containing the flight identifier.
    :return: generator - generator that yields 12 character long ticket codes.

    """

    for seat in seat_numbers:
        zeros = "0" * (12 - len(seat) - len(flight_id))
        yield f"{seat}{flight_id}{zeros}"
