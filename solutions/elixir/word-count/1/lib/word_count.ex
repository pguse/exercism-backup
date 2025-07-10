defmodule WordCount do
  @doc """
  Count the number of words in the sentence.

  Words are compared case-insensitively.
  """
  @spec count(String.t()) :: map
  def count(sentence) do
    sentence
    |> String.replace(~r/[^\p{L}\p{N}\-]/u, " ")
    |> String.downcase
    |> String.split
    |> Enum.reduce(%{}, fn (word,acc) -> Map.update(acc, word, 1, &(&1 + 1)) end)
  end
end
