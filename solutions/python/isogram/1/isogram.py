def is_isogram(string):
    for i in range( len(string) - 1):
        for j in range( i+1, len(string) ):
            if string[i].lower() == string[j].lower():
                if string[i] != " " and string[i] != "-":
                    return False
    return True