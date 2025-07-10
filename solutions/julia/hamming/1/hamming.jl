"""
    distance(a, b)

The Hamming distance between two DNA strands a and b.

"""
function distance(a, b)
    if length(a) != length(b)
        throw(ArgumentError("Strands not equal length."))
    end
    dist = 0
    for i in 1:length(a)
        if a[i] != b[i]
            dist += 1
        end
    end
    dist
end
