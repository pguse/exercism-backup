=begin
Write your code for the 'Raindrops' exercise in this file. Make the tests in
`raindrops_test.rb` pass.

To get started with TDD, see the `README.md` file in your
`ruby/raindrops` directory.
=end
class Raindrops
  def self.convert(n)
    result = ""
    
    if n % 3 == 0
      result = result + "Pling"
    end
    if n % 5 == 0
      result = result + "Plang"
    end
    if n % 7 == 0
      result = result + "Plong"
    end
  
    if result == ""
      return n.to_s
    else
      return result
    end
  end
end
