defmodule TwoFer do
  @doc """
  Two-fer or 2-fer is short for two for one. One for you and one for me.
  """
  @spec two_fer(String.t()) :: String.t()
  def two_fer(name \\ "you") do
    cond do
      is_binary(name) -> "One for #{name}, one for me"
      :else -> raise FunctionClauseError
    end
  end

end
