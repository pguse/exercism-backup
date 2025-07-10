"""
    count_nucleotides(strand)

The frequency of each nucleotide within `strand` as a dictionary.

Invalid strands raise a `DomainError`.

"""
function count_nucleotides(strand)
    dna = Dict('A' => 0, 'C' => 0, 'G' => 0, 'T' => 0)
    for n in strand
        if n in keys(dna)
            dna[n] += 1
        else
            throw(DomainError(n, "expects A,C,G, or T"))
        end
    end
    dna
end
