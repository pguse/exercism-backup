defmodule Hamming do
  @doc """
  Returns number of differences between two strands of DNA, known as the Hamming Distance.

  ## Examples

  iex> Hamming.hamming_distance('AAGTCATA', 'TAGCGATC')
  {:ok, 4}
  """
  @spec hamming_distance([char], [char]) :: {:ok, non_neg_integer} | {:error, String.t()}
  def hamming_distance(strand1, strand2) when length(strand1) == length(strand2) do
    hamming_distance =
      Enum.zip(strand1,strand2)
      |> Enum.reduce(0, fn {ch1,ch2}, acc ->
        if ch1 != ch2 do
          acc + 1
        else
          acc
        end
      end)
    {:ok, hamming_distance}
  end

  def hamming_distance(_strand1, _strand2), do: {:error, "strands must be of equal length"}
end
