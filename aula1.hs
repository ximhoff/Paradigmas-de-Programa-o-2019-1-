sumSquares :: Int -> Int -> Int
sumSquares x y = (x^2) + (y^2)

hasEqHeads :: [Int] -> [Int] -> Bool
hasEqHeads x y = head x == head y

addSuper :: String -> String
addSuper x = "Super " ++ x

contSpace :: String -> Int
contSpace x = length (filter (== ' ') x)

calc :: [Float] -> [Float]
calc x = map (\x -> 3 * x^2 + 2 / x + 1) x

neg :: [Int] -> [Int]
neg x = filter (<0) x

between :: [Int] -> [Int]
between x = filter (\x -> x >= 1 && x <= 100) x

age :: [Int] -> [Int]
age x = filter (\x -> x < 2019-1980) x


even2 :: [Int] -> [Int]
even2 x = filter (\x -> mod x 2 == 0) x

charFound :: Char -> String -> Bool
charFound x y = (filter (== x ) y) /= []

foundA :: [String] -> [String]
foundA x = filter (\x -> last x == 'a') x

takeWhile2 :: (a -> Bool) -> [a] -> [a]

