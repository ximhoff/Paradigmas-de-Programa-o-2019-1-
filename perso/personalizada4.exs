defmodule Lista2 do
	
	def myLast(x) do
		List.last(x)
	end

	def myButLast(x) do
		Enum.at(x,-2)
	end

	def elementAt(x,y) do
		Enum.at(x,y-1)
	end
	
	def myLength(x) do
		length x
	end

	def myReverse(x) do 
		Enum.reverse(x)
	end

	def isPalindrome(x,y) do
		Enum.reverse(x) == y
	end

end
