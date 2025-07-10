"""
    to_rna(dna)

The transcribed RNA strand given the DNA strand dna

"""
function to_rna(dna)
    rna = ""
    for n in dna
        if n == 'G'
            rna = rna*'C'
        elseif n == 'C'
            rna = rna*'G'
        elseif n == 'T'
            rna = rna*'A'
        elseif n == 'A'
            rna = rna*'U'
        else
            throw(ErrorException("Invalid input."))
        end
    end
    rna
end

