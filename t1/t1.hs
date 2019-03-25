import Data.Char

isVowel :: Char -> Bool
isVowel x = toLower(x)=='a' 
            || toLower(x)=='e' 
            || toLower(x)=='i' 
            || toLower(x)=='o' 
            || toLower(x)=='u'

addComma :: [String] -> [String]
addComma x = map (++ ",") x 

htmlListItems :: [String] -> [String]
htmlListItems x = map ( \x -> "<LI>" ++ x ++ "</LI>") x

addLI :: String -> String
addLI x = "<LI>" ++ x ++ "</LI>"

htmlListItems2 :: [String] -> [String]
htmlListItems2 x = map addLI x

rmVowel :: String -> String
rmVowel x = filter (\i -> not (isVowel i)) x

traco :: String -> String
traco x = map (\x -> if x /= ' ' then '-' else x) x
 
_traco2:: Char -> Char
_traco2 x = if x /= ' ' then '-' else x

traco2 :: String -> String
traco2 x = map _traco2 x

firstName :: String -> String
firstName x = takeWhile (/= ' ') x

isLetter2 :: Char -> Bool
isLetter2 x = not (x>='0' && x<='9')

isInt :: String -> Bool
isInt x = length (filter (isLetter2) x) == 0

lastName :: String -> String
lastName x = reverse(firstName(reverse x))

userName :: String -> String
userName x = map (toLower) ([head x] ++ (lastName x))

_encodeName :: Char -> Char
_encodeName x = if toLower(x)=='a' then '4' else
                if toLower(x)=='e' then '3' else
                if toLower(x)=='i' then '2' else
                if toLower(x)=='o' then '1' else '0'

encodeName :: String -> String
encodeName x = map (\x -> if (isVowel x) 
                then (_encodeName x)
                else x) x

_helpBEN :: Char -> String
_helpBEN x = if toLower(x)=='a' then "4" else
                if toLower(x)=='e' then "3" else
                if toLower(x)=='i' then "1" else
                if toLower(x)=='o' then "0" else
               	if toLower(x)=='u' then "00" else
               	[x]

betterEncodeName :: String -> String
betterEncodeName x =  concatMap (_helpBEN) x

addDot :: String -> String
addDot x = take 10 (x ++ "..........")

tenChar :: [String] -> [String]
tenChar x = map (\y -> if (length y) < 10 then addDot y else take 10 y ) x