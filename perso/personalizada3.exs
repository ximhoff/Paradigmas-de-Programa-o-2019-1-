defmodule Lista do
	def sumSquares(x,y) do
		:math.pow(x,2) + :math.pow(y,2)
	end

	def hasEqHeads(x,y) do
		[h|_] = x
		[a|_] = y
		h == a
	end

  	def addSuper(x) when is_list(x) do
    		Enum.map(x, fn y -> "Super" <> " " <> y end)
  	end
	
	def numSpaces(x) when is_binary(x) do
    		(length String.split(x," "))-1
	end

	def calc(x) when is_list(x) do
    		Enum.map(x,fn y-> 3 * (y * y) + (2 / y) + 1 end)
	end

	def negatives(x) when is_list(x) do
    		Enum.filter(x,fn y-> y < 0 end)
	end
	
	def between(x) when is_list(x) do
		Enum.filter(x,fn y-> y >= 1 && y <= 100 end)
	end

	def after1980(x) when is_list(x) do
		Enum.filter(x,fn y-> 2019 - y > 1980 end)
  	end

	def even(x) when is_list(x) do
    		Enum.filter(x,fn y-> rem(y,2) == 0 end)
	end

	def charFound(x, y) when is_binary(y) and is_binary(x) do
    		String.contains?(y, x)
	end

  	def endA(x) when is_list(x) do
  	  	Enum.filter(x, fn y -> String.ends_with?(y, "a") end)
	end

end
