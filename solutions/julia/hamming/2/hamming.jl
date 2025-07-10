"""
    distance(a, b)

The Hamming distance between two DNA strands a and b.

"""
function distance(a, b)
    if length(a) != length(b)
        throw(ArgumentError("Strands not equal length."))
    end
    sum( [ a != b for (a,b) in zip(a,b) ] )
end
