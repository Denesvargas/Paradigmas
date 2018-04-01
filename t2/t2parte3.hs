import Data.Char 

--- exercicio parte 3

isEanOk :: String -> Bool
isEanOk str
  | length str /= 13 = undefined 
  | otherwise = (10 - (mod (calculaDig str) 10)) == digitToInt (last str)

calculaDig :: String -> Int
calculaDig (x:xs)
  | length (x:xs) == 1 = 0
  | otherwise = (digitToInt x)*1 + calculaDig2 xs

calculaDig2 :: String -> Int
calculaDig2 (x:xs)
  | length (x:xs) == 1 = 0
  | otherwise = (digitToInt x)*3 + calculaDig xs
