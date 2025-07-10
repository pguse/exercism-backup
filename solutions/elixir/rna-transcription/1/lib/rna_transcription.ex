defmodule RnaTranscription do
  @doc """
  Transcribes a character list representing DNA nucleotides to RNA

  ## Examples

  iex> RnaTranscription.to_rna('ACTG')
  'UGAC'
  """
  @spec to_rna([char]) :: [char]
  def to_rna(dna) do
    rna =  %{ 65 => 85, 84 => 65, 71 => 67, 67 => 71}
    dna
    |> Enum.map(fn ch -> rna[ch] end)
  end
end
