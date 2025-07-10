def distance(strand_a, strand_b):
    if len(strand_a) != len(strand_b):
        raise ValueError("Lengths are not equal")
    else:
        s = 0
        for i in range(len(strand_a)):
            if strand_a[i] != strand_b[i]:
                s = s + 1
        return s
